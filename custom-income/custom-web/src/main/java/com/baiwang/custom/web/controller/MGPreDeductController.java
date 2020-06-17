package com.baiwang.custom.web.controller;

import com.baiwang.custom.common.model.MGPreDeductRequest;
import com.baiwang.custom.web.service.MGPreDeductService;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mgPreDeduct")
public class MGPreDeductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MGPreDeductService mgPreDeductService;
	
	/**
	 * 待认证列表查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryPreDeduct")
	@ResponseBody
	public CrRpcResult<?> queryPreDeduct(@RequestBody MGPreDeductRequest request, HttpServletRequest httpRequest){
		//当前系统时间
		long start = System.currentTimeMillis();
		logger.info("queryCheckDeduct begin request uid:{}",request.getUid());
		CrRpcResult result = mgPreDeductService.doQueryPreDeduct(request,httpRequest);
		if("0".equals(result.getCode())){
			logger.info("查询成功！耗时：{}ms",System.currentTimeMillis()-start);
		}
		return result;
	}

	/**
	 * 待认证列表导出
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/exportXls")
	public ModelAndView exportExcel(@RequestBody MGPreDeductRequest request, ModelMap modelMap, HttpServletRequest httpRequest){
		//当前系统时间
		long start = System.currentTimeMillis();
		logger.info("queryCheckDeduct begin request uid:{}",request.getUid());
		return mgPreDeductService.queryExportList(request,modelMap,httpRequest);
	}
}
