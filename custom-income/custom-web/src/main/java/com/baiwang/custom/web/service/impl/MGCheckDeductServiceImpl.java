package com.baiwang.custom.web.service.impl;

import com.baiwang.custom.common.dao.MGCheckDeductDao;
import com.baiwang.custom.common.entity.MGTScmVatMain;
import com.baiwang.custom.common.model.CheckDeductRequestModel;
import com.baiwang.custom.common.model.MGCheckDeductResponseModel;
import com.baiwang.custom.web.service.MGCheckDeductService;
import com.baiwang.platform.custom.common.result.CrRpcResult;
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

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MGCheckDeductServiceImpl implements MGCheckDeductService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MGCheckDeductDao checkDeductDao;
	@Autowired
	private UserInfoCache cache;
    @Autowired
    private UserInfoCache userInfoCache;


	@Override
	public CrRpcResult doQueryCheckDeduct(CheckDeductRequestModel request,HttpServletRequest httpRequest) {		
		CrRpcResult result = new CrRpcResult();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = new HashMap<String, Object>();		
		String invoiceDateStart = request.getInvoiceDateStart();
		String invoiceDateEnd = request.getInvoiceDateEnd();

		//TODO: 去掉六个月校验 ----by liuyufeng
//		long days = getDistanceDays(invoiceDateStart,invoiceDateEnd);
//		if(days >180){
//			logger.error("查询勾选认证数据列表 ,日期间隔不能超过六个月，请重新选择日期!");
//			return new CrRpcResult(RestFulApiContants.REQ_PARAMS_ERROR, RestFulApiContants.REQ_PARAMS_ERROR_CN);
//		}

		if(StringUtils.isNotBlank(request.getAccountDate()) && request.getAccountDate().contains(" ")){
			String[] accountDateArray = request.getAccountDate().split(" ");
			request.setAccountBeginDate(accountDateArray[0]);
			request.setAccountEndDate(accountDateArray[1]);
		}


		/**
		 * 用户中心
		 * TODO
		 */
		UserInfo userInfo = cache.getUserInfo(request.getUid());
        if(userInfo == null){
        	logger.error("用户中心数据为空,用户名:{}",request.getUid());
			result.setCode("-1");
			result.setMessage("执行失败");
			return result;
        }

		//获取当前登入用户数据权限等
		String[] orgId = cache.getOrgIdStr(null,null,request.getUid());
		if(orgId==null){
			logger.error("用户机构为空,用户名:{}",request.getUid());
			result.setCode("-1");
			result.setMessage("执行失败");
			return result;
		}

        List<Map<String,String>> taxCodeList = userInfoCache.
                getOrgTaxCodeById(request.getUid());

        List<String>taxNoList = new ArrayList<String>();
        if(taxCodeList!=null && taxCodeList.size()>0 ){
            for(Map<String,String>data : taxCodeList) {
                String taxno = data.get("taxno");
                taxNoList.add(taxno);
            }
        }

        map.put("sysCompanyCode",userInfo.getTenantId());
        map.put("sysOrgCode",orgId);
        
		map.put("invKind", request.getInvoiceCode());
		map.put("invNum", request.getInvoiceNo());
		map.put("invDate_begin", invoiceDateStart);
		map.put("invDate_end", invoiceDateEnd);
		if(StringUtils.isNotBlank(request.getBuyerTaxNo())){
            map.put("buyerTaxNo", request.getBuyerTaxNo());
        }else{
            map.put("taxNoList",taxNoList);
        }
		map.put("sellerName", request.getSellerName());
		//采集状态 0-未采集 1-已采集
        map.put("collectStatus", request.getCollectStatus());

		map.put("voucherNum", request.getVoucherNum());
		map.put("accountBeginDate", request.getAccountBeginDate());
		map.put("accountEndDate", request.getAccountEndDate());
		//添加单据编号
		map.put("billCode", request.getBillCode());

		//根据查询条件查询主表数据信息		
		Map<String, Object> param = new HashMap<String, Object>();
		List<MGCheckDeductResponseModel> responseList = null;
		try {
			PageInfo<MGTScmVatMain> page = queryVatMainEntity(map, Integer.valueOf(request.getPage()), Integer.valueOf(request.getRows()));



			if(page.getList() != null){
				responseList = new ArrayList<MGCheckDeductResponseModel>();				
				for(MGTScmVatMain entity : page.getList()){
					MGCheckDeductResponseModel response = new MGCheckDeductResponseModel();
					response.setId(String.valueOf(entity.getId()));
					response.setInvoiceType(entity.getInvType());
					response.setBuyerTaxNo(entity.getBuyerTaxno());
					response.setInvoiceCode(entity.getInvKind());
					response.setInvoiceNo(entity.getInvNum());
					response.setInvoiceTotalPrice(entity.getInvCost());
					response.setInvoiceTotalPriceTax(entity.getInvSum());
					response.setInvoiceTotalTax(entity.getInvVat());
					response.setInvoiceDate(sdf.format(entity.getInvDate()));
					response.setBuyerAddressPhone(entity.getBuyerAddrTel());
					response.setBuyerBankAccount(entity.getBuyerBank());
					response.setBuyerName(entity.getBuyerName());
					response.setSellerTaxNo(entity.getSellerTaxno());
					response.setSellerName(entity.getSellerName());
					response.setSellerAddressPhone(entity.getSellerAddrTel());
					response.setSellerBankAccount(entity.getSellerBank());

					response.setAccountTime(entity.getAccountTimeStr());
					response.setVoucherNum(entity.getVoucherNum());
					response.setBillCode(entity.getBillCode());

					if("0".equals(request.getCollectStatus())){
						response.setCollectStatus("0");
					}else if("1".equals(request.getCollectStatus())){
						response.setCollectStatus("1");
					}else{
						if((entity.getTaxInvoiceCode()!=null && !entity.getTaxInvoiceNumber().equals(""))
								&& (entity.getTaxInvoiceNumber()!=null && !entity.getTaxInvoiceNumber().equals(""))){
							response.setCollectStatus("1");
						}else{
							response.setCollectStatus("0");
						}
					}
					responseList.add(response);
				}							
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
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
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
			for (MGTScmVatMain tScmVatMain : list) {
				vatSum = vatSum.add(new BigDecimal(tScmVatMain.getInvVat()));
				costSum = costSum.add(new BigDecimal(tScmVatMain.getInvCost()));
				idList.add(String.valueOf(tScmVatMain.getId()));
			}
		}
		statisticssMap.put("count",String.valueOf(count));
		statisticssMap.put("vatSum",String.valueOf(vatSum.setScale(2,BigDecimal.ROUND_HALF_UP)));
		statisticssMap.put("costSum",String.valueOf(costSum.setScale(2,BigDecimal.ROUND_HALF_UP)));
		statisticssMap.put("idList",idList);

		return statisticssMap;
	}

    public PageInfo<MGTScmVatMain> queryVatMainEntity(Map<String, Object> map, int pageNum, int pageSize) {
		Page<MGTScmVatMain> page = PageHelper.startPage(pageNum, pageSize);
		
		try {
			if("1".equals(map.get("collectStatus"))){//已采集
				checkDeductDao.queryCollectInfo(map);
			}else if("0".equals(map.get("collectStatus"))){//未采集
				checkDeductDao.queryCheckDeductNotExistCollectInfo(map);
			}else{//显示所有已采集和未采集的信息
				checkDeductDao.queryCheckDeductList(map);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
					
        return page.toPageInfo();
	}

}