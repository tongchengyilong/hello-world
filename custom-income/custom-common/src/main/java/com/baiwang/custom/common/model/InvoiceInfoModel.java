package com.baiwang.custom.common.model;

import java.math.BigDecimal;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 9:18 2018/6/15
 * @Modified By:
 */
public class InvoiceInfoModel {

    private int id;

    private int imageId;

    private String authStatus;

    private String consolidatedTaxRate;

    private String goodsName;

    private String inspectionStatus;

    private String invoiceCheckCode;

    private String invoiceCode;

    private String invoiceDate;

    private String invoiceNo;

    private String invoiceStatus;

    private String invoiceTotalPriceTax;

    private String invoiceTypeCode;

    private String sellerTaxNo;

    private String sellerName;

    private String buyerTaxNo;

    private String buyerName;

    private String invoicePwd;

    private String MachineCode;

    private BigDecimal invoiceTotalPrice;

    private BigDecimal invoiceTotalTax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getConsolidatedTaxRate() {
        return consolidatedTaxRate;
    }

    public void setConsolidatedTaxRate(String consolidatedTaxRate) {
        this.consolidatedTaxRate = consolidatedTaxRate;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public String getInvoiceCheckCode() {
        return invoiceCheckCode;
    }

    public void setInvoiceCheckCode(String invoiceCheckCode) {
        this.invoiceCheckCode = invoiceCheckCode;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getInvoiceTotalPriceTax() {
        return invoiceTotalPriceTax;
    }

    public void setInvoiceTotalPriceTax(String invoiceTotalPriceTax) {
        this.invoiceTotalPriceTax = invoiceTotalPriceTax;
    }

    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    public BigDecimal getInvoiceTotalPrice() {
        return invoiceTotalPrice;
    }

    public void setInvoiceTotalPrice(BigDecimal invoiceTotalPrice) {
        this.invoiceTotalPrice = invoiceTotalPrice;
    }

    public BigDecimal getInvoiceTotalTax() {
        return invoiceTotalTax;
    }

    public void setInvoiceTotalTax(BigDecimal invoiceTotalTax) {
        this.invoiceTotalTax = invoiceTotalTax;
    }

    public String getSellerTaxNo() {
        return sellerTaxNo;
    }

    public void setSellerTaxNo(String sellerTaxNo) {
        this.sellerTaxNo = sellerTaxNo;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public void setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getInvoicePwd() {
        return invoicePwd;
    }

    public void setInvoicePwd(String invoicePwd) {
        this.invoicePwd = invoicePwd;
    }

    public String getMachineCode() {
        return MachineCode;
    }

    public void setMachineCode(String machineCode) {
        MachineCode = machineCode;
    }

    @Override
    public String toString() {
        return "InvoiceInfoModel{" +
                "id=" + id +
                ", imageId=" + imageId +
                ", authStatus='" + authStatus + '\'' +
                ", consolidatedTaxRate='" + consolidatedTaxRate + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", inspectionStatus='" + inspectionStatus + '\'' +
                ", invoiceCheckCode='" + invoiceCheckCode + '\'' +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", invoiceStatus='" + invoiceStatus + '\'' +
                ", invoiceTotalPriceTax='" + invoiceTotalPriceTax + '\'' +
                ", invoiceTypeCode='" + invoiceTypeCode + '\'' +
                ", sellerTaxNo='" + sellerTaxNo + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", buyerTaxNo='" + buyerTaxNo + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", invoicePwd='" + invoicePwd + '\'' +
                ", MachineCode='" + MachineCode + '\'' +
                ", invoiceTotalPrice=" + invoiceTotalPrice +
                ", invoiceTotalTax=" + invoiceTotalTax +
                '}';
    }
}
