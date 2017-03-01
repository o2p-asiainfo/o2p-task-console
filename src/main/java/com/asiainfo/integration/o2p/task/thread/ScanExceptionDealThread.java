package com.asiainfo.integration.o2p.task.thread;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ailk.eaap.op2.bo.ExceptionDealInfo;
import com.asiainfo.foundation.log.Logger;
import com.asiainfo.integration.o2p.task.dao.Mapper.IExceptionDealInfoDao;
import com.asiainfo.integration.o2p.task.dao.activemq.IActiveMqDao;
import com.linkage.rainbow.util.StringUtil;

public class ScanExceptionDealThread extends Thread{
	
	private static final Logger log = Logger.getLog(ScanExceptionDealThread.class);
	
	private IActiveMqDao activeMqDao;
	private IExceptionDealInfoDao exceptionDealInfoDao;

	@Override
	public void run() {
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("tryStatus", ExceptionDealInfo.TRY_STATUS_R);
		param.put("startPage_mysql",0);
		param.put("endPage_mysql",100);
		String queueName = "";
		int infoId = 0;
		while(true){
			try{
				List<ExceptionDealInfo> list = exceptionDealInfoDao.queryExceptionDealInfoPage(param);
				if(list != null && !list.isEmpty()) {
					for(ExceptionDealInfo info:list){
						queueName = info.getExceptionQueueName();
						infoId = info.getExceptionId();
						info.setUpdateDate(new Timestamp(System.currentTimeMillis()));
						info.setTryStatus(ExceptionDealInfo.TRY_STATUS_D);
						if(!StringUtil.isBlank(queueName)){
							activeMqDao.sendToActiveMq(info, queueName);
							exceptionDealInfoDao.updateExceptionDealInfo(info);
						}
					}
				} else {
					Thread.sleep(2000);
				}
			}catch(Exception e){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					log.error("sleep exception", e1);
				}
				log.error(" scan exceptionDealInfo Id:"+infoId+" to send queueName:"+queueName+" error:", e);
			}
			
		}
		
	}

	public IActiveMqDao getActiveMqDao() {
		return activeMqDao;
	}

	public void setActiveMqDao(IActiveMqDao activeMqDao) {
		this.activeMqDao = activeMqDao;
	}

	public void setExceptionDealInfoDao(
			IExceptionDealInfoDao exceptionDealInfoDao) {
		this.exceptionDealInfoDao = exceptionDealInfoDao;
	}
	
	
}
