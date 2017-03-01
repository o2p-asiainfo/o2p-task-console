package com.asiainfo.integration.o2p.task.smo.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.transaction.annotation.Transactional;

import com.ailk.eaap.o2p.fileExchange.model.TaskJobLogBean;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.o2p.task.model.TaskRelaObj;
import com.ailk.eaap.o2p.task.model.TaskType;
import com.ailk.eaap.op2.bo.GatherCycle;
import com.ailk.eaap.op2.bo.SerInvokeIns;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.Constant;
import com.asiainfo.integration.o2p.task.common.quartz.QuartzManager;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;
import com.asiainfo.integration.o2p.task.smo.IJobConsoleService;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;
import com.asiainfo.integration.o2p.task.smo.job.ConCurrentTaskJob;
import com.asiainfo.integration.o2p.task.smo.job.NonConCurrentTaskJob;

public class JobConsoleServiceImpl implements IJobConsoleService {
	private static final Logger LOG = Logger
			.getLog(JobConsoleServiceImpl.class);
	private IJobLogService jobLogService;
	private ITaskJobDAO taskJobDAO;
	private QuartzManager quartzManager;
	private ITaskCasService taskCacheService;
	private String startFlag;

	public void setQuartzManager(QuartzManager quartzManager) {
		this.quartzManager = quartzManager;
	}

	public void setTaskJobDAO(ITaskJobDAO taskJobDAO) {
		this.taskJobDAO = taskJobDAO;
	}

	public void setJobLogService(IJobLogService jobLogService) {
		this.jobLogService = jobLogService;
	}
	
	@Override
	public List<String> getCurrRunTask() {
		return quartzManager.getCurrRunTaskList();
	}

	public List<String> startAll(String  tenantId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Constant.START_PAGE, "0");
		param.put(Constant.END_PAGE, getTaskListNum(param));
		param.put("tenantId", tenantId);
		List<TaskContentBean> list = taskJobDAO.getTaskList(param);

