package com.asiainfo.integration.o2p.task.dao.Mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ailk.eaap.op2.bo.ExceptionDealInfo;

@Component(value="exceptionDealInfoDao")
public interface IExceptionDealInfoDao {
	Integer queryExceptionDealInfoCountByObjId(Integer objId);
	List<ExceptionDealInfo> queryExceptionDealInfoPage(Map<String, Object> prarams);
	void updateExceptionDealInfo(ExceptionDealInfo info);
	ExceptionDealInfo queryExceptionDealInfoById(Integer id);
}
