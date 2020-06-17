package com.baiwang.custom.common.model;

import java.util.Date;

/**
 * @author gengjingjing
 */

public class QueryInvModel {

    private Long id;


    private String invoiceCode;


    private String invoiceNumber;


    private String billingDate;


    private String invoiceType;


    private Double totalTax;


    private Double amountTax;


    private Double totalAmount;


    private String checkCode;


    private String orgId;


    private String buyerTaxNo;


    private String tradeType;


    private String collectType;


    private String collectSource;


    private String checkStatus;


    private String deductStatus;


    private String storageStatus;


    private String deductType;


    private String repeatCollect;


    private String invoiceStatus;


    private String imagePath;


    private String businessType;


    private String collectTime;


    private String collector;
    private String collectorName;


    private Date lastUpdateTime;


    private String invoiceKey;

    private String invConfirmStatus;

    private String collectStatus;

    private String sellerName;

    private String redOrBlue;

    private String matterStatus;

    private String invDeduResult;

    private String accountTime;

    private String voucherNum;

    private String createBy;

    //20180910版本 全票面信息导出增加字段
    private String certificationType;//是否抵扣

    private String invDeduDate;//抵扣日期

    private String incomeMonth;//税款所属期

    private String buyerName;//购方名称

    private String buyerTaxno;//购方税号

    private String buyerBank;//购方开户行账户

    private String buyerAddrTel;//购方地址电话

    private String sellerTaxno;//销方税号

    private String sellerBank;//销方开户行账户

    private String sellerAddrTel;//销方地址电话

    private String machineCode;//机器编码

    private int detailLineNum;//发票行行号

    private String gname;//货物或应税劳务名称

    private String gtype;//规格型号

    private String gpiece;//单位

    private String gnum;//数量

    private String price;//单价

    private String detailInvCost;//金额

    private String detailInvRate;//税率

    private String detailInvVat;//税额

    public String getSellerAddrTel() {
        return sellerAddrTel;
    }

    public void setSellerAddrTel(String sellerAddrTel) {
        this.sellerAddrTel = sellerAddrTel;
    }

    public String getCertificationType() {
        return certificationType;
    }

    public void setCertificationType(String certificationType) {
        this.certificationType = certificationType;
    }

    public String getInvDeduDate() {
        return invDeduDate;
    }

    public void setInvDeduDate(String invDeduDate) {
        this.invDeduDate = invDeduDate;
    }

    public String getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(String incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTaxno() {
        return buyerTaxno;
    }

    public void setBuyerTaxno(String buyerTaxno) {
        this.buyerTaxno = buyerTaxno;
    }

    public String getBuyerBank() {
        return buyerBank;
    }

    public void setBuyerBank(String buyerBank) {
        this.buyerBank = buyerBank;
    }

    public String getBuyerAddrTel() {
        return buyerAddrTel;
    }

    public void setBuyerAddrTel(String buyerAddrTel) {
        this.buyerAddrTel = buyerAddrTel;
    }

    public String getSellerTaxno() {
        return sellerTaxno;
    }

    public void setSellerTaxno(String sellerTaxno) {
        this.sellerTaxno = sellerTaxno;
    }

    public String getSellerBank() {
        return sellerBank;
    }

    public void setSellerBank(String sellerBank) {
        this.sellerBank = sellerBank;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public int getDetailLineNum() {
        return detailLineNum;
    }

    public void setDetailLineNum(int detailLineNum) {
        this.detailLineNum = detailLineNum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public String getGpiece() {
        return gpiece;
    }

    public void setGpiece(String gpiece) {
        this.gpiece = gpiece;
    }

    public String getGnum() {
        return gnum;
    }

    public void setGnum(String gnum) {
        this.gnum = gnum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetailInvCost() {
        return detailInvCost;
    }

    public void setDetailInvCost(String detailInvCost) {
        this.detailInvCost = detailInvCost;
    }

    public String getDetailInvRate() {
        return detailInvRate;
    }

    public void setDetailInvRate(String detailInvRate) {
        this.detailInvRate = detailInvRate;
    }

    public String getDetailInvVat() {
        return detailInvVat;
    }

    public void setDetailInvVat(String detailInvVat) {
        this.detailInvVat = detailInvVat;
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

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public Double getAmountTax() {
        return amountTax;
    }

    public void setAmountTax(Double amountTax) {
        this.amountTax = amountTax;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public void setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
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

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    public String getDeductType() {
        return deductType;
    }

    public void setDeductType(String deductType) {
        this.deductType = deductType;
    }

    public String getRepeatCollect() {
        return repeatCollect;
    }

    public void setRepeatCollect(String repeatCollect) {
        this.repeatCollect = repeatCollect;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getInvoiceKey() {
        return invoiceKey;
    }

    public void setInvoiceKey(String invoiceKey) {
        this.invoiceKey = invoiceKey;
    }

    public String getInvConfirmStatus() {
        return invConfirmStatus;
    }

    public void setInvConfirmStatus(String invConfirmStatus) {
        this.invConfirmStatus = invConfirmStatus;
    }

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getInvDeduResult() {
        return invDeduResult;
    }

    public void setInvDeduResult(String invDeduResult) {
        this.invDeduResult = invDeduResult;
    }

    public String getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(String accountTime) {
        this.accountTime = accountTime;
    }

    public String getVoucherNum() {
        return voucherNum;
    }

    public void setVoucherNum(String voucherNum) {
        this.voucherNum = voucherNum;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}

