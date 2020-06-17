package com.baiwang.custom.common.entity;

import com.baiwang.custom.common.util.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: gankunjian
 * @Description: 影像重扫  数据列表  实体
 * @Date: Created in 16:33 2018/6/4
 * @Modified By:
 */
@XStreamAlias(value = "service")
public class ImageRescanEntity extends BaseEntity{

    @XStreamAlias(value = "serviceid")
    private String serviceId;//请求ID

    @XStreamAlias(value = "barcode")
    private String barCode;//单据编号

    @XStreamAlias(value = "useraccount")
    private String userAccount;//用户账号

    private String remark;//备注

    private String type;//类型

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String requestParamCheck(XStream xStream) {
        if (StringUtil.isEmpty(this.serviceId)) {
            return getErrorResult(xStream, "请求ID不能为空");
        }
        if (StringUtil.isEmpty(this.barCode)) {
            return getErrorResult(xStream, "单据编号不能为空");
        }
        if (StringUtil.isEmpty(this.userAccount)) {
            return getErrorResult(xStream, "用户账号不能为空");
        }
        if (StringUtil.isEmpty(this.remark)) {
            return getErrorResult(xStream, "备注不能为空");
        }
        if (StringUtil.isEmpty(this.type)) {
            return getErrorResult(xStream, "类型不能为空");
        }
        return null;
    }

    @Override
    public String toString() {
        return "ImageRescanEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", barCode='" + barCode + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", remark='" + remark + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
