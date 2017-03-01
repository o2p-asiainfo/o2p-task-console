package com.asiainfo.integration.o2p.task.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.asiainfo.integration.o2p.task.dao.Mapper.IExceptionDealInfoDao;
import com.asiainfo.integration.o2p.task.dao.activemq.IActiveMqDao;
import com.asiainfo.integration.o2p.task.thread.ScanExceptionDealThread;
import com.linkage.rainbow.util.spring.ContextHolder;

public class ScanExceptionDealInfoServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4120073985192121468L;

	@Override
	public void init() throws ServletException {
		
		ServletContext servletContext = this.getServletContext();  
		  
	    WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext); 
	    //初始化applicationContext
	    ContextHolder.setApplicationContext(ctx);
	    
	    IActiveMqDao activeMqDao = (IActiveMqDao)ctx.getBean("activeMqDao");
	    IExceptionDealInfoDao exceptionDealInfoDao = (IExceptionDealInfoDao)ctx.getBean("exceptionDealInfoDao");
		
		ScanExceptionDealThread thread = new ScanExceptionDealThread();
		thread.setActiveMqDao(activeMqDao);
		thread.setExceptionDealInfoDao(exceptionDealInfoDao);
		
		thread.start();
	}

}
