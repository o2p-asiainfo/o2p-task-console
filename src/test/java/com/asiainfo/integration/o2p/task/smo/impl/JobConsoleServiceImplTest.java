package com.asiainfo.integration.o2p.task.smo.impl;

import java.io.Reader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.easymock.EasyMock;
import org.junit.*;
import org.junit.runner.RunWith;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.fileExchange.model.TaskJobLogBean;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.o2p.task.model.TaskRelaObj;
import com.ailk.eaap.op2.bo.GatherCycle;
import com.ailk.eaap.op2.bo.SerInvokeIns;
import com.ailk.eaap.op2.bo.Service;
import com.asiainfo.integration.o2p.task.common.quartz.QuartzManager;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;
import com.asiainfo.integration.o2p.task.dao.impl.TaskJobDAOImpl;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;
import com.asiainfo.integration.o2p.task.service.Impl.TaskCacheService;
import com.asiainfo.integration.o2p.task.smo.IJobLogService;
import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;

/**
 * The class <code>JobConsoleServiceImplTest</code> contains tests for the class <code>{@link JobConsoleServiceImpl}</code>.
 *
 * @generatedBy CodePro at 15-11-24 下午3:42
 * @author windy
 * @version $Revision: 1.0 $
 */
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:o2p-taskconsole-spring-db.xml"})
public class JobConsoleServiceImplTest {
	@Resource(name="taskSqlSessionFactory")
	public SqlSessionFactory taskSqlSessionFactory;
	