		return this.start(list);
	}

	public List<String> start(List<TaskContentBean> taskContentList) {
		List<String> resultList = new ArrayList<String>();
		// 启动调度器
		quartzManager.start();
		for (TaskContentBean taskContent : taskContentList) {
			
			stopOneTask(taskContent);
			
			String result = "";
			try {

				// 根据线程数启动job
				int threadNumber = 1;
				if (taskContent.getThreadNumber() > 1) {
					threadNumber = taskContent.getThreadNumber();
				}

				String jobGroupName = getJobGroupName(taskContent);
				String triggerGroupName = jobGroupName;
				String exprTime = taskContent.getGcExp();
				if(canStart(taskContent)) {
					while (threadNumber > 0) {
						this.addJob(taskContent, jobGroupName, triggerGroupName,
								exprTime, threadNumber);
						threadNumber--;
					}
					// 更新任务状态 I:运行中,启动时间
					taskContent.setTaskState(Constant.TASK_STATE_I);
					taskContent.setStartDate("start");
					result = getJsonObject(taskContent.getTaskName(), Constant.CODE_SUCCESS,
							"start success!");
				} else {
					// 更新任务状态 F:运行中,启动时间
					taskContent.setTaskState(Constant.TASK_STATE_F);
					result = getJsonObject(taskContent.getTaskName(), "fail",
							"error! the service loses efficacy");
				}
				taskJobDAO.updateStartTaskState(taskContent);
			} catch (Exception e) {
				LOG.error(LogModel.EVENT_APP_EXCPT, e);
				result = getJsonObject(taskContent.getTaskName(), "fail",
						e.getMessage());
			}

			resultList.add(result);
		}

		return resultList;
	}

	private void stopOneTask(TaskContentBean taskContent) {
		List<TaskContentBean> stopTask = new ArrayList<TaskContentBean>();
		stopTask.add(taskContent);
		stop(stopTask);
	}
	
	private String getJobGroupName(TaskContentBean taskContent) {

		return taskContent.getTenantId()+"tenant"+taskContent.getTaskId() + "";
	}

	public boolean canStart(TaskContentBean task) {
		boolean canStart = false;
		if(task.getTaskRelaObj() != null && (Constant.OBJ_TYPE_SER_INVOKE_INS).equals(task.getTaskRelaObj().getObjTypeCd())) {
			SerInvokeIns serInvokeIns = taskJobDAO.getSerInvokeIns(task.getTaskRelaObj().getObjId());
			if(serInvokeIns != null && serInvokeIns.getService() != null) {
				if(LOG.isDebugEnabled()) {
					LOG.debug("serInvokeIns id = {0}, serInvokeIns service id = {1}, state = {2}", 
							serInvokeIns.getSerInvokeInsId(), 
							serInvokeIns.getService().getServiceId(), 
							serInvokeIns.getService().getState());
				}
				if(Constant.IN_USE.equals(serInvokeIns.getService().getState())) {
					canStart =  true;
				}
			}
		}
		return canStart;
	}
	
	public List<String> restart(List<TaskContentBean> taskContentList, List<TaskContentBean> taskContentListStop) {
		try {
			if(taskContentList == null || taskContentList.isEmpty()) {
				this.stopAllRunningTask();
				return null;
			}
			List<String> runningList = quartzManager.getCurrRunTaskList();
			if(runningList == null || runningList.isEmpty()) {
				return this.start(taskContentList);
			}
			List<TaskContentBean> startList = new ArrayList<TaskContentBean>();
			List<TaskContentBean> stopList = new ArrayList<TaskContentBean>();
			for(TaskContentBean bean:taskContentList) {
				String jobGroupName = bean.getTaskId() + "";
				if(!runningList.contains(jobGroupName)) {
					startList.add(bean);
				} else {
					if(LOG.isDebugEnabled()) {
						LOG.debug("task name {0}, is already start", new Object[]{bean.getTaskName()});
					}
				}
			}
			for(TaskContentBean bean: taskContentListStop) {
				String jobGroupName = bean.getTaskId() + "";
				if(runningList.contains(jobGroupName)) {
					if(LOG.isDebugEnabled()) {
						LOG.debug("task name {0} state is stop in the database, and will shutdown it", new Object[]{bean.getTaskName()});
					}
					stopList.add(bean);
				}
			}
			List<String> result = new ArrayList<String>();
			if(!startList.isEmpty()) {
				result.addAll(this.start(startList));
			}
			if(!stopList.isEmpty()) {
				result.addAll(this.stop(stopList));
			}
		} catch (Exception e) {
			LOG.error(LogModel.EVENT_APP_EXCPT, new BusinessException(Constant.ERROR_CODE_9221,
					"restart task error", e));
		}	
		return null;
	}

	public List<String> stop(List<TaskContentBean> taskContentList) {
		List<String> resultList = new ArrayList<String>();

		for (TaskContentBean taskContent : taskContentList) {
			String result = "";
			try {

				String jobGroupName = getJobGroupName(taskContent);
				String triggerGroupName = jobGroupName;
				// 停止任务
				quartzManager.removeJob(jobGroupName, triggerGroupName);

				// 更新任务状态 F:未运行，停止时间
				taskContent.setTaskState(Constant.TASK_STATE_F);
				taskContent.setStopDate("stop");
				taskJobDAO.updateStartTaskState(taskContent);
				result = getJsonObject(taskContent.getTaskName(), Constant.CODE_SUCCESS,
						"stop success!");
			} catch (Exception e) {
				LOG.error(LogModel.EVENT_APP_EXCPT, new BusinessException(Constant.ERROR_CODE_9221,
						"stop task error", e));
				result = getJsonObject(taskContent.getTaskName(), "fail",
						e.getMessage());
			}
			resultList.add(result);
		}
		return resultList;
	}

	private String getJsonObject(String taskName, String code, String message) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("taskName", taskName);
		jsonObject.put("code", code);
		jsonObject.put("message", message);

		return jsonObject.toString();
	}

	public TaskContentBean getTaskContentBean(Map<String, Object> param) {

		TaskContentBean taskContent = null;
		try {
			taskContent = taskJobDAO.getTaskContentBean(param);
		} catch (Exception e) {
			LOG.error("getTaskContentBean error", e);
		}
		return taskContent;
	}

	public void addJob(TaskContentBean taskContentBean, String jobGroupName,
			String triggerGroupName, String exprTime, int threadNumber)
			throws SchedulerException, ParseException, ClassNotFoundException {

		JobDetail jobDetail = null;

		// 业务实体
		TaskRelaObj taskRela = taskContentBean.getTaskRelaObj();
		TaskType taskType = taskContentBean.getTaskTypeObj();

		String objTypeCd = "1";
		String queueName = "";
		if(taskType != null) {queueName = (String)taskContentBean.getTaskTypeObj().getQueueName();}
		if (taskRela != null) {objTypeCd = taskRela.getObjTypeCd();}
		//如果任务风格为空，默认为1
		if(taskContentBean.getTaskStyle()==null || taskContentBean.getTaskStyle().equals("")){
			taskContentBean.setTaskStyle(TaskContentBean.CONCURRENCY_TASK);
		}
		String jobName = "[" + taskContentBean.getTaskName() + " - " + queueName + "-" + objTypeCd + "] "
				+ taskContentBean.getTaskId() + "_"
				+ threadNumber;
		String triggerName = jobName;
		if(TaskContentBean.CONCURRENCY_TASK.equals(taskContentBean.getTaskStyle())) {
			jobDetail = JobBuilder.newJob(ConCurrentTaskJob.class).withIdentity(new JobKey(jobName, jobGroupName)).build();// 任务名，任务组，任务执行类
		} else {
			jobDetail = JobBuilder.newJob(NonConCurrentTaskJob.class).withIdentity(new JobKey(jobName, jobGroupName)).build();// 任务名，任务组，任务执行类
		}
		JobDataMap map = jobDetail.getJobDataMap();
		map.put("taskContent", taskContentBean);
		
		quartzManager.addJob(jobDetail, triggerName, triggerGroupName, exprTime);
	}

	public int updateTaskContentBean(TaskContentBean taskContentBean) {
		int result = 0;
		try {
			//判断任务是否在执行
			List<String> currentRunningList = quartzManager.getCurrRunTaskList();
			boolean isTaskRunning = false;
			if(currentRunningList != null) {
				for(String runningTask: currentRunningList) {
					if(runningTask.equals(String.valueOf(taskContentBean.getTaskId()))) {
						isTaskRunning = true;
					}
				}
			}
			if(isTaskRunning) {
				String gcCd = taskContentBean.getGcCd();
				GatherCycle gc = this.getGatherCycleBean(Integer.parseInt(gcCd));
				String jobGroupName = taskContentBean.getTaskId() + "";
				String triggerGroupName = jobGroupName;
				String exprTime = gc.getGcSEExp();
				int threadNum = 1;
				if (taskContentBean.getThreadNumber() > 1) {
					threadNum = taskContentBean.getThreadNumber();
				}
				quartzManager.removeJob(taskContentBean.getTaskId() + "",
						taskContentBean.getTaskId() + "");
				
				TaskType taskType = taskJobDAO.getTaskTypeByCd(taskContentBean.getTaskType());
				if(taskType != null) {taskContentBean.setTaskTypeObj(taskType);}
				this.addJob(taskContentBean, jobGroupName, triggerGroupName,
						exprTime, threadNum);
			}
			result = taskJobDAO.updateTaskContentBean(taskContentBean);
		} catch (Exception e) {
			LOG.error(LogModel.EVENT_APP_EXCPT, new BusinessException(Constant.ERROR_CODE_9223,
					"update task error", e));
		}
		return result;
	}

	public List<GatherCycle> getTaskCycleList(Integer tenantId) {
		List<GatherCycle> list = null;
		try {
			list = taskJobDAO.getTaskCycleList(tenantId);
		} catch (Exception e) {
			LOG.error("getTaskCycleList error", e);
		}
		return list;
	}

	public int getTaskListNum(Map<String, Object> param) {
		int listCount = 0;
		try {
			listCount = taskJobDAO.getTaskCount(param);
		} catch (Exception e) {
			LOG.error("getTaskListNum error",e);
		}
		return listCount;
	}

	public List<TaskContentBean> getTaskList(Map<String, Object> param) {
		List<TaskContentBean> fmList = new ArrayList<TaskContentBean>();
		List<TaskContentBean> allList = new ArrayList<TaskContentBean>();
		try {
			Map<String, Object> newParam = new HashMap<String, Object>();
			newParam.put("tenantId",param.get("tenantId"));
			allList = taskJobDAO.getTaskList(newParam);
			//更新实际运行状态
			setCurrentRunStatu(allList);
			
			fmList = taskJobDAO.getTaskList(param);
			if(LOG.isDebugEnabled()) {
				
				LOG.debug("=====> dataBaseTaskList size:"+fmList.size());
			}
			if(fmList != null) {
				for(TaskContentBean tc: fmList) {
					
					if(LOG.isDebugEnabled()) {
						
						LOG.debug("=====> databaseTask:"+tc.getTaskName()+"===> taskStatu:"+tc.getTaskState());
					}
					
					if(canStart(tc)) {
						tc.setTaskUsable(true);
					} else {
						tc.setTaskUsable(false);
					}
				}
			}
		} catch (Exception e) {
			LOG.error("getTaskList error", e);
		}
		if(LOG.isDebugEnabled()) {
			
			LOG.debug("=====> memoryTaskList size:"+fmList.size());
		}
		return fmList;
	}

	private void setCurrentRunStatu(List<TaskContentBean> allList) {

		List<String> groupNames = getCurrRunTask();
		
		for(TaskContentBean tc : allList) {
			
			String taskStatus = Constant.TASK_STATE_F;
			for(String groupName : groupNames) {
				
				if(!StringUtils.isEmpty(groupName) && (groupName).equals(getJobGroupName(tc))) {
					
					taskStatus = Constant.TASK_STATE_I;
					if(LOG.isDebugEnabled()) {
						
						LOG.debug("=====> RealRunningTask:"+tc.getTaskName());
					}
					break;
				} 
			}
			//实际运行状态
			if(!taskStatus.equals(tc.getTaskState())) {
				
				tc.setTaskState(taskStatus);
				taskJobDAO.updateStartTaskState(tc);
			}
		}
	}

