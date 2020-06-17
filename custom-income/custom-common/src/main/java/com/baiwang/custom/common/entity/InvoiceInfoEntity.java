package com.baiwang.custom.common.entity;

import com.baiwang.custom.common.util.StringUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 15:20 2018/6/5
 * @Modified By:
 */
@XStreamAlias(value = "invoice")
public class InvoiceInfoEntity {

    private String invoicestatus;//发票状态

    private String gfsh;//购方税号

    private String gfmc;//购方名称

    private String xfsh;//销方税号

    private String xfmc;//销方名称

    private String fpdm;//发票代码

    private String fphm;//发票号码

    private BigDecimal je;//金额

    private BigDecimal se;//税额

    private BigDecimal hjje;//价税合计

    private String kprq;//开票日期

    private String mw;//密文   与密码区相同

    private String invtype;//发票类型

    private String agreement;

    private String project;

    private String branchcode;//公司编码

    private String interbarcode;

    private String machinecode;//机器编码

    private String mmq;//密码区

    public String getInvoicestatus() {
        return invoicestatus;
    }

    public void setInvoicestatus(String invoicestatus) {
        this.invoicestatus = invoicestatus;
    }

    public String getGfsh() {
        return gfsh;
    }

    public void setGfsh(String gfsh) {
        this.gfsh = gfsh;
    }

    public String getGfmc() {
        return gfmc;
    }

    public void setGfmc(String gfmc) {
        this.gfmc = gfmc;
    }

    public String getXfsh() {
        return xfsh;
    }

    public void setXfsh(String xfsh) {
        this.xfsh = xfsh;
    }

    public String getXfmc() {
        return xfmc;
    }

    public void setXfmc(String xfmc) {
        this.xfmc = xfmc;
    }

    public String getFpdm() {
        return fpdm;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public BigDecimal getSe() {
        return se;
    }

    public void setSe(BigDecimal se) {
        this.se = se;
    }

    public BigDecimal getHjje() {
        return hjje;
    }

    public void setHjje(BigDecimal hjje) {
        this.hjje = hjje;
    }

    public String getKprq() {
        return kprq;
    }

    public void setKprq(String kprq) {
        this.kprq = kprq;
    }

    public String getMw() {
        return mw;
    }

    public void setMw(String mw) {
        this.mw = mw;
    }

    public String getInvtype() {
        return invtype;
    }

    public void setInvtype(String invtype) {
        this.invtype = invtype;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getInterbarcode() {
        return interbarcode;
    }

    public void setInterbarcode(String interbarcode) {
        this.interbarcode = interbarcode;
    }

    public String getMachinecode() {
        return machinecode;
    }

    public void setMachinecode(String machinecode) {
        this.machinecode = machinecode;
    }

    public String getMmq() {
        return mmq;
    }

    public void setMmq(String mmq) {
        this.mmq = mmq;
    }

    public String requestParamCheck() {
        if (StringUtil.isEmpty(this.invoicestatus)) {
            return "发票状态不能为空";
        }
        if (StringUtil.isEmpty(this.gfsh)) {
            return "购方税号不能为空";
        }
        if (StringUtil.isEmpty(this.gfmc)) {
            return "购方名称不能为空";
        }
        if (StringUtil.isEmpty(this.xfsh)) {
            return "销方税号不能为空";
        }
        if (StringUtil.isEmpty(this.xfmc)) {
            return "销方名称不能为空";
        }
        if (StringUtil.isEmpty(this.fpdm)) {
            return "发票代码不能为空";
        }
        if (StringUtil.isEmpty(this.fphm)) {
            return "发票号码不能为空";
        }
        if (this.je == null) {
            return "金额不能为空";
        }
        if (this.se == null) {
            return "税额不能为空";
        }
        if (this.hjje == null) {
            return "价税合计不能为空";
        }
        if (StringUtil.isEmpty(this.kprq)) {
            return "开票日期不能为空";
        }
        if (StringUtil.isEmpty(this.mw)) {
            return "密文不能为空";
        }
        if (StringUtil.isEmpty(this.invtype)) {
            return "发票类型不能为空";
        }
        if (StringUtil.isEmpty(this.agreement)) {
            return "agreement不能为空";
        }
        if (StringUtil.isEmpty(this.project)) {
            return "project不能为空";
        }
        if (StringUtil.isEmpty(this.branchcode)) {
            return "公司编码不能为空";
        }
        if (StringUtil.isEmpty(this.interbarcode)) {
            return "interbarcode不能为空";
        }
        if (StringUtil.isEmpty(this.machinecode)) {
            return "机器编码不能为空";
        }
        if (StringUtil.isEmpty(this.mmq)) {
            return "密码区不能为空";
        }
        if (!this.mmq.equals(this.mw)) {
            return "密文与密码区不同";
        }
        return null;
    }

    @Override
    public String toString() {
        return "InvoiceInfoEntity{" +
                "invoicestatus='" + invoicestatus + '\'' +
                ", gfsh='" + gfsh + '\'' +
                ", gfmc='" + gfmc + '\'' +
                ", xfsh='" + xfsh + '\'' +
                ", xfmc='" + xfmc + '\'' +
                ", fpdm='" + fpdm + '\'' +
                ", fphm='" + fphm + '\'' +
                ", je=" + je +
                ", se=" + se +
                ", hjje=" + hjje +
                ", kprq='" + kprq + '\'' +
                ", mw='" + mw + '\'' +
                ", invtype='" + invtype + '\'' +
                ", agreement='" + agreement + '\'' +
                ", project='" + project + '\'' +
                ", branchcode='" + branchcode + '\'' +
                ", interbarcode='" + interbarcode + '\'' +
                ", machinecode='" + machinecode + '\'' +
                ", mmq='" + mmq + '\'' +
                '}';
    }
}
