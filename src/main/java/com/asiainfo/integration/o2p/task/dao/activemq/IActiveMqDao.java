package com.asiainfo.integration.o2p.task.dao.activemq;

import java.io.Serializable;

import javax.jms.JMSException;

import com.asiainfo.integration.o2p.task.common.TaskException;

/**
 * 类名称<br>
 * 这里是类的描述区域，概括出该的主要功能或者类的使用范围、注意事项等
 * <p>
 * @version 1.0
 * @author Administrator 2014-1-6
 * <hr>
 * 修改记录
 * <hr>
 * 1、修改人员:    修改时间:<br>       
 *    修改内容:
 * <hr>
 */

public interface IActiveMqDao extends Serializable{
	
	/**
	 * 发送数据到队列
	 * @param messageContent
	 * @throws TaskException 
	 * @throws JMSException
	 */
	void sendToActiveMq(Serializable messageObject, String queueName) throws TaskException;
	
	/**
	 * 从队列中获取数据
	 * @param messageContent
	 * @throws JMSException
	 */
	Serializable receiveToActiveMq(String queueName) throws JMSException;
	
}