package com.asiainfo.integration.o2p.task.smo.job.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobExecutionContext;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.ee.jmx.jboss.JBoss4RMIRemoteMBeanScheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.JobExecutionContextImpl;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.spi.TriggerFiredBundle;

import com.asiainfo.integration.o2p.task.QuartTestBean;
import com.asiainfo.integration.o2p.task.common.quartz.QuartzManager;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;
import com.asiainfo.integration.o2p.task.smo.impl.JobLogServiceImpl;

/**
 * The class <code>QuartzTriggerListenerTest</code> contains tests for the class
 * <code>{@link QuartzTriggerListener}</code>.
 * 
 * @generatedBy CodePro at 15-11-24 下午3:42
 * @author windy
 * @version $Revision: 1.0 $
 */
public class QuartzTriggerListenerTest {
	/**
	 * Run the QuartzTriggerListener() constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testQuartzTriggerListener_1() throws Exception {

		QuartzTriggerListener result = new QuartzTriggerListener();

		// add additional test code here
		assertNotNull(result);
		assertEquals("DEFAULT_TRIGGER_LISTENER", result.getName());
		assertEquals(
				"Trigger {1}.{0} completed firing job {6}.{5} at {4, date, HH:mm:ss MM/dd/yyyy} with resulting trigger instruction code: {9}",
				result.getTriggerCompleteMessage());
		assertEquals(
				"Trigger {0} misfired job {5}.{4}  at: {3, date, HH:mm:ss MM/dd/yyyy}.  Should have fired at: {2, date, HH:mm:ss MM/dd/yyyy}",
				result.getTriggerMisfiredMessage());
		assertEquals(
				"Trigger {1}.{0} fired job {6}.{5} at: {4, date, HH:mm:ss MM/dd/yyyy}",
				result.getTriggerFiredMessage());
	}

	/**
	 * Run the String getName() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetName_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTriggerCompleteMessage() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTriggerCompleteMessage_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");

		String result = fixture.getTriggerCompleteMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTriggerFiredMessage() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTriggerFiredMessage_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");

		String result = fixture.getTriggerFiredMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTriggerMisfiredMessage() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTriggerMisfiredMessage_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");

		String result = fixture.getTriggerMisfiredMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setJobLogService(IJobLogService) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetJobLogService_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");
		IJobLogService jobLogService = new JobLogServiceImpl();

		fixture.setJobLogService(jobLogService);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetName_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setQuartzManager(QuartzManager) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetQuartzManager_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");
		QuartzManager quartzManager = new QuartzManager();

		fixture.setQuartzManager(quartzManager);

		// add additional test code here
	}

	/**
	 * Run the void setTriggerCompleteMessage(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetTriggerCompleteMessage_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");
		String triggerCompleteMessage = "";

		fixture.setTriggerCompleteMessage(triggerCompleteMessage);

		// add additional test code here
	}

	/**
	 * Run the void setTriggerFiredMessage(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetTriggerFiredMessage_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");
		String triggerFiredMessage = "";

		fixture.setTriggerFiredMessage(triggerFiredMessage);

		// add additional test code here
	}

	/**
	 * Run the void setTriggerMisfiredMessage(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetTriggerMisfiredMessage_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");
		String triggerMisfiredMessage = "";

		fixture.setTriggerMisfiredMessage(triggerMisfiredMessage);

		// add additional test code here
	}

	/**
	 * Run the boolean vetoJobExecution(Trigger,JobExecutionContext) method
	 * test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testVetoJobExecution_1() throws Exception {
		QuartzTriggerListener fixture = new QuartzTriggerListener();
		fixture.setTriggerCompleteMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setName("");
		fixture.setTriggerMisfiredMessage("");
		fixture.setQuartzManager(new QuartzManager());
		fixture.setTriggerFiredMessage("");
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
				.cronSchedule("0 0 12 * * ?");
		CronTrigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(new TriggerKey("11", "11")).forJob("11", "11")
				.withSchedule(scheduleBuilder).build();
		JobExecutionContext context = new JobExecutionContextImpl(
				new JBoss4RMIRemoteMBeanScheduler(), new TriggerFiredBundle(
						new JobDetailImpl(), new CalendarIntervalTriggerImpl(),
						new AnnualCalendar(), true, new Date(), new Date(),
						new Date(), new Date()), new QuartTestBean());

		boolean result = fixture.vetoJobExecution(trigger, context);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:42
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
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(QuartzTriggerListenerTest.class);
	}
}