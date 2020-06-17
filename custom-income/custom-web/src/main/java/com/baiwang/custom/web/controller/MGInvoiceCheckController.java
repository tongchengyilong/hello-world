package com.baiwang.custom.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baiwang.custom.common.model.MGQueryInvModel;
import com.baiwang.custom.common.model.QueryInvModel;
import com.baiwang.custom.common.model.QueryInvRequest;
import com.baiwang.custom.common.model.QueryInvRequestModel;
import com.baiwang.custom.web.base.BaseController;
import com.baiwang.custom.web.service.MGInvoiceCheckService;
import com.baiwang.platform.custom.common.poi.excel.entity.TemplateExportParams;
import com.baiwang.platform.custom.common.poi.excel.entity.vo.TemplateExcelConstants;
import com.baiwang.platform.custom.common.poi.excel.view.TaxTemplateExcelView;
import com.baiwang.platform.custom.common.poi.excel.view.TaxTemplateZipCsvView;
import com.baiwang.platform.custom.common.poi.excel.view.TaxTemplateZipExcelView;
import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.baiwang.platform.custom.common.result.RestFulApiContants;
import com.baiwang.platform.custom.integration.usercenter.UserInfoCache;

import com.baiwang.platform.custom.web.aop.LogT;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/mginvoiceCheck")
public class MGInvoiceCheckController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(MGInvoiceCheckController.class);
	
	@Autowired
    private TaxTemplateZipCsvView taxTemplateZipExcelView;
	
    @Autowired
    private UserInfoCache userInfoCache;
    
    @Autowired
    private TaxTemplateExcelView taxTemplateExcelView;
    
    @Autowired
    private MGInvoiceCheckService invoiceCheckService;
    /**
     * 已入库发票查询
     * @param queryInvRequestModel
     * @return
     */
    @RequestMapping("/queryInv")
    @ResponseBody
    @LogT
    public CrRpcResult queryInv(@RequestBody QueryInvRequestModel queryInvRequestModel){
        try {
            //校验入参
            //格式化入参
            CrRpcResult checkResult = queryInvRequestModel.paramsQueryCheck();
            if(checkResult!=null){
                return checkResult;
            }

            //获取当前登入用户数据权限等
            String[] orgId = userInfoCache.getOrgIdStr(queryInvRequestModel.getTradeType(),queryInvRequestModel.getOrgIdStr(),queryInvRequestModel.getUid());
            if(orgId==null){
                logger.warn("InvoiceCheck queryInv 无权访问");
                return new CrRpcResult(RestFulApiContants.AUTH_NOT_EXIST, RestFulApiContants.AUTH__NOT_EXIST_CN);
            }
            //数据权限控制
            queryInvRequestModel.setOrgIdController(orgId);

            //分页查询
            PageInfo<MGQueryInvModel> page = invoiceCheckService.getQueryInvModelListPage(queryInvRequestModel, queryInvRequestModel.getPage(),
            		queryInvRequestModel.getRows());

            //封装返回对象
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("total", page.getTotal());
            resultMap.put("results", page.getList());
            
            return result(RestFulApiContants.SUCCESS, RestFulApiContants.SUCCESS_CN,resultMap);
        } catch (Exception e) {
            //日志
            logger.error("InvoiceCheck queryInv system error e:",e);
            return result(RestFulApiContants.UN_ERROR, RestFulApiContants.UN_ERROR_CN,null);
        }
    }
    /**
     *  导出入库发票列表Excel
     * @param queryInvRequestModel
     * @return
     */
    @RequestMapping("/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, HttpServletResponse response, @RequestBody QueryInvRequestModel queryInvRequestModel, ModelMap modelMap){
        try {
            //校验入参
            //格式化入参
            CrRpcResult checkResult = queryInvRequestModel.paramsQueryCheck();
            if(checkResult!=null){
                return null;
            }

            //获取当前登入用户数据权限等
            String[] orgId = userInfoCache.getOrgIdStr(queryInvRequestModel.getTradeType(),queryInvRequestModel.getOrgIdStr(),queryInvRequestModel.getUid());
            if(orgId==null){
                logger.warn("InvoiceCheck exportXls 无权访问");
                return null;
            }

            //数据权限控制
            queryInvRequestModel.setOrgIdController(orgId);

            //分页查询，最大100000条
            PageInfo<MGQueryInvModel> page = invoiceCheckService.getQueryInvModelListPage(queryInvRequestModel,
                    1,60000);
            List<MGQueryInvModel> results = page.getList();

            //返回结果数据处理(字典转换)
            List<Map<String,Object>> formartList = invoiceCheckService.getFormartVatList(results);
            //封装返回对象
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", formartList);
            //返回Excel文件
            modelMap.put(TemplateExcelConstants.MAP_DATA, map);
            modelMap.put(TemplateExcelConstants.FILE_NAME, "发票查询列表");
            modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/invoiceInfoTemplate.xls"));
            return new ModelAndView(taxTemplateExcelView);

        } catch (Exception e) {
            //日志
            logger.error("InvoiceCheck exportXls system error e:",e);
            return null;
        }
    }
    /**
     *  导出入库发票全票面列表Excel
     * @param queryInvRequestModel
     * @return
     */
    @RequestMapping("/exportFullXls")
