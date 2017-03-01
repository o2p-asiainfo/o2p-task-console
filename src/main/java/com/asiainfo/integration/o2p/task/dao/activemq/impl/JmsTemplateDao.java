package com.asiainfo.integration.o2p.task.dao.activemq.impl;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.TaskException;
import com.asiainfo.integration.o2p.task.dao.activemq.IActiveMqDao;

public class JmsTemplateDao implements IActiveMqDao{
	private static final long serialVersionUID = 1L;
	private transient JmsTemplate jmsTemplate;

	@Override
	public void sendToActiveMq(final Serializable messageObject, String queueName) throws TaskException {
		try {
			jmsTemplate.send(queueName, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					ObjectMessage objectMessage = session.createObjectMessage();
					objectMessage.setObject(messageObject);
					return objectMessage;
				}
			});
		} catch(JmsException e) {
			throw new TaskException(e);
		}
	}

	@Override
	public Serializable receiveToActiveMq(String queueName) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
}
