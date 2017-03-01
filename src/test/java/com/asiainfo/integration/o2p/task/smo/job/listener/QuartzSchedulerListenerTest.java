package com.asiainfo.integration.o2p.task.smo.job.listener;

import static org.junit.Assert.assertNotNull;

import java.io.Reader;
import java.sql.Connection;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asiainfo.integration.o2p.task.common.quartz.QuartzManager;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;
import com.asiainfo.integration.o2p.task.smo.impl.JobLogServiceImpl;
import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;

/**
 * The class <code>QuartzSchedulerListenerTest</code> contains tests for the
 * class <code>{@link QuartzSchedulerListener}</code>.
 * 
 * @generatedBy CodePro at 15-11-24 下午3:39
 * @author windy
 * @version $Revision: 1.0 $
 */
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:o2p-taskconsole-spring-db.xml")
public class QuartzSchedulerListenerTest {

	@Resource(name = "DEPSqlSessionFactory")
	public SqlSessionFactory depSqlSessionFactory;
	@Resource(name = "taskJobDAO")
	public ITaskJobDAO taskJobDAO;

	public static boolean isInit = false;

	@Before
	public void setUp() throws Exception {
		if (!isInit) {
			SqlSession session = depSqlSessionFactory.openSession();
			Connection conn = session.getConnection();
			Reader reader = Resources.getResourceAsReader("task_log.sql");
			ScriptRunner runner = new ScriptRunner(conn, true, true);
			runner.setLogWriter(null);
			runner.runScript(reader);
			reader.close();
			session.close();
			isInit = true;
		}
	}

