package com.asiainfo.integration.o2p.task.common.quartz;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.foundation.util.ExceptionUtils;

/**
 * @Title:Quartz管理类
 * 
 * @Description:
 * 
 * @Copyright: 
 * @author  
 * @version 1.00.000
 *
 */
public class QuartzManager {
   private static final String JOB_GROUP_NAME = "group1";
   private static final String TRIGGER_GROUP_NAME = "trigger1";
   private  Scheduler sched;
   private  static final Logger log = Logger.getLog(QuartzManager.class);

	public  void setSched(Scheduler sched) {
		this.sched = sched;
	}

	public Scheduler getSched() {
		return sched;
	}
   
   public void start() {
	   try {
		   if(!sched.isStarted()) {
			sched.start();
			//恢复调度器中的任务
			sched.resumeAll();
			
			}
		} catch (SchedulerException e) {
		    log.error(e.getMessage());
		}
   }

/**
    *  添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
    * @param jobName 任务名
    * @param job     任务
    * @param time    时间设置，参考quartz说明文档
    * @throws SchedulerException
    * @throws ParseException
    */
   public   void addJob(String jobName,Job job,String time) throws SchedulerException, ParseException{
       JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(new JobKey(jobName, JOB_GROUP_NAME)).build();//任务名，任务组，任务执行类
       //触发器
       CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
       CronTrigger  trigger =TriggerBuilder.newTrigger().withIdentity(new TriggerKey(jobName, TRIGGER_GROUP_NAME)).withSchedule(scheduleBuilder).build();//触发器名,触发器组
       sched.scheduleJob(jobDetail,trigger);
       //启动
       if(!sched.isShutdown()) {
          sched.start();
       }
       
   }
   
   /**
    * 清空所有quart正在运行的任务
    * @throws SchedulerException
    */
   public void clear() throws SchedulerException {
	   sched.clear();
   }
   
   /**
    * 添加一个定时任务
    * @param jobName 任务名
    * @param jobGroupName 任务组名
    * @param triggerName  触发器名
    * @param triggerGroupName 触发器组名
    * @param job     任务
    * @param time    时间设置，参考quartz说明文档
    * @throws SchedulerException
    * @throws ParseException
    */
   public   void addJob(String jobName,String jobGroupName,String triggerName,String triggerGroupName, Job job,String time) 
                               throws SchedulerException, ParseException{
       JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(new JobKey(jobName, jobGroupName)).build();//任务名，任务组，任务执行类
       //触发器
       CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
       CronTrigger  trigger =TriggerBuilder.newTrigger().withIdentity(new TriggerKey(jobName, jobGroupName)).withSchedule(scheduleBuilder).build();//触发器名,触发器组
       sched.scheduleJob(jobDetail,trigger);
       sched.resumeAll();
       if(!sched.isShutdown()) {
          sched.start();
       }
   }
   
   public   void addJob(JobDetail jobDetail, String triggerName,String triggerGroupName,String time) 
           throws SchedulerException, ParseException{
	    //触发器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
        CronTrigger  trigger =TriggerBuilder.newTrigger().withIdentity(new TriggerKey(triggerName, triggerGroupName)).withSchedule(scheduleBuilder).build();//触发器名,触发器组
		sched.scheduleJob(jobDetail,trigger);
		sched.resumeAll();
		if(!sched.isStarted()) {
			sched.start();
		}
   }   
   /**
    * 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)
    * @param jobName
    * @param time
    * @throws SchedulerException
    * @throws ParseException
    */
   public   void modifyJobTime(String jobName,String time) throws SchedulerException, ParseException{
	   TriggerKey key = new TriggerKey(jobName, TRIGGER_GROUP_NAME);
       Trigger trigger =  sched.getTrigger(key);
       if(trigger != null){
    	   CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
           trigger =TriggerBuilder.newTrigger().withIdentity(new TriggerKey(jobName, TRIGGER_GROUP_NAME)).withSchedule(scheduleBuilder).build();//触发器名,触发器组
    	   sched.rescheduleJob(key, trigger);
       }
   }
   
