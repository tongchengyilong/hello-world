package com.baiwang.custom.common.model;

import java.math.BigDecimal;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 9:09 2018/6/15
 * @Modified By:
 */
public class BillInfoModel {

    private int id;

    private BigDecimal amount;

    private String barCode;

    private String billCode;

    private String billDate;

    private String billStatus;

    private String billType;

    private String branchCode;

    private Integer checkAmount;

    private Integer mediaAmount;

    private String pushState;

    private Integer recognizeAmount;

    private String remark;

    private String scanType;

    private String userName;

    private String voucher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Integer getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(Integer checkAmount) {
        this.checkAmount = checkAmount;
    }

    public Integer getMediaAmount() {
        return mediaAmount;
    }

    public void setMediaAmount(Integer mediaAmount) {
        this.mediaAmount = mediaAmount;
    }

    public Integer getRecognizeAmount() {
        return recognizeAmount;
    }

    public void setRecognizeAmount(Integer recognizeAmount) {
        this.recognizeAmount = recognizeAmount;
    }

    public String getPushState() {
        return pushState;
    }

    public void setPushState(String pushState) {
        this.pushState = pushState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    @Override
    public String toString() {
        return "BillInfoModel{" +
                "id=" + id +
                ", amount=" + amount +
                ", barCode='" + barCode + '\'' +
                ", billCode='" + billCode + '\'' +
                ", billDate='" + billDate + '\'' +
                ", billStatus='" + billStatus + '\'' +
                ", billType='" + billType + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", checkAmount=" + checkAmount +
                ", mediaAmount=" + mediaAmount +
                ", pushState='" + pushState + '\'' +
                ", recognizeAmount=" + recognizeAmount +
                ", remark='" + remark + '\'' +
                ", scanType='" + scanType + '\'' +
                ", userName='" + userName + '\'' +
                ", voucher='" + voucher + '\'' +
                '}';
    }
}
