package com.baiwang.custom.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baiwang.baiwangcloud.utils.StringUtil;
import com.baiwang.custom.common.model.MGSynchronizationModel;
import com.baiwang.custom.common.model.MGrecAndCheckModel;
import com.baiwang.custom.common.model.RecAndCheckRequestModel;
import com.baiwang.custom.web.base.BaseController;
import com.baiwang.custom.web.client.RecognitionAndCheckService;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.baiwang.platform.custom.common.result.RestFulApiContants;

@RestController
@RequestMapping("/recAndCheck")
public class RecognitionAndCheckController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RecognitionAndCheckService recognitionAndCheckService;

	@RequestMapping("/synchronizationResult")
	@ResponseBody
	public CrRpcResult<?> synchronization(@RequestBody RecAndCheckRequestModel recAndCheckRequestModel) {
		if (recAndCheckRequestModel != null) {
			logger.info("影像调用进项全票面入参:{}", JSON.toJSON(recAndCheckRequestModel));
			List<MGSynchronizationModel> billInvoiceList = recAndCheckRequestModel.getBillInvoiceList();
			if (billInvoiceList.size() > 0 && billInvoiceList != null) {
				CrRpcResult cResult = this.checkInoviceParams(billInvoiceList);

				if (null != cResult) {
					return cResult;
				}

				logger.info("maAccount getAccountBill:[{}]", JSON.toJSON(billInvoiceList));
				// 通过此方法推送数据给金蝶系统
				MGrecAndCheckModel response = this.recognitionAndCheckService.recAndCheck(billInvoiceList);

				if ("0" == response.getReturnCode()) {
					return result(RestFulApiContants.SUCCESS, RestFulApiContants.SUCCESS_CN, null);
				} else {

					return result(response.getReturnCode(), response.getReturnMessage(), null);
				}
			} else {
				return result(RestFulApiContants.REQ_JSON_ERROR, RestFulApiContants.REQ_JSON_ERROR_CN, null);
			}
		} else {
			return result(RestFulApiContants.REQ_JSON_ERROR, RestFulApiContants.REQ_JSON_ERROR_CN, null);
		}
	}

	private CrRpcResult<?> checkInoviceParams(List<MGSynchronizationModel> mgAccountResqust) {
		// 单据数
		int i = 0;
		if (null != mgAccountResqust) {

			for (MGSynchronizationModel mGSynchronizationModel : mgAccountResqust) {
				if (StringUtil.isEmpty(mgAccountResqust.get(i).getBillCode())) {
					return result(RestFulApiContants.REQ_PARAMS_ERROR, "单据编号不能为空，请检查！", "");
				}
				i++;
			}

		} else {
			return result(RestFulApiContants.REQ_JSON_ERROR, RestFulApiContants.REQ_JSON_ERROR_CN, null);
		}
		return null;
	}

}
