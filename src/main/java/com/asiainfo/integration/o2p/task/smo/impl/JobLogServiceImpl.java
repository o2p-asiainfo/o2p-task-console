package com.asiainfo.integration.o2p.task.smo.impl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.quartz.JobExecutionContext;

import com.ailk.eaap.o2p.fileExchange.model.TaskJobLogBean;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.o2p.task.model.TaskRelaObj;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.Constant;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;



public class JobLogServiceImpl implements IJobLogService{
	private  static final Logger  LOG = Logger.getLog(JobLogServiceImpl.class);
	private ITaskJobDAO taskJobDAO; 
	
	public void setTaskJobDAO(ITaskJobDAO taskJobDAO) {
		this.taskJobDAO = taskJobDAO;
	}


	/**
	 * 任务未运行
	 */
	public void addUnExedJobLog(String message,String schdInstId, String jobName, 
			String jobClass, String groupName, String eventType) {
		try {
			int taskId = Integer.parseInt(groupName.split("tenant")[1]);
			
			Map taskMap = new HashMap();
			taskMap.put("taskId", taskId);
			
			TaskContentBean task = taskJobDAO.getTaskContentBean(taskMap);
			
			TaskJobLogBean tlog = new TaskJobLogBean();
			if(task != null) {
				tlog.setTenantId(task.getTenantId());
			}
			tlog.setTaskId(taskId);
			tlog.setLogType(Constant.TASK_LOG_TYPE_1);
			tlog.setSchdInstId(schdInstId);
			tlog.setEventType(eventType);
			tlog.setJobClass(jobClass);
			tlog.setInfo(message);
			tlog.setJobName(jobName);
			taskJobDAO.addTaskLog(tlog);
		} catch(Exception e) {
			 LOG.error(LogModel.EVENT_APP_EXCPT, new BusinessException(Constant.ERROR_CODE_9033, Constant.MESSAGE_ADD_TASK_ABNORMAL, e));
		}
	}

	/**
	 * 任务已运行
	 */
	public void addExedJobLog(String message, String schdInstId,  String jobName, String jobClass, 
			JobExecutionContext context, String eventType) {
		try {
			TaskContentBean taskContent = (TaskContentBean)context.getMergedJobDataMap().get(Constant.PARAM_TASK_CONTENT);
			
			TaskJobLogBean tlog = new TaskJobLogBean();
			tlog.setTenantId(taskContent.getTenantId());
			tlog.setTaskId(taskContent.getTaskId());
			tlog.setInfo(message);
			tlog.setSchdInstId(schdInstId);
			tlog.setJobName(jobName);
			tlog.setJobClass(jobClass);
			tlog.setEventType(eventType);
			tlog.setLogType(Constant.TASK_LOG_TYPE_1);
			taskJobDAO.addTaskLog(tlog);
		} catch(Exception e) {
			 LOG.error(LogModel.EVENT_APP_EXCPT, new BusinessException(Constant.ERROR_CODE_9233, Constant.MESSAGE_ADD_TASK_ABNORMAL, e));
		}
	}
	
	/**
	 * 任务运行过程中报错
	 */
	public void addExedJobErrorLog(String errMsg, String schdInstId,  String jobName, String jobClass, 
			JobExecutionContext context, String eventType) {
		try {
			TaskContentBean taskContent = (TaskContentBean)context.getMergedJobDataMap().get(Constant.PARAM_TASK_CONTENT);
			String errorInfo = errMsg;
			if(errMsg.length() > Constant.ERROR_MSG_LENGTH) {errorInfo = errMsg.substring(0, Constant.ERROR_MSG_LENGTH);}
			TaskJobLogBean tlog = new TaskJobLogBean();
			tlog.setTaskId(taskContent.getTaskId());
			tlog.setTenantId(taskContent.getTenantId());
			tlog.setErrorInfo(errorInfo);
			tlog.setSchdInstId(schdInstId);
			tlog.setJobName(jobName);
			tlog.setJobClass(jobClass);
			tlog.setEventType(eventType);
			tlog.setLogType(Constant.TASK_LOG_TYPE_1);
			taskJobDAO.addTaskLog(tlog);
		} catch(Exception e) {
			 LOG.error(LogModel.EVENT_APP_EXCPT, new BusinessException(Constant.ERROR_CODE_9233, Constant.MESSAGE_ADD_TASK_ABNORMAL, e));
		}
	}

	/**
	 * 用户操作
	 */
	public void addOperatorLog(Map<String, Object> map) {

		try {
			TaskContentBean taskContentBean = (TaskContentBean)map.get("taskContentBean");
			if(taskContentBean == null) {
				return;
			}
			TaskRelaObj taskRela = taskContentBean.getTaskRelaObj();
			String objTypeCd = "";
			if(taskRela != null) {
				objTypeCd = taskRela.getObjTypeCd();
			}
			String type = map.get("type").toString();
			String sessionId = map.get(Constant.SESSION_ID) == null ? null : map.get(Constant.SESSION_ID).toString();
			String staffNo = map.get(Constant.STAFF_NO) == null ? null : map.get(Constant.STAFF_NO).toString();
			String ip = map.get(Constant.IP) == null ? null : map.get(Constant.IP).toString();
			String message = "User {0}  {1} the task [{2}]  service invoker [{3}]";
			String eventType = "";
			Object[] args = null;
			if(Constant.NAME_START.equals(type)) {
				 args = new Object[] {
					staffNo, Constant.NAME_START,taskContentBean.getTaskName(),
					objTypeCd
				 };
				 eventType = Constant.TASK_LOG_EVENT_TYPE_START;
			} else if (Constant.NAME_STOP.equals(type)) {
				 args =  new Object[] {
					staffNo, Constant.NAME_STOP,taskContentBean.getTaskName(),
					objTypeCd
				 };
				 eventType = Constant.TASK_LOG_EVENT_TYPE_STOP;
			} 
			
			TaskJobLogBean tlog = new TaskJobLogBean();
			tlog.setLogType(Constant.TASK_LOG_TYPE_2);
			tlog.setTenantId(taskContentBean.getTenantId());
			tlog.setTaskId(Integer.parseInt(map.get("taskId").toString()));
			tlog.setSessionId(sessionId);
			tlog.setStaffNo(staffNo);
			tlog.setIp(ip);
			tlog.setInfo(MessageFormat.format(message, args));
			tlog.setEventType(eventType);
			taskJobDAO.addTaskLog(tlog);
		} catch(Exception e) {
			throw new BusinessException(Constant.ERROR_CODE_9234, "Add user log abnormal  ", e);
		}
	}
	
}
