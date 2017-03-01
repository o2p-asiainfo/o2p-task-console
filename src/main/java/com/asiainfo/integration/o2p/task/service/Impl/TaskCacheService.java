package com.asiainfo.integration.o2p.task.service.Impl;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;

import com.ailk.eaap.o2p.common.cache.CacheFactory;
import com.ailk.eaap.o2p.common.cache.CacheKey;
import com.ailk.eaap.o2p.common.util.zookeeperUtil.DistributedConsistencyHelper;
import com.ailk.eaap.o2p.common.util.zookeeperUtil.ZooKeeperCodeCallBack;
import com.ailk.eaap.o2p.common.util.zookeeperUtil.ZooKeeperReentrantLock;
import com.ailk.eaap.o2p.task.model.TaskContentBean;
import com.ailk.eaap.op2.bo.CacheFlagCommon;
import com.ailk.eaap.op2.bo.TaskCacheFlag;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.common.TaskException;
import com.asiainfo.integration.o2p.task.dao.ITaskJobDAO;
import com.asiainfo.integration.o2p.task.dao.Mapper.IExceptionDealInfoDao;
import com.asiainfo.integration.o2p.task.service.ITaskCasService;


public class TaskCacheService implements ITaskCasService{
	

	private static final Logger log = Logger.getLog(TaskCacheService.class);
	private CacheFactory<String, Object> cacheFactory;
	@Autowired
	private IExceptionDealInfoDao exceptionDealInfoDao;
	@Autowired
	private ITaskJobDAO taskJobDAO;
	
	/**
	 * 判断串行任务不同任务风格，任务KEY组在缓存中的状态
	 * @param taskFlagList
	 * @return
	 * @throws TaskException 
	 */
	@SuppressWarnings("unchecked")
	public boolean conTaskFlagIncacheStatus(List<String> taskFlagList,String taskStyle, int objId, Integer tenantId) throws TaskException{
		int countStatus = 0;
		if(tenantId == null) {
			tenantId = CacheKey.defaultTenantId;
		}
		final Integer tenId = tenantId;
		try{
			for(final String key:taskFlagList){
				TaskCacheFlag cacheKeyStatusObject = (TaskCacheFlag)cacheFactory.getCacheClient().get(key);
				if(cacheKeyStatusObject==null || !taskStyle.equals(cacheKeyStatusObject.getTaskStyle())){
					new ZooKeeperReentrantLock(tenId+CacheFlagCommon.TASK_MAP_FLAG).lockCode(3, TimeUnit.MINUTES, new ZooKeeperCodeCallBack() {
						@Override
						public boolean callBack() {
							Map<String,String> taskMap = (Map<String,String>) cacheFactory.getCacheClient().get(tenId+CacheFlagCommon.TASK_MAP_FLAG);
							if(taskMap==null){
								taskMap = new LinkedHashMap<String,String>();
							}
							taskMap.put(key, key);
							return cacheFactory.getCacheClient().put(tenId+CacheFlagCommon.TASK_MAP_FLAG,taskMap);
						}
					});
					
					cacheKeyStatusObject = new TaskCacheFlag();
					cacheKeyStatusObject.setTaskCode(key);
					cacheKeyStatusObject.setTaskStatus(CacheFlagCommon.TASK_STATUS_OVER);
					cacheKeyStatusObject.setModifyDate(new Timestamp(System.currentTimeMillis()));
					cacheKeyStatusObject.setTaskStyle(taskStyle);
					cacheFactory.getCacheClient().put(key, cacheKeyStatusObject);
				}
				countStatus += cacheKeyStatusObject.getTaskStatus();
				
				if(log.isDebugEnabled()){
					log.debug("taskKey:{0},taskStyle:{1},countStatus:{2}",key,taskStyle,countStatus);
				}
			}
			//根据任务风格进行判断是否增加到队列中
			if(taskStyle.equals(TaskContentBean.NON_CONCURRENCY_DEPENDENT_TASK)){
				if(countStatus == taskFlagList.size()*CacheFlagCommon.TASK_STATUS_OVER || countStatus == taskFlagList.size()*CacheFlagCommon.TASK_STATUS_READY){
					if(exceptionDealInfoDao.queryExceptionDealInfoCountByObjId(objId) <= 0) {
						return true;
					} else {
						log.debug("task objId {0} is found in the table exceptionDealInfo ", objId);
					}
				}
			}else if(taskStyle.equals(TaskContentBean.NON_CONCURRENCY_INDEPENDENT_TASK)){
				if(countStatus >= taskFlagList.size()*CacheFlagCommon.TASK_STATUS_EXCEPTION || countStatus == taskFlagList.size()*CacheFlagCommon.TASK_STATUS_READY){
					return true;
				}
			}
		} catch (RuntimeException e) {
			if(e.getCause() instanceof PersistenceException) {
				throw new TaskException(e.getCause());
			}
		}
		return false;
	}
	
