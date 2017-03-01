package com.asiainfo.integration.o2p.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.asiainfo.integration.o2p.task.smo.IJobConsoleService;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:eaap-o2p-fileExchange-rmi-task.xml"})
public class TestOpTask {
	@Resource(name="jobServiceClient")
	IJobConsoleService jobConsoleService;

	@Test
	public void testStart() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("taskId", 112);
		List<TaskContentBean> taskList = jobConsoleService.getTaskList(params);
		jobConsoleService.start(taskList);
	}
	
	@Test
	public void testStop() {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("taskId", 112);
		List<TaskContentBean> taskList = jobConsoleService.getTaskList(params);
		jobConsoleService.stop(taskList);
	}
}
