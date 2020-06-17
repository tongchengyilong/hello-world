package com.baiwang.custom.common.dao;

import com.baiwang.custom.common.entity.MGTScmVatMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface MGPreDeductMapper {

	//查询已采集发票信息
	List<MGTScmVatMain> queryCollectInfo(Map map);
	//查询未采集数据
	List<MGTScmVatMain> queryCheckDeductNotExistCollectInfo(Map map);
	//根据查询条件查询主表信息
	List<MGTScmVatMain> queryCheckDeductList(Map map);

	
}
