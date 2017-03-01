/** 
 * Project Name:o2p-serviceAgent 
 * File Name:SubQuarztServlet.java 
 * Package Name:com.ailk.eaap.op2.serviceagent.servlet 
 * Date:2014年10月7日下午12:10:57 
 * Copyright (c) 2014, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.asiainfo.integration.o2p.task.servlet;  

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ailk.eaap.o2p.common.util.zookeeperUtil.DistributedConsistencyHelper;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.asiainfo.integration.o2p.task.common.Constant;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;
import com.asiainfo.integration.o2p.task.service.Impl.ServerAgentBreakDownWatcherCallback;
import com.asiainfo.integration.o2p.task.smo.IJobConsoleService;
import com.linkage.rainbow.util.spring.ContextHolder;
//import com.ailk.eaap.o2p.common.Constant;
//import com.ailk.eaap.o2p.service.IJobConsoleService;

/** 
 * ClassName:SubQuarztServlet <br/> 
 * Function:SubQuarztServlet<br/> 
 * Reason:   SubQuarztServlet. <br/> 
 * Date:     2014年10月7日 下午12:10:57 <br/> 
 * @author   mf 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class SubQuarztServlet extends HttpServlet{
	
	private static final long serialVersionUID = -1727573808521004376L;
	
	private static final Logger log = Logger.getLogger(SubQuarztServlet.class);

	@Override
	public void init() throws ServletException {
		
		ServletContext servletContext = this.getServletContext();  
		  
	    WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext); 
	    //初始化applicationContext
	    ContextHolder.setApplicationContext(ctx);
		
	    IJobConsoleService quartzJobService = (IJobConsoleService)ctx.getBean("jobConsoleService");
	    ITaskJobDAO taskJobDao = (ITaskJobDAO)ctx.getBean("taskJobDAO");
	    
	    log.debug("...Start Task...");
	    if(quartzJobService.isInitTask()){
	    	Map<String, Object> params = new HashMap<String, Object>();
	    	params.put("statu", Constant.TASK_STATE_I);
	    	List<TaskContentBean> list  = (List<TaskContentBean>)taskJobDao.getTaskList(params);
	    	
	    	params.put("statu", Constant.TASK_STATE_F);
	    	List<TaskContentBean> list1  = (List<TaskContentBean>)taskJobDao.getTaskList(params);
	    	quartzJobService.restart(list, list1);
	    	
	    	//监听服务引擎状态和如果挂掉，清空其上运行的任务状态
	    	ITaskCasService casService = (ITaskCasService)ctx.getBean("taskCacheService");
	    	final ServerAgentBreakDownWatcherCallback callBack = new ServerAgentBreakDownWatcherCallback();
	    	callBack.setCasService(casService);
			try {
				new DistributedConsistencyHelper().createWatherToServers(DistributedConsistencyHelper.DEFAULT_AGENT_NAME, callBack);
			} catch (Exception e) {
				log.error("watch to server error", e);
			}
	    }
	}

}
