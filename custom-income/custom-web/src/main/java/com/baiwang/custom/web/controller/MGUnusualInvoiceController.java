package com.baiwang.custom.web.controller;

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

import com.baiwang.custom.common.model.MGBwRequestUnusual;
import com.baiwang.custom.web.service.MGUnusualService;
import com.baiwang.platform.custom.common.result.CrRpcResult;

/**
 * 异常发票列表查询
 *
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/mgunusual")
public class MGUnusualInvoiceController {

	@Autowired
	private MGUnusualService unusualService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 异常列表查询
	 *
	 * @param bwrUnusual
	 * @return
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
	public CrRpcResult<?> queryUnusual(@RequestBody MGBwRequestUnusual bwrUnusual)
			throws IllegalAccessException {
		long startQueryUnusual = System.currentTimeMillis();
		CrRpcResult<?> result = null;
		if (bwrUnusual != null) {
			logger.info("请求查验异常列表入参【"+bwrUnusual.toString()+"】");
			result = unusualService.queryUnusual(bwrUnusual);
			logger.info("当前税号：" + bwrUnusual.getBuyerTaxNo() + "请求异常列表查询耗时：【" + (System.currentTimeMillis() - startQueryUnusual) + "ms】异常列表结果：{" + result.getData() + "}");
			return result;
		}
		result = new CrRpcResult<Object>();
		result.setCode("405");
		result.setMessage("请求参数不全");
		return result;
	}

	/**
	 * 异常列表导出
	 *
	 * @param bwrUnusual
	 * @param modelMap
	 * @param request
	 * @return
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/exportXls")
	public ModelAndView exportExcel(@RequestBody MGBwRequestUnusual bwrUnusual,
			ModelMap modelMap, HttpServletRequest request)
			throws IllegalAccessException {

		return unusualService.queryExportList(bwrUnusual, modelMap, request);

	}

}