//    @LogT
    public ModelAndView exportFullXls(HttpServletRequest request, HttpServletResponse response, @RequestBody QueryInvRequestModel queryInvRequestModel, ModelMap modelMap){
        try {
            //校验入参
            //格式化入参
            CrRpcResult checkResult = queryInvRequestModel.paramsQueryCheck();
            if(checkResult!=null){
                return null;
            }

            //获取当前登入用户数据权限等
            String[] orgId = userInfoCache.getOrgIdStr(queryInvRequestModel.getTradeType(),queryInvRequestModel.getOrgIdStr(),queryInvRequestModel.getUid());
            if(orgId==null){
                logger.warn("InvoiceCheck exportXls 无权访问");
                return null;
            }

            //数据权限控制
            queryInvRequestModel.setOrgIdController(orgId);

            //分页查询，最大600000条
            PageInfo<MGQueryInvModel> page = invoiceCheckService.getQueryInvModelFullListPage(queryInvRequestModel,
                    1,600000);
            List<MGQueryInvModel> results = page.getList();

            //返回结果数据处理(字典转换)
            List<Map<String,Object>> formartList = invoiceCheckService.getFormartVatList(results);
            //封装返回对象
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("list", formartList);
            //返回Excel文件
            modelMap.put(TemplateExcelConstants.MAP_DATA, map);
            modelMap.put(TemplateExcelConstants.FILE_NAME, "发票查询列表");
            modelMap.put(TemplateExcelConstants.PARAMS, new TemplateExportParams("export/invoiceInfoASStorageTemplateST.xls"));

            if(page.getList().size() <= TaxTemplateZipExcelView.MAX_SIZE){
                return new ModelAndView(taxTemplateExcelView);
            }else{
                modelMap.put(TemplateExcelConstants.HEAD_DATA,"发票代码,发票号码,发票类型,开票日期,发票状态,是否抵扣,抵扣日期,税款所属期,购方名称,购方税号,购方开户行账户,购方地址电话,销方名称,销方税号,销方开户行账户,销方地址电话,合计金额,合计税额,价税合计,机器编码,校验码,发票行行号,货物或应税劳务名称,规格型号,单位,数量,单价,金额,税率,税额");
                modelMap.put(TemplateExcelConstants.FIELD_DATA,"invoiceCode,invoiceNumber,invoiceType,billingDate,invoiceStatus,certificationType,invDeduDate,incomeMonth,buyerName,buyerTaxno,buyerBank,buyerAddrTel,sellerName,sellerTaxno,sellerBank,sellerAddrTel,totalAmount,totalTax,amountTax,machineCode,checkCode,detailLineNum,gname,gtype,gpiece,gnum,price,detailInvCost,detailInvRate,detailInvVat");
                return new ModelAndView(taxTemplateZipExcelView);
            }

        } catch (Exception e) {
            //日志
            logger.error("InvoiceCheck exportXls system error e:",e);
            return null;
        }
    }

}
