package com.baiwang.custom.common.entity;

import com.baiwang.platform.custom.dao.domain.TScmVatMain;

/**
 * @Description: TODO
 * @Author: Guoyongzheng
 * @Date: 2018/10/15-8:57
 */
public class MGTScmVatMain extends TScmVatMain {

    //单据编号 -- “来源系统单号”
    private String billCode;
    // 凭证编号 -- 凭证号
    private String finslVoucherNo;
    // 记账日期
    private String voucherDate;

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

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }
}
