package com.baiwang.custom.common.entity;

import com.baiwang.custom.common.util.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 9:40 2018/7/9
 * @Modified By:
 */
@XStreamAlias(value = "service")
public class ImagePreviewEntity extends BaseEntity {

    @XStreamAlias(value = "serviceid")
    private String serviceId;//请求ID

    @XStreamAlias(value = "userid")
    private String userAccount;

    @XStreamAlias(value = "barcode")
    private String billCode;

    @XStreamAlias(value = "evaluation")
    private String evaluation;

    @XStreamAlias(value = "type")
    private String type;

    @XStreamAlias(value = "candownprint")
    private String candownprint;

    @XStreamAlias(value = "showother")
    private String showother;

    @XStreamAlias(value = "imageop")
    private String imageop;

    @XStreamAlias(value = "commenttype")
    private String commenttype;

    @XStreamAlias(value = "accountdate")
    private String accountdate;

    @XStreamAlias(value = "viewSource")
    private String viewSource;

    public String getViewSource() {
        return viewSource;
    }

    public void setViewSource(String viewSource) {
        this.viewSource = viewSource;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCandownprint() {
        return candownprint;
    }

    public void setCandownprint(String candownprint) {
        this.candownprint = candownprint;
    }

    public String getShowother() {
        return showother;
    }

    public void setShowother(String showother) {
        this.showother = showother;
    }

    public String getImageop() {
        return imageop;
    }

    public void setImageop(String imageop) {
        this.imageop = imageop;
    }

    public String getCommenttype() {
        return commenttype;
    }

    public void setCommenttype(String commenttype) {
        this.commenttype = commenttype;
    }

    public String getAccountdate() {
        return accountdate;
    }

    public void setAccountdate(String accountdate) {
        this.accountdate = accountdate;
    }

    @Override
    public String requestParamCheck(XStream xStream) {
        if (StringUtil.isEmpty(this.serviceId)) {
            return getErrorResult(xStream, "请求ID不能为空");
        }
        if (StringUtil.isEmpty(this.userAccount)) {
            return getErrorResult(xStream, "用户账号不能为空");
        }
        if (StringUtil.isEmpty(this.billCode)) {
            return getErrorResult(xStream, "单据编号不能为空");
        }
        if (StringUtil.isEmpty(this.evaluation)) {
            return getErrorResult(xStream, "退回重扫标识不能为空");
        }
        return null;
    }
}
