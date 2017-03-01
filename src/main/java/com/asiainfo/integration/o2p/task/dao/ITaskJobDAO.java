package com.asiainfo.integration.o2p.task.dao;

import java.util.List;
import java.util.Map;

import com.ailk.eaap.o2p.fileExchange.model.TaskJobLogBean;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.o2p.task.model.TaskType;
import com.ailk.eaap.op2.bo.Component;
import com.ailk.eaap.op2.bo.GatherCycle;
import com.ailk.eaap.op2.bo.SerInvokeIns;

public interface ITaskJobDAO {
	
	/**
	 * 判断服务调用实例对应的消息流中是否含有分发端点
	 * @param objId
	 * @return
	 */
	 List<Integer> hasPublicEndpoint(Integer objId);

	/**
	 * 根据任务id获取任务执行周期表达式
	 * @param taskId
	 * @return
	 */
	String getTaskCycleExp(String taskId);

	/**
	 * 更新任务状态
	 * @param string
	 * @param taskId
	 */
	void updateStartTaskState(TaskContentBean taskContent);

	/**
	 * 添加任务执行日志
	 * @param taskContent
	 */
	void addTaskLog(TaskJobLogBean taskJobLog);

	/**
	 * 获取任务总数
	 * @return
	 */
	int getTaskCount(Map<String, Object> param);

	/**
	 * 获取任务列表
	 * @param 参数
	 * @return
	 */
	List<TaskContentBean> getTaskList(Map<String, Object> param);

	/**
	 * 修改任务运行周期
	 * @param taskContent
	 */
	void updateJobCycle(TaskContentBean taskContent);

	/**
	 * 取任务日志总数
	 * @return
	 */
	int getTaskLogCount(Map<String, Object> param);

	/**
	 * 取任务日志列表
	 * @param skipRow
	 * @param maxResult
	 * @return
	 */
	List<TaskJobLogBean> getTaskLogList(Map<String, Object> param);

	/**
	 * 修改线程数
	 * @param taskContent
	 */
	void changeJobThreadNumber(TaskContentBean taskContent);

	/**
	 * 查看任务
	 * @param taskId
	 */
	TaskContentBean getTaskContentBean(Map<String, Object> param);

	/**
	 * 修改任务
	 * @param taskId
	 * @return
	 */
	int updateTaskContentBean(TaskContentBean taskContentBean);

	/**
	 * 获取周期列表
	 * @param tenantId 
	 * @return
	 */
	List<GatherCycle> getTaskCycleList(Integer tenantId);

	/**
	 * 获取周期列表
	 * @return
	 */
	List<GatherCycle> getTaskCycleList(
			Map<String, Object> param);

	/**
	 * 修改周期
	 * @return
	 */
	void updateCycle(GatherCycle gc);

	/**
	 * 删除周期
	 * @return
	 */
	void deleteCycle(GatherCycle gc);

	/**
	 * 根据周期id查询任务数
	 * @return
	 */
	int getTaskCountByGcCd(GatherCycle gc);

	/**
	 * 添加周期
	 * @return
	 */
	int addCycle(GatherCycle gc);
	TaskContentBean getTaskById(Integer taskId);

	/**
	 * 周期总数
	 * @param param
	 * @return
	 */
	int getTaskCycleNum(Map<String, Object> param);

	/**
	 * 根据id查询周期
	 * @param gcCd
	 * @return
	 */
	GatherCycle getGatherCycleBean(int gcCd);

	/**
	 * 添加任务
	 * @param param
	 */
	int addTask(Map<String, Object> param);

	/**
	 * 添加任务对应服务调用实例
	 * @param param
	 */
//	int addTaskSerIns(Map<String, Object> param);

	/**
	 * 根据id查询日志详细信息
	 * @param taskLogId
	 * @return
	 */
	TaskJobLogBean getTaskJobLogById(int taskLogId);

	/**
	 * 获取任务类型列表
	 * @param param
	 * @return
	 */
//	List<TaskContentBean> getTaskTypeList(Map<String, Object> param);

	/**
	 * 删除任务
	 * @param param
	 */
	void deleteTask(Map<String, Object> param);
	
	/**
	 * 添加任务实体
	 */
	int addRelaObj(Map<String, Object> param);

	/**
	 * 获取任务类型
	 * @param taskType
	 * @return
	 */
	TaskType getTaskTypeByCd(String taskType);

	/**
	 * 获取服务调用实例
	 * @param objId
	 * @return
	 */
	SerInvokeIns getSerInvokeIns(int objId);

	/**
	 * 获取组件
	 * @param componentCode
	 * @return
	 */
	Component getComponent(String componentCode);


	List<String> getTenantIdList();

	
}
