package com.baiwang.custom.common.model;

import com.baiwang.platform.custom.common.model.PreDeductRequest;

/**
 * @Description: TODO
 * @Author: Guoyongzheng
 * @Date: 2018/10/15-8:51
 */
public class MGPreDeductRequest extends PreDeductRequest {
    private String billCode;

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }
}