	@Before
	public void setUp() throws Exception  
    {  
        SqlSession session = taskSqlSessionFactory.openSession();  
        Connection conn = session.getConnection();  
        Reader reader = Resources.getResourceAsReader("tables_hsqldb.sql");  
        ScriptRunner runner = new ScriptRunner(conn, true, true);  
        runner.setLogWriter(null);  
        runner.runScript(reader);  
        reader.close();  
        session.close();  
    }
	/**
	 * Run the JobConsoleServiceImpl() constructor test.
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testJobConsoleServiceImpl_1()
		throws Exception {
		JobConsoleServiceImpl result = new JobConsoleServiceImpl();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the int addCycle(GatherCycle) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testAddCycle_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the boolean canStart(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testCanStart_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		TaskContentBean task = new TaskContentBean();
		TaskRelaObj obj = new TaskRelaObj();
		obj.setObjId(10);
		obj.setObjTypeCd("1");
		task.setTaskRelaObj(obj);
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		EasyMock.expect(dao.getSerInvokeIns(10)).andReturn(null);
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		boolean result = fixture.canStart(task);
		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canStart(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testCanStart_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		TaskContentBean task = new TaskContentBean();
		TaskRelaObj obj = new TaskRelaObj();
		obj.setObjId(10);
		obj.setObjTypeCd("1");
		task.setTaskRelaObj(obj);
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		SerInvokeIns ser = new SerInvokeIns();
		Service s = new Service();
		s.setState("D");
		ser.setService(s);
		EasyMock.expect(dao.getSerInvokeIns(10)).andReturn(ser);
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		boolean result = fixture.canStart(task);
		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canStart(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testCanStart_3()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		TaskContentBean task = new TaskContentBean();
		TaskRelaObj obj = new TaskRelaObj();
		obj.setObjId(10);
		obj.setObjTypeCd("1");
		task.setTaskRelaObj(obj);
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		SerInvokeIns ser = new SerInvokeIns();
		Service s = new Service();
		s.setState("A");
		ser.setService(s);
		EasyMock.expect(dao.getSerInvokeIns(10)).andReturn(ser);
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		boolean result = fixture.canStart(task);
		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean canStart(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testCanStart_4()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		TaskContentBean task = new TaskContentBean();
		TaskRelaObj obj = new TaskRelaObj();
		obj.setObjId(10);
		obj.setObjTypeCd("2");
		task.setTaskRelaObj(obj);
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		SerInvokeIns ser = new SerInvokeIns();
		Service s = new Service();
		s.setState("A");
		ser.setService(s);
		EasyMock.expect(dao.getSerInvokeIns(10)).andReturn(ser);
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		boolean result = fixture.canStart(task);
		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canStart(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testCanStart_5()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		TaskContentBean task = new TaskContentBean();
		TaskRelaObj obj = new TaskRelaObj();
		obj.setObjId(10);
		obj.setObjTypeCd("2");
		task.setTaskRelaObj(obj);
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		SerInvokeIns ser = new SerInvokeIns();
		EasyMock.expect(dao.getSerInvokeIns(10)).andReturn(ser);
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		boolean result = fixture.canStart(task);
		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canStart(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testCanStart_6()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		TaskContentBean task = new TaskContentBean();
		TaskRelaObj obj = new TaskRelaObj();
		obj.setObjId(10);
		obj.setObjTypeCd(null);
		task.setTaskRelaObj(obj);
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		SerInvokeIns ser = new SerInvokeIns();
		Service s = new Service();
		s.setState("A");
		ser.setService(s);
		EasyMock.expect(dao.getSerInvokeIns(10)).andReturn(ser);
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		boolean result = fixture.canStart(task);
		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the int deleteCycle(GatherCycle) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testDeleteCycle_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		gc.setGcCd(10);
		EasyMock.expect(dao.getTaskCountByGcCd(gc)).andReturn(0);
		dao.deleteCycle(gc);
		EasyMock.expectLastCall();
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		int result = fixture.deleteCycle(gc);
		assertEquals(0, result);
	}

	/**
	 * Run the int deleteCycle(GatherCycle) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testDeleteCycle_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		gc.setGcCd(10);
		EasyMock.expect(dao.getTaskCountByGcCd(gc)).andReturn(3);
		dao.deleteCycle(gc);
		EasyMock.expectLastCall();
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		int result = fixture.deleteCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> deleteTask(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testDeleteTask_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		dao.deleteTask(new HashMap<String, Object>());
		EasyMock.expectLastCall();
		EasyMock.replay(dao);
		List<String> taskIds = new LinkedList();
		List<String> result = fixture.deleteTask(taskIds);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the GatherCycle getGatherCycleBean(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetGatherCycleBean_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.getGatherCycleBean(10)).andReturn(gc);
		fixture.setTaskJobDAO(dao);
		EasyMock.replay(dao);
		int gcCd = 1;

		GatherCycle result = fixture.getGatherCycleBean(10);

		// add additional test code here
		assertEquals(gc, result);
	}

	/**
	 * Run the TaskContentBean getTaskContentBean(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskContentBean_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		TaskContentBean bean = new TaskContentBean();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("taskId", "10");
		param.put("tenantId", CacheKey.defaultTenantId);
		EasyMock.expect(dao.getTaskContentBean(param)).andReturn(bean);
		EasyMock.replay(dao);
		int taskId = 10;

		TaskContentBean result = fixture.getTaskContentBean(param);

		// add additional test code here
		assertEquals(bean, result);
	}

	/**
	 * Run the List<GatherCycle> getTaskCycleList(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskCycleList_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		List<GatherCycle> list = new ArrayList<GatherCycle>();
		Integer tenantId = new Integer(1);
		EasyMock.expect(dao.getTaskCycleList(tenantId)).andReturn(list);
		EasyMock.replay(dao);
		List<GatherCycle> result = fixture.getTaskCycleList(tenantId);
		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<GatherCycle> getTaskCycleList(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskCycleList_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		List<GatherCycle> list = new ArrayList<GatherCycle>();
		Integer tenantId = new Integer(1);
		EasyMock.expect(dao.getTaskCycleList(tenantId)).andReturn(list);
		EasyMock.replay(dao);
		List<GatherCycle> result = fixture.getTaskCycleList(tenantId);
		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the int getTaskCycleNum(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskCycleNum_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		List<GatherCycle> list = new ArrayList<GatherCycle>();
		Integer tenantId = new Integer(1);
		EasyMock.expect(dao.getTaskCycleNum(new HashMap<String, Object>())).andReturn(0);
		EasyMock.replay(dao);
		int result = fixture.getTaskCycleNum(new HashMap<String, Object>());
		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the ITaskJobDAO getTaskJobDAO() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskJobDAO_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		fixture.setTaskJobDAO(new TaskJobDAOImpl());

		ITaskJobDAO result = fixture.getTaskJobDAO();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the TaskJobLogBean getTaskJobLogById(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskJobLogById_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		TaskJobLogBean bean = new TaskJobLogBean();
		EasyMock.expect(dao.getTaskJobLogById(1)).andReturn(bean);
		EasyMock.replay(dao);
		int taskLogId = 1;

		TaskJobLogBean result = fixture.getTaskJobLogById(taskLogId);

		// add additional test code here
		assertEquals(bean, result);
	}

	/**
	 * Run the List<TaskContentBean> getTaskList(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskList_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		List<TaskContentBean> bean = new ArrayList<TaskContentBean>();
		EasyMock.expect(dao.getTaskList(new HashMap<String, Object>())).andReturn(bean);
		EasyMock.replay(dao);
		int taskLogId = 1;

		List<TaskContentBean> result = fixture.getTaskList(new HashMap<String, Object>());

		// add additional test code here
		assertEquals(bean, result);
	}

	/**
	 * Run the List<TaskContentBean> getTaskList(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskList_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		List<TaskContentBean> bean = new ArrayList<TaskContentBean>();
		EasyMock.expect(dao.getTaskList(new HashMap<String, Object>())).andReturn(bean);
		EasyMock.replay(dao);
		int taskLogId = 1;

		List<TaskContentBean> result = fixture.getTaskList(new HashMap<String, Object>());

		// add additional test code here
		assertEquals(bean, result);
	}

	/**
	 * Run the List<TaskContentBean> getTaskList(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskList_3()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		List<TaskContentBean> bean = new ArrayList<TaskContentBean>();
		EasyMock.expect(dao.getTaskList(new HashMap<String, Object>())).andReturn(bean);
		EasyMock.replay(dao);
		int taskLogId = 1;

		List<TaskContentBean> result = fixture.getTaskList(new HashMap<String, Object>());

		// add additional test code here
		assertEquals(bean, result);
	}

	/**
	 * Run the List<TaskContentBean> getTaskList(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskList_4()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		List<TaskContentBean> bean = new ArrayList<TaskContentBean>();
		EasyMock.expect(dao.getTaskList(new HashMap<String, Object>())).andReturn(bean);
		EasyMock.replay(dao);
		int taskLogId = 1;

		List<TaskContentBean> result = fixture.getTaskList(new HashMap<String, Object>());

		// add additional test code here
		assertEquals(bean, result);
	}

	/**
	 * Run the int getTaskListNum(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskListNum_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		fixture.setTaskJobDAO(dao);
		EasyMock.expect(dao.getTaskCount(new HashMap<String, Object>())).andReturn(5);
		EasyMock.replay(dao);
		int taskLogId = 1;

		int result = fixture.getTaskListNum(new HashMap<String, Object>());

		// add additional test code here
		assertEquals(5, result);
	}

	/**
	 * Run the List<TaskJobLogBean> getTaskLogList(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskLogList_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the int getTaskLogListNum(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetTaskLogListNum_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the boolean isInitTask() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testIsInitTask_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the boolean isInitTask() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testIsInitTask_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void operatorLog(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testOperatorLog_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void operatorLog(Map<String,Object>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testOperatorLog_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void setJobLogService(IJobLogService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetJobLogService_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void setQuartzManager(QuartzManager) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetQuartzManager_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void setStartFlag(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetStartFlag_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void setTaskCasService(ITaskCasService) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetTaskCasService_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void setTaskJobDAO(ITaskJobDAO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testSetTaskJobDAO_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void shutDown() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testShutDown_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void shutDown() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testShutDown_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> start(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStart_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> start(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStart_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> start(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStart_3()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> start(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStart_4()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> start(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStart_5()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> start(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStart_6()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> start(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStart_7()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> startAll(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStartAll_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> stop(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStop_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> stop(List<TaskContentBean>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStop_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the List<String> stopAll(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStopAll_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the void stopAllRunningTask() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStopAllRunningTask_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.asiainfo.integration.o2p.task.common.quartz.QuartzManager.clear(QuartzManager.java:86)
		//       at com.asiainfo.integration.o2p.task.smo.impl.JobConsoleServiceImpl.stopAllRunningTask(JobConsoleServiceImpl.java:461)
	}

	/**
	 * Run the void stopAllRunningTask() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testStopAllRunningTask_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.asiainfo.integration.o2p.task.common.quartz.QuartzManager.clear(QuartzManager.java:86)
		//       at com.asiainfo.integration.o2p.task.smo.impl.JobConsoleServiceImpl.stopAllRunningTask(JobConsoleServiceImpl.java:461)
	}

	/**
	 * Run the void updateCycle(GatherCycle) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testUpdateCycle_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);

		// add additional test code here
	}

	/**
	 * Run the int updateTaskContentBean(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testUpdateTaskContentBean_1()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the int updateTaskContentBean(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testUpdateTaskContentBean_2()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the int updateTaskContentBean(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testUpdateTaskContentBean_3()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the int updateTaskContentBean(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testUpdateTaskContentBean_4()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the int updateTaskContentBean(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testUpdateTaskContentBean_5()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Run the int updateTaskContentBean(TaskContentBean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testUpdateTaskContentBean_6()
		throws Exception {
		JobConsoleServiceImpl fixture = new JobConsoleServiceImpl();
		fixture.setTaskCacheService(new TaskCacheService());
		fixture.setQuartzManager(new QuartzManager());
		fixture.setStartFlag("");
		fixture.setJobLogService(new JobLogServiceImpl());
		ITaskJobDAO dao = EasyMock.createMock(TaskJobDAOImpl.class);
		GatherCycle gc = new GatherCycle();
		EasyMock.expect(dao.addCycle(gc)).andReturn(3);
		EasyMock.replay(dao);
		fixture.setTaskJobDAO(dao);
		int result = fixture.addCycle(gc);
		assertEquals(3, result);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
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
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(JobConsoleServiceImplTest.class);
	}
}