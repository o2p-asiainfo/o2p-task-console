package com.asiainfo.integration.o2p.task.common;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TaskExceptionTest</code> contains tests for the class <code>{@link TaskException}</code>.
 *
 * @generatedBy CodePro at 15-11-24 下午3:42
 * @author windy
 * @version $Revision: 1.0 $
 */
public class TaskExceptionTest {
	/**
	 * Run the TaskException(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testTaskException_1()
		throws Exception {
		String msg = "";

		TaskException result = new TaskException(msg);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1, result.getErrorType());
		assertEquals(null, result.getCause());
		assertEquals("com.asiainfo.integration.o2p.task.common.TaskException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
	}

	/**
	 * Run the TaskException(Throwable) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testTaskException_2()
		throws Exception {
		Throwable e = new Throwable();

		TaskException result = new TaskException(e);

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1, result.getErrorType());
		assertEquals("com.asiainfo.integration.o2p.task.common.TaskException: java.lang.Throwable", result.toString());
		assertEquals("java.lang.Throwable", result.getLocalizedMessage());
		assertEquals("java.lang.Throwable", result.getMessage());
	}

	/**
	 * Run the int getErrorType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
	 */
	@Test
	public void testGetErrorType_1()
		throws Exception {
		TaskException fixture = new TaskException("");

		int result = fixture.getErrorType();

		// add additional test code here
		assertEquals(-1, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:42
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
		new org.junit.runner.JUnitCore().run(TaskExceptionTest.class);
	}
}