	/**
	 * 判断并行任务不同任务风格，任务KEY组在缓存中的状态
	 * @param taskFlagList
	 * @return
	 * @throws TaskException 
	 */
	@SuppressWarnings("unchecked")
	public boolean noConTaskFlagIncacheStatus(List<String> taskFlagList,String taskStyle, int objId, Integer parallelismDegree, Integer tenantId) throws TaskException{
		if(tenantId == null) {
			tenantId = CacheKey.defaultTenantId;
		}
		final Integer tenId = tenantId;
		if(parallelismDegree == null) {
			if(cacheFactory.getCacheClient().get(taskFlagList.get(0)) != null) {
				cacheFactory.getCacheClient().remove(taskFlagList.get(0));
			}
			return true;
		} else {
			final String key = taskFlagList.get(0);
			TaskCacheFlag cacheKeyStatusObject = (TaskCacheFlag)cacheFactory.getCacheClient().get(key);
			if(log.isDebugEnabled()) {
				log.debug("taskStyle = {0},parallelismDegree = {1},objId={2}",  taskStyle, parallelismDegree, objId);
			}
			if(cacheKeyStatusObject==null || !taskStyle.equals(cacheKeyStatusObject.getTaskStyle())){
				new ZooKeeperReentrantLock(tenId+CacheFlagCommon.TASK_MAP_FLAG).lockCode(3, TimeUnit.MINUTES, new ZooKeeperCodeCallBack() {
					@Override
					public boolean callBack() {
						Map<String,String> taskMap = (Map<String,String>) cacheFactory.getCacheClient().get(tenId+CacheFlagCommon.TASK_MAP_FLAG);
						if(taskMap==null){
							taskMap = new LinkedHashMap<String,String>();
						}
						taskMap.put(key, key);
						return cacheFactory.getCacheClient().put(tenId+CacheFlagCommon.TASK_MAP_FLAG,taskMap);
					}
				});
				cacheKeyStatusObject = new TaskCacheFlag();
				cacheKeyStatusObject.setTaskCode(key);
				cacheKeyStatusObject.setTaskRunningCount(0);
				cacheKeyStatusObject.setModifyDate(new Timestamp(System.currentTimeMillis()));
				cacheKeyStatusObject.setTaskStyle(taskStyle);
				cacheFactory.getCacheClient().put(key, cacheKeyStatusObject);
			}
			if(log.isDebugEnabled()){
				log.debug("taskKey:{0},taskStyle:{1}, parallelismDegree, currentRunNum",key,taskStyle, parallelismDegree, cacheKeyStatusObject.getTaskRunningCount());
			}
			return cacheKeyStatusObject.getTaskRunningCount() < parallelismDegree;
		}
	}
	
	public void reSetConcurrentTaskMemcached(String key, Integer tenantId) {
		@SuppressWarnings("unchecked")
		Map<String,String> taskMap = (Map<String,String>) cacheFactory.getCacheClient().get(tenantId+CacheFlagCommon.TASK_MAP_FLAG);
		if(taskMap!=null && taskMap.size()>0){
			ZooKeeperReentrantLock lock = null;
			try {
				List<String> identifyList = new DistributedConsistencyHelper().getAllServerIdentify(DistributedConsistencyHelper.DEFAULT_AGENT_NAME,true);
				lock = new ZooKeeperReentrantLock(tenantId+CacheFlagCommon.TASK_MAP_FLAG);
				if(lock.lock()) {
					if(key != null) {
						TaskCacheFlag cacheKeyStatusObject = (TaskCacheFlag)cacheFactory.getCacheClient().get(key);
						reSetConcurrentTaskMemcachedByKey(key,cacheKeyStatusObject,identifyList);
					} else {
						for(String k : taskMap.keySet()){
							TaskCacheFlag cacheKeyStatusObject = (TaskCacheFlag)cacheFactory.getCacheClient().get(k);
							reSetConcurrentTaskMemcachedByKey(k,cacheKeyStatusObject,identifyList);
						}
					}
				}
			} catch (Exception e) {
				log.error("lock reSetTaskMemcached failed", e);
			} finally {
				if(lock != null) {
					try {
						lock.release();
					} catch (Exception e) {
						log.error("release lock reSetTaskMemcached failed", e);
					}
				}
			}
		}
	}
	
