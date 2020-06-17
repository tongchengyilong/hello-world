package com.baiwang.custom.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 19:56 2018/6/13
 * @Modified By:
 */
@XStreamAlias(value = "item")
public class ItemModel {

    private String serviceid;

    private String result;

    private String errormsg;

    private String success;

    public ItemModel() {
    }

    public ItemModel(String serviceid, String result, String errormsg, String success) {
        this.serviceid = serviceid;
        this.result = result;
        this.errormsg = errormsg;
        this.success = success;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "serviceid='" + serviceid + '\'' +
                ", result='" + result + '\'' +
                ", errormsg='" + errormsg + '\'' +
                ", success=" + success +
                '}';
    }
}
