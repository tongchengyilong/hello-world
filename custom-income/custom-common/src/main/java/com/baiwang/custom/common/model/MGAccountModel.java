package com.baiwang.custom.common.model;

import com.baiwang.custom.common.entity.BaseEntity;
import com.baiwang.custom.common.util.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Description: 记账接口字段模型
 * @Author: Guoyongzheng
 * @Date: 2018/10/12-19:28
 */
@XStreamAlias(value = "service")
public class MGAccountModel extends BaseEntity {
    // 单据编号
    @XStreamAlias(value = "Billcode")
    private String billCode;
    // 凭证编号
    @XStreamAlias(value = "Finslvoucherno")
    private String finslVoucherNo;
    // 凭证会计期
    @XStreamAlias(value = "foucherperiod")
    private String foucherPeriod;
    // 记账税额
    @XStreamAlias(value = "vouchertax")
    private String voucherTax;
    // 记账日期
    @XStreamAlias(value = "voucherdate")
    private String voucherDate;

    //// 更新类型
    //@XStreamAlias(value = "updateType")
    //private String updateType;
    // 扩展字段2
    @XStreamAlias(value = "ext01")
    private String ext01;
    // 扩展字段2
    @XStreamAlias(value = "ext02")
    private String ext02;
    // 扩展字段3
    @XStreamAlias(value = "ext03")
    private String ext03;
    // 扩展字段4
    @XStreamAlias(value = "ext04")
    private String ext04;
    // 扩展字段5
    @XStreamAlias(value = "ext05")
    private String ext05;

    public String getExt01() {
        return ext01;
    }

    public void setExt01(String ext01) {
        this.ext01 = ext01;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getFinslVoucherNo() {
        return finslVoucherNo;
    }

    public void setFinslVoucherNo(String finslVoucherNo) {
        this.finslVoucherNo = finslVoucherNo;
    }

    public String getFoucherPeriod() {
        return foucherPeriod;
    }

    public void setFoucherPeriod(String foucherPeriod) {
        this.foucherPeriod = foucherPeriod;
    }

    public String getVoucherTax() {
        return voucherTax;
    }

    public void setVoucherTax(String voucherTax) {
        this.voucherTax = voucherTax;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    //public String getUpdateType() {
    //    return updateType;
    //}
    //
    //public void setUpdateType(String updateType) {
    //    this.updateType = updateType;
    //}

    public String getExt02() {
        return ext02;
    }

    public void setExt02(String ext02) {
        this.ext02 = ext02;
    }

    public String getExt03() {
        return ext03;
    }

    public void setExt03(String ext03) {
        this.ext03 = ext03;
    }

    public String getExt04() {
        return ext04;
    }


    public void setExt04(String ext04) {
        this.ext04 = ext04;
    }

    public String getExt05() {
        return ext05;
    }

    public void setExt05(String ext05) {
        this.ext05 = ext05;
    }

    @Override
    public String requestParamCheck(XStream xStream) {
        if (StringUtil.isEmpty(this.billCode)) {
            return getErrorResult(xStream, "单据编号不能为空");
        }
        if (StringUtil.isEmpty(this.finslVoucherNo)) {
            return getErrorResult(xStream, "凭证号不能为空");
        }
        if (StringUtil.isEmpty(this.voucherDate)) {
            return getErrorResult(xStream, "记账日期不能为空");
        }
        return  null;
    }
}
