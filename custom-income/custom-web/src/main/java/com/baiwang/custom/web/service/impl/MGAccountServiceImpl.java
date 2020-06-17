package com.baiwang.custom.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.baiwang.custom.common.dao.MGAccountMapper;
import com.baiwang.custom.common.model.MGAccountResponse;
import com.baiwang.custom.common.model.MGAccountResqust;
import com.baiwang.custom.common.model.MGInvoiceModel;
import com.baiwang.custom.web.service.MGAccountService;
import com.baiwang.platform.custom.common.result.RestFulApiContants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 发票记账信息同步接口
 * @Author: Guoyongzheng
 * @Date: 2018/10/15-10:15
 */
@Service
public class MGAccountServiceImpl implements MGAccountService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MGAccountMapper mgAccountMapper;

    @Override
    @Transactional
    public MGAccountResponse accountSysn(MGAccountResqust mgAccountResqust) {
        //组装List<Object>格式参数
        List<MGInvoiceModel> modelList = this.queryModelInvAccount(mgAccountResqust);
        //查询主表，判断传入发票是否都存在主表中
        List<MGInvoiceModel> responseList = this.mgAccountMapper.queryInvTVM(modelList);
        //当传入参数List与主表查询出List不一致时，返回异常提示
        if (null != responseList && responseList.size() != modelList.size()) {
            return new MGAccountResponse(RestFulApiContants.VAT_NOT_EXIST_ERROR, "报账单据中发票数量与数据库不一致！", false);
        }//当入参都存在于主表中时
        else {
            //通过凭证号查询拓展表
            responseList = this.mgAccountMapper.findExtendByVoucherNo(mgAccountResqust);
            if (responseList == null || responseList.size() <= 0) {
                boolean insertFlag = this.mgAccountMapper.batchInsertReimburseInfo(modelList);
                if (insertFlag) {
                    return new MGAccountResponse("0", "报账单据信息同步数据成功", true);
                } else {
                    return new MGAccountResponse(RestFulApiContants.UN_ERROR, "报账单据信息同步失败，请检查！", false);
                }

            } else {
                boolean deleteFalg = this.mgAccountMapper.DeleteByVoucherNo(mgAccountResqust);
                if (deleteFalg) {
                    boolean insertFlag = this.mgAccountMapper.batchInsertReimburseInfo(modelList);
                    if (insertFlag) {
                        return new MGAccountResponse("0", "报账单据信息同步数据成功", true);
                    } else {
                        return new MGAccountResponse(RestFulApiContants.UN_ERROR, "报账单据信息同步失败，请检查！", false);
                    }
                } else {
                    //插入前删除失败
                    return new MGAccountResponse(RestFulApiContants.UN_ERROR, "数据更新异常，同步失败", false);
                }
            }
            //    //查询拓展表，判断当执行插入操作时，拓展表中不应该存在该单据数据；当更新，作废是拓展表应当存在该单据数据
            //    responseList = this.mgAccountMapper.queryInvExtend(responseList);
            //    //插入业务操作 -- 当更新标识为null或0时执行插入操作
            //    if (mgAccountResqust.getUpdateType() == null || "0".equals(mgAccountResqust.getUpdateType())) {
            //        //当执行插入操作时，拓展表中不应该存在该单据数据
            //        if (0 == responseList.size()) {
            //            boolean insertFlag = this.mgAccountMapper.batchInsertReimburseInfo(modelList);
            //            if (insertFlag) {
            //                return new MGAccountResponse("0", "报账单据信息同步数据成功", true);
            //            } else {
            //                return new MGAccountResponse(RestFulApiContants.UN_ERROR, "报账单据信息同步失败，请检查！", false);
            //            }
            //        } else {
            //            return new MGAccountResponse(RestFulApiContants.UN_ERROR, "报账单已存在，不能重复报账", false);
            //        }
            //    }
            //    //更新或作废业务操作 -- 注意更新标识一张单据只能存在一种状态
            //    else if ("1".equals(mgAccountResqust.getUpdateType()) || "2".equals(mgAccountResqust.getUpdateType())) {
            //        //当更新，作废是拓展表应当存在该单据数据 且发票数量与入参list应一致
            //        if (responseList.size() > 0 && responseList.size() == modelList.size()) {
            //            //此处批量更新
            //            boolean updateFlag = this.mgAccountMapper.batchUpdateReimburseInfo(modelList);
            //            if (updateFlag) {
            //                return new MGAccountResponse("0", "报账单据信息更新数据成功", true);
            //            } else {
            //                return new MGAccountResponse(RestFulApiContants.UN_ERROR, "报账单据信息同步失败，请检查！", false);
            //            }
            //        } else {
            //            return new MGAccountResponse(RestFulApiContants.UN_ERROR, "报账单不存在，无法执行更新或作废操作，请检查！", false);
            //        }
            //    } else {
            //        return new MGAccountResponse(RestFulApiContants.UN_ERROR, "更新标识码不正确：0 - 插入，1 – 更新，2 - 作废", false);
            //    }
            //} else {
            //    return new MGAccountResponse(RestFulApiContants.UN_ERROR, RestFulApiContants.UN_ERROR_CN, false);
        }
    }

    //组装List<Object>格式参数
    private List<MGInvoiceModel> queryModelInvAccount(MGAccountResqust mgAccountResqust) {
        List<MGInvoiceModel> mgInvoiceModelList = new ArrayList<>();
        for (MGInvoiceModel model : mgAccountResqust.getInvoiceList()) {
            model.setBillCode(mgAccountResqust.getBillCode());
            model.setFinslVoucherNo(mgAccountResqust.getFinslVoucherNo());
            model.setFoucherPeriod(mgAccountResqust.getFoucherPeriod());
            model.setVoucherTax(mgAccountResqust.getVoucherTax());
            model.setVoucherDate(mgAccountResqust.getVoucherDate());
            //model.setUpdateType(mgAccountResqust.getUpdateType());
            mgInvoiceModelList.add(model);
        }
        return mgInvoiceModelList;
    }

}
