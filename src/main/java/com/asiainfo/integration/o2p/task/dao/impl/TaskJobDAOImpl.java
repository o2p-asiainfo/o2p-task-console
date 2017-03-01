package com.asiainfo.integration.o2p.task.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.ailk.eaap.o2p.fileExchange.model.TaskJobLogBean;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.o2p.task.model.TaskType;
import com.ailk.eaap.op2.bo.Component;
import com.ailk.eaap.op2.bo.GatherCycle;
import com.ailk.eaap.op2.bo.SerInvokeIns;
import com.ailk.eaap.op2.bo.Service;
import com.ailk.eaap.op2.bo.Tenant;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;

public class TaskJobDAOImpl implements ITaskJobDAO {
	private SqlSessionTemplate sqlSessionTemplate;
	public static final String GET_TASK_CYCLE_LIST_PAGE = "taskjob.GET_TASK_CYCLE_LIST_PAGE";
	public static final String GET_TASK_BY_ID = "taskjob.getTaskById";

	public String getTaskCycleExp(String taskId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void addTaskLog(TaskJobLogBean taskJobLog) {

		sqlSessionTemplate.insert("taskjob.ADD_TASK_LOG", taskJobLog);
	}

	public int getTaskCount(Map<String, Object> param) {

		return (Integer) sqlSessionTemplate.selectOne("taskjob.GET_TASK_COUNT",
				param);
	}

	public List<TaskContentBean> getTaskList(Map<String, Object> param) {
		return sqlSessionTemplate.selectList("taskjob.GET_TASK_LIST_PAGE", param);
	}

	public void updateJobCycle(TaskContentBean taskContent) {

		sqlSessionTemplate.update("taskjob.UPDATE_JOB_CYCLE", taskContent);
	}

	public int getTaskLogCount(Map<String, Object> param) {

		return (Integer) sqlSessionTemplate.selectOne(
				"taskjob.GET_TASK_LOG_COUNT", param);
	}

	public List<TaskJobLogBean> getTaskLogList(Map<String, Object> param) {

		return sqlSessionTemplate.selectList("taskjob.GET_TASK_LOG_LIST_PAGE", param);
	}

	public void changeJobThreadNumber(TaskContentBean taskContent) {

		sqlSessionTemplate.update("taskjob.CHANGE_JOB_THREAD_NUM", taskContent);
	}

	public TaskContentBean getTaskContentBean(Map<String, Object> param) {
		//Map<String, Object> param = new HashMap<String, Object>();
		//param.put("taskId", taskId);
		return (TaskContentBean)sqlSessionTemplate.selectOne(GET_TASK_BY_ID, param);
	}

	public int updateTaskContentBean(TaskContentBean taskContentBean) {
		if(taskContentBean.getTaskRelaObj() != null) {
			taskContentBean.getTaskRelaObj().setTaskId(String.valueOf(taskContentBean.getTaskId()));
			sqlSessionTemplate.update("taskjob.UPDATE_TASK_RELA_OBJ", taskContentBean.getTaskRelaObj());
		}
		return sqlSessionTemplate.update("taskjob.UPDATE_TASK_CONTENT",
				taskContentBean);
	}

	public List<GatherCycle> getTaskCycleList(Integer tenantId) {
		return sqlSessionTemplate.selectList(GET_TASK_CYCLE_LIST_PAGE, tenantId);
	}	

	public List<GatherCycle> getTaskCycleList(Map<String, Object> param) {
		return sqlSessionTemplate.selectList(GET_TASK_CYCLE_LIST_PAGE, param);
	}

	public void updateCycle(GatherCycle gc) {

		sqlSessionTemplate.update("taskjob.UPDATE_CYCLE", gc);
	}

	public void deleteCycle(GatherCycle gc) {

		sqlSessionTemplate.update("taskjob.DELETE_CYCLE", gc);
	}

	public int getTaskCountByGcCd(GatherCycle gc) {

		return (Integer) sqlSessionTemplate.selectOne(
				"taskjob.GET_TASK_COUNT_BY_GCCD", gc);
	}

	public int addCycle(GatherCycle gc) {
		sqlSessionTemplate.insert("taskjob.ADD_CYCLE", gc);
		return gc.getGcCd();
	}

	public TaskContentBean getTaskById(Integer taskId) {
		return (TaskContentBean) sqlSessionTemplate.selectOne(
				GET_TASK_BY_ID, taskId);
	}

	public int getTaskCycleNum(Map<String, Object> param) {
		return (Integer) sqlSessionTemplate.selectOne(
				"taskjob.GET_TASK_CYCLE_NUM", param);
	}

	public GatherCycle getGatherCycleBean(int gcCd) {
		GatherCycle gc = new GatherCycle();
		gc.setGcCd(gcCd);
		return (GatherCycle) sqlSessionTemplate.selectOne(
				"taskjob.GET_GATHER_CYCLE_BEAN", gc);
	}

	public int addTask(Map<String, Object> param) {
		return (Integer) sqlSessionTemplate.insert("taskjob.ADD_TASK_MANAGER", param);
	}

	public int addRelaObj(Map<String, Object> param) {
		return (Integer) sqlSessionTemplate.insert("taskjob.ADD_TASK_RELA_OBJ", param);
	}

	public TaskJobLogBean getTaskJobLogById(int taskLogId) {
		TaskJobLogBean taskJobLogBean = new TaskJobLogBean();
		taskJobLogBean.setTaskLogId(taskLogId);
		return (TaskJobLogBean) sqlSessionTemplate.selectOne(
				"taskjob.GET_TASK_JOB_LOG_BY_ID", taskJobLogBean);
	}

	public void deleteTask(Map<String, Object> param) {
		sqlSessionTemplate.update("taskjob.DELETE_TASK", param);
	}

	@Override
	public void updateStartTaskState(TaskContentBean taskContent) {
		sqlSessionTemplate.update("taskjob.UPDATE_TASK_STATE", taskContent);
	}

	@Override
	public TaskType getTaskTypeByCd(String taskType) {
		return (TaskType) sqlSessionTemplate.selectOne("taskjob.getTaskTypeByCd", Integer.parseInt(taskType));
	}
	
	private String ObjtoString(Object obj){
		if(obj==null){
			return "";
		}
		return obj.toString();
	}
	private int ObjtoInt(Object obj){
		if(obj==null){
			return 0;
		}
		String routeidstr2 = obj.toString();
		return Double.valueOf(routeidstr2).intValue();
	}

	@Override
	public SerInvokeIns getSerInvokeIns(int objId) {
		List<Map<String,String>> resultMap =  sqlSessionTemplate.selectList("taskjob.getSerInvokeIns", objId);
		if(resultMap != null && !resultMap.isEmpty()) {
			Map<String, String> map = resultMap.get(0);
			SerInvokeIns serInvokeIns = new SerInvokeIns();
			serInvokeIns.setComponentId(ObjtoString(map.get("COMPONENT_ID")));
			serInvokeIns.setSerInvokeInsName(map.get("SER_INVOKE_INS_NAME"));
			serInvokeIns.setSerInvokeInsId(ObjtoInt(map.get("SER_INVOKE_INS_ID")));
			serInvokeIns.setServiceId(ObjtoInt(map.get("SERVICE_ID")));
			serInvokeIns.setComponentCode(ObjtoString(map.get("CODE")));
			serInvokeIns.setState(ObjtoString(map.get("STATE")));
			serInvokeIns.setLogLevel(ObjtoString(map.get("LOG_LEVEL")));
			serInvokeIns.setAuthExpress(ObjtoString(map.get("AUTH_EXPRESS")));
			if(map.get("SERVICE_ID") != null) {
				serInvokeIns.setService(this.getService(ObjtoInt(map.get("SERVICE_ID"))));
			}
			return serInvokeIns;
 		} else {
			return null;
		}
	}
	
	private Service getService(int serviceId) {
		List<Map<String,String>> resultMap =  sqlSessionTemplate.selectList("taskjob.getService", serviceId);
		if(resultMap == null || resultMap.isEmpty()) {
			return null;
		} else {
			Map<String, String> map = resultMap.get(0);
			Service s = new Service();
			s.setServiceCnName(map.get("SERVICE_CN_NAME"));
			s.setServiceId(ObjtoInt(map.get("SERVICE_ID")));
			s.setServiceCode(map.get("SERVICE_CODE").toString());
			s.setServiceVersion(map.get("SERVICE_VERSION").toString());
			s.setState(map.get("STATE").toString());
			return s;
		}
	}

	@Override
	public Component getComponent(String componentCode) {
		List<Component> componentList =  sqlSessionTemplate.selectList("taskjob.getComponent", componentCode);
		if(componentList == null || componentList.size() == 0) {return null;}
		else {return componentList.get(0);}
	}

	@Override
	public  List<Integer> hasPublicEndpoint(Integer objId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		return sqlSessionTemplate.selectList("taskjob.getPublicEndpoint", param);
	}
	
	@Override
	public List<String> getTenantIdList() {
		List<Map<String, String>> result = sqlSessionTemplate.selectList("taskjob.getTenantIdList", null);
		if(result!=null && !result.isEmpty()){
			List<String> tenantIdList = new ArrayList<String>();
			for(Map<String, String> map : result){
				tenantIdList.add(String.valueOf(map.get("TENANT_ID")));
			}
			return tenantIdList;
		}
		return null;
	}
	
}
