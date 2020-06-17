package com.baiwang.custom.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baiwang.custom.common.model.MGOverDueReqModel;
import com.baiwang.custom.web.service.MGOverDuelistService;
import com.baiwang.platform.custom.common.result.CrRpcResult;

@RestController
@RequestMapping("/mgoverdue")
public class MGTheOverdueController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	// 获取即将逾期的发票
	// 即将逾期的发票列表查询
	@Autowired
	private MGOverDuelistService overDueService;
	@Autowired
	private MGOverDuelistService mGoverDueService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getOverDueList", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
	public CrRpcResult<?> getOverDueList(@RequestBody MGOverDueReqModel mGoverDueReqModel) {
		long statrtGetOverDueList = System.currentTimeMillis();
		if(mGoverDueReqModel!=null){
			logger.info("请求逾期列表参数：【"+mGoverDueReqModel.toString()+"】");
			Map requestMap = new HashMap();
			requestMap.put("uid", mGoverDueReqModel.getUid());
			requestMap.put("token", mGoverDueReqModel.getToken());
			requestMap.put("buyerTaxno", mGoverDueReqModel.getBuyerTaxno());
			requestMap.put("sellerName", mGoverDueReqModel.getSellerName());
			requestMap.put("page", mGoverDueReqModel.getPage());
			requestMap.put("rows", mGoverDueReqModel.getRows());
			requestMap.put("billCode", mGoverDueReqModel.getBillCode());
			requestMap.put("finslVoucherNo", mGoverDueReqModel.getFinslVoucherNo());
			requestMap.put("voucherDate", mGoverDueReqModel.getVoucherDate());
			CrRpcResult overDueList = mGoverDueService.getOverDueList(requestMap);
			logger.info("当前税号：" + mGoverDueReqModel.getBuyerTaxno() + "请求逾期列表查询getOverDueList耗时:【"
					+ (System.currentTimeMillis() - statrtGetOverDueList)
					+ "】ms,请求结果：{" + overDueList.getData() + "}");
			return overDueList;
		}
		CrRpcResult result = new CrRpcResult<Object>();
		result.setCode("405");
		result.setMessage("请求参数不全");
		return result;
	}
	/**
	 * 即将逾期发票列表导出
	 *
	 * @param overDueReqModel
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/exportXls")
	public ModelAndView exportExcel(@RequestBody MGOverDueReqModel overDueReqModel,ModelMap modelMap, HttpServletRequest request){
		if(overDueReqModel!=null){
			logger.info("请求逾期列表参数：【"+overDueReqModel.toString()+"】");
			Map requestMap = new HashMap();
			requestMap.put("uid", overDueReqModel.getUid());
			requestMap.put("token", overDueReqModel.getToken());
			requestMap.put("buyerTaxno", overDueReqModel.getBuyerTaxno());
			requestMap.put("sellerName", overDueReqModel.getSellerName());
			requestMap.put("billCode", overDueReqModel.getRows());
			requestMap.put("finslVoucherNo", overDueReqModel.getFinslVoucherNo());
			requestMap.put("voucherDate", overDueReqModel.getVoucherDate());
			return mGoverDueService.queryExportList(requestMap, modelMap, request);
		}
		logger.error("请求参数不全");
		return null;
	}
}
