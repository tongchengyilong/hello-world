package com.baiwang.custom.common.entity;

import com.baiwang.custom.common.util.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 15:14 2018/6/5
 * @Modified By:
 */
@XStreamAlias(value = "service")
public class ImageCallBackEntity extends BaseEntity {

    @XStreamAlias(value = "serviceid")
    private String serviceId;//请求ID

    @XStreamAlias(value = "barcode")
    private String barCode;//单据编号

    @XStreamAlias(value = "billtype")
    private String billType;//单据类型

    @XStreamAlias(value = "serino")
    private String seriNo;//序号

    private String state;//状态

    @XStreamAlias(value = "imagecount")
    private int imageCount;//影像数量

    @XStreamAlias(value = "busstype")
    private String bussType;//业务类型

    @XStreamAlias(value = "opuseraccount")
    private String opUserAccount;//操作员账号

    @XStreamAlias(value = "opusername")
    private String opUserName;//操作员名称

    @XStreamAlias(value = "opuserdatetime")
    private String opUserDatetime;//操作时间   YYYYMMDDHHMMSS

    @XStreamAlias(value = "type")
    private String type;

    private List<InvoiceInfoEntity> invoices;

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

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public String getBussType() {
        return bussType;
    }

    public void setBussType(String bussType) {
        this.bussType = bussType;
    }

    public String getOpUserAccount() {
        return opUserAccount;
    }

    public void setOpUserAccount(String opUserAccount) {
        this.opUserAccount = opUserAccount;
    }

    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }

    public String getOpUserDatetime() {
        return opUserDatetime;
    }

    public void setOpUserDatetime(String opUserDatetime) {
        this.opUserDatetime = opUserDatetime;
    }

    public List<InvoiceInfoEntity> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceInfoEntity> invoices) {
        this.invoices = invoices;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String requestParamCheck(XStream xStream) {
        return requestParamCheck();
    }

    public String requestParamCheck() {
        if (StringUtil.isEmpty(this.serviceId)) {
            return "参数请求ID不能为空";
        }
        if (StringUtil.isEmpty(this.barCode)) {
            return "参数单据编号不能为空";
        }
        if (StringUtil.isEmpty(this.billType)) {
            return "参数单据类型不能为空";
        }
        if (StringUtil.isEmpty(this.seriNo)) {
            return "参数序号不能为空";
        }
        if (StringUtil.isEmpty(this.state)) {
            return "参数状态不能为空";
        }
        if (this.imageCount == 0) {
            return "参数影像数量不能为空";
        }
        if (StringUtil.isEmpty(this.bussType)) {
            return "参数业务类型不能为空";
        }
        if (StringUtil.isEmpty(this.opUserAccount)) {
            return "参数操作员账号不能为空";
        }
        if (StringUtil.isEmpty(this.opUserName)) {
            return "参数操作员名称不能为空";
        }
        if (StringUtil.isEmpty(this.opUserDatetime)) {
            return "参数操作时间不能为空";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        if (this.opUserDatetime.length() != 14 || !pattern.matcher(this.opUserDatetime).matches()) {
            //非数字
            return "操作时间格式不正确";
        }
        try {
            format.parse(this.opUserDatetime);
        } catch (Exception e) {
            e.printStackTrace();
            return "操作时间格式不正确";
        }
        String result;
        if (this.invoices != null && this.invoices.size() > 0) {
            for (InvoiceInfoEntity e : this.invoices) {
                result = e.requestParamCheck();
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ImageCallBackEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", barCode='" + barCode + '\'' +
                ", billType='" + billType + '\'' +
                ", seriNo='" + seriNo + '\'' +
                ", state='" + state + '\'' +
                ", imageCount=" + imageCount +
                ", bussType='" + bussType + '\'' +
                ", opUserAccount='" + opUserAccount + '\'' +
                ", opUserName='" + opUserName + '\'' +
                ", opUserDatetime='" + opUserDatetime + '\'' +
                ", invoices=" + invoices +
                '}';
    }

}
