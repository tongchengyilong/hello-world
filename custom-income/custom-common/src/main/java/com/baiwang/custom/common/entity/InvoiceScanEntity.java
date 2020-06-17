package com.baiwang.custom.common.entity;

import com.baiwang.custom.common.base.XStreamDateConverter;
import com.baiwang.custom.common.util.StringUtil;
import com.baiwang.platform.custom.common.util.DateUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: gankunjian
 * @Description: 发票扫描  数据列表  实体
 * @Date: Created in 16:19 2018/6/4
 * @Modified By:
 */
@XStreamAlias(value = "service")
public class InvoiceScanEntity extends BaseEntity{

    @XStreamAlias(value = "serviceid")
    private String serviceId;//请求ID

    @XStreamAlias(value = "billtype")
    private String billType;//单据类型

    @XStreamAlias(value = "barcode")
    private String barCode;//单据编号

    @XStreamAlias(value = "branchcode")
    private String branchCode;//机构编码

    @XStreamAlias(value = "username")
    private String userName;//用户名

    @XStreamAlias(value = "useraccount")
    private String userAccount;//账号

    @XStreamAlias(value = "billdate")
    @XStreamConverter(value = XStreamDateConverter.class)
    private Date billDate;//单据日期   YYYY-MM-DD

    private BigDecimal amount;//金额

    @XStreamAlias(value = "billcode")
    private String billCode;//单据编码

    private String remark;//备注

    private String type;//类型

    @XStreamAlias(value = "systype")
    private String sysType;//系统类型

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

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
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

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
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
        if (StringUtil.isEmpty(this.branchCode)) {
            return getErrorResult(xStream, "机构编码不能为空");
        }
        if (StringUtil.isEmpty(this.userName)) {
            return getErrorResult(xStream, "用户名不能为空");
        }
        if (StringUtil.isEmpty(this.userAccount)) {
            return getErrorResult(xStream, "账号不能为空");
        }
        if (this.billDate == null) {
            return getErrorResult(xStream, "单据日期不能为空");
        }
        if (this.amount == null) {
            return getErrorResult(xStream, "金额不能为空");
        }
        if (StringUtil.isEmpty(this.billCode)) {
            return getErrorResult(xStream, "单据编码不能为空");
        }
        if (StringUtil.isEmpty(this.remark)) {
            return getErrorResult(xStream, "备注不能为空");
        }
        if (StringUtil.isEmpty(this.type)) {
            return getErrorResult(xStream, "类型不能为空");
        }
        if (StringUtil.isEmpty(this.sysType)) {
            return getErrorResult(xStream, "系统类型不能为空");
        }
        return null;
    }

    @Override
    public String toString() {
        return "InvoiceScanEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", billType='" + billType + '\'' +
                ", barCode='" + barCode + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", billDate='" + billDate + '\'' +
                ", amount=" + amount +
                ", billCode='" + billCode + '\'' +
                ", remark='" + remark + '\'' +
                ", type='" + type + '\'' +
                ", sysType='" + sysType + '\'' +
                '}';
    }
}
