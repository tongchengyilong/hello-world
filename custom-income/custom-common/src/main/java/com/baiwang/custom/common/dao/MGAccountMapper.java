package com.baiwang.custom.common.dao;

import com.baiwang.custom.common.model.MGAccountResqust;
import com.baiwang.custom.common.model.MGInvoiceModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 发票记账接口
 * @Author: Guoyongzheng
 * @Date: 2018/10/15-10:21
 */
@Mapper
public interface MGAccountMapper {
    //查询主表
    List<MGInvoiceModel> queryInvTVM(List<MGInvoiceModel> params);
    //查询拓展表
    List<MGInvoiceModel> queryInvExtend(List<MGInvoiceModel> params);

    List<MGInvoiceModel> findExtendByVoucherNo(MGAccountResqust params);

    //批量插库
    boolean batchInsertReimburseInfo(List<MGInvoiceModel> params);
    //批量更新 -- 标识1为更新 标识2为作废
    boolean batchUpdateReimburseInfo(List<MGInvoiceModel> params);
    //单条更新列表
    boolean updateReimburseInfo(MGInvoiceModel params );
    //通过凭证号删除发票信息
    boolean DeleteByVoucherNo(MGAccountResqust params );
}
