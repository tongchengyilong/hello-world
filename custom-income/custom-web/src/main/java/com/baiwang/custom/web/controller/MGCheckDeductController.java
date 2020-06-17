package com.baiwang.custom.web.controller;

import com.baiwang.custom.common.model.CheckDeductRequestModel;
import com.baiwang.custom.web.service.MGCheckDeductService;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mgcheckDeduct")
public class MGCheckDeductController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired 
	private MGCheckDeductService checkDeductService;
	/**
	 * 勾选认证查询
	 */
	@RequestMapping(value = "/queryCheckDeduct")
	@ResponseBody
	public CrRpcResult<?> queryCheckDeduct(@RequestBody CheckDeductRequestModel checkDeductRequestModel,HttpServletRequest request){
		//当前系统时间
		long start = System.currentTimeMillis();
		logger.info("queryCheckDeduct begin request uid:{},token:{},invoiceCode:{},invoiceNo:{}",checkDeductRequestModel.getUid(),checkDeductRequestModel.getToken(),checkDeductRequestModel.getInvoiceCode(),checkDeductRequestModel.getInvoiceNo());			
		CrRpcResult result = checkDeductService.doQueryCheckDeduct(checkDeductRequestModel,request);
		if("0".equals(result.getCode())){
			logger.info("查询成功！耗时：{}ms",System.currentTimeMillis()-start);
		}	
		return result;
	}
}
