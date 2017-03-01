package com.asiainfo.integration.o2p.task.interceptor;

import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.ibatis.plugin.Invocation;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PageInterceptorTest</code> contains tests for the class <code>{@link PageInterceptor}</code>.
 *
 * @generatedBy CodePro at 15-11-24 下午3:39
 * @author windy
 * @version $Revision: 1.0 $
 */
public class PageInterceptorTest {
	/**
	 * Run the PageInterceptor() constructor test.
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testPageInterceptor_1()
		throws Exception {
		PageInterceptor result = new PageInterceptor();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the StringBuilder buildPageSqlForMysql(String,Integer,Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testBuildPageSqlForMysql_1()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		String sql = "";
		Integer start_row = null;
		Integer limit = new Integer(1);

		StringBuilder result = fixture.buildPageSqlForMysql(sql, start_row, limit);

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals(1, result.length());
		assertEquals(100, result.capacity());
	}

	/**
	 * Run the StringBuilder buildPageSqlForMysql(String,Integer,Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testBuildPageSqlForMysql_2()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		String sql = "";
		Integer start_row = new Integer(1);
		Integer limit = null;

		StringBuilder result = fixture.buildPageSqlForMysql(sql, start_row, limit);

		// add additional test code here
		assertNotNull(result);
		assertEquals(" limit 1, ", result.toString());
		assertEquals(10, result.length());
		assertEquals(100, result.capacity());
	}

	/**
	 * Run the StringBuilder buildPageSqlForOracle(String,Integer,Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testBuildPageSqlForOracle_1()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		String sql = "";
		Integer start_row = new Integer(1);
		Integer limit = new Integer(1);

		StringBuilder result = fixture.buildPageSqlForOracle(sql, start_row, limit);

		// add additional test code here
		assertNotNull(result);
		assertEquals("select * from ( select temp.*, rownum row_id from (  ) temp where rownum <= 2) where row_id > 1", result.toString());
		assertEquals(95, result.length());
		assertEquals(100, result.capacity());
	}

	/**
	 * Run the StringBuilder buildPageSqlForOracle(String,Integer,Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testBuildPageSqlForOracle_2()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		String sql = "";
		Integer start_row = new Integer(1);
		Integer limit = null;

		StringBuilder result = fixture.buildPageSqlForOracle(sql, start_row, limit);

		// add additional test code here
		assertNotNull(result);
		assertEquals("select * from ( select temp.*, rownum row_id from (  ) temp where row_id > 1", result.toString());
		assertEquals(76, result.length());
		assertEquals(100, result.capacity());
	}

	/**
	 * Run the StringBuilder buildPageSqlForOracle(String,Integer,Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testBuildPageSqlForOracle_3()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		String sql = "";
		Integer start_row = null;
		Integer limit = new Integer(1);

		StringBuilder result = fixture.buildPageSqlForOracle(sql, start_row, limit);

		// add additional test code here
		assertNotNull(result);
		assertEquals("select * from ( select temp.*, rownum row_id from (  ) temp where rownum <= 1)", result.toString());
		assertEquals(78, result.length());
		assertEquals(100, result.capacity());
	}

	/**
	 * Run the Object intercept(Invocation) method test.
	 *
	 * @throws Throwable
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test(expected = java.lang.ClassCastException.class)
	public void testIntercept_1()
		throws Throwable {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId((String) null);
		fixture.setDialect((String) null);
		Invocation invocation = new Invocation(new Object(), Object.class.getMethods()[0], new Object[] {});

		Object result = fixture.intercept(invocation);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object intercept(Invocation) method test.
	 *
	 * @throws Throwable
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test(expected = java.lang.ClassCastException.class)
	public void testIntercept_2()
		throws Throwable {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		Invocation invocation = new Invocation(new Object(), Object.class.getMethods()[0], new Object[] {});

		Object result = fixture.intercept(invocation);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object plugin(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testPlugin_1()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		Object target = new Object();

		Object result = fixture.plugin(target);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Object plugin(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testPlugin_2()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		Object target = new Object();

		Object result = fixture.plugin(target);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void setDialect(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetDialect_1()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		String dialect = "";

		fixture.setDialect(dialect);

		// add additional test code here
	}

	/**
	 * Run the void setPageSqlId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetPageSqlId_1()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		String pageSqlId = "";

		fixture.setPageSqlId(pageSqlId);

		// add additional test code here
	}

	/**
	 * Run the void setProperties(Properties) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetProperties_1()
		throws Exception {
		PageInterceptor fixture = new PageInterceptor();
		fixture.setPageSqlId("");
		fixture.setDialect("");
		Properties properties = new Properties();

		fixture.setProperties(properties);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
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
		new org.junit.runner.JUnitCore().run(PageInterceptorTest.class);
	}
}