   /**
    * 修改一个任务的触发时间
    * @param triggerName
    * @param triggerGroupName
    * @param time
    * @throws SchedulerException
    * @throws ParseException
    */
   public   void modifyJobTime(String triggerName,String triggerGroupName,
                                    String time) 
                                  throws SchedulerException, ParseException{
	   TriggerKey key = new TriggerKey(triggerName, triggerGroupName);
       Trigger trigger =  sched.getTrigger(key);
       if(trigger != null){
    	   CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
           trigger =TriggerBuilder.newTrigger().withIdentity(new TriggerKey(triggerName, TRIGGER_GROUP_NAME)).withSchedule(scheduleBuilder).build();//触发器名,触发器组
    	   sched.rescheduleJob(key, trigger);
       }
   }
   
   /**
    * 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
    * @param jobName
    * @throws SchedulerException
    */
   public   void removeJob(String jobName) throws SchedulerException{
	   TriggerKey key = new TriggerKey(jobName, TRIGGER_GROUP_NAME);
	   JobKey jobKey = new JobKey(jobName, JOB_GROUP_NAME);
       sched.pauseTrigger(key);//停止触发器
       sched.unscheduleJob(key);//移除触发器
       sched.deleteJob(jobKey);//删除任务
   }
   
   /**
    * 移除一个任务
    * @param jobName
    * @param jobGroupName
    * @param triggerName
    * @param triggerGroupName
    * @throws SchedulerException
    */
   public   void removeJob(String jobName,String jobGroupName,String triggerName,String triggerGroupName) 
          throws SchedulerException{
	   TriggerKey key = new TriggerKey(jobName, jobGroupName);
	   JobKey jobKey = new JobKey(jobName, jobGroupName);
       sched.pauseTrigger(key);//停止触发器
       sched.unscheduleJob(key);//移除触发器
       sched.deleteJob(jobKey);//删除任务
   }
   
   public	void shutdown() throws SchedulerException{
	   sched.shutdown() ;
	   try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		log.error("quartz shutdown error ,cause: {0}", ExceptionUtils.populateExecption(e,500));
	}
	   
   }

	public  void removeJob(String jobGroupName, String triggerGroupName) throws SchedulerException {
		GroupMatcher<JobKey> gm = GroupMatcher.jobGroupEquals(jobGroupName);
		sched.pauseJobs(gm);
		Set<JobKey> jobNames = sched.getJobKeys(gm);
		if(jobNames != null) {
			for(JobKey jobName : jobNames){
				TriggerKey key = new TriggerKey(jobName.getName(), triggerGroupName);
				sched.pauseTrigger(key);//停止触发器
			    sched.unscheduleJob(key);//移除触发器
				sched.deleteJob(jobName);
			}
		}
	}

	public  void modifyJobGroupTime(String triggerGroupName, String time) throws SchedulerException, ParseException {
		GroupMatcher<JobKey> gm = GroupMatcher.jobGroupEquals(triggerGroupName);
		GroupMatcher<TriggerKey> tm = GroupMatcher.triggerGroupEquals(triggerGroupName);
		sched.pauseJobs(gm);
		sched.pauseTriggers(tm);
		Set<TriggerKey> triggerNames = sched.getTriggerKeys(tm);
		if(triggerNames != null) {
			for(TriggerKey triggerName : triggerNames) {
				Trigger trigger =  sched.getTrigger(triggerName);
				if(trigger != null){
					CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(time);
			        trigger =TriggerBuilder.newTrigger().withIdentity(new TriggerKey(triggerName.getName(), triggerGroupName)).withSchedule(scheduleBuilder).build();//触发器名,触发器组
			    	sched.rescheduleJob(triggerName, trigger);
				}
			}
		}
	}

	public List<String> getCurrRunTaskList() {
		List<String> names;
		List<String> list = new ArrayList<String>();
		try {
			names = sched.getJobGroupNames();
			if(names != null) {
				for(String name : names) {
					list.add(name);
				}
			}
		} catch (SchedulerException e) {
			log.error("get running task list error", e);
		}
		return list;
	}

	public void pauseAll() {
		try {
			sched.pauseAll();
		} catch (SchedulerException e) {
			 log.error("pause all task error", e);
		}
	}
}
