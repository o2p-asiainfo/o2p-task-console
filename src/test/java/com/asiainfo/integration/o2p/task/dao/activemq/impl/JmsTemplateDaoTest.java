package com.asiainfo.integration.o2p.task.dao.activemq.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * The class <code>JmsTemplateDaoTest</code> contains tests for the class <code>{@link JmsTemplateDao}</code>.
 *
 * @generatedBy CodePro at 15-11-24 下午3:43
 * @author windy
 * @version $Revision: 1.0 $
 */
public class JmsTemplateDaoTest {
	
	static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
	static BrokerService broker = new BrokerService();
	
	/** 
	 * Run the JmsTemplateDao() constructor test.
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testJmsTemplateDao_1()
		throws Exception {
		JmsTemplateDao result = new JmsTemplateDao();
		assertNotNull(result);
		// add additional test code here
	}
	
	@Before
	public void startMq() throws Exception{
		if(!broker.isStarted()) {
			TransportConnector connector = new TransportConnector();
			
			connector.setUri(new URI("tcp://localhost:61616"));
			broker.addConnector(connector);
			broker.start();
		}
	}


	/**
	 * Run the Serializable receiveToActiveMq(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testReceiveToActiveMq_1()
		throws Exception {
		JmsTemplateDao fixture = new JmsTemplateDao();
		fixture.setJmsTemplate(new JmsTemplate(connectionFactory));
		String queueName = "";

		Serializable result = fixture.receiveToActiveMq(queueName);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void sendToActiveMq(Serializable,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testSendToActiveMq_1()
		throws Exception {
		JmsTemplateDao fixture = new JmsTemplateDao();
		JmsTemplate tem = new JmsTemplate(connectionFactory);
		tem.setReceiveTimeout(1000);
		fixture.setJmsTemplate(tem);
		String msgBody = "hello world!";
		fixture.sendToActiveMq(msgBody, "test");
//		String result = tem.receiveAndConvert("test").toString();
//		System.out.println(result);
//		assertEquals(msgBody, result);
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: ConnectionFactory must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at org.springframework.jms.connection.ConnectionFactoryUtils.doGetTransactionalSession(ConnectionFactoryUtils.java:280)
		//       at org.springframework.jms.core.JmsTemplate.execute(JmsTemplate.java:481)
		//       at org.springframework.jms.core.JmsTemplate.send(JmsTemplate.java:580)
		//       at com.asiainfo.integration.o2p.task.dao.activemq.impl.JmsTemplateDao.sendToActiveMq(JmsTemplateDao.java:23)
	}

	/**
	 * Run the void sendToActiveMq(Serializable,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testSendToActiveMq_2()
		throws Exception {
		JmsTemplateDao fixture = new JmsTemplateDao();
		fixture.setJmsTemplate(new JmsTemplate(connectionFactory));
		Serializable messageObject = new IOException();
		String queueName = "test";

		fixture.sendToActiveMq(messageObject, queueName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: ConnectionFactory must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at org.springframework.jms.connection.ConnectionFactoryUtils.doGetTransactionalSession(ConnectionFactoryUtils.java:280)
		//       at org.springframework.jms.core.JmsTemplate.execute(JmsTemplate.java:481)
		//       at org.springframework.jms.core.JmsTemplate.send(JmsTemplate.java:580)
		//       at com.asiainfo.integration.o2p.task.dao.activemq.impl.JmsTemplateDao.sendToActiveMq(JmsTemplateDao.java:23)
	}

	/**
	 * Run the void setJmsTemplate(JmsTemplate) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	@Test
	public void testSetJmsTemplate_1()
		throws Exception {
		JmsTemplateDao fixture = new JmsTemplateDao();
		fixture.setJmsTemplate(new JmsTemplate(connectionFactory));
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);

		fixture.setJmsTemplate(jmsTemplate);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-11-24 下午3:43
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
	 * @generatedBy CodePro at 15-11-24 下午3:43
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
	 * @generatedBy CodePro at 15-11-24 下午3:43
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(JmsTemplateDaoTest.class);
	}
}