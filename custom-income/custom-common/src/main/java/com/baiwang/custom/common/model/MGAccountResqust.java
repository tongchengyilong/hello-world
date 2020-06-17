package com.baiwang.custom.common.model;

import java.util.List;

/**
 * @Description: 接收影像处理单据信息
 * @Author: Guoyongzheng
 * @Date: 2018/10/12-19:49
 */
public class MGAccountResqust extends MGAccountModel{
    private List<MGInvoiceModel> invoiceList;

    public List<MGInvoiceModel> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<MGInvoiceModel> invoiceList) {
        this.invoiceList = invoiceList;
    }
}
