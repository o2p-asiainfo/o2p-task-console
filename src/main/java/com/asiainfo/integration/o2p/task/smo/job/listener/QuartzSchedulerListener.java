package com.asiainfo.integration.o2p.task.smo.job.listener;

import java.text.MessageFormat;
import java.util.Set;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;

import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.Constant;
import com.asiainfo.integration.o2p.task.common.quartz.QuartzManager;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;

public class QuartzSchedulerListener implements SchedulerListener {
	private  static final Logger log = Logger.getLog(QuartzTriggerListener.class);
	private IJobLogService jobLogService;
	private  QuartzManager quartzManager;
	
	public void setJobLogService(IJobLogService jobLogService) {
		this.jobLogService = jobLogService;
	}

	public void setQuartzManager(QuartzManager quartzManager) {
		this.quartzManager = quartzManager;
	}

	@Override
	public void jobScheduled(Trigger trigger) {
		if(trigger != null) {
			String message = "Job {0} scheduled  at: {1, date, HH:mm:ss MM/dd/yyyy}";
		
			Object[] args = {
					trigger.getKey().getName(),
		            new java.util.Date() 
	        };
			String messFor = MessageFormat.format(message, args);
			this.addUnExedJobLog(messFor, trigger.getKey().getName(), trigger.getJobKey().getGroup(), Constant.TASK_LOG_EVENT_TYPE_SCHEDULED);
			log.info(messFor);
		}
	}

	@Override
	public void jobUnscheduled(TriggerKey key) {
		if(key != null) {
			String message = "Job {0} unscheduled  at: {1, date, HH:mm:ss MM/dd/yyyy}";
			Object[] args = {
					key.getName(),
	            new java.util.Date() 
	        };
			String messFor = MessageFormat.format(message, args);
			
			if(key.getGroup() != null) {
				this.addUnExedJobLog(messFor, key.getName(), key.getGroup(), Constant.TASK_LOG_EVENT_TYPE_UNSCHEDULED);
			}
			
			log.warn(messFor);
		}
	}

	public void triggerFinalized(Trigger trigger) {
		if(trigger != null) {
			String message = "Trigger {0} will never fire again";
			Object[] args = {
					trigger.getKey().getName()
	        };
			String messFor = MessageFormat.format(message, args);
			this.addUnExedJobLog(messFor, trigger.getKey().getName(), trigger.getJobKey().getGroup(), Constant.TASK_LOG_EVENT_TYPE_FINALIZED);
			log.warn(messFor);
		}
		
	}

	@Override
	public void triggersPaused(String triggerGroup) {
		GroupMatcher<TriggerKey> gm = GroupMatcher.triggerGroupEquals(triggerGroup);
		Set<TriggerKey> tk;
		try {
			tk = quartzManager.getSched().getTriggerKeys(gm);
			if(tk != null) {
				for(TriggerKey key: tk) {
					String message = "Trigger {0} paused  at: {1, date, HH:mm:ss MM/dd/yyyy}";
					Object[] args = {
							key.getName(), 
			            new java.util.Date() 
			        };
					String messFor = MessageFormat.format(message, args);
					if(key.getGroup() != null) {
						this.addUnExedJobLog(messFor, key.getName(), key.getGroup(), Constant.TASK_LOG_EVENT_TYPE_PAUSED);
					}
					log.warn(messFor);
				}
			}
		} catch (SchedulerException e) {
			log.error("Scedlisteners triggers pause error", e);
		}
		
	}

	@Override
	public void triggersResumed(String triggerGroup) {
		log.info("triggersResumed"+ triggerGroup);
	}

	@Override
	public void jobsPaused(String jobGroup) {
		log.info("jobsPaused" + jobGroup);
	}

	@Override
	public void jobsResumed(String jobGroup) {
		log.info("jobsResumed" + jobGroup);
	}

	@Override
	public void schedulerError(String msg, SchedulerException cause) {
		String message = "**** Scheduler error " + msg;
		cause.getMessage();
		
		log.warn(message);
	}

	@Override
	public void schedulerShutdown() {
		String message = "Scheduler shutdown  at: {0, date, HH:mm:ss MM/dd/yyyy}";
		Object[] args = {
            new java.util.Date() 
        };
		String messFor = MessageFormat.format(message, args);
		this.addUnExedJobLog(messFor, "", "-1", Constant.TASK_LOG_EVENT_TYPE_SCHED_SHUTDOWN);
		log.warn(messFor);
	}

	public void addUnExedJobLog(String message, String jobName, String groupName, String eventType) {
		Scheduler sched = quartzManager.getSched();
		String schdInstId = "";
		String jobClass = "";
		if(sched != null) {
			try {
				schdInstId = sched.getSchedulerInstanceId();
				if(jobName != null && !"".equals(jobName)) {
					JobDetail jd = sched.getJobDetail(new JobKey(jobName, groupName));
					if(jd != null) {
						jobClass = jd.getJobClass().getName();
					}
				}
			} catch (SchedulerException e) {
				log.error(e.getMessage());
			}
		}
		 log.info(message+", jobName:"+jobName+", eventType:"+eventType);
//		jobLogService.addUnExedJobLog(message, schdInstId, jobName, jobClass, groupName, eventType);
	}

	@Override
	public void jobAdded(JobDetail arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jobDeleted(JobKey key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void schedulerInStandbyMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void schedulerShuttingdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void schedulerStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void triggerPaused(TriggerKey key) {
		if(key != null) {
			String message = "Trigger {0} paused  at: {1, date, HH:mm:ss MM/dd/yyyy}";
			Object[] args = {
					key.getName(), 
	            new java.util.Date() 
	        };
			String messFor = MessageFormat.format(message, args);
			if(key.getGroup() != null) {
				this.addUnExedJobLog(messFor, key.getName(), key.getGroup(), Constant.TASK_LOG_EVENT_TYPE_PAUSED);
			}
			log.warn(messFor);
		}
	}

	@Override
	public void triggerResumed(TriggerKey key) {
		if(key != null) {
			String message = "Trigger {0} resumer  at: {1, date, HH:mm:ss MM/dd/yyyy}";
			Object[] args = {
					key.getName(), 
	            new java.util.Date() 
	        };
			String messFor = MessageFormat.format(message, args);
			if(key.getGroup() != null) {
				this.addUnExedJobLog(messFor, key.getName(), key.getGroup(), Constant.TASK_LOG_EVENT_TYPE_PAUSED);
			}
			log.warn(messFor);
		}
	}

	@Override
	public void jobPaused(JobKey jobKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jobResumed(JobKey jobKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void schedulerStarting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void schedulingDataCleared() {
		// TODO Auto-generated method stub
		
	}
}
