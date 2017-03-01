package com.asiainfo.integration.o2p.task.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;

public class DeleteAllKeyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3250317591415905703L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(req.getSession().getServletContext());
		ITaskCasService taskCasService = (ITaskCasService) context
				.getBean("taskCacheService");
		Object tenantIdObj = req.getSession().getAttribute("USER_TENANT_ID");
		Integer tenantId = null;
		if(tenantIdObj != null && StringUtils.hasText(tenantIdObj.toString())) {
			tenantId = Integer.valueOf(tenantIdObj.toString());
		}
		if(tenantId == null) {
			tenantId = CacheKey.defaultTenantId;
		}
		taskCasService.reSetConcurrentTaskMemcached(null,tenantId);
		PrintWriter pw = resp.getWriter();
		if (req.getAttribute("err") != null) {
			pw.write(req.getAttribute("err") + "");
		}
		pw.flush();
		pw.close();
	}
	
	

}
