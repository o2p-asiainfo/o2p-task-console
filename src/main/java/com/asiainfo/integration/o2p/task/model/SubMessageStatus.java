/** 
 * Project Name:o2p-subpub-service 
 * File Name:SubMessageStatus.java 
 * Package Name:com.ailk.eaap.o2p.model 
 * Date:2014年10月6日下午3:02:23 
 * Copyright (c) 2014, www.asiainfo.com All Rights Reserved. 
 * 
 */

package com.asiainfo.integration.o2p.task.model;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * ClassName:SubMessageStatus <br/>
 * Date: 2014年10月6日 下午3:02:23 <br/>
 * 
 * @author mf
 * @version
 * @since JDK 1.6
 * @see
 */
public class SubMessageStatus implements Serializable {

	/** 
	 * @since JDK 1.6 
	 */  
	private static final long serialVersionUID = -4659996623152018626L;
	
	private Integer subId;
	private Integer subTaskId;
	private Integer subMesId;
	private Integer subSerInsId;
	private Integer subEndpointId;
	private Integer subContentType;
	private String subContent;
	private Integer subStatus;
	private Timestamp subNextDate;
	private Integer subTimeNum;
	private Timestamp subDate;
	private Timestamp createDate;
	private String hostName;
	
	
	public SubMessageStatus(Integer subId, Integer subTaskId, Integer subMesId,
			Integer subSerInsId, Integer subEndpointId, Integer subContentType,
			String subContent, Integer subStatus, Timestamp subNextDate,
			Integer subTimeNum, Timestamp subDate, Timestamp createDate,
			String hostName) {
		
		this.subId = subId;
		this.subTaskId = subTaskId;
		this.subMesId = subMesId;
		this.subSerInsId = subSerInsId;
		this.subEndpointId = subEndpointId;
		this.subContentType = subContentType;
		this.subContent = subContent;
		this.subStatus = subStatus;
		this.subNextDate = new Timestamp(subNextDate.getTime());
		this.subTimeNum = subTimeNum;
		this.subDate = new Timestamp(subDate.getTime());
		this.createDate = new Timestamp(createDate.getTime());
		this.hostName = hostName;
	}


	public SubMessageStatus() {
		
	}


	public Integer getSubId() {
		return subId;
	}


	public void setSubId(Integer subId) {
		this.subId = subId;
	}


	public Integer getSubTaskId() {
		return subTaskId;
	}


	public void setSubTaskId(Integer subTaskId) {
		this.subTaskId = subTaskId;
	}


	public Integer getSubMesId() {
		return subMesId;
	}


	public void setSubMesId(Integer subMesId) {
		this.subMesId = subMesId;
	}


	public Integer getSubSerInsId() {
		return subSerInsId;
	}


	public void setSubSerInsId(Integer subSerInsId) {
		this.subSerInsId = subSerInsId;
	}


	public Integer getSubEndpointId() {
		return subEndpointId;
	}


	public void setSubEndpointId(Integer subEndpointId) {
		this.subEndpointId = subEndpointId;
	}


	public Integer getSubContentType() {
		return subContentType;
	}


	public void setSubContentType(Integer subContentType) {
		this.subContentType = subContentType;
	}


	public String getSubContent() {
		return subContent;
	}


	public void setSubContent(String subContent) {
		this.subContent = subContent;
	}


	public Integer getSubStatus() {
		return subStatus;
	}


	public void setSubStatus(Integer subStatus) {
		this.subStatus = subStatus;
	}


	public Timestamp getSubNextDate() {
		return new Timestamp(subNextDate.getTime());
	}


	public void setSubNextDate(Timestamp subNextDate) {
		this.subNextDate = new Timestamp(subNextDate.getTime());
	}


	public Integer getSubTimeNum() {
		return subTimeNum;
	}


	public void setSubTimeNum(Integer subTimeNum) {
		this.subTimeNum = subTimeNum;
	}


	public Timestamp getSubDate() {
		return new Timestamp(subDate.getTime());
	}


	public void setSubDate(Timestamp subDate) {
		this.subDate = new Timestamp(subDate.getTime());
	}


	public Timestamp getCreateDate() {
		return new Timestamp(createDate.getTime());
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = new Timestamp(createDate.getTime());
	}


	public String getHostName() {
		return hostName;
	}


	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
}
