package com.baiwang.custom.common.entity;

import com.baiwang.custom.common.util.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: gankunjian
 * @Description: 影像退单  数据列表  实体
 * @Date: Created in 16:25 2018/6/4
 * @Modified By:
 */
@XStreamAlias(value = "service")
public class ImageChargebackEntity extends BaseEntity {

    @XStreamAlias(value = "serviceid")
    private String serviceId;//请求ID

    @XStreamAlias(value = "billtype")
    private String billType;//单据类型

    @XStreamAlias(value = "barcode")
    private String barCode;//单据编号

    @XStreamAlias(value = "username")
    private String userName;//用户名

    private String _userstaff;//员工姓名

    @XStreamAlias(value = "useraccount")
    private String userAccount;//账户名称

    private String phone;//电话

    private String remark;//备注

    private String type;//类型

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String get_userstaff() {
        return _userstaff;
    }

    public void set_userstaff(String _userstaff) {
        this._userstaff = _userstaff;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (StringUtil.isEmpty(this.billType)) {
            return getErrorResult(xStream, "单据类型不能为空");
        }
        if (StringUtil.isEmpty(this.userName)) {
            return getErrorResult(xStream, "用户名不能为空");
        }
        if (StringUtil.isEmpty(this._userstaff)) {
            return getErrorResult(xStream, "员工姓名不能为空");
        }
        if (StringUtil.isEmpty(this.userAccount)) {
            return getErrorResult(xStream, "账户名称不能为空");
        }
//        if (StringUtil.isEmpty(this.phone)) {
//            return getErrorResult(xStream, "电话不能为空");
//        }
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
        return "ImageChargebackEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", billType='" + billType + '\'' +
                ", barCode='" + barCode + '\'' +
                ", userName='" + userName + '\'' +
                ", _userstaff='" + _userstaff + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
