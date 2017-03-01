package com.asiainfo.integration.o2p.task.dao.Mapper;

import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ailk.eaap.op2.bo.ExceptionDealInfo;
import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:o2p-taskconsole-spring-db.xml")
public class IExceptionDealInfoDaoTest {
	@Autowired
	public IExceptionDealInfoDao exceptionDealInfoDao;
	@Resource(name="DEPSqlSessionFactory")
	public SqlSessionFactory depSqlSessionFactory;
	public static boolean isInit = false;
	
	@Before
	public void setUp() throws Exception  
    {  
		if(!isInit) {
	        SqlSession session = depSqlSessionFactory.openSession();  
	        Connection conn = session.getConnection();  
	        Reader reader = Resources.getResourceAsReader("hqlbd.sql");  
	        ScriptRunner runner = new ScriptRunner(conn, true, true);  
	        runner.setLogWriter(null);  
	        runner.runScript(reader); 
	        
	        
	        reader.close();  
	        session.close(); 
	        isInit = true;
		}
    }
	
	@Test
	public void queryExceptionDealInfoCountByObjIdTest() {
		int count =-1;
		try {
			count = exceptionDealInfoDao.queryExceptionDealInfoCountByObjId(3150);
		} catch(PersistenceException e) {
			System.out.println("PersistenceException");
		} catch(RuntimeException ex) {
			if(ex.getCause() instanceof PersistenceException) {
				System.out.println(ex.getCause().getCause() instanceof CannotGetJdbcConnectionException);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		Assert.assertNotSame(count, 1);
		
		count = exceptionDealInfoDao.queryExceptionDealInfoCountByObjId(-1);
		Assert.assertEquals(count, 0);
	}

	@Test
	public void queryExceptionDealInfoPageTest() {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("messageFlowId", 3150);
		params.put("startPage_mysql", 0);
		params.put("endPage_mysql", 100);
		List<ExceptionDealInfo> infos = exceptionDealInfoDao.queryExceptionDealInfoPage(params);
		
		Assert.assertEquals(0, infos.size());
	}
	
	@Test
	public void updateExceptionDealInfoTest() {
		ExceptionDealInfo info = exceptionDealInfoDao.queryExceptionDealInfoById(100018301);
		int num = info.getTryNum();
		info.setTryNum(num+1);
		exceptionDealInfoDao.updateExceptionDealInfo(info);
		info = exceptionDealInfoDao.queryExceptionDealInfoById(100018301);
		Assert.assertNotSame(num, info.getTryNum());
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
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
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(IExceptionDealInfoDaoTest.class);
	}
}
