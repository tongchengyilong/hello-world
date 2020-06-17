package com.baiwang.custom.common.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.baiwang.platform.custom.common.result.CrRpcResult;
import com.baiwang.platform.custom.common.result.RestFulApiContants;

public class QueryInvRequest {
    private String orgId;
    private String tradeType;
    private String invoiceType;
    private String collectType;
    private String collectSource;
    private String businessType;
    private String storageStatus;
    private String checkStatus;
    private String deductStatus;
    private String invoiceStatus;
    private String collectorName;
    private String invoiceCode;
    private String invoiceNo;
    private String payAppNo;
    private String billingDate;
    private int page;
    private int rows;
    private String orgIdStr;
    private String uid;
    private String resourceId;

    private String billingBeginDate;
    private String billingEndDate;

    private String id;//发票明细入参

    private String[] orgIdController;

    private String invoiceNumber;
    private String collectStatus;
    private String invDeduResult;
    private String collector;
    private String deductType;
    private String redOrBlue;
    private String matterStatus;
    private String repeatCollect;
    private String sellerName;
    private String buyerTaxNo;
    private String exceptionFlag;
    private String tenantId;

    private Double gteTotalAmout;

    private Date accountTime;

    private String voucherNum;

    private String accounttingNo;

    private BigDecimal amountUse;

    private BigDecimal taxUse;

    private String accountStatus;

    private String accountDate;
    private String accountBeginDate;
    private String accountEndDate;

    //勾选查验,ids
    private String ids;
    //勾选查验，格式化ids
    private List<String> idsVec;

    private String createBy;
    /**
     * 发票备注
     */
    private String invComment;

    /**
     * 校验已入库发票入参
     * @return
     */
    public CrRpcResult paramsQueryCheck(){
        if(StringUtils.isNotBlank(billingDate) && billingDate.contains(" ")){
            String[] billingDateArray = billingDate.split(" ");
            billingBeginDate = billingDateArray[0];
            billingEndDate = billingDateArray[1];
        }

        if(StringUtils.isNotBlank(accountDate) && accountDate.contains(" ")){
            String[] accountDateArray = accountDate.split(" ");
            accountBeginDate = accountDateArray[0];
            accountEndDate = accountDateArray[1];
        }

        return null;
    }

    /**
     * 校验发票明细入参
     * @return
     */
    public CrRpcResult paramsDetailCheck(){

        if(StringUtils.isBlank(id)){
            return new CrRpcResult(RestFulApiContants.CHECK_ERROR, RestFulApiContants.PARAMS_ERROR_CN);
        }



        return null;
    }

    /**
     * 校验更新发票凭证号
     * @return
     */
    public CrRpcResult paramsUpdateInv(){
        if(StringUtils.isBlank(invoiceCode)||StringUtils.isBlank(invoiceNo)
                ||StringUtils.isBlank(uid)||StringUtils.isBlank(voucherNum)
                ||accountTime == null || amountUse == null
                ||StringUtils.isBlank(accounttingNo)
                ||taxUse == null || StringUtils.isBlank(accountStatus)){
            return new CrRpcResult(RestFulApiContants.CHECK_ERROR,
                    RestFulApiContants.PARAMS_ERROR_CN);
        }

        return null;
    }

    /**
     * 校验获取发票扩展信息列表
     * @return
     */
    public CrRpcResult paramsExtend(){
        if(StringUtils.isBlank(invoiceCode)||StringUtils.isBlank(invoiceNo)
                ||StringUtils.isBlank(uid)){
            return new CrRpcResult(RestFulApiContants.CHECK_ERROR,
                    RestFulApiContants.PARAMS_ERROR_CN);
        }

        return null;
    }

    /**
     * 校验勾选查验参数校验
     * @return
     */
    public CrRpcResult paramsAddCheck(){
        if(StringUtils.isBlank(ids)){
            return new CrRpcResult(RestFulApiContants.CHECK_ERROR,
                    RestFulApiContants.PARAMS_ERROR_CN);
        }

        //格式化
        try {
            String[] split = ids.split(",");
            List<String> list = new ArrayList<String>();
            for (String string : split) {
                list.add(string);
            }
            idsVec = list;
        }catch (Exception e){
            return new CrRpcResult(RestFulApiContants.CHECK_ERROR,
                    RestFulApiContants.PARAMS_ERROR_CN);
        }

        return null;
    }

