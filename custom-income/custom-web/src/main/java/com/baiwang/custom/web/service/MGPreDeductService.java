package com.baiwang.custom.web.service;

import com.baiwang.custom.common.model.MGPreDeductRequest;
import com.baiwang.platform.custom.common.model.PreDeductRequest;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface MGPreDeductService {

	CrRpcResult doQueryPreDeduct(MGPreDeductRequest request, HttpServletRequest httpRequest);

    ModelAndView queryExportList(MGPreDeductRequest request, ModelMap modelMap, HttpServletRequest httpRequest);
}
