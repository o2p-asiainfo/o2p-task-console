package com.asiainfo.integration.o2p.task.smo.job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.DisallowConcurrentExecution;

import net.sf.json.JSONObject;

import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.op2.bo.CacheFlagCommon;
import com.ailk.eaap.op2.bo.Tenant;
import com.asiainfo.integration.o2p.task.common.TaskException;

@DisallowConcurrentExecution
public class NonConCurrentTaskJob extends BaseTaskJob{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void assembeTaskFlagList(List<String> taskFlagList, int objId) {
		//根据任务是否有分发流程生成key值组
		List<Integer> endPointList = getTaskJobDAO().hasPublicEndpoint(objId);
		if(endPointList!=null && endPointList.size()>0){
			for(int i=0;i<endPointList.size();i++){
				Integer endpointId = endPointList.get(i);
				String taskCacheFlag = CacheFlagCommon.TASK_FLAG+objId+CacheFlagCommon.PUB_FLAG+endpointId;
				taskFlagList.add(taskCacheFlag);
			}
			
		}else{
			String taskCacheFlag = CacheFlagCommon.TASK_FLAG+objId;
			taskFlagList.add(taskCacheFlag);
		}
	}

	@Override
	public void sendToMq(List<String> taskFlagList,
			TaskContentBean taskContent, int objId, JSONObject json,
			String queueName, Integer tenantId) throws TaskException {
		if(getTaskCasService().conTaskFlagIncacheStatus(taskFlagList,taskContent.getTaskStyle(), objId, tenantId)){
			for(String key:taskFlagList){
				getTaskCasService().modifyTaskCacheStatus(key, CacheFlagCommon.TASK_STATUS_READY);
			}
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
		return JSONObject.fromObject(map);
	
	}
}
