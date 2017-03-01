package com.asiainfo.integration.o2p.task.service;

import java.util.List;

import com.asiainfo.integration.o2p.task.common.TaskException;

public interface ITaskCasService {
	
	/**
	 * 判断不同串行任务风格，任务KEY组在缓存中的状态
	 * @param taskFlagList
	 * @return
	 * @throws TaskException 
	 */
	boolean conTaskFlagIncacheStatus(List<String> taskFlagList,String taskStyle, int objId, Integer tenantId) throws TaskException;
	
	/**
	 * 判断并行任务在缓存中运行的数量
	 * @param taskFlagList
	 * @param taskStyle
	 * @param objId
	 * @param maxRunNum
	 * @return
	 * @throws TaskException
	 */
	boolean noConTaskFlagIncacheStatus(List<String> taskFlagList,String taskStyle, int objId, Integer parallelismDegree, Integer tenantId) throws TaskException;
	
	/**
	 * 修改任务风格在缓存中状态
	 * @param key
	 * @param status
	 */
	void modifyTaskCacheStatus(String key, int status);
	
	/**
	 * 初始化任务状态
	 * @param serverIdentifying
	 */
	void initMemcacheTaskList(String serverIdentifying);
	
	/**
	 * 并发任务已挂掉的状态清空
	 * @param key
	 */
	void reSetConcurrentTaskMemcached(String key, Integer tenantId);

}
