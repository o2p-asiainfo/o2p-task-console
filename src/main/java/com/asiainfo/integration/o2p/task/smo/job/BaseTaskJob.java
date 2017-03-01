package com.asiainfo.integration.o2p.task.smo.job;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.util.StringUtils;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.TaskException;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;
import com.asiainfo.integration.o2p.task.dao.activemq.IActiveMqDao;
import com.asiainfo.integration.o2p.task.service.IErrorStrategyService;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;
import com.linkage.rainbow.util.spring.ContextHolder;

public abstract class BaseTaskJob  implements Job, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1774639819783725779L;
	
	private static final Logger log = Logger.getLog(BaseTaskJob.class);
	
	private transient IErrorStrategyService errorStrategyService;
	private transient ITaskJobDAO taskJobDAO;
	private transient ITaskCasService taskCasService;
	private transient IActiveMqDao activeMqDao;
	
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		TaskContentBean taskContent = (TaskContentBean)context.getMergedJobDataMap().get("taskContent");
		int objId = -1;
		if(taskContent.getTaskRelaObj() != null) {
			objId = taskContent.getTaskRelaObj().getObjId();
		} else {
			log.error("the taskRelaObj of task, name = " + taskContent.getTaskName() + " no be found, skip the execution.");
			return;
		}
		String queueName = (String)taskContent.getTaskTypeObj().getQueueName();
		if(StringUtils.hasText(queueName)){
			List<String> taskFlagList = new ArrayList<String>();
			assembeTaskFlagList(taskFlagList, objId);
			JSONObject json = assembeJson(objId, taskContent.getTenantId(), taskContent.getParallelismDegree(), taskContent.getTaskStyle(), taskFlagList);
			//根据任务风格进行判断是否增加到队列中
			try {
				sendToMq(taskFlagList, taskContent, objId, json, queueName, taskContent.getTenantId());
			} catch(TaskException e) {
				log.error("task :"+taskContent.getTaskName()+" send to execute failed, will retry according to the retry strategy.", e);
				getErrorStrategyService().setErrorType(e.getErrorType());
				getErrorStrategyService().excuteErrorRetry(taskFlagList, taskContent, json);
			}
		}
	}
	
	public abstract JSONObject assembeJson(int objId, Integer tenantId, Integer parallelismDegree, String taskStyle,List<String> taskFlagList);

	public abstract void sendToMq(List<String> taskFlagList, TaskContentBean taskContent, int objId, JSONObject json, String queueName, Integer tenantId) throws TaskException;

	public abstract void assembeTaskFlagList(List<String> taskFlagList, int objId);
	
	public ITaskCasService getTaskCasService() {
		if(taskCasService == null) {
			return (ITaskCasService)ContextHolder.getSpringContext().getBean("taskCacheService");
		}
		return taskCasService;
	}
	
	public IActiveMqDao getActiveMqDao() {
		if(activeMqDao == null) {
			return (IActiveMqDao)ContextHolder.getSpringContext().getBean("activeMqDao");
		}
		return activeMqDao;
	}
	
	public void setActiveMqDao(IActiveMqDao activeMqDao) {
		this.activeMqDao = activeMqDao;
	}

	public ITaskJobDAO getTaskJobDAO() {
		if(taskJobDAO == null) {
			return (ITaskJobDAO)ContextHolder.getSpringContext().getBean("taskJobDAO");
		}
		return taskJobDAO;
	}
	
	public void setTaskJobDAO(ITaskJobDAO taskJobDAO) {
		this.taskJobDAO = taskJobDAO;
	}
	
	public void setErrorStrategyService(IErrorStrategyService errorStrategyService) {
		this.errorStrategyService = errorStrategyService;
	}
	

	public void setTaskCasService(ITaskCasService taskCasService) {
		this.taskCasService = taskCasService;
	}

	public IErrorStrategyService getErrorStrategyService() {
		if(errorStrategyService == null) {
			return (IErrorStrategyService)ContextHolder.getSpringContext().getBean("errorStrategyService");
		}
		return errorStrategyService;
	}
}
