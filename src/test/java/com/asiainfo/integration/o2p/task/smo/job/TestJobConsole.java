/** 
 * Project Name:o2p-task-console-2.8 
 * File Name:TestJobConsole.java 
 * Package Name:com.asiainfo.integration.o2p.task.smo.job 
 * Date:2016年10月26日上午10:22:46 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.task.smo.job;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.asiainfo.integration.o2p.task.smo.IJobConsoleService;

/** 
 * ClassName:TestJobConsole <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年10月26日 上午10:22:46 <br/> 
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class TestJobConsole {

	private  Logger log = Logger.getLogger(TestJobConsole.class);
	ApplicationContext app = null;

	@Before
	public void setUp(){
		app = new ClassPathXmlApplicationContext(new String[]{"spring/o2p-taskconsole-spring-db.xml","spring/o2p-taskconsole-spring-activemq.xml","spring/o2p-taskconsole-spring-job.xml"});
	}
	
	@Test
	public void testGetList() {
		
		IJobConsoleService jobConsoleService = (IJobConsoleService)app.getBean("jobConsoleService");
		
		jobConsoleService.startAll("1");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tenantId", 1);
		List<TaskContentBean> list = jobConsoleService.getTaskList(map);
		System.out.println(list.size());
	}
}
