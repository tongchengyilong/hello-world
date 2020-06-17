package com.baiwang.custom.common.model;

import java.util.List;

public class RecAndCheckRequestModel {
	List<MGSynchronizationModel> BillInvoiceList;

	public List<MGSynchronizationModel> getBillInvoiceList() {
		return BillInvoiceList;
	}

	public void setBillInvoiceList(List<MGSynchronizationModel> billInvoiceList) {
		this.BillInvoiceList = billInvoiceList;
	}
	
}
