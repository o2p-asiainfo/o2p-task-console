package com.asiainfo.integration.o2p.task.smo.job;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.asiainfo.integration.o2p.task.service.Impl.TaskCacheService;

/**
 * The class <code>ConCurrentTaskJobTest</code> contains tests for the class
 * <code>{@link ConCurrentTaskJob}</code>.
 * 
 * @generatedBy CodePro at 15-11-24 下午3:43
 * @author windy
 * @version $Revision: 1.0 $
 */
public class ConCurrentTaskJobTest {
	/**
	 * Run the ConCurrentTaskJob() constructor test.
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testConCurrentTaskJob_1() throws Exception {
		ConCurrentTaskJob result = new ConCurrentTaskJob();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the JSONObject assembeJson(int,Integer,Integer,String,List<String>)
	 * method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testAssembeJson_1() throws Exception {
		ConCurrentTaskJob fixture = new ConCurrentTaskJob();
		fixture.setTaskCasService(new TaskCacheService());
		int objId = 1;
		Integer tenantId = new Integer(1);
		Integer parallelismDegree = new Integer(1);
		String taskStyle = "";
		List<String> taskFlagList = new LinkedList();
		taskFlagList.add("11");

		JSONObject result = fixture.assembeJson(objId, tenantId,
				parallelismDegree, taskStyle, taskFlagList);

		// add additional test code here
		assertNotNull(result);
		assertEquals(5, result.size());
		assertTrue(result.containsKey("taskKeys"));
		assertEquals("", result.get("taskStyle"));
		assertEquals(new Integer(1), result.get("parallelismDegree"));
		assertEquals(new Integer(1), result.get("objId"));
		assertEquals(new Integer(1), result.get("tenantId"));
	}

	/**
	 * Run the JSONObject assembeJson(int,Integer,Integer,String,List<String>)
	 * method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testAssembeJson_2() throws Exception {
		ConCurrentTaskJob fixture = new ConCurrentTaskJob();
		fixture.setTaskCasService(new TaskCacheService());
		int objId = 1;
		Integer tenantId = new Integer(1);
		Integer parallelismDegree = null;
		String taskStyle = "";
		List<String> taskFlagList = new LinkedList();
		taskFlagList.add("11");

		JSONObject result = fixture.assembeJson(objId, tenantId,
				parallelismDegree, taskStyle, taskFlagList);

		// add additional test code here
		assertNotNull(result);
		assertEquals(4, result.size());
		assertTrue(result.containsKey("taskKeys"));
		assertEquals("", result.get("taskStyle"));
		assertEquals(new Integer(1), result.get("objId"));
		assertEquals(new Integer(1), result.get("tenantId"));
	}

	/**
	 * Run the void assembeTaskFlagList(List<String>,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testAssembeTaskFlagList_1() throws Exception {
		ConCurrentTaskJob fixture = new ConCurrentTaskJob();
		fixture.setTaskCasService(new TaskCacheService());
		List<String> taskFlagList = new LinkedList();
		taskFlagList.add("11");
		int objId = 1;

		fixture.assembeTaskFlagList(taskFlagList, objId);

		// add additional test code here
	}

	/**
	 * Run the void sendToMq(List<String>,TaskContentBean,int,JSONObject,String)
	 * method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testSendToMq_1() throws Exception {
		ConCurrentTaskJob fixture = new ConCurrentTaskJob();
		fixture.setTaskCasService(new TaskCacheService());
		List<String> taskFlagList = new LinkedList();
		taskFlagList.add("11");
		TaskContentBean taskContent = new TaskContentBean();
		int objId = 1;
		JSONObject json = new JSONObject();
		String queueName = "";

		

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskCasService(BaseTaskJob.java:70)
		// at
		// com.asiainfo.integration.o2p.task.smo.job.ConCurrentTaskJob.sendToMq(ConCurrentTaskJob.java:30)
	}

	/**
	 * Run the void sendToMq(List<String>,TaskContentBean,int,JSONObject,String)
	 * method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testSendToMq_2() throws Exception {
		ConCurrentTaskJob fixture = new ConCurrentTaskJob();
		fixture.setTaskCasService(new TaskCacheService());
		List<String> taskFlagList = new LinkedList();
		taskFlagList.add("11");
		TaskContentBean taskContent = new TaskContentBean();
		int objId = 1;
		JSONObject json = new JSONObject();
		String queueName = "";

		

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskCasService(BaseTaskJob.java:70)
		// at
		// com.asiainfo.integration.o2p.task.smo.job.ConCurrentTaskJob.sendToMq(ConCurrentTaskJob.java:30)
	}

	/**
	 * Run the void sendToMq(List<String>,TaskContentBean,int,JSONObject,String)
	 * method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testSendToMq_3() throws Exception {
		ConCurrentTaskJob fixture = new ConCurrentTaskJob();
		fixture.setTaskCasService(new TaskCacheService());
		List<String> taskFlagList = new LinkedList();
		taskFlagList.add("11");
		TaskContentBean taskContent = new TaskContentBean();
		int objId = 1;
		JSONObject json = new JSONObject();
		String queueName = "";

		

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskCasService(BaseTaskJob.java:70)
		// at
		// com.asiainfo.integration.o2p.task.smo.job.ConCurrentTaskJob.sendToMq(ConCurrentTaskJob.java:30)
	}

	/**
	 * Run the void sendToMq(List<String>,TaskContentBean,int,JSONObject,String)
	 * method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testSendToMq_4() throws Exception {
		ConCurrentTaskJob fixture = new ConCurrentTaskJob();
		fixture.setTaskCasService(new TaskCacheService());
		List<String> taskFlagList = new LinkedList();
		taskFlagList.add("11");
		TaskContentBean taskContent = new TaskContentBean();
		int objId = 1;
		JSONObject json = new JSONObject();
		String queueName = "";
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// com.asiainfo.integration.o2p.task.smo.job.BaseTaskJob.getTaskCasService(BaseTaskJob.java:70)
		// at
		// com.asiainfo.integration.o2p.task.smo.job.ConCurrentTaskJob.sendToMq(ConCurrentTaskJob.java:30)
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 15-11-24 下午3:43
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
	 * @generatedBy CodePro at 15-11-24 下午3:43
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
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ConCurrentTaskJobTest.class);
	}
}