package com.asiainfo.integration.o2p.task.smo.job.listener;

import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;
import org.quartz.Calendar;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.ee.jmx.jboss.JBoss4RMIRemoteMBeanScheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.JobExecutionContextImpl;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.TriggerFiredBundle;
import com.asiainfo.integration.o2p.task.QuartTestBean;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;
import com.asiainfo.integration.o2p.task.smo.impl.JobLogServiceImpl;

/**
 * The class <code>QuartzJobListenerTest</code> contains tests for the class <code>{@link QuartzJobListener}</code>.
 *
 * @generatedBy CodePro at 15-11-24 下午3:41
 * @author windy
 * @version $Revision: 1.0 $
 */
public class QuartzJobListenerTest {
	/**
	 * Run the QuartzJobListener() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testQuartzJobListener_1()
		throws Exception {

		QuartzJobListener result = new QuartzJobListener();

		// add additional test code here
		assertNotNull(result);
		assertEquals("DEFAULT_JOB_LISTENER", result.getName());
		assertEquals("Job {1}.{0} fired (by trigger {4}.{3}) at: {2, date, HH:mm:ss MM/dd/yyyy}", result.getJobToBeFiredMessage());
		assertEquals("Job {1}.{0} was vetoed.  It was to be fired (by trigger {4}.{3}) at: {2, date, HH:mm:ss MM/dd/yyyy}", result.getJobWasVetoedMessage());
		assertEquals("Job {1}.{0} execution complete at {2, date, HH:mm:ss MM/dd/yyyy} and reports: {8}", result.getJobSuccessMessage());
		assertEquals("Job {0} execution failed at {1, date, HH:mm:ss MM/dd/yyyy} and reports: {7}", result.getJobFailedMessage());
	}

	/**
	 * Run the String getJobFailedMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testGetJobFailedMessage_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");

		String result = fixture.getJobFailedMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getJobSuccessMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testGetJobSuccessMessage_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");

		String result = fixture.getJobSuccessMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getJobToBeFiredMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testGetJobToBeFiredMessage_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");

		String result = fixture.getJobToBeFiredMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getJobWasVetoedMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testGetJobWasVetoedMessage_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");

		String result = fixture.getJobWasVetoedMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("DEFAULT_JOB_LISTENER", result);
	}

	/**
	 * Run the void jobExecutionVetoed(JobExecutionContext) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testJobExecutionVetoed_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");
		JobExecutionContext context = new JobExecutionContextImpl(new JBoss4RMIRemoteMBeanScheduler(), new TriggerFiredBundle(new JobDetailImpl(), new CalendarIntervalTriggerImpl(), new AnnualCalendar(), true, new Date(), new Date(), new Date(), new Date()), new QuartTestBean());

		fixture.jobExecutionVetoed(context);

		// add additional test code here
	}

	/**
	 * Run the void jobToBeExecuted(JobExecutionContext) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testJobToBeExecuted_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");
		JobExecutionContext context = new JobExecutionContextImpl(new JBoss4RMIRemoteMBeanScheduler(), new TriggerFiredBundle(new JobDetailImpl(), new CalendarIntervalTriggerImpl(), new AnnualCalendar(), true, new Date(), new Date(), new Date(), new Date()), new QuartTestBean());

		fixture.jobToBeExecuted(context);

		// add additional test code here
	}

	/**
	 * Run the void setJobFailedMessage(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testSetJobFailedMessage_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");
		String jobFailedMessage = "";

		fixture.setJobFailedMessage(jobFailedMessage);

		// add additional test code here
	}

	/**
	 * Run the void setJobLogService(IJobLogService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testSetJobLogService_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");
		IJobLogService jobLogService = new JobLogServiceImpl();

		fixture.setJobLogService(jobLogService);

		// add additional test code here
	}

	/**
	 * Run the void setJobSuccessMessage(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testSetJobSuccessMessage_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");
		String jobSuccessMessage = "";

		fixture.setJobSuccessMessage(jobSuccessMessage);

		// add additional test code here
	}

	/**
	 * Run the void setJobToBeFiredMessage(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testSetJobToBeFiredMessage_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");
		String jobToBeFiredMessage = "";

		fixture.setJobToBeFiredMessage(jobToBeFiredMessage);

		// add additional test code here
	}

	/**
	 * Run the void setJobWasVetoedMessage(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Test
	public void testSetJobWasVetoedMessage_1()
		throws Exception {
		QuartzJobListener fixture = new QuartzJobListener();
		fixture.setJobFailedMessage("");
		fixture.setJobWasVetoedMessage("");
		fixture.setJobToBeFiredMessage("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setJobSuccessMessage("");
		String jobWasVetoedMessage = "";

		fixture.setJobWasVetoedMessage(jobWasVetoedMessage);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:41
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(QuartzJobListenerTest.class);
	}
}