	/**
	 * Run the QuartzSchedulerListener() constructor test.
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testQuartzSchedulerListener_1() throws Exception {
		QuartzSchedulerListener result = new QuartzSchedulerListener();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void addUnExedJobLog(String,String,String,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testAddUnExedJobLog_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String message = "";
		String jobName = "";
		String groupName = "1";
		String eventType = "1";

		fixture.addUnExedJobLog(message, jobName, groupName, eventType);

		// add additional test code here
	}

	/**
	 * Run the void addUnExedJobLog(String,String,String,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testAddUnExedJobLog_2() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String message = "";
		String jobName = "";
		String groupName = "1";
		String eventType = "1";

		fixture.addUnExedJobLog(message, jobName, groupName, eventType);

		// add additional test code here
	}

	/**
	 * Run the void addUnExedJobLog(String,String,String,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testAddUnExedJobLog_3() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String message = "";
		String jobName = null;
		String groupName = "1";
		String eventType = "1";

		fixture.addUnExedJobLog(message, jobName, groupName, eventType);

		// add additional test code here
	}

	/**
	 * Run the void addUnExedJobLog(String,String,String,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testAddUnExedJobLog_4() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String message = "";
		String jobName = "";
		String groupName = "1";
		String eventType = "";

		fixture.addUnExedJobLog(message, jobName, groupName, eventType);

		// add additional test code here
	}

	/**
	 * Run the void addUnExedJobLog(String,String,String,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testAddUnExedJobLog_5() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String message = "";
		String jobName = "";
		String groupName = "1";
		String eventType = "";

		fixture.addUnExedJobLog(message, jobName, groupName, eventType);

		// add additional test code here
	}

	/**
	 * Run the void addUnExedJobLog(String,String,String,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testAddUnExedJobLog_6() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String message = "";
		String jobName = "";
		String groupName = "1";
		String eventType = "";

		fixture.addUnExedJobLog(message, jobName, groupName, eventType);

		// add additional test code here
	}

	/**
	 * Run the void addUnExedJobLog(String,String,String,String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testAddUnExedJobLog_7() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String message = "1";
		String jobName = "1";
		String groupName = "1";
		String eventType = "1";

		fixture.addUnExedJobLog(message, jobName, groupName, eventType);

		// add additional test code here
	}

	/**
	 * Run the void jobAdded(JobDetail) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobAdded_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		JobDetail arg0 = new JobDetailImpl();

		fixture.jobAdded(arg0);

		// add additional test code here
	}

	/**
	 * Run the void jobDeleted(JobKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobDeleted_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		JobKey key = new JobKey("");

		fixture.jobDeleted(key);

		// add additional test code here
	}

	/**
	 * Run the void jobPaused(JobKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobPaused_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		JobKey jobKey = new JobKey("");

		fixture.jobPaused(jobKey);

		// add additional test code here
	}

	/**
	 * Run the void jobResumed(JobKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobResumed_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		JobKey jobKey = new JobKey("");

		fixture.jobResumed(jobKey);

		// add additional test code here
	}

	/**
	 * Run the void jobScheduled(Trigger) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobScheduled_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
				.cronSchedule("0 0 12 * * ?");
		CronTrigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(new TriggerKey("11", "11")).forJob("11", "11")
				.withSchedule(scheduleBuilder).build();

		fixture.jobScheduled(trigger);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.listener.QuartzSchedulerListener.jobScheduled(QuartzSchedulerListener.java:39)
	}

	/**
	 * Run the void jobScheduled(Trigger) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobScheduled_2() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		Trigger trigger = null;

		fixture.jobScheduled(trigger);

		// add additional test code here
	}

	/**
	 * Run the void jobUnscheduled(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobUnscheduled_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.jobUnscheduled(key);

		// add additional test code here
	}

	/**
	 * Run the void jobUnscheduled(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobUnscheduled_2() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.jobUnscheduled(key);

		// add additional test code here
	}

	/**
	 * Run the void jobUnscheduled(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobUnscheduled_3() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.jobUnscheduled(key);

		// add additional test code here
	}

	/**
	 * Run the void jobsPaused(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobsPaused_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String jobGroup = "";

		fixture.jobsPaused(jobGroup);

		// add additional test code here
	}

	/**
	 * Run the void jobsResumed(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testJobsResumed_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String jobGroup = "";

		fixture.jobsResumed(jobGroup);

		// add additional test code here
	}

	/**
	 * Run the void schedulerError(String,SchedulerException) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSchedulerError_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String msg = "";
		SchedulerException cause = new SchedulerException();

		fixture.schedulerError(msg, cause);

		// add additional test code here
	}

	/**
	 * Run the void schedulerInStandbyMode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSchedulerInStandbyMode_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());

		fixture.schedulerInStandbyMode();

		// add additional test code here
	}

	/**
	 * Run the void schedulerShutdown() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSchedulerShutdown_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());

		fixture.schedulerShutdown();

		// add additional test code here
	}

	/**
	 * Run the void schedulerShuttingdown() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSchedulerShuttingdown_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());

		fixture.schedulerShuttingdown();

		// add additional test code here
	}

	/**
	 * Run the void schedulerStarted() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSchedulerStarted_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());

		fixture.schedulerStarted();

		// add additional test code here
	}

	/**
	 * Run the void schedulerStarting() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSchedulerStarting_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());

		fixture.schedulerStarting();

		// add additional test code here
	}

	/**
	 * Run the void schedulingDataCleared() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSchedulingDataCleared_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());

		fixture.schedulingDataCleared();

		// add additional test code here
	}

	/**
	 * Run the void setJobLogService(IJobLogService) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetJobLogService_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		IJobLogService jobLogService = new JobLogServiceImpl();

		fixture.setJobLogService(jobLogService);

		// add additional test code here
	}

	/**
	 * Run the void setQuartzManager(QuartzManager) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetQuartzManager_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		QuartzManager quartzManager = new QuartzManager();

		fixture.setQuartzManager(quartzManager);

		// add additional test code here
	}

	/**
	 * Run the void triggerFinalized(Trigger) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggerFinalized_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
				.cronSchedule("0 0 12 * * ?");
		CronTrigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(new TriggerKey("11", "11")).forJob("11", "11")
				.withSchedule(scheduleBuilder).build();

		fixture.triggerFinalized(trigger);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.listener.QuartzSchedulerListener.triggerFinalized(QuartzSchedulerListener.java:70)
	}

	/**
	 * Run the void triggerFinalized(Trigger) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggerFinalized_2() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		Trigger trigger = null;

		fixture.triggerFinalized(trigger);

		// add additional test code here
	}

	/**
	 * Run the void triggerPaused(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggerPaused_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.triggerPaused(key);

		// add additional test code here
	}

	/**
	 * Run the void triggerPaused(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggerPaused_2() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.triggerPaused(key);

		// add additional test code here
	}

	/**
	 * Run the void triggerPaused(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggerPaused_3() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.triggerPaused(key);

		// add additional test code here
	}

	/**
	 * Run the void triggerResumed(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggerResumed_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.triggerResumed(key);

		// add additional test code here
	}

	/**
	 * Run the void triggerResumed(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggerResumed_2() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.triggerResumed(key);

		// add additional test code here
	}

	/**
	 * Run the void triggerResumed(TriggerKey) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggerResumed_3() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		TriggerKey key = new TriggerKey("1", "1");

		fixture.triggerResumed(key);

		// add additional test code here
	}

	/**
	 * Run the void triggersResumed(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testTriggersResumed_1() throws Exception {
		QuartzSchedulerListener fixture = new QuartzSchedulerListener();
		JobLogServiceImpl service = new JobLogServiceImpl();
		service.setTaskJobDAO(taskJobDAO);
		fixture.setJobLogService(service);
		fixture.setQuartzManager(new QuartzManager());
		String triggerGroup = "";

		fixture.triggersResumed(triggerGroup);

		// add additional test code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(QuartzSchedulerListenerTest.class);
	}
}