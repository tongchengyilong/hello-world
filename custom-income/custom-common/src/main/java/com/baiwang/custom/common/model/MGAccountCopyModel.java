package com.baiwang.custom.common.model;

/**
 * @Description: 处理接收转换的request
 * @Author: Guoyongzheng
 * @Date: 2018/10/23-8:56
 */
public class MGAccountCopyModel {
    private String BILL_CODE;
    private String FINAL_VOUCHER_NO;
    private String VOUCHER_PERIOD;
    private String VOUCHER_TAX;
    private String VOUCHER_DATE;
    //使用拓展字段更替为updateType
    private String EXT_01;
    private String EXT_02;
    private String EXT_03;
    private String EXT_04;
    private String EXT_05;

    public String getBILL_CODE() {
        return BILL_CODE;
    }

    public void setBILL_CODE(String BILL_CODE) {
        this.BILL_CODE = BILL_CODE;
    }

    public String getFINAL_VOUCHER_NO() {
        return FINAL_VOUCHER_NO;
    }

    public void setFINAL_VOUCHER_NO(String FINAL_VOUCHER_NO) {
        this.FINAL_VOUCHER_NO = FINAL_VOUCHER_NO;
    }

    public String getVOUCHER_PERIOD() {
        return VOUCHER_PERIOD;
    }

    public void setVOUCHER_PERIOD(String VOUCHER_PERIOD) {
        this.VOUCHER_PERIOD = VOUCHER_PERIOD;
    }

    public String getVOUCHER_TAX() {
        return VOUCHER_TAX;
    }

    public void setVOUCHER_TAX(String VOUCHER_TAX) {
        this.VOUCHER_TAX = VOUCHER_TAX;
    }

    public String getVOUCHER_DATE() {
        return VOUCHER_DATE;
    }

    public void setVOUCHER_DATE(String VOUCHER_DATE) {
        this.VOUCHER_DATE = VOUCHER_DATE;
    }

    public String getEXT_01() {
        return EXT_01;
    }

    public void setEXT_01(String EXT_01) {
        this.EXT_01 = EXT_01;
    }

    public String getEXT_02() {
        return EXT_02;
    }

    public void setEXT_02(String EXT_02) {
        this.EXT_02 = EXT_02;
    }

    public String getEXT_03() {
        return EXT_03;
    }

    public void setEXT_03(String EXT_03) {
        this.EXT_03 = EXT_03;
    }

    public String getEXT_04() {
        return EXT_04;
    }

    public void setEXT_04(String EXT_04) {
        this.EXT_04 = EXT_04;
    }

    public String getEXT_05() {
        return EXT_05;
    }

    public void setEXT_05(String EXT_05) {
        this.EXT_05 = EXT_05;
    }
}