	public void reSetConcurrentTaskMemcachedByKey(String key,TaskCacheFlag cacheKeyStatusObject,List<String> identifyList) {
		if(cacheKeyStatusObject == null) {
			return;
		}
		if(TaskContentBean.CONCURRENCY_TASK.equals(cacheKeyStatusObject.getTaskStyle())) {
			if(cacheKeyStatusObject.getRunCountDetail().keySet() != null) {
				for(String cacheKey: cacheKeyStatusObject.getRunCountDetail().keySet()){
					if(!identifyList.contains(cacheKey)) {
						Integer num = cacheKeyStatusObject.getRunCountDetail().get(cacheKey);
						if(num != null) { 
							cacheKeyStatusObject.setModifyDate(new Timestamp(System.currentTimeMillis()));
							cacheKeyStatusObject.getRunCountDetail().remove(cacheKey);
							cacheKeyStatusObject.setTaskRunningCount(cacheKeyStatusObject.getTaskRunningCount()-num);
							cacheFactory.getCacheClient().put(key, cacheKeyStatusObject);
						}
					}
				}
			}
		} else {
			cacheKeyStatusObject.setModifyDate(new Timestamp(System.currentTimeMillis()));
			cacheKeyStatusObject.setTaskStatus(CacheFlagCommon.TASK_STATUS_OVER);
			cacheFactory.getCacheClient().put(key, cacheKeyStatusObject);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initMemcacheTaskList(final String serverIdentifying) {
		List<String> tenantIdList = taskJobDAO.getTenantIdList();
		if(tenantIdList != null && !tenantIdList.isEmpty()) {
			for(String tenantIdStr: tenantIdList) {
				Integer tenantId = Integer.valueOf(tenantIdStr);
				//服务引擎启动时，初始化任务在缓存中的状态
				Map<String,String> taskMap = (Map<String,String>) cacheFactory.getCacheClient().get(tenantId+CacheFlagCommon.TASK_MAP_FLAG);
				String[] identifyArray = serverIdentifying.split(DistributedConsistencyHelper.DEFAULT_SPLIT);
				String regHost = identifyArray[0] + DistributedConsistencyHelper.DEFAULT_SPLIT + identifyArray[1];
				final String uuid = identifyArray[2];
				if(taskMap!=null && taskMap.size()>0){
					ZooKeeperReentrantLock lock = null;
					lock = new ZooKeeperReentrantLock(tenantId+CacheFlagCommon.TASK_MAP_FLAG);
					try {
						if(lock.lock()) {
							String key = null;
							for(Map.Entry<String, String> entity : taskMap.entrySet()){
								key = entity.getKey();
								if(!regHost.equals(entity.getValue())) {
									continue;
								}
								TaskCacheFlag cacheKeyStatusObject = (TaskCacheFlag)cacheFactory.getCacheClient().get(key);
								if(cacheKeyStatusObject==null){
									TaskCacheFlag taskCache = new TaskCacheFlag();
									taskCache.setTaskCode(key);
									taskCache.setModifyDate(new Timestamp(System.currentTimeMillis()));
									taskCache.setTaskStatus(CacheFlagCommon.TASK_STATUS_OVER);
									taskCache.setTaskRunningCount(0);
									cacheFactory.getCacheClient().put(key,taskCache);
								}else{
									if(TaskContentBean.CONCURRENCY_TASK.equals(cacheKeyStatusObject.getTaskStyle())) {
										cacheKeyStatusObject.setModifyDate(new Timestamp(System.currentTimeMillis()));
										if(cacheKeyStatusObject.getRunCountDetail().containsKey(uuid)) {
											cacheKeyStatusObject.setTaskRunningCount(cacheKeyStatusObject.getTaskRunningCount()-cacheKeyStatusObject.getRunCountDetail().get(uuid));
											cacheKeyStatusObject.getRunCountDetail().remove(uuid);
										}
										cacheFactory.getCacheClient().put(key, cacheKeyStatusObject);
									} else if(CacheFlagCommon.TASK_STATUS_RUNNING.equals(cacheKeyStatusObject.getTaskStatus())) {
										cacheKeyStatusObject.setModifyDate(new Timestamp(System.currentTimeMillis()));
										cacheKeyStatusObject.setTaskStatus(CacheFlagCommon.TASK_STATUS_OVER);
										cacheFactory.getCacheClient().put(key, cacheKeyStatusObject);
									}
								}
							}
						}
					} catch(Exception e) {
						log.error("init memcached lock failed", e);
					} finally {
						try {
							if(lock != null) {
								lock.release();
							}
						} catch (Exception e) {
							log.error("init memcached lock release failed", e);
						}
					}
				}
			}
		}
	}
	
	public void modifyTaskCacheStatus(String key, final int status) {
		TaskCacheFlag taskCacheFlag = (TaskCacheFlag)cacheFactory.getCacheClient().get(key);
		if(taskCacheFlag.getTaskStatus() != status) {
			taskCacheFlag.setTaskStatus(status);
			taskCacheFlag.setReadyDate(new Timestamp(System.currentTimeMillis()));
			cacheFactory.getCacheClient().put(taskCacheFlag.getTaskCode(), taskCacheFlag);
		}
	}
	
	public CacheFactory<String, Object> getCacheFactory() {
		return cacheFactory;
	}

	public void setCacheFactory(CacheFactory<String, Object> cacheFactory) {
		this.cacheFactory = cacheFactory;
	}

	public void setExceptionDealInfoDao(IExceptionDealInfoDao exceptionDealInfoDao) {
		this.exceptionDealInfoDao = exceptionDealInfoDao;
	}

}
