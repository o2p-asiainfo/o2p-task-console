package com.asiainfo.integration.o2p.task.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>SubMessageStatusTest</code> contains tests for the class <code>{@link SubMessageStatus}</code>.
 *
 * @generatedBy CodePro at 15-11-24 下午3:39
 * @author windy
 * @version $Revision: 1.0 $
 */
public class SubMessageStatusTest {
	/**
	 * Run the SubMessageStatus() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSubMessageStatus_1()
		throws Exception {

		SubMessageStatus result = new SubMessageStatus();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getHostName());
		assertEquals(null, result.getSubContentType());
		assertEquals(null, result.getSubTimeNum());
		assertEquals(null, result.getSubEndpointId());
		assertEquals(null, result.getSubStatus());
		assertEquals(null, result.getSubTaskId());
		assertEquals(null, result.getSubId());
		assertEquals(null, result.getSubSerInsId());
		assertEquals(null, result.getSubContent());
		assertEquals(null, result.getSubMesId());
	}

	/**
	 * Run the SubMessageStatus(Integer,Integer,Integer,Integer,Integer,Integer,String,Integer,Timestamp,Integer,Timestamp,Timestamp,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSubMessageStatus_2()
		throws Exception {
		Integer subId = new Integer(1);
		Integer subTaskId = new Integer(1);
		Integer subMesId = new Integer(1);
		Integer subSerInsId = new Integer(1);
		Integer subEndpointId = new Integer(1);
		Integer subContentType = new Integer(1);
		String subContent = "";
		Integer subStatus = new Integer(1);
		Timestamp subNextDate = new Timestamp(1L);
		Integer subTimeNum = new Integer(1);
		Timestamp subDate = new Timestamp(1L);
		Timestamp createDate = new Timestamp(1L);
		String hostName = "";

		SubMessageStatus result = new SubMessageStatus(subId, subTaskId, subMesId, subSerInsId, subEndpointId, subContentType, subContent, subStatus, subNextDate, subTimeNum, subDate, createDate, hostName);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getHostName());
		assertEquals(new Integer(1), result.getSubContentType());
		assertEquals(new Integer(1), result.getSubTimeNum());
		assertEquals(new Integer(1), result.getSubEndpointId());
		assertEquals(new Integer(1), result.getSubStatus());
		assertEquals(new Integer(1), result.getSubTaskId());
		assertEquals(new Integer(1), result.getSubId());
		assertEquals(new Integer(1), result.getSubSerInsId());
		assertEquals("", result.getSubContent());
		assertEquals(new Integer(1), result.getSubMesId());
	}

	/**
	 * Run the Timestamp getCreateDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetCreateDate_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Timestamp result = fixture.getCreateDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1L)), DateFormat.getInstance().format(result));
		assertEquals(1L, result.getTime());
	}

	/**
	 * Run the String getHostName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetHostName_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		String result = fixture.getHostName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getSubContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubContent_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		String result = fixture.getSubContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Integer getSubContentType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubContentType_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Integer result = fixture.getSubContentType();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the Timestamp getSubDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubDate_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Timestamp result = fixture.getSubDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1L)), DateFormat.getInstance().format(result));
		assertEquals(1L, result.getTime());
	}

	/**
	 * Run the Integer getSubEndpointId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubEndpointId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Integer result = fixture.getSubEndpointId();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the Integer getSubId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Integer result = fixture.getSubId();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the Integer getSubMesId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubMesId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Integer result = fixture.getSubMesId();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the Timestamp getSubNextDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubNextDate_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Timestamp result = fixture.getSubNextDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1L)), DateFormat.getInstance().format(result));
		assertEquals(1L, result.getTime());
	}

	/**
	 * Run the Integer getSubSerInsId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubSerInsId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Integer result = fixture.getSubSerInsId();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the Integer getSubStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubStatus_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Integer result = fixture.getSubStatus();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the Integer getSubTaskId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubTaskId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Integer result = fixture.getSubTaskId();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the Integer getSubTimeNum() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testGetSubTimeNum_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");

		Integer result = fixture.getSubTimeNum();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the void setCreateDate(Timestamp) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetCreateDate_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Timestamp createDate = new Timestamp(1L);

		fixture.setCreateDate(createDate);

		// add additional test code here
	}

	/**
	 * Run the void setHostName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetHostName_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		String hostName = "";

		fixture.setHostName(hostName);

		// add additional test code here
	}

	/**
	 * Run the void setSubContent(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubContent_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		String subContent = "";

		fixture.setSubContent(subContent);

		// add additional test code here
	}

	/**
	 * Run the void setSubContentType(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubContentType_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Integer subContentType = new Integer(1);

		fixture.setSubContentType(subContentType);

		// add additional test code here
	}

	/**
	 * Run the void setSubDate(Timestamp) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubDate_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Timestamp subDate = new Timestamp(1L);

		fixture.setSubDate(subDate);

		// add additional test code here
	}

	/**
	 * Run the void setSubEndpointId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubEndpointId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Integer subEndpointId = new Integer(1);

		fixture.setSubEndpointId(subEndpointId);

		// add additional test code here
	}

	/**
	 * Run the void setSubId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Integer subId = new Integer(1);

		fixture.setSubId(subId);

		// add additional test code here
	}

	/**
	 * Run the void setSubMesId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubMesId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Integer subMesId = new Integer(1);

		fixture.setSubMesId(subMesId);

		// add additional test code here
	}

	/**
	 * Run the void setSubNextDate(Timestamp) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubNextDate_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Timestamp subNextDate = new Timestamp(1L);

		fixture.setSubNextDate(subNextDate);

		// add additional test code here
	}

	/**
	 * Run the void setSubSerInsId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubSerInsId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Integer subSerInsId = new Integer(1);

		fixture.setSubSerInsId(subSerInsId);

		// add additional test code here
	}

	/**
	 * Run the void setSubStatus(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubStatus_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Integer subStatus = new Integer(1);

		fixture.setSubStatus(subStatus);

		// add additional test code here
	}

	/**
	 * Run the void setSubTaskId(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubTaskId_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Integer subTaskId = new Integer(1);

		fixture.setSubTaskId(subTaskId);

		// add additional test code here
	}

	/**
	 * Run the void setSubTimeNum(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:39
	 */
	@Test
	public void testSetSubTimeNum_1()
		throws Exception {
		SubMessageStatus fixture = new SubMessageStatus(new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), new Integer(1), "", new Integer(1), new Timestamp(1L), new Integer(1), new Timestamp(1L), new Timestamp(1L), "");
		Integer subTimeNum = new Integer(1);

		fixture.setSubTimeNum(subTimeNum);

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
		new org.junit.runner.JUnitCore().run(SubMessageStatusTest.class);
	}
}