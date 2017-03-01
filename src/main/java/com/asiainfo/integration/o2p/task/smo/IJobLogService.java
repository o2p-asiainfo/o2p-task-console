package com.asiainfo.integration.o2p.task.smo;

import java.util.Map;

import org.quartz.JobExecutionContext;


public interface IJobLogService {
	
	void addUnExedJobLog(String message, String schdInstId, String jobName, String jobClass, String groupName, String eventType);

	void addExedJobLog(String message, String schdInstId, String jobName, String jobClass, JobExecutionContext context, String eventType);
	
	void addOperatorLog(Map<String, Object> map);
	
	void addExedJobErrorLog(String errMsg, String schdInstId,  String jobName, String jobClass, JobExecutionContext context, String eventType);
}
