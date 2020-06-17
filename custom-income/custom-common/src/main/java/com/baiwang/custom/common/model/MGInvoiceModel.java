package com.baiwang.custom.common.model;

/**
 * @Description: 发票信息实体
 * @Author: Guoyongzheng
 * @Date: 2018/10/12-19:46
 */
public class MGInvoiceModel {
    private String invoiceCode;
    private String invoiceNum;

    // 单据编号
    private String billCode;
    // 凭证编号
    private String finslVoucherNo;
    // 凭证会计期
    private String foucherPeriod;
    // 记账税额
    private String voucherTax;
    // 记账日期
    private String voucherDate;

    private String updateType;

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getFinslVoucherNo() {
        return finslVoucherNo;
    }

    public void setFinslVoucherNo(String finslVoucherNo) {
        this.finslVoucherNo = finslVoucherNo;
    }

    public String getFoucherPeriod() {
        return foucherPeriod;
    }

    public void setFoucherPeriod(String foucherPeriod) {
        this.foucherPeriod = foucherPeriod;
    }

    public String getVoucherTax() {
        return voucherTax;
    }

    public void setVoucherTax(String voucherTax) {
        this.voucherTax = voucherTax;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }
}