    /**
     * 校验获取用户查验记录入参
     * @return
     */
    public CrRpcResult paramsGetCheckLog(){
        if(StringUtils.isBlank(uid)){
            return new CrRpcResult(RestFulApiContants.CHECK_ERROR,
                    RestFulApiContants.PARAMS_ERROR_CN);
        }

        return null;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getCollectType() {
        return collectType;
    }

    public void setCollectType(String collectType) {
        this.collectType = collectType;
    }

    public String getCollectSource() {
        return collectSource;
    }

    public void setCollectSource(String collectSource) {
        this.collectSource = collectSource;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getDeductStatus() {
        return deductStatus;
    }

    public void setDeductStatus(String deductStatus) {
        this.deductStatus = deductStatus;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getPayAppNo() {
        return payAppNo;
    }

    public void setPayAppNo(String payAppNo) {
        this.payAppNo = payAppNo;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getOrgIdStr() {
        return orgIdStr;
    }

    public void setOrgIdStr(String orgIdStr) {
        this.orgIdStr = orgIdStr;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getBillingBeginDate() {
        return billingBeginDate;
    }

    public void setBillingBeginDate(String billingBeginDate) {
        this.billingBeginDate = billingBeginDate;
    }

    public String getBillingEndDate() {
        return billingEndDate;
    }

    public void setBillingEndDate(String billingEndDate) {
        this.billingEndDate = billingEndDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getOrgIdController() {
        return orgIdController;
    }

    public void setOrgIdController(String[] orgIdController) {
        this.orgIdController = orgIdController;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }

    public String getInvDeduResult() {
        return invDeduResult;
    }

    public void setInvDeduResult(String invDeduResult) {
        this.invDeduResult = invDeduResult;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public String getDeductType() {
        return deductType;
    }

    public void setDeductType(String deductType) {
        this.deductType = deductType;
    }

    public String getRedOrBlue() {
        return redOrBlue;
    }

    public void setRedOrBlue(String redOrBlue) {
        this.redOrBlue = redOrBlue;
    }

    public String getMatterStatus() {
        return matterStatus;
    }

    public void setMatterStatus(String matterStatus) {
        this.matterStatus = matterStatus;
    }

    public String getRepeatCollect() {
        return repeatCollect;
    }

    public void setRepeatCollect(String repeatCollect) {
        this.repeatCollect = repeatCollect;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<String> getIdsVec() {
        return idsVec;
    }

    public void setIdsVec(List<String> idsVec) {
        this.idsVec = idsVec;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public void setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
    }

    public String getExceptionFlag() {
        return exceptionFlag;
    }

    public void setExceptionFlag(String exceptionFlag) {
        this.exceptionFlag = exceptionFlag;
    }

    public Double getGteTotalAmout() {
        return gteTotalAmout;
    }

    public void setGteTotalAmout(Double gteTotalAmout) {
        this.gteTotalAmout = gteTotalAmout;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getVoucherNum() {
        return voucherNum;
    }

    public void setVoucherNum(String voucherNum) {
        this.voucherNum = voucherNum;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    public String getAccountBeginDate() {
        return accountBeginDate;
    }

    public void setAccountBeginDate(String accountBeginDate) {
        this.accountBeginDate = accountBeginDate;
    }

    public String getAccountEndDate() {
        return accountEndDate;
    }

    public void setAccountEndDate(String accountEndDate) {
        this.accountEndDate = accountEndDate;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public String getAccounttingNo() {
        return accounttingNo;
    }

    public void setAccounttingNo(String accounttingNo) {
        this.accounttingNo = accounttingNo;
    }

    public BigDecimal getAmountUse() {
        return amountUse;
    }

    public void setAmountUse(BigDecimal amountUse) {
        this.amountUse = amountUse;
    }

    public BigDecimal getTaxUse() {
        return taxUse;
    }

    public void setTaxUse(BigDecimal taxUse) {
        this.taxUse = taxUse;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getInvComment() {
        return invComment;
    }

    public void setInvComment(String invComment) {
        this.invComment = invComment;
    }
}
