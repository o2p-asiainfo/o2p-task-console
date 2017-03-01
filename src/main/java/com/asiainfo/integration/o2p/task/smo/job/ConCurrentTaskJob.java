package com.asiainfo.integration.o2p.task.smo.job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import net.sf.json.JSONObject;

import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.op2.bo.CacheFlagCommon;
import com.asiainfo.integration.o2p.task.common.TaskException;

public class ConCurrentTaskJob extends BaseTaskJob{
	public static final Integer DEFAULT_PARALLELISM_DEGREE = 10;
	
	private static final long serialVersionUID = 1L;

	@Override
	public void assembeTaskFlagList(List<String> taskFlagList, int objId) {
		String taskCacheFlag = CacheFlagCommon.TASK_FLAG+objId;
		taskFlagList.add(taskCacheFlag);
	}

	@Override
	public void sendToMq(List<String> taskFlagList,
			TaskContentBean taskContent, int objId, JSONObject json,
			String queueName, Integer tenantId) throws TaskException {
		if(getTaskCasService().noConTaskFlagIncacheStatus(taskFlagList,taskContent.getTaskStyle(), objId, taskContent.getParallelismDegree(), tenantId)){
			getActiveMqDao().sendToActiveMq(json.toString(), queueName);
		}
	}

	@Override
	public JSONObject assembeJson(int objId, Integer tenantId, Integer parallelismDegree,
			String taskStyle, List<String> taskFlagList) {
		String[] taskKeys = taskFlagList.toArray(new String[taskFlagList.size()]);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("objId", objId);
		map.put("taskStyle", taskStyle);
		map.put("taskKeys",taskKeys);
		map.put("tenantId", tenantId);
		if(parallelismDegree != null) {
			map.put("parallelismDegree", parallelismDegree);
		}
		return JSONObject.fromObject(map);
	
	}

}
