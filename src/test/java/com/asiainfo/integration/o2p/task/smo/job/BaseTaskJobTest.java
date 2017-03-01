package com.asiainfo.integration.o2p.task.smo.job;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.quartz.JobExecutionContext;
import org.quartz.ee.jmx.jboss.JBoss4RMIRemoteMBeanScheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.JobExecutionContextImpl;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.spi.TriggerFiredBundle;

import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.asiainfo.integration.o2p.task.QuartTestBean;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;
import com.asiainfo.integration.o2p.task.dao.activemq.IActiveMqDao;
import com.asiainfo.integration.o2p.task.dao.activemq.impl.JmsTemplateDao;
import com.asiainfo.integration.o2p.task.dao.impl.TaskJobDAOImpl;
import com.asiainfo.integration.o2p.task.service.IErrorStrategyService;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;
import com.asiainfo.integration.o2p.task.service.Impl.ErrorStrategyImpl;
import com.asiainfo.integration.o2p.task.service.Impl.TaskCacheService;

/**
 * The class <code>BaseTaskJobTest</code> contains tests for the class
 * <code>{@link BaseTaskJob}</code>.
 * 
 * @generatedBy CodePro at 15-11-24 下午3:45
 * @author windy
 * @version $Revision: 1.0 $
 */
public class BaseTaskJobTest {
	/**
	 * Run the void execute(JobExecutionContext) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testExecute_1() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());
		JobExecutionContext context = new JobExecutionContextImpl(
				new JBoss4RMIRemoteMBeanScheduler(), new TriggerFiredBundle(
						new JobDetailImpl(), new CalendarIntervalTriggerImpl(),
						new AnnualCalendar(), true, new Date(), new Date(),
						new Date(), new Date()), new QuartTestBean());
		context.getMergedJobDataMap().put("taskContent", new TaskContentBean());
		fixture.execute(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.execute(BaseTaskJob.java:40)
	}

	/**
	 * Run the void execute(JobExecutionContext) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testExecute_2() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());
		JobExecutionContext context = new JobExecutionContextImpl(
				new JBoss4RMIRemoteMBeanScheduler(), new TriggerFiredBundle(
						new JobDetailImpl(), new CalendarIntervalTriggerImpl(),
						new AnnualCalendar(), true, new Date(), new Date(),
						new Date(), new Date()), new QuartTestBean());
		context.getMergedJobDataMap().put("taskContent", new TaskContentBean());
		fixture.execute(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.execute(BaseTaskJob.java:40)
	}

	/**
	 * Run the void execute(JobExecutionContext) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testExecute_3() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());
		JobExecutionContext context = new JobExecutionContextImpl(
				new JBoss4RMIRemoteMBeanScheduler(), new TriggerFiredBundle(
						new JobDetailImpl(), new CalendarIntervalTriggerImpl(),
						new AnnualCalendar(), true, new Date(), new Date(),
						new Date(), new Date()), new QuartTestBean());
		context.getMergedJobDataMap().put("taskContent", new TaskContentBean());
		fixture.execute(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.execute(BaseTaskJob.java:40)
	}

	/**
	 * Run the void execute(JobExecutionContext) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testExecute_4() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());
		JobExecutionContext context = new JobExecutionContextImpl(
				new JBoss4RMIRemoteMBeanScheduler(), new TriggerFiredBundle(
						new JobDetailImpl(), new CalendarIntervalTriggerImpl(),
						new AnnualCalendar(), true, new Date(), new Date(),
						new Date(), new Date()), new QuartTestBean());
		context.getMergedJobDataMap().put("taskContent", new TaskContentBean());
		fixture.execute(context);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.execute(BaseTaskJob.java:40)
	}

	/**
	 * Run the IActiveMqDao getActiveMqDao() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetActiveMqDao_1() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		IActiveMqDao result = fixture.getActiveMqDao();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getActiveMqDao(BaseTaskJob.java:77)
		assertNotNull(result);
	}

	/**
	 * Run the IActiveMqDao getActiveMqDao() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetActiveMqDao_2() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		IActiveMqDao result = fixture.getActiveMqDao();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getActiveMqDao(BaseTaskJob.java:77)
		assertNotNull(result);
	}

	/**
	 * Run the IActiveMqDao getActiveMqDao() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetActiveMqDao_3() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		IActiveMqDao result = fixture.getActiveMqDao();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getActiveMqDao(BaseTaskJob.java:77)
		assertNotNull(result);
	}

	/**
	 * Run the IErrorStrategyService getErrorStrategyService() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetErrorStrategyService_1() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		IErrorStrategyService result = fixture.getErrorStrategyService();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getErrorStrategyService(BaseTaskJob.java:91)
		assertNotNull(result);
	}

	/**
	 * Run the IErrorStrategyService getErrorStrategyService() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetErrorStrategyService_2() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		IErrorStrategyService result = fixture.getErrorStrategyService();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getErrorStrategyService(BaseTaskJob.java:91)
		assertNotNull(result);
	}

	/**
	 * Run the IErrorStrategyService getErrorStrategyService() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetErrorStrategyService_3() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		IErrorStrategyService result = fixture.getErrorStrategyService();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getErrorStrategyService(BaseTaskJob.java:91)
		assertNotNull(result);
	}

	/**
	 * Run the ITaskCasService getTaskCasService() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testgetTaskCasService_1() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());
		
		ITaskCasService result = fixture.getTaskCasService();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskCasService(BaseTaskJob.java:70)
		assertNotNull(result);
	}

	/**
	 * Run the ITaskCasService getTaskCasService() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testgetTaskCasService_2() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		ITaskCasService result = fixture.getTaskCasService();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskCasService(BaseTaskJob.java:70)
		assertNotNull(result);
	}

	/**
	 * Run the ITaskCasService getTaskCasService() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testgetTaskCasService_3() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		ITaskCasService result = fixture.getTaskCasService();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskCasService(BaseTaskJob.java:70)
		assertNotNull(result);
	}

	/**
	 * Run the ITaskJobDAO getTaskJobDAO() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetTaskJobDAO_1() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		ITaskJobDAO result = fixture.getTaskJobDAO();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskJobDAO(BaseTaskJob.java:84)
		assertNotNull(result);
	}

	/**
	 * Run the ITaskJobDAO getTaskJobDAO() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetTaskJobDAO_2() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		ITaskJobDAO result = fixture.getTaskJobDAO();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskJobDAO(BaseTaskJob.java:84)
		assertNotNull(result);
	}

	/**
	 * Run the ITaskJobDAO getTaskJobDAO() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	@Test
	public void testGetTaskJobDAO_3() throws Exception {
		BaseTaskJob fixture = new ConCurrentTaskJob();fixture.setTaskCasService(new TaskCacheService());
		fixture.setErrorStrategyService(new ErrorStrategyImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());
		fixture.setActiveMqDao(new JmsTemplateDao());

		ITaskJobDAO result = fixture.getTaskJobDAO();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskJobDAO(BaseTaskJob.java:84)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:45
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
	 * @generatedBy CodePro at 15-11-24 下午3:45
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
	 * @generatedBy CodePro at 15-11-24 下午3:45
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BaseTaskJobTest.class);
	}
}