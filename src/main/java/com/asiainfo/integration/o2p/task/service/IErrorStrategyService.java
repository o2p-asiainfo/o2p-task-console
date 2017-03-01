package com.asiainfo.integration.o2p.task.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.ailk.eaap.o2p.task.model.TaskContentBean;


public interface IErrorStrategyService {

	void excuteErrorRetry(List<String> taskFlagList,
			TaskContentBean taskContent, JSONObject json);
	
	void setErrorType(int errorType);
	
}
