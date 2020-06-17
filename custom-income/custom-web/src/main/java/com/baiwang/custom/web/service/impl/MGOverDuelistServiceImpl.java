package com.baiwang.custom.web.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.baiwang.custom.common.dao.MGTScmVatMainMapper;
import com.baiwang.custom.common.model.MGOverDueModel;
import com.baiwang.custom.web.service.MGOverDuelistService;
import com.baiwang.platform.custom.common.poi.excel.entity.TemplateExportParams;
import com.baiwang.platform.custom.common.poi.excel.entity.vo.TemplateExcelConstants;
import com.baiwang.platform.custom.common.poi.excel.view.TaxTemplateExcelView;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.baiwang.platform.custom.common.result.RestFulApiContants;
import com.baiwang.platform.custom.common.util.MyBeanUtils;
import com.baiwang.platform.custom.common.util.TaxInfoUtil;
import com.baiwang.platform.custom.dao.domain.TScmTaxnoInfo;
import com.baiwang.platform.custom.dao.redis.RedisDao;
import com.baiwang.platform.custom.integration.usercenter.UserInfoCache;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
@ComponentScan(basePackages = { "com.baiwang.platform" })
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MGOverDuelistServiceImpl implements MGOverDuelistService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MGTScmVatMainMapper mGtscmVatMainDao;
	
	@Autowired
	private UserInfoCache userInfoCache;
	
	@Autowired
	private RedisDao redisDao;
	
	@Autowired
	private TaxTemplateExcelView taxTemplateExcelView;
	
	@SuppressWarnings("unchecked")
	@Override
	public CrRpcResult getOverDueList(Map requestMap) {
		// 获取税款所属期
		String taxno = requestMap.get("buyerTaxno").toString();
		String uid = requestMap.get("uid").toString();
		String[] orgIdStr = userInfoCache.getOrgIdStr(null, null, uid);
		if (orgIdStr == null) {
			logger.error("当前税号：" + taxno + "没有操作权限------");
			return new CrRpcResult(RestFulApiContants.AUTH_NOT_EXIST,
					RestFulApiContants.AUTH__NOT_EXIST_CN);
		}
		CrRpcResult result = new CrRpcResult();
		/*
		 * TaxnoInfoEntity taxnoLockInfo = scanDeductDao.getTaxnoLockInfo(taxno,
		 * null);
		 */
		TScmTaxnoInfo taxnoLockInfo = redisDao.getTaxnoInfo(taxno);
			// 当前可勾选起始日期
		if(taxnoLockInfo!=null)
		{
			Date selectStartDate = taxnoLockInfo.getSelectStartDate();
			String seleDate = getYYmmdd2(selectStartDate);
			// 税款所属期
			String incomeMonth = taxnoLockInfo.getIncomeMonth();
			String taxPeriod = getYYMMDD(incomeMonth);
			// 申报周期
			int reportingPeriod = 1;
			Date[] resultDate = getResult(taxPeriod, reportingPeriod, seleDate);
			Date startdate = resultDate[0];
			Date enddate = resultDate[1];
			logger.info("即将逾期的发票起止时间【"+getYYmmdd2(resultDate[0])+"_"+getYYmmdd2(resultDate[1])+"】可勾选日期为【"+seleDate+"】税款所属期【"+taxPeriod+"】申报周期默认为【1】");
			if (startdate.compareTo(enddate) <= -1) {
				String startDate = getYYmmdd2(resultDate[0]);
				String endDate = getYYmmdd2(resultDate[1]);
				logger.info("当前税号：" + taxno + "逾期起始时间：【" + startDate + "_"
						+ endDate + "】");
				requestMap.put("startDate", startDate);
				requestMap.put("endDate", endDate);
				requestMap.put("orgIdStr", orgIdStr);

				logger.info("map里获取当前税号为：【"+requestMap.get("buyerTaxno")+"】");
				PageInfo<MGOverDueModel> queryList = queryList(requestMap);
				if (queryList.getTotal() > 0) {
					Map resultMap = new HashMap();
					logger.info("当前税号：" + taxno + "逾期列表查询总页数：【"
							+ queryList.getPages() + "】");
					logger.info("当前税号：" + taxno + "逾期列表查询总数为：【"
							+ queryList.getTotal() + "】");
					resultMap.put("total", queryList.getTotal());
					List<MGOverDueModel> list = queryList.getList();
					//TODO 数据字典
					resultMap.put("results", queryList.getList());
					result.setData(resultMap);
					return result;
				}
			}
		}
		logger.error("当前税号：" + taxno + "逾期列表查询未查询到相关逾期发票数据");
		result.setCode("-1");
		result.setMessage("该机构下无即将逾期发票");
		return result;
	}

	@Override
	public ModelAndView queryExportList(Map requestMap, ModelMap modelMap, HttpServletRequest request) {
		long t = System.currentTimeMillis();
		try {
			// 获取税款所属期
			String taxno = requestMap.get("buyerTaxno").toString();
			String uid = requestMap.get("uid").toString();
			String[] orgIdStr = userInfoCache.getOrgIdStr(null, null, uid);
			if (orgIdStr == null) {
				logger.error("当前税号：" + taxno + "没有操作权限------");
				return null;
			}
			TScmTaxnoInfo taxnoLockInfo = redisDao.getTaxnoInfo(taxno);
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			// 当前可勾选起始日期
			if(taxnoLockInfo!=null)
			{
				Date selectStartDate = taxnoLockInfo.getSelectStartDate();
				String seleDate = getYYmmdd2(selectStartDate);
				// 税款所属期
				String incomeMonth = taxnoLockInfo.getIncomeMonth();
				String taxPeriod = getYYMMDD(incomeMonth);
				// 申报周期
				int reportingPeriod = 1;
				Date[] resultDate = getResult(taxPeriod, reportingPeriod, seleDate);
				Date startdate = resultDate[0];
				Date enddate = resultDate[1];
				logger.info("即将逾期的发票起止时间【"+getYYmmdd2(resultDate[0])+"_"+getYYmmdd2(resultDate[1])+"】可勾选日期为【"+seleDate+"】税款所属期【"+taxPeriod+"】申报周期默认为【1】");
				if (startdate.compareTo(enddate) <= -1) {
					String startDate = getYYmmdd2(resultDate[0]);
					String endDate = getYYmmdd2(resultDate[1]);
					logger.info("当前税号：" + taxno + "逾期起始时间：【" + startDate + "_"
							+ endDate + "】");
					requestMap.put("startDate", startDate);
					requestMap.put("endDate", endDate);
					requestMap.put("orgIdStr", orgIdStr);
					//requestMap.put("", "");
					logger.info("map里获取当前税号为：【"+requestMap.get("buyerTaxno")+"】");
					List<MGOverDueModel> queryList = queryExportList(requestMap);
					if (queryList != null && queryList.size() > 0) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						for (MGOverDueModel overDueModel : queryList) {
							Map<String, Object> maps = MyBeanUtils
									.beanToMap(overDueModel);
							list.add(maps);
						}
					}
				}
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			modelMap.put(TemplateExcelConstants.MAP_DATA, map);
			modelMap.put(TemplateExcelConstants.FILE_NAME, "即将逾期发票");
			modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams(
					"export/invoiceExpireTemplate.xls"));
			logger.info(modelMap.get(TemplateExcelConstants.FILE_NAME)
					+ "excel /baiwangcloud/invoiceExpireTemplate export成功！时间["
					+ (System.currentTimeMillis() - t) + "]毫秒！");
			return new ModelAndView(taxTemplateExcelView);
		}catch(Exception ex) {
			logger.warn(modelMap.get(TemplateExcelConstants.FILE_NAME)+"excel /baiwangcloud/invoiceExpireTemplate export system error,！时间["
	                 +"],异常[" + ex + "]！");
	            return null;
		}
	}
	/**
	 * 即将逾期发票列表查询
	 *
	 * @param params
	 * @return
	 */
	public List<MGOverDueModel> queryExportList(Map params) {
		List<MGOverDueModel> queryOverDueList =mGtscmVatMainDao.queryOverDueList(params);
		return queryOverDueList;
	}

	// 字符串日期转换为YY-MM-DD
	public static String getYYmmdd2(Date d) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date2 = format.format(d);
		return date2;
	}
	// 字符串转日期
	public static String getYYMMDD(String string) {
		StringBuilder sb = new StringBuilder(string);
		return sb.insert(4, "-").insert(7, "-").append("01").toString();
	}
	// 字符串日期转换为YYMMDD
	public static String getYYmmdd(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = null;
		try {
			d = formatter.parse(date);
		} catch (ParseException e) {
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date2 = format.format(d);
		String sdate = date2.replaceAll("-", "");
		return sdate;
	}
	/**
	 * 计算将逾期起止时间
	 *
	 * @param period
	 *            当前税期 yyyy-MM-01 格式
	 * @param cycle
	 *            申报周期 单位：月
	 * @param selectBegin
	 *            当前可勾选起始日
	 */
	public Date[] getResult(String period, int cycle, String selectBegin) {
		return TaxInfoUtil.getOverdueSpan(DateTime.parse(period).toDate(),
				cycle, DateTime.parse(selectBegin).toDate());
	}
	/**
	 * 分页查询
	 *
	 * @param params
	 * @return
	 */
	public PageInfo<MGOverDueModel> queryList(Map params) {
		Page<MGOverDueModel> page = PageHelper.startPage(
				Integer.parseInt(params.get("page").toString()),
				Integer.parseInt(params.get("rows").toString()));
		mGtscmVatMainDao.queryOverDueList(params);
		return page.toPageInfo();
	}

}
