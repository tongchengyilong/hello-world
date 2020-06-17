package com.baiwang.custom.web.service;

import javax.servlet.http.HttpServletRequest;

import com.baiwang.custom.common.model.CheckDeductRequestModel;
import com.baiwang.platform.custom.common.result.CrRpcResult;

public interface MGCheckDeductService {
	//根据条件查询
	CrRpcResult doQueryCheckDeduct(CheckDeductRequestModel checkDeductRequestModel,HttpServletRequest request);

}
