package com.baiwang.custom.web.service.impl;

import com.baiwang.custom.common.dao.MGTScmVatMainMapper;
import com.baiwang.custom.common.model.MGBwRequestUnusual;
import com.baiwang.custom.common.model.MGBwResponesUnusual;
import com.baiwang.custom.web.service.MGUnusualService;
import com.baiwang.platform.custom.common.poi.excel.entity.TemplateExportParams;
import com.baiwang.platform.custom.common.poi.excel.entity.vo.TemplateExcelConstants;
import com.baiwang.platform.custom.common.poi.excel.view.TaxTemplateExcelView;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.baiwang.platform.custom.common.result.RestFulApiContants;
import com.baiwang.platform.custom.common.util.MapUtil;
import com.baiwang.platform.custom.common.util.MyBeanUtils;
import com.baiwang.platform.custom.dao.TScmTransferInfoMapper;
import com.baiwang.platform.custom.dao.domain.TScmTaxnoInfo;
import com.baiwang.platform.custom.dao.redis.RedisDao;
import com.baiwang.platform.custom.integration.usercenter.UserInfoCache;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MGUnusualServiceimpl implements MGUnusualService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MGTScmVatMainMapper tscmVatMainDao;
	@Autowired
	private TaxTemplateExcelView taxTemplateExcelView;
	@Autowired
	private UserInfoCache userInfoCache;
	@Autowired
	private RedisDao redisDao;
    @Autowired
    private TScmTransferInfoMapper tScmTransferInfoMapper;

	@SuppressWarnings("unchecked")
	@Override
	public CrRpcResult<?> queryUnusual(MGBwRequestUnusual bwrUnusual)
			throws IllegalAccessException {
		CrRpcResult result = new CrRpcResult<Map>();
		// TODO 用户中心交互统一处理
		String uid = bwrUnusual.getUid();
		String[] orgIdStr = userInfoCache.getOrgIdStr(null, null, uid);
		if (orgIdStr == null) {
			logger.error("当前税号：" + bwrUnusual.getBuyerTaxNo() + "没有操作权限------");
			return new CrRpcResult(RestFulApiContants.AUTH_NOT_EXIST,
					RestFulApiContants.AUTH__NOT_EXIST_CN);
		}
		// 数据库查询
		Map resultMap = new HashMap();
		PageInfo<MGBwResponesUnusual> queryList = queryList(bwrUnusual, orgIdStr);
		List<MGBwResponesUnusual> list = queryList.getList();
		List<MGBwResponesUnusual>list2 =new ArrayList<MGBwResponesUnusual>();
		for (MGBwResponesUnusual bwResponesUnusual : list) {
			String checkErrCode = bwResponesUnusual.getCheckErrCode();
			if (checkErrCode != null) {
				StringBuilder checkErrBuilder = new StringBuilder();
				String[] checkErrCodeSplit = checkErrCode.split(":");
				for (String str:checkErrCodeSplit) {
					if (RestFulApiContants.CHECK_ERROR_INFO.containsKey(str)) {
						String tmpStr = RestFulApiContants.CHECK_ERROR_INFO.get(str);
						if (tmpStr.equals(str)) {
							checkErrBuilder.append(RestFulApiContants.CHECK_ERROR_INFO.get(bwResponesUnusual.getInvoiceStatus()));
						}else {
							checkErrBuilder.append(tmpStr);
						}
						checkErrBuilder.append(";");
					}
				}
				if (checkErrBuilder.length()>0) {
					String tmpCheckErr = checkErrBuilder.substring(0,checkErrBuilder.length()-1);
					bwResponesUnusual.setCheckErrReason(tmpCheckErr);
				}
			}
			String s=tScmTransferInfoMapper.selectTransferStatu(bwResponesUnusual.getInvoiceCode(),bwResponesUnusual.getInvoiceNo());
			bwResponesUnusual.setTransferStatus(s);
			list2.add(bwResponesUnusual);
		}
		logger.info("总页数=" + queryList.getPages());
		logger.info("总记录数=" + queryList.getTotal());
		resultMap.put("total", queryList.getTotal());
		resultMap.put("results",list2);
		result.setData(resultMap);
		return result;
	}

	/**
	 * 异常列表分页查询
	 *
	 * @param bwrUnusual
	 * @param orgIdStr
	 * @return
	 * @throws IllegalAccessException
	 */
	public PageInfo<MGBwResponesUnusual> queryList(MGBwRequestUnusual bwrUnusual,
			String[] orgIdStr) throws IllegalAccessException {
		Map params = MapUtil.objectToMap(bwrUnusual);
		Page<MGBwResponesUnusual> page = PageHelper.startPage(
				Integer.parseInt(params.get("page").toString()),
				Integer.parseInt(params.get("rows").toString()));
		String checkCode=null;
		if (StringUtils.isNotBlank(bwrUnusual.getCheckErrCode())) {
 			 checkCode = bwrUnusual.getCheckErrCode();
		}else{
			checkCode="100:101:102:103:104:105:-1";
		}
		String[] checkErrCode = checkCode.split(":");
		params.put("checkErrCode", checkErrCode);
		params.put("orgIdStr", orgIdStr);
		params.put("finslVoucherNo",bwrUnusual.getFinslVoucherNo());
		params.put("billCode",bwrUnusual.getBillCode());
		params.put("voucherDate",bwrUnusual.getVoucherDate());
		tscmVatMainDao.queryUnusualList(params);
		return page.toPageInfo();

	}

	/**
	 * 异常列表查询
	 *
	 * @param bwrUnusual
	 * @param orgIdStr
	 * @return
	 * @throws IllegalAccessException
	 */
	public List<MGBwResponesUnusual> queryExportList(MGBwRequestUnusual bwrUnusual,
			String[] orgIdStr) throws IllegalAccessException {
		Map params = MapUtil.objectToMap(bwrUnusual);
		String checkCode=null;
		if (StringUtils.isNotBlank(bwrUnusual.getCheckErrCode())) {
 			 checkCode = bwrUnusual.getCheckErrCode();
		}else {
			checkCode="100:101:102:103:104:105:-1";
		}
		String[] checkErrCode = checkCode.split(":");
		params.put("checkErrCode", checkErrCode);
		params.put("orgIdStr", orgIdStr);
        params.put("finslVoucherNo",bwrUnusual.getFinslVoucherNo());
        params.put("billCode",bwrUnusual.getBillCode());
        params.put("voucherDate",bwrUnusual.getVoucherDate());
		List<MGBwResponesUnusual> queryUnusualList = tscmVatMainDao.queryUnusualList(params);
		return queryUnusualList;
	}

	/**
	 * Excel导出
	 */
	@Override
	public ModelAndView queryExportList(MGBwRequestUnusual bwrUnusual,
			ModelMap modelMap, HttpServletRequest request)
			 {
		long t = System.currentTimeMillis();
		// TODO Auto-generated method stub
		String uid = bwrUnusual.getUid();
		String[] orgIdStr = userInfoCache.getOrgIdStr(null, null, uid);
		if (orgIdStr == null) {
			logger.warn("无权限操作");
			return null;
		}
		List<MGBwResponesUnusual> queryExportList;
		try {
			queryExportList = queryExportList(bwrUnusual, orgIdStr);
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			TScmTaxnoInfo taxnoInfo = redisDao.getTaxnoInfo(bwrUnusual
					.getBuyerTaxNo());
			if (queryExportList != null && queryExportList.size() > 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (MGBwResponesUnusual bwResponesUnusual : queryExportList) {
					bwResponesUnusual.setInvoiceStatus(redisDao.getNameByCode(
							"finInvSt", bwResponesUnusual.getInvoiceStatus()));
					bwResponesUnusual
							.setInvConfirmStatus(redisDao.getNameByCode(
									"deductStatus",
									bwResponesUnusual.getInvConfirmStatus()));
					bwResponesUnusual.setInvDeduResult(redisDao.getNameByCode(
							"finDeduResult", bwResponesUnusual.getInvDeduResult()));
					bwResponesUnusual.setIncomeMonth(taxnoInfo.getIncomeMonth());
					String s=tScmTransferInfoMapper.selectTransferStatu(bwResponesUnusual.getInvoiceCode(),bwResponesUnusual.getInvoiceNo());
					bwResponesUnusual.setTransferStatus(s);
					Map<String, Object> maps = MyBeanUtils
							.beanToMap(bwResponesUnusual);
					if (maps.get("collectTime") != null) {
						String errUpdateTime = sdf
								.format(maps.get("errUpdateTime"));
						maps.put("errUpdateTime", errUpdateTime);
					}
					list.add(maps);
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			modelMap.put(TemplateExcelConstants.MAP_DATA, map);
			modelMap.put(TemplateExcelConstants.FILE_NAME, "异常发票列表");
			modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams(
					"export/invoiceExceptionTemplate.xls"));
			logger.info(modelMap.get(TemplateExcelConstants.FILE_NAME)
					+ "excel /baiwangcloud/exceptionInvoiceList export成功！时间["
					+ (System.currentTimeMillis() - t) + "]毫秒！");
			return new ModelAndView(taxTemplateExcelView);
		} catch (IllegalAccessException e) {
			logger.warn(modelMap.get(TemplateExcelConstants.FILE_NAME)+"excel /baiwangcloud/exceptionInvoiceList export system error,！时间["
	                 +"],异常[" + e + "]！");
	            return null;
		}

	}
}
