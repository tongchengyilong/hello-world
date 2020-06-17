package com.baiwang.custom.common.dao;

import com.baiwang.custom.common.model.MGBwResponesUnusual;
import com.baiwang.custom.common.model.MGOverDueModel;
import com.baiwang.custom.common.model.MGQueryInvModel;
import com.baiwang.custom.common.model.QueryInvRequestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MGTScmVatMainMapper {

    List<MGQueryInvModel> queryInvList(QueryInvRequestModel queryInvRequestModel);
    //20180910版新增 查询全票面信息 TODO:需要时使用
    List<MGQueryInvModel> queryInvFullList(QueryInvRequestModel queryInvRequestModel);
    //异常发票列表查询
    List<MGBwResponesUnusual> queryUnusualList(@Param("queryParams")Map params);

    List<MGOverDueModel> queryOverDueList(@Param("queryParams")Map params);
    

}
