package com.baiwang.custom.common.model;

/**
 * @Description: 已入库发票入参模型
 * @Author: Guoyongzheng
 * @Date: 2018/10/12-20:18
 */
public class MGQueryInvRequest extends QueryInvRequest {
    private String billCode;

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
}
