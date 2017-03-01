package com.asiainfo.integration.o2p.task.smo.job.listener;

import java.text.MessageFormat;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.op2.bo.EOPDomain;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.Constant;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;

public class QuartzJobListener implements  JobListener  {
	private  static final Logger log = Logger.getLog(QuartzJobListener.class);
	private IJobLogService jobLogService;


	private String name;
	private String jobToBeFiredMessage = "Job {1}.{0} fired (by trigger {4}.{3}) at: {2, date, HH:mm:ss MM/dd/yyyy}";
	    
	private String jobSuccessMessage = "Job {1}.{0} execution complete at {2, date, HH:mm:ss MM/dd/yyyy} and reports: {8}";

	private String jobFailedMessage = "Job {0} execution failed at {1, date, HH:mm:ss MM/dd/yyyy} and reports: {7}";

	private String jobWasVetoedMessage = "Job {1}.{0} was vetoed.  It was to be fired (by trigger {4}.{3}) at: {2, date, HH:mm:ss MM/dd/yyyy}";
	
	public void setJobLogService(IJobLogService jobLogService) {
		this.jobLogService = jobLogService;
	}

	public String getJobToBeFiredMessage() {
		return jobToBeFiredMessage;
	}

	public void setJobToBeFiredMessage(String jobToBeFiredMessage) {
		this.jobToBeFiredMessage = jobToBeFiredMessage;
	}

	public String getJobSuccessMessage() {
		return jobSuccessMessage;
	}

	public void setJobSuccessMessage(String jobSuccessMessage) {
		this.jobSuccessMessage = jobSuccessMessage;
	}

	public String getJobFailedMessage() {
		return jobFailedMessage;
	}

	public void setJobFailedMessage(String jobFailedMessage) {
		this.jobFailedMessage = jobFailedMessage;
	}

	public String getJobWasVetoedMessage() {
		return jobWasVetoedMessage;
	}

	public void setJobWasVetoedMessage(String jobWasVetoedMessage) {
		this.jobWasVetoedMessage = jobWasVetoedMessage;
	}

	public QuartzJobListener() {
		super();
		this.name = "DEFAULT_JOB_LISTENER";
	}

	public String getName() {
		return this.name;
	}

	public void jobToBeExecuted(JobExecutionContext context) {
		
	}

	public void jobExecutionVetoed(JobExecutionContext context) {
		
	}
	
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		String schdInstId = null;
		String jobClass = null;
		try {
			schdInstId = context.getScheduler().getSchedulerInstanceId();
			jobClass = context.getJobDetail().getJobClass().getName();
		} catch (SchedulerException e) {
			log.error(e.getMessage());
		}
		
		Trigger trigger = context.getTrigger();
        String jobName = trigger.getJobKey().getName();
        Object[] args = null;
        
        TaskContentBean taskContent = (TaskContentBean)context.getMergedJobDataMap().get("taskContent");
        if (jobException != null) {
        	if(taskContent != null && EOPDomain.YES.equalsIgnoreCase(taskContent.getEnableLog())) {
	            String errMsg = jobException.getMessage();
	            args = new Object[] {
	                    context.getJobDetail().getKey().getName(), new java.util.Date(),
	                    trigger.getKey().getName(), trigger.getKey().getGroup(),
	                    trigger.getPreviousFireTime(), trigger.getNextFireTime(),
	                    Integer.valueOf(context.getRefireCount()), errMsg
	                };
	            String messFor = MessageFormat.format(getJobFailedMessage(), args);
	            log.warn(messFor+ jobException.getMessage()); 
	            //任务异常日志
//	    		jobLogService.addExedJobErrorLog(messFor,schdInstId, jobName,jobClass, context, Constant.TASK_LOG_EVENT_TYPE_EXCEPTION);
        	}
        } else {
            
            String result = String.valueOf(context.getResult());
            args = new Object[] {
                    context.getJobDetail().getKey().getName(),
                    context.getJobDetail().getKey().getGroup(), new java.util.Date(),
                    trigger.getKey().getName(), trigger.getKey().getGroup(),
                    trigger.getPreviousFireTime(), trigger.getNextFireTime(),
                    Integer.valueOf(context.getRefireCount()), result
                };
            
            log.info(MessageFormat.format(getJobSuccessMessage(), args));
            //运行正常日志
//    		jobLogService.addExedJobLog(MessageFormat.format(getJobFailedMessage(), args),trigger.getJobName(), context);
        }
        
	}
}
