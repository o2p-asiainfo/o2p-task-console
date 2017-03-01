package com.asiainfo.integration.o2p.task.service.Impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.op2.bo.CacheFlagCommon;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.TaskException;
import com.asiainfo.integration.o2p.task.dao.activemq.IActiveMqDao;
import com.asiainfo.integration.o2p.task.service.IErrorStrategyService;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;

public class ErrorStrategyImpl implements IErrorStrategyService {
	@Autowired
	private ITaskCasService taskCasService;
	@Autowired
	private IActiveMqDao activeMqDao;
	public static final Logger LOGGER = Logger.getLog(ErrorStrategyImpl.class);
	private int errorType;
	public static final String DEFAULT_ERROR_STRATEGY = "0 5 5 5";

	@Override
	public void excuteErrorRetry(List<String> taskFlagList,
			TaskContentBean taskContent, JSONObject json) {
		String errorStrategyExpression = taskContent.getErrorStrategyExpression();
		if(!StringUtils.hasText(errorStrategyExpression)) {
			errorStrategyExpression = DEFAULT_ERROR_STRATEGY;
		}
		String[] excuteParam = errorStrategyExpression.split(" ");
		if(excuteParam.length != 4) {
			LOGGER.error("task error retry expression:{0} configure error",  errorStrategyExpression);
			return;
		}
		boolean isPublish = (Integer.valueOf(excuteParam[0])) == 1 ? true : false;
		int tryNum = Integer.valueOf(excuteParam[1]);
		long interval = Long.valueOf(excuteParam[2]);
		long beginTime = Long.valueOf(excuteParam[3]);
		this.doRetry(isPublish, tryNum, interval, beginTime, taskFlagList, taskContent, json, taskContent.getTenantId());
	}

	private void doRetry(boolean isPublish, int tryNum, long interval,
			long beginTime, List<String> taskFlagList,
			TaskContentBean taskContent, JSONObject json, Integer tenantId) {
		if(beginTime > 0) {
			try {
				Thread.sleep(beginTime * 1000);
			} catch (InterruptedException e) {
				LOGGER.error("retry begin sleep failed, taskName = " + taskContent.getTaskName(), e);
			}
		}
		int num = 0;
		String queueName = taskContent.getTaskTypeObj().getQueueName();
		int objId = taskContent.getTaskRelaObj().getObjId();
		while((tryNum-num) > 0) {
			try {
				if(errorType == TaskException.ERROR_TYPE_SEND_MQ) {
					activeMqDao.sendToActiveMq(json.toString(), queueName);
				} else{
					if(taskCasService.conTaskFlagIncacheStatus(taskFlagList,taskContent.getTaskStyle(), objId,tenantId)){
						for(String key:taskFlagList){
							taskCasService.modifyTaskCacheStatus(key, CacheFlagCommon.TASK_STATUS_READY);
						}
						activeMqDao.sendToActiveMq(json.toString(), queueName);
					}
				}
			} catch(TaskException e) {
				num++;
				LOGGER.error("retry failed, current num  = "+num+" of retry, taskName = " + taskContent.getTaskName() + " retry interval = " + interval + "s");
				if(interval > 0) {
					try {
						Thread.sleep(1000*interval);
					} catch (InterruptedException e1) {
						LOGGER.error("retry failed cause Thread sleep failed.", e1);
					}
				}
				continue;
			}
			LOGGER.debug("task excute error retry success!");
			return;
		}
		if(isPublish) {
			LOGGER.error("task excute error retry num("+tryNum+") failed, finilly isSend: "+isPublish+", errorType:"+errorType);
			if(errorType != TaskException.ERROR_TYPE_SEND_MQ) {
				try {
					activeMqDao.sendToActiveMq(json.toString(), (String)taskContent.getTaskTypeObj().getQueueName());
				} catch (TaskException e) {
					LOGGER.error("retry failed, tryNum = "+tryNum+" taskName = " + taskContent.getTaskName(), e);
				}
			}
		}
		
	}

	@Override
	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}

}
