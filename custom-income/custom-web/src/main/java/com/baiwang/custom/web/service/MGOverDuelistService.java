package com.baiwang.custom.web.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.baiwang.platform.custom.common.result.CrRpcResult;

public interface MGOverDuelistService {
	CrRpcResult getOverDueList(Map resultMap);
	
	ModelAndView queryExportList(Map resultMap, ModelMap modelMap, HttpServletRequest request);
}
