package com.asiainfo.integration.o2p.task.common;

import java.util.concurrent.TimeoutException;
import org.springframework.jms.JmsException;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.ibatis.exceptions.PersistenceException;

public class TaskException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ERROR_TYPE_SEND_MQ = 0;
	public static final int ERROR_TYPE_CONN_DB = 1;
	public static final int ERROR_TYPE_CPMM_CACHE = 2;
	private int errorType = -1;

	public TaskException(String msg) {
		super(msg);
	}
	
	public TaskException(Throwable e) {
		super(e);
		setErrorType(e);
	}
	
	public int getErrorType() {
		return this.errorType;
	}

	private void setErrorType(Throwable e) {
		if(e instanceof PersistenceException) {
			this.errorType = ERROR_TYPE_CONN_DB;
		} else if(e instanceof TimeoutException) {
			this.errorType = ERROR_TYPE_CPMM_CACHE;
		} else if(e instanceof InterruptedException) {
			this.errorType = ERROR_TYPE_CPMM_CACHE;
		} else if(e instanceof MemcachedException) {
			this.errorType = ERROR_TYPE_CPMM_CACHE;
		} else if(e instanceof JmsException) {
			this.errorType = ERROR_TYPE_SEND_MQ;
		}
	}

}