//	private void setCurrentRunStatu(TaskContentBean tc, Map<String, Object> param, List<TaskContentBean> newList) {
//
//		List<String> groupNames = getCurrRunTask();
//		
//		String taskStatus = Constant.TASK_STATE_F;
//		for(String groupName : groupNames) {
//			
//			if(!StringUtils.isEmpty(groupName) && (groupName).equals(getJobGroupName(tc))) {
//				
//				taskStatus = Constant.TASK_STATE_I;
//				if(LOG.isDebugEnabled()) {
//					
//					LOG.debug("=====> RealRunningTask:"+tc.getTaskName());
//				}
//				break;
//			} 
//		}
//		//实际运行状态
//		if(!taskStatus.equals(tc.getTaskState())) {
//			
//			tc.setTaskState(taskStatus);
//			taskJobDAO.updateStartTaskState(tc);
//		}
//		
//		Object statuObj = param.get("statu");
//			
//		if(newList != null && (statuObj == null || (statuObj != null &&
//				tc.getTaskState().equalsIgnoreCase(statuObj.toString())))) {
//			
//			newList.add(tc);
//		}
//			
//	}

	public int getTaskLogListNum(Map<String, Object> param) {
		int listCount = 0;
		try {
			listCount = taskJobDAO.getTaskLogCount(param);
		} catch (Exception e) {
			LOG.error("getTaskLogListNum error", e);
		}
		return listCount;
	}

	public List<TaskJobLogBean> getTaskLogList(Map<String, Object> param) {
		List<TaskJobLogBean> fmList = new ArrayList<TaskJobLogBean>();
		try {

			fmList = taskJobDAO.getTaskLogList(param);

		} catch (Exception e) {
			LOG.error("getTaskLogList error", e);
		}

		return fmList;
	}

	public List<TaskContentBean> getRunningList() {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("statu", Constant.TASK_STATE_I);
		return this.getTaskList(param);
	}

	public List<GatherCycle> getTaskCycleList(Map<String, Object> param) {
		List<GatherCycle> fmList = new ArrayList<GatherCycle>();
		try {

			fmList = taskJobDAO.getTaskCycleList(param);

		} catch (Exception e) {
			LOG.error("getTaskCycle error", e);
		}

		return fmList;
	}

	public void updateCycle(GatherCycle gc) {
		try {

			taskJobDAO.updateCycle(gc);
		} catch (Exception e) {
			LOG.error("updateCycle error", e);
		}

	}

	public int deleteCycle(GatherCycle gc) {
		try {
			int taskCount = taskJobDAO.getTaskCountByGcCd(gc);
			if (taskCount > 0) {
				return taskCount;
			}
			taskJobDAO.deleteCycle(gc);
		} catch (Exception e) {
			LOG.error("deleteCycle error", e);
		}
		return 0;
	}

	public int addCycle(GatherCycle gc) {
		int gcCd = 0;
		try {
			gcCd = taskJobDAO.addCycle(gc);
		} catch (Exception e) {
			LOG.error("addCycle error", e);
		}
		return gcCd;
	}

	public int getTaskCycleNum(Map<String, Object> param) {
		int listCount = 0;
		try {
			listCount = taskJobDAO.getTaskCycleNum(param);
		} catch (Exception e) {
			LOG.error("getTaskCycleNum error", e);
		}
		return listCount;
	}

	public GatherCycle getGatherCycleBean(int gcCd) {
		GatherCycle gc = null;
		try {
			gc = taskJobDAO.getGatherCycleBean(gcCd);
		} catch (Exception e) {
			LOG.error("getGatherCycleBean error", e);
		}
		return gc;
	}

	public List<String> stopAll(String  tenantId) {
		Map<String, Object> param = new HashMap<String, Object>();
		int num = getTaskListNum(param);
		param.put(Constant.START_PAGE, "0");
		param.put(Constant.END_PAGE, num);
		param.put("tenantId", tenantId);
		List<TaskContentBean> list = taskJobDAO.getTaskList(param);
		return this.stop(list);
	}

	@Transactional
	public int addTask(Map<String, Object> param) {
		param.put("taskState", Constant.TASK_STATE_F);
		taskJobDAO.addTask(param);
		param.put(Constant.PARAM_TASK_ID, param.get("taskId"));
		return taskJobDAO.addRelaObj(param);
	}
	
	public void stopAllRunningTask() {
		try {
			quartzManager.clear();
		} catch (SchedulerException e) {
			LOG.error("clear all task error", e);
		}
	}

	public void shutDown() {
		try {
			quartzManager.shutdown();
		} catch (SchedulerException e) {
			LOG.error("shutDown error", e);
		}
	}

	public void operatorLog(Map<String, Object> map) {
		try {
			int taskId = Integer.parseInt(map.get(Constant.PARAM_TASK_ID).toString());
			
			Map taskMap = new HashMap();
			taskMap.put("taskId", taskId);
			
			TaskContentBean taskContentBean = this.getTaskContentBean(taskMap);
			map.put("taskContentBean", taskContentBean);
			jobLogService.addOperatorLog(map);
		} catch (Exception e) {
			LOG.error("operatorLog error", e);
		}

	}

	public TaskJobLogBean getTaskJobLogById(int taskLogId) {
		TaskJobLogBean taskJobLogBean = null;
		try {
			taskJobLogBean = taskJobDAO.getTaskJobLogById(taskLogId);
		} catch (Exception e) {
			LOG.error("getTaskJobLog error", e);
		}
		return taskJobLogBean;
	}

	public List<String> deleteTask(List<String> taskIds) {
		List<String> resultList = new ArrayList<String>();
		try {
			for (String taskId : taskIds) {

				// 停止任务
				String jobGroupName = taskId;
				String triggerGroupName = taskId;
				quartzManager.removeJob(jobGroupName, triggerGroupName);

				// 删除任务
				Map<String, Object> param = new HashMap<String, Object>();
				param.put(Constant.PARAM_TASK_ID, taskId);
				taskJobDAO.deleteTask(param);

			}

		} catch (Exception e) {
			LOG.error("Delete job fail :{0} ", e);
			resultList.add("Delete job fail : " + e);
		}
		return resultList;
	}

	public boolean isInitTask() {
		if ("true".equalsIgnoreCase(this.getStartFlag())) {
			return true;
		}
		return false;
	}

	public IJobLogService getJobLogService() {
		return jobLogService;
	}

	public ITaskJobDAO getTaskJobDAO() {
		return taskJobDAO;
	}

	public QuartzManager getQuartzManager() {
		return quartzManager;
	}

	public String getStartFlag() {
		return startFlag;
	}

	public void setStartFlag(String startFlag) {
		this.startFlag = startFlag;
	}

	public ITaskCasService getTaskCacheService() {
		return taskCacheService;
	}

	public void setTaskCacheService(ITaskCasService taskCacheService) {
		this.taskCacheService = taskCacheService;
	}
}
