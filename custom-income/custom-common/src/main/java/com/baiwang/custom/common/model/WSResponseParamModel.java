package com.baiwang.custom.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * @Author: gankunjian
 * @Description: webService 服务端响应参数实体
 * @Date: Created in 15:26 2018/6/4
 * @Modified By:
 */
@XStreamAlias(value = "root")
public class WSResponseParamModel {

    private String result;

    private boolean success;

    private String errormsg;

    private List<ItemModel> items;

    public WSResponseParamModel() {
    }

    public WSResponseParamModel(String result, boolean success, String errormsg, List<ItemModel> items) {
        this.result = result;
        this.success = success;
        this.errormsg = errormsg;
        this.items = items;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuilder listStr = new StringBuilder();
        if (items != null) {
            for (ItemModel t : items) {
                listStr.append(t.toString()).append(" ");
            }
        }
        return "WSResponseParamModel{" +
                "result='" + result + '\'' +
                ", success=" + success +
                ", errormsg='" + errormsg + '\'' +
                ", items=[" + listStr.toString() +
                "]}";
    }
}
