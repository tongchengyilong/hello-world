package com.baiwang.custom.web.service;

import java.util.List;
import java.util.Map;

import com.baiwang.custom.common.model.MGQueryInvModel;
import com.baiwang.custom.common.model.QueryInvModel;
import com.baiwang.custom.common.model.QueryInvRequest;
import com.baiwang.custom.common.model.QueryInvRequestModel;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.github.pagehelper.PageInfo;

public interface MGInvoiceCheckService {

    //分页查询已入库发票
    PageInfo<MGQueryInvModel> getQueryInvModelListPage(QueryInvRequestModel queryInvRequestModel, int pageNum, int pageSize);
    //分页查询已入库发票全票面信息 20180910版新增
    PageInfo<MGQueryInvModel> getQueryInvModelFullListPage(QueryInvRequestModel queryInvRequestModel, int pageNum, int pageSize);
    //格式化返回列表(已入库)（Excel）
    List<Map<String,Object>> getFormartVatList(List<MGQueryInvModel> results);
    //根据id获取发票主表实体

}