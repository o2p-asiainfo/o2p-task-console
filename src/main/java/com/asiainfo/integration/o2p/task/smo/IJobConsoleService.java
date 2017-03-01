package com.asiainfo.integration.o2p.task.smo;

import java.util.List;
import java.util.Map;
import com.ailk.eaap.o2p.fileExchange.model.TaskJobLogBean;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.op2.bo.GatherCycle;

public interface IJobConsoleService {
	
	/**
	 * 添加任务
	 * @param param
	 */
	int addTask(Map<String, Object> param);
	
	/**
	 * 获取运行中任务
	 */
	List<String> getCurrRunTask();
	
	/**
	 * 启动任务
	 * @param taskContentList
	 * @return
	 */
	List<String> start(List<TaskContentBean> taskContentList);
	
	/**
	 * 重启任务
	 */
	List<String> restart(List<TaskContentBean> taskContentList,List<TaskContentBean> taskContentListStop);
	
	/**
	 * 启动所有任务
	 */
	List<String> startAll(String tenantId);
	
	/**
	 * 停止所有任务
	 */
	List<String> stopAll(String tenantId);
	
	/**
	 * 关闭任务
	 * @param taskContentList
	 */
	List<String> stop(List<TaskContentBean> taskContentList);
	
	
	/**
	 * 获取任务列表的总数
	 * @param param
	 * @return
	 */
	int getTaskListNum(Map<String, Object> param);

	/**
	 * 获取任务列表
	 * @param param
	 * @return
	 */
	List<TaskContentBean> getTaskList(Map<String, Object> param);
	
	/**
	 * 获取任务日志的总数
	 * @param param
	 * @return
	 */
	int getTaskLogListNum(Map<String, Object> param);
	
	/**
	 * 获取任务日志列表
	 * @param param
	 * @return
	 */
	List<TaskJobLogBean> getTaskLogList(Map<String, Object> param);

	
	/**
	 * 查看任务
	 * @param taskId
	 * @return
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
	 * @return
	 */
	List<GatherCycle>  getTaskCycleList(Integer tenantId);
	
	/**
	 * 获取周期列表
	 * @param param
	 * @return
	 */
	List<GatherCycle> getTaskCycleList(Map<String, Object> param);
	
	/**
	 * 获取周期数目
	 * @param param
	 * @return
	 */
	int getTaskCycleNum(Map<String, Object> param);

	
	/**
	 * 修改周期
	 * @param gc
	 */
	void updateCycle(GatherCycle gc);
	
	/**
	 * 删除周期
	 * @param gc
	 */
	int deleteCycle(GatherCycle gc);
	
	
	/**
	 * 新增周期
	 * @param gc
	 * @return
	 */
	int addCycle(GatherCycle gc);
	
	/**
	 * 根据id查询周期
	 * @param gcCd
	 * @return
	 */
	GatherCycle getGatherCycleBean(int gcCd);

	/**
	 * 用户操作日志
	 * @param map
	 */
	void operatorLog(Map<String, Object> map);
	
	void shutDown();
	
	/**
	 * 日志详细信息
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
	 * @param ids
	 */
	List<String> deleteTask(List<String> taskIds);
	
	/**
	 * 
	 * startFlag:是否启动定时任务生产者标示 <br/> 
	 * @author mf 
	 * @return 
	 * @since JDK 1.6
	 */
	boolean isInitTask();
}
