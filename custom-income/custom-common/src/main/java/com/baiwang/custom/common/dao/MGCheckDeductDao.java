package com.baiwang.custom.common.dao;

import com.baiwang.custom.common.entity.MGTScmVatMain;

import java.util.List;
import java.util.Map;

public interface MGCheckDeductDao {

	//根据查询条件查询主表信息 TODO 3
	List<MGTScmVatMain> queryCheckDeductList(Map map);
    //	TODO 1
	List<MGTScmVatMain> queryCollectInfo(Map map);
	//  TODO 2
	List<MGTScmVatMain> queryCheckDeductNotExistCollectInfo(Map map);


}
