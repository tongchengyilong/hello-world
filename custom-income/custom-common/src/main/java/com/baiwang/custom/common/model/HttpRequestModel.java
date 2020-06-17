package com.baiwang.custom.common.model;

import java.util.List;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 9:06 2018/6/15
 * @Modified By:
 */
public class HttpRequestModel {

    private BillInfoModel billInfo;

    private List<InvoiceInfoModel> invoiceInfos;

    public BillInfoModel getBillInfo() {
        return billInfo;
    }

    public void setBillInfo(BillInfoModel billInfo) {
        this.billInfo = billInfo;
    }

    public List<InvoiceInfoModel> getInvoiceInfos() {
        return invoiceInfos;
    }

    public void setInvoiceInfos(List<InvoiceInfoModel> invoiceInfos) {
        this.invoiceInfos = invoiceInfos;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (invoiceInfos != null) {
            for (InvoiceInfoModel model : invoiceInfos){
                str.append(model.toString()).append(" ");
            }
        }
        return "HttpRequestModel{" +
                "billInfo=" + billInfo.toString() +
                ", invoiceInfos=[" + str.toString() +
                "]}";
    }
}
