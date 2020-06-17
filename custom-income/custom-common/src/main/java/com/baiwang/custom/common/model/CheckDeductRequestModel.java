package com.baiwang.custom.common.model;

import com.baiwang.platform.custom.common.model.CheckDeductRequest;

public class CheckDeductRequestModel extends CheckDeductRequest {
	private String billCode;

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
}
