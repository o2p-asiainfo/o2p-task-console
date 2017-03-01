package com.asiainfo.integration.o2p.task.service.Impl;

import com.ailk.eaap.o2p.common.spring.config.ServerBreakDownWatcherCallback;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;

public class ServerAgentBreakDownWatcherCallback implements ServerBreakDownWatcherCallback{
	
	private ITaskCasService casService;
	private static final Logger LOGGER = Logger.getLog(ServerAgentBreakDownWatcherCallback.class);

	@Override
	public void callBack(String serverIdentifying) {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("server:{0} shutdown and clear the server running task", serverIdentifying);
		}
		casService.initMemcacheTaskList(serverIdentifying);
	}

	public void setCasService(ITaskCasService casService) {
		this.casService = casService;
	}
}
