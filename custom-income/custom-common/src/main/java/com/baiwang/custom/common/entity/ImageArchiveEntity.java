package com.baiwang.custom.common.entity;

import com.baiwang.custom.common.base.XStreamDateConverter;
import com.baiwang.custom.common.util.StringUtil;
import com.baiwang.platform.custom.common.util.DateUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @Author: gankunjian
 * @Description: 影像归档  数据列表  实体
 * @Date: Created in 16:36 2018/6/4
 * @Modified By:
 */
@XStreamAlias(value = "service")
public class ImageArchiveEntity extends BaseEntity{

    @XStreamAlias(value = "serviceid")
    private String serviceId;//请求ID

    @XStreamAlias(value = "billtype")
    private String billType;//单据类型

    @XStreamAlias(value = "barcode")
    private String barCode;//单据条形码

    @XStreamAlias(value = "bustype")
    private String busType;//业务类型

    @XStreamAlias(value = "optype")
    private String opType;//操作类型

    private String voucher;//凭单编号

    private String year;//年 YYYY

    private String braNPSh;//公司名称

    @XStreamConverter(value = XStreamDateConverter.class)
    private Date date;//单据日期   YYYY-MM-DD

    @XStreamAlias(value = "username")
    private String userName;//用户名

    @XStreamAlias(value = "useraccount")
    private String userAccount;//账号

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

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBraNPSh() {
        return braNPSh;
    }

    public void setBraNPSh(String braNPSh) {
        this.braNPSh = braNPSh;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String requestParamCheck(XStream xStream) {
        if (StringUtil.isEmpty(this.serviceId)) {
            return getErrorResult(xStream, "请求ID不能为空");
        }
        if (StringUtil.isEmpty(this.barCode)) {
            return getErrorResult(xStream, "单据条形码不能为空");
        }
        if (StringUtil.isEmpty(this.billType)) {
            return getErrorResult(xStream, "单据类型不能为空");
        }
        if (StringUtil.isEmpty(this.busType)) {
            return getErrorResult(xStream, "业务类型不能为空");
        }
        if (StringUtil.isEmpty(this.opType)) {
            return getErrorResult(xStream, "操作类型不能为空");
        }
        if (StringUtil.isEmpty(this.voucher)) {
            return getErrorResult(xStream, "凭单编号不能为空");
        }
        if (StringUtil.isEmpty(this.year)) {
            return getErrorResult(xStream, "年不能为空");
        }
        if (StringUtil.isEmpty(this.braNPSh)) {
            return getErrorResult(xStream, "公司名称不能为空");
        }
        if (this.date == null) {
            return getErrorResult(xStream, "单据日期不能为空");
        }
        if (StringUtil.isEmpty(this.userName)) {
            return getErrorResult(xStream, "用户名不能为空");
        }
        if (StringUtil.isEmpty(this.userAccount)) {
            return getErrorResult(xStream, "用户账号不能为空");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        format.setLenient(false);
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        if (this.year.length() != 4 && !pattern.matcher(this.year).matches()) {
            return getErrorResult(xStream, "年:" + this.year + "格式不正确");
        }
        try {
            format.parse(this.year);
        }catch (Exception e){
            e.printStackTrace();
            return getErrorResult(xStream, "年:" + this.year + "格式不正确");
        }
        return null;
    }

    @Override
    public String toString() {
        return "ImageArchiveEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", billType='" + billType + '\'' +
                ", barCode='" + barCode + '\'' +
                ", busType='" + busType + '\'' +
                ", opType='" + opType + '\'' +
                ", voucher='" + voucher + '\'' +
                ", year='" + year + '\'' +
                ", braNPSh='" + braNPSh + '\'' +
                ", date=" + date +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                '}';
    }
}
