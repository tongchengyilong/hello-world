package com.baiwang.custom.web.service.impl;

import com.baiwang.custom.common.dao.MGPreDeductMapper;
import com.baiwang.custom.common.entity.MGTScmVatMain;
import com.baiwang.custom.common.model.MGCheckDeductResponse;
import com.baiwang.custom.common.model.MGPreDeductRequest;
import com.baiwang.custom.web.service.MGPreDeductService;
import com.baiwang.platform.custom.common.poi.excel.entity.TemplateExportParams;
import com.baiwang.platform.custom.common.poi.excel.entity.vo.TemplateExcelConstants;
import com.baiwang.platform.custom.common.poi.excel.view.TaxTemplateExcelView;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.baiwang.platform.custom.common.result.RestFulApiContants;
import com.baiwang.platform.custom.integration.usercenter.UserInfo;
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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class MGPreDeductServiceImpl implements MGPreDeductService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MGPreDeductMapper mgPreDeductDao;
	@Autowired
	private UserInfoCache userInfoCache;
	@Autowired
	private TaxTemplateExcelView taxTemplateExcelView;
	
	@Override
	public CrRpcResult doQueryPreDeduct(MGPreDeductRequest request, HttpServletRequest httpRequest) {
		
		CrRpcResult result = new CrRpcResult();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> map = new HashMap<String,Object>();

		//TODO: 待判断单据编号
		String billingDate = request.getBillingDate();
		String billingDateBegin = null;
		String billingDateEnd = null;
		if(StringUtils.isNotBlank(billingDate) && billingDate.contains(" ")){
			String[] billingDateArray = billingDate.split(" ");
			billingDateBegin = billingDateArray[0];
			billingDateEnd = billingDateArray[1];
			try {
				long days = getDistanceDays(billingDateBegin,billingDateEnd);
				if(days >180){
					logger.error("查询待认证数据列表 ,日期间隔不能超过六个月，请重新选择日期,{}",request.getBillingDate());
					return new CrRpcResult(RestFulApiContants.REQ_PARAMS_ERROR, RestFulApiContants.REQ_PARAMS_ERROR_CN);
				}
			} catch (Exception e) {
				logger.error("查询待认证数据列表 ,时间判断异常,{},{}",e,request.getBillingDate());
				return new CrRpcResult(RestFulApiContants.REQ_PARAMS_ERROR, RestFulApiContants.REQ_PARAMS_ERROR_CN);
			}			
		}


		if(StringUtils.isNotBlank(request.getAccountDate()) && request.getAccountDate().contains(" ")){
			String[] accountDateArray = request.getAccountDate().split(" ");
			request.setAccountBeginDate(accountDateArray[0]);
			request.setAccountEndDate(accountDateArray[1]);
		}


		/**
		 * 和用户中心交互的统一处理
		 */
		UserInfo userInfo = null;
		String[] orgId = null;
		try {
			userInfo = userInfoCache.getUserInfo(request.getUid());
			if(userInfo == null){
				logger.error("用户中心数据为空,用户名:{}",request.getUid());
				result.setCode("-1");
				result.setMessage("执行失败");
				return result;
			}

			//获取当前登入用户数据权限等
			orgId = userInfoCache.getOrgIdStr(null,null,request.getUid());
			if(orgId==null){
				logger.error("用户机构为空,用户名:{}",request.getUid());
				result.setCode("-1");
				result.setMessage("执行失败");
				return result;
			}


		} catch (Exception e) {
			result.setCode("-1");
			result.setMessage("执行失败");
			e.printStackTrace();
			return result;
		}
		//添加单据编号
		map.put("billCode",request.getBillCode());

		map.put("invKind", request.getInvoiceCode());
		map.put("invNum", request.getInvoiceNo());
		map.put("invDate_begin", billingDateBegin);
		map.put("invDate_end", billingDateEnd);
		map.put("buyerTaxNo", request.getBuyerTaxNo());
		map.put("sellerName", request.getSellerName());
		map.put("isScanner", request.getIsScanner());
		map.put("collectStatus", request.getCollectStatus());
		map.put("sysCompanyCode", userInfo.getTenantId());
		map.put("sysOrgCode", orgId);
		map.put("voucherNum", request.getVoucherNum());
		map.put("accountBeginDate", request.getAccountBeginDate());
		map.put("accountEndDate", request.getAccountEndDate());
		
		Map<String,Object> param = new HashMap<String,Object>();
		List<MGCheckDeductResponse> responseList = null;
		try {
            //替换主表实体类
			PageInfo<MGTScmVatMain> page = queryVatMainEntity(map, Integer.valueOf(request.getPage()), Integer.valueOf(request.getRows()));

			if(page.getList()!=null){
				responseList = new ArrayList<MGCheckDeductResponse>();
				for(MGTScmVatMain entity : page.getList()){
					MGCheckDeductResponse response = new MGCheckDeductResponse();
					//填入单据编号
					response.setBillCode(entity.getBillCode());

					response.setId(String.valueOf(entity.getId()));
					response.setInvoiceType(entity.getInvType());
					response.setInvoiceDate(sdf.format(entity.getInvDate()));
					response.setInvoiceCode(entity.getInvKind());
					response.setInvoiceNo(entity.getInvNum());
					response.setBuyerName(entity.getBuyerName());
					response.setBuyerTaxNo(entity.getBuyerTaxno());
					response.setBuyerAddressPhone(entity.getBuyerAddrTel());
					response.setBuyerBankAccount(entity.getBuyerBank());
					response.setSellerName(entity.getSellerName());
					response.setSellerTaxNo(entity.getSellerTaxno());
					response.setSellerAddressPhone(entity.getSellerAddrTel());
					response.setSellerBankAccount(entity.getSellerBank());
					response.setInvoiceTotalPrice(entity.getInvCost());
					response.setInvoiceTotalPriceTax(entity.getInvSum());
					response.setInvoiceTotalTax(entity.getInvVat());

					response.setAccountTime(entity.getAccountTimeStr());
					response.setVoucherNum(entity.getVoucherNum());

                    response.setCertificationWay(entity.getCertificationWay());

					if("0".equals(request.getCollectStatus())){
						response.setCollectStatus("0");
					}else if("1".equals(request.getCollectStatus())){
						response.setCollectStatus("1");
					}else{
						if((entity.getTaxInvoiceCode()!=null && !entity.getTaxInvoiceNumber().equals("")) && (entity.getTaxInvoiceNumber()!=null && !entity.getTaxInvoiceNumber().equals(""))){
							response.setCollectStatus("1");
						}else{
							response.setCollectStatus("0");
						}
					}
					response.setIsScanner(entity.getIsScanner());
					responseList.add(response);
				}

				//TODO: 增加统计数据
				Map<String,Object> statisticsMap = getStatistics(map);
				param.put("count", statisticsMap.get("count"));
				param.put("vatSum", statisticsMap.get("vatSum"));
				param.put("costSum", statisticsMap.get("costSum"));
				param.put("idList", statisticsMap.get("idList"));

				param.put("total", page.getTotal());
				param.put("results", responseList);				
				result.setCode("0");
				result.setMessage("执行成功");
				result.setData(param);
			}
		} catch (Exception e) {
			result.setCode("-1");
			result.setMessage("执行失败！");
			e.printStackTrace();
		}	
		return result;
	}

	/**
	 * 获取统计数据
	 * @param map
	 * @return
	 */
	public Map<String,Object> getStatistics(Map<String, Object> map){
		//获取所有数据

		PageInfo<MGTScmVatMain> page = queryVatMainEntity(map, 1, 1000000);
		List<MGTScmVatMain> list = page.getList();
		//TODO:获取统计数据。
		Map<String,Object> statisticssMap = new HashMap<>();

		BigDecimal vatSum = new BigDecimal(0);
		BigDecimal costSum = new BigDecimal(0);
		Integer count = 0;
		List<String> idList = new ArrayList<>();
		if(list!=null && !list.isEmpty()) {
			count = list.size();
			for (MGTScmVatMain mgTScmVatMain : list) {
				vatSum = vatSum.add(new BigDecimal(mgTScmVatMain.getInvVat()));
				costSum = costSum.add(new BigDecimal(mgTScmVatMain.getInvCost()));
				idList.add(String.valueOf(mgTScmVatMain.getId()));
			}
		}
		statisticssMap.put("count",String.valueOf(count));
		statisticssMap.put("vatSum",String.valueOf(vatSum.setScale(2,BigDecimal.ROUND_HALF_UP)));
		statisticssMap.put("costSum",String.valueOf(costSum.setScale(2,BigDecimal.ROUND_HALF_UP)));
		statisticssMap.put("idList",idList);

		return statisticssMap;
	}
	
	
	public long getDistanceDays(String startTime, String endTinme){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	if((!startTime.equals("") && startTime!=null) && (!"".equals(endTinme) && endTinme!=null )){
        		Date one = df.parse(startTime);
                Date two = df.parse(endTinme);
                long time1 = one.getTime();
                long time2 = two.getTime();
                long diff ;
                if(time1<time2) {
                    diff = time2 - time1;
                } else {
                    diff = time1 - time2;
                }
                long days = diff / (1000 * 60 * 60 * 24);
                return days;
        	}
        	
		} catch (Exception e) {
			e.printStackTrace();
		}     
        return 0L;
    }



	
	
	public PageInfo<MGTScmVatMain> queryVatMainEntity(Map<String, Object> map, int pageNum, int pageSize) {
		Page<MGTScmVatMain> page = PageHelper.startPage(pageNum, pageSize);
		try {
			if("1".equals(map.get("collectStatus"))){//已采集
                mgPreDeductDao.queryCollectInfo(map);
			}else if("0".equals(map.get("collectStatus"))){//未采集
                mgPreDeductDao.queryCheckDeductNotExistCollectInfo(map);
			}else{//显示所有已采集和未采集的信息
                mgPreDeductDao.queryCheckDeductList(map);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
        return page.toPageInfo();
	}

	@Override
	public ModelAndView queryExportList(MGPreDeductRequest request, ModelMap modelMap, HttpServletRequest httpRequest) {
		long t = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> map = new HashMap<String,Object>();
        //TODO: 待判断单据编号

		String billingDate = request.getBillingDate();
		String billingDateBegin = null;
		String billingDateEnd = null;
		if(StringUtils.isNotBlank(billingDate) && billingDate.contains(" ")){
			String[] billingDateArray = billingDate.split(" ");
			billingDateBegin = billingDateArray[0];
			billingDateEnd = billingDateArray[1];
			try {
				long days = getDistanceDays(billingDateBegin,billingDateEnd);
				if(days >180){
					logger.error("查询待认证数据列表 ,日期间隔不能超过六个月，请重新选择日期,{}",request.getBillingDate());
				}
			} catch (Exception e) {
				logger.error("查询待认证数据列表 ,时间判断异常,{},{}",e,request.getBillingDate());
			}			
		}

		if(StringUtils.isNotBlank(request.getAccountDate()) && request.getAccountDate().contains(" ")){
			String[] accountDateArray = request.getAccountDate().split(" ");
			request.setAccountBeginDate(accountDateArray[0]);
			request.setAccountEndDate(accountDateArray[1]);
		}

		/**
		 * 和用户中心交互的统一处理
		 */
		UserInfo userInfo = null;
		String[] orgId = null;
		try {
			userInfo = userInfoCache.getUserInfo(request.getUid());
			if(userInfo == null){
				logger.error("用户中心数据为空,用户名:{}",request.getUid());
			}

			//获取当前登入用户数据权限等
			orgId = userInfoCache.getOrgIdStr(null,null,request.getUid());
			if(orgId==null){
				logger.error("用户机构为空,用户名:{}",request.getUid());
			}
		} catch (Exception e) {
			logger.error("查询待认证数据列表 ,时间判断异常,{},{}",e,"-1 执行失败");
		}
		map.put("billCode",request.getBillCode());

		map.put("invKind", request.getInvoiceCode());
		map.put("invNum", request.getInvoiceNo());
		map.put("invDate_begin", billingDateBegin);
		map.put("invDate_end", billingDateEnd);
		map.put("buyerTaxNo", request.getBuyerTaxNo());
		map.put("sellerName", request.getSellerName());
		map.put("isScanner", request.getIsScanner());
		map.put("collectStatus", request.getCollectStatus());
		map.put("sysCompanyCode", userInfo.getTenantId());
		map.put("sysOrgCode", orgId);
		map.put("voucherNum", request.getVoucherNum());
		map.put("accountBeginDate", request.getAccountBeginDate());
		map.put("accountEndDate", request.getAccountEndDate());
		
		Map<String,Object> param = new HashMap<String,Object>();
		List<MGCheckDeductResponse> responseList = null;
		try {
			List<MGTScmVatMain> excelList = queryVatMainEntity(map);
			Integer No=1;
			responseList = new ArrayList<MGCheckDeductResponse>();
			for(MGTScmVatMain entity : excelList){
				MGCheckDeductResponse response = new MGCheckDeductResponse();
				response.setId(String.valueOf(No));
				response.setInvoiceType(entity.getInvType());
				response.setInvoiceDate(sdf.format(entity.getInvDate()));
				response.setInvoiceCode(entity.getInvKind());
				response.setInvoiceNo(entity.getInvNum());
				response.setBuyerName(entity.getBuyerName());
				response.setBuyerTaxNo(entity.getBuyerTaxno());
				response.setBuyerAddressPhone(entity.getBuyerAddrTel());
				response.setBuyerBankAccount(entity.getBuyerBank());
				response.setSellerName(entity.getSellerName());
				response.setSellerTaxNo(entity.getSellerTaxno());
				response.setSellerAddressPhone(entity.getSellerAddrTel());
				response.setSellerBankAccount(entity.getSellerBank());
				response.setInvoiceTotalPrice(entity.getInvCost());
				response.setInvoiceTotalPriceTax(entity.getInvSum());
				response.setInvoiceTotalTax(entity.getInvVat());

				response.setAccountTime(entity.getAccountTimeStr());
				response.setVoucherNum(entity.getVoucherNum());

                response.setCertificationWay(entity.getCertificationWay());
                //填入单据编号
                response.setBillCode(entity.getBillCode());

                //TODO: 可优化
				if("0".equals(request.getCollectStatus())){
					response.setCollectStatus("0");
				}else if("1".equals(request.getCollectStatus())){
					response.setCollectStatus("1");
				}else{
					if((entity.getTaxInvoiceCode()!=null && !entity.getTaxInvoiceNumber().equals("")) && (entity.getTaxInvoiceNumber()!=null && !entity.getTaxInvoiceNumber().equals(""))){
						response.setCollectStatus("1");
					}else{
						response.setCollectStatus("0");
					}
				}
				response.setIsScanner(entity.getIsScanner());
				responseList.add(response);
				No=No+1;
			}
			
			Map<String, Object> mapexcel = new HashMap<String, Object>();
			mapexcel.put("list", responseList);
			logger.info("输出list集合："+responseList);
			
			modelMap.put(TemplateExcelConstants.MAP_DATA, mapexcel);
			modelMap.put(TemplateExcelConstants.FILE_NAME, "待认证发票列表");
			modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams(
					"export/invoicePreDeductTemplate.xls"));
			
			logger.info(modelMap.get(TemplateExcelConstants.FILE_NAME)
					+ "excel /baiwangcloud/invoicePreDeductTemplate export成功！时间["
					+ (System.currentTimeMillis() - t) + "]毫秒！");
			logger.info("输出list集合："+modelMap.get("list"));
			return new ModelAndView(taxTemplateExcelView);
		}catch(Exception ex) {
			logger.warn(modelMap.get(TemplateExcelConstants.FILE_NAME)+"excel /baiwangcloud/invoicePreDeductTemplate export system error,！时间["
	                 +"],异常[" + ex + "]！");
	            return null;
		}
	}
	
	public List<MGTScmVatMain> queryVatMainEntity(Map<String, Object> map) {
		List<MGTScmVatMain> excelList = new ArrayList<MGTScmVatMain>();
		try {
			if("1".equals(map.get("collectStatus"))){//已采集
				excelList=mgPreDeductDao.queryCollectInfo(map);
			}else if("0".equals(map.get("collectStatus"))){//未采集
				excelList=mgPreDeductDao.queryCheckDeductNotExistCollectInfo(map);
			}else{//显示所有已采集和未采集的信息
				excelList=mgPreDeductDao.queryCheckDeductList(map);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
        return excelList;
	}


	
}
