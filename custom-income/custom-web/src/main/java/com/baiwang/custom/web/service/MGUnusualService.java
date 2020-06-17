package com.baiwang.custom.web.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.baiwang.custom.common.model.MGBwRequestUnusual;
import com.baiwang.platform.custom.common.model.BwRequestUnusual;
import com.baiwang.platform.custom.common.result.CrRpcResult;

public interface MGUnusualService {
	CrRpcResult<?> queryUnusual(MGBwRequestUnusual bwrUnusual)throws IllegalAccessException;

	ModelAndView queryExportList(MGBwRequestUnusual bwrUnusual, ModelMap modelMap, HttpServletRequest request);
}
