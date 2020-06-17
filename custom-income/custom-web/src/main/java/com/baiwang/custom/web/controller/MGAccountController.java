package com.baiwang.custom.web.controller;

import com.alibaba.fastjson.JSON;
import com.baiwang.baiwangcloud.utils.StringUtil;
import com.baiwang.custom.common.model.MGAccountResponse;
import com.baiwang.custom.common.model.MGAccountResqust;
import com.baiwang.custom.common.model.MGInvoiceModel;
import com.baiwang.custom.web.base.BaseController;
import com.baiwang.custom.web.service.MGAccountService;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.baiwang.platform.custom.common.result.RestFulApiContants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 发票记账信息同步接口
 * @Author: Guoyongzheng
 * @Date: 2018/10/15-10:13
 */
@RestController
@RequestMapping("/maAccount")
public class MGAccountController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MGAccountService mgAccountService;

    @RequestMapping("/getAccountBill")
    public CrRpcResult<?> rlReimburse(@RequestBody MGAccountResqust mgAccountResqust){
         logger.info("maAccount getAccountBill:[{}]",JSON.toJSON(mgAccountResqust));
        //  校验入参
        CrRpcResult cResult = this.checkInoviceParams(mgAccountResqust);
        if (null != cResult){
            return cResult;
        }
        //调用服务
        MGAccountResponse response = this.mgAccountService.accountSysn(mgAccountResqust);
        if (response.isSuccess()){
            return result(RestFulApiContants.SUCCESS,RestFulApiContants.SUCCESS_CN,null);
        }else{
            return result(response.getErrorCode(),response.getMessage(),null);
        }
    }

    private  CrRpcResult<?> checkInoviceParams(MGAccountResqust mgAccountResqust){
        if (null != mgAccountResqust){
            if (StringUtil.isEmpty(mgAccountResqust.getBillCode())){
                return result(RestFulApiContants.REQ_PARAMS_ERROR,"单据编号不能为空，请检查！","");
            }else if (StringUtil.isEmpty(mgAccountResqust.getFinslVoucherNo())){
                return result(RestFulApiContants.REQ_PARAMS_ERROR,"凭证号不能为空，请检查！","");
            }else if (StringUtil.isEmpty(mgAccountResqust.getVoucherDate())){
                return result(RestFulApiContants.REQ_PARAMS_ERROR,"记账日期不能为空，请检查！","");
            //    判断
            }else if (null == mgAccountResqust.getInvoiceList() || 0 == mgAccountResqust.getInvoiceList().size()){
                return result(RestFulApiContants.REQ_PARAMS_ERROR,"报账单据中发票信息为空，请检查！","");
            }else {
                for (MGInvoiceModel model:mgAccountResqust.getInvoiceList()){
                    if (StringUtil.isEmpty(model.getInvoiceCode())){
                        return result(RestFulApiContants.REQ_PARAMS_ERROR, model.getInvoiceNum() + "_"+ model.getInvoiceCode() +"发票代码不正确，请检查！","");
                    } else if (StringUtil.isEmpty(model.getInvoiceNum())) {
                        return result(RestFulApiContants.REQ_PARAMS_ERROR,model.getInvoiceNum() + "_"+ model.getInvoiceCode() + "发票号码不正确，请检查！","");
                    }
                }
                return  null;
            }
        }else {
            return result(RestFulApiContants.REQ_JSON_ERROR,RestFulApiContants.REQ_JSON_ERROR_CN,null);
        }
    }

}
