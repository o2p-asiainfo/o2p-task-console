package com.asiainfo.integration.o2p.task.smo.job.listener;

import java.text.MessageFormat;

import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;

import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.Constant;
import com.asiainfo.integration.o2p.task.common.quartz.QuartzManager;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;

public class QuartzTriggerListener implements TriggerListener {
	private  static final Logger log = Logger.getLog(QuartzTriggerListener.class);
	private  QuartzManager quartzManager;
	private IJobLogService jobLogService;
	private String name;
	private String triggerFiredMessage = "Trigger {1}.{0} fired job {6}.{5} at: {4, date, HH:mm:ss MM/dd/yyyy}";
	private String triggerMisfiredMessage = "Trigger {0} misfired job {5}.{4}  at: {3, date, HH:mm:ss MM/dd/yyyy}.  Should have fired at: {2, date, HH:mm:ss MM/dd/yyyy}";
	private String triggerCompleteMessage = "Trigger {1}.{0} completed firing job {6}.{5} at {4, date, HH:mm:ss MM/dd/yyyy} with resulting trigger instruction code: {9}";

	
	public void setQuartzManager(QuartzManager quartzManager) {
		this.quartzManager = quartzManager;
	}

	public QuartzTriggerListener() {
		super();
		this.name = "DEFAULT_TRIGGER_LISTENER";
	}

	public String getTriggerFiredMessage() {
		return triggerFiredMessage;
	}

	public void setTriggerFiredMessage(String triggerFiredMessage) {
		this.triggerFiredMessage = triggerFiredMessage;
	}

	public String getTriggerCompleteMessage() {
		return triggerCompleteMessage;
	}

	public void setTriggerCompleteMessage(String triggerCompleteMessage) {
		this.triggerCompleteMessage = triggerCompleteMessage;
	}

	public void setJobLogService(IJobLogService jobLogService) {
		this.jobLogService = jobLogService;
	}

	
	public String getTriggerMisfiredMessage() {
		return triggerMisfiredMessage;
	}

	public void setTriggerMisfiredMessage(String triggerMisfiredMessage) {
		this.triggerMisfiredMessage = triggerMisfiredMessage;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		
        Object[] args = {
            trigger.getKey().getName(), trigger.getKey().getGroup(),
            trigger.getPreviousFireTime(), trigger.getNextFireTime(),
            new java.util.Date(), context.getJobDetail().getKey().getName(),
            context.getJobDetail().getKey().getGroup(),
            Integer.valueOf(context.getRefireCount())
        };

		log.info(MessageFormat.format(getTriggerFiredMessage(), args));
	}

	
	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
		String instrCode = "UNKNOWN";
		switch (triggerInstructionCode) {
		case DELETE_TRIGGER:
			instrCode = "DELETE TRIGGER";
			break;
		case NOOP:
			instrCode = "DO NOTHING";
			break;
		case RE_EXECUTE_JOB:
			instrCode = "RE-EXECUTE JOB";
			break;
		case SET_ALL_JOB_TRIGGERS_COMPLETE:
			instrCode = "SET ALL OF JOB'S TRIGGERS COMPLETE";
			break;
		case SET_TRIGGER_COMPLETE:
			instrCode = "SET THIS TRIGGER COMPLETE";
			break;
		default:
			instrCode = "UNKNOWN";
			break;
		}

        Object[] args = {
            trigger.getKey().getName(), trigger.getKey().getGroup(),
            trigger.getPreviousFireTime(), trigger.getNextFireTime(),
            new java.util.Date(), context.getJobDetail().getKey().getName(),
            context.getJobDetail().getKey().getGroup(),
            Integer.valueOf(context.getRefireCount()),
            triggerInstructionCode.name(), instrCode
        };

		log.info(MessageFormat.format(getTriggerCompleteMessage(), args));
	}

	public String getName() {
		return this.name;
	}

	@Override
	public void triggerMisfired(Trigger trigger) {
		Scheduler sched = quartzManager.getSched();
		String schdInstId = "";
		String jobName = trigger.getJobKey().getName();
		String jobClass = "";
		if(sched != null) {
			try {
				schdInstId = sched.getSchedulerInstanceId();
				jobClass = sched.getJobDetail(new JobKey(jobName, trigger.getJobKey().getGroup())).getJobClass().getName();
			} catch (SchedulerException e) {
				log.error(e.getMessage());
			}
		}
		
		Object[] args = {
            trigger.getKey().getName(),
            trigger.getPreviousFireTime(), trigger.getNextFireTime(),
            new java.util.Date(), trigger.getJobKey().getName(),
            trigger.getJobKey().getGroup()
        };
		String messFor = MessageFormat.format(getTriggerMisfiredMessage(), args);
		log.warn(messFor);
		 
//        jobLogService.addUnExedJobLog(messFor,schdInstId, jobName,jobClass, trigger.getKey().getGroup(), Constant.TASK_LOG_EVENT_TYPE_MISFIRED);
	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		log.info("vetoJobExecution: {0}",context.toString());
		return false;
	}
}
