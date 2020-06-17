package com.baiwang.custom.common.model;

/**
 * @Author: gankunjian
 * @Description:
 * @Date: Created in 15:57 2018/7/10
 * @Modified By:
 */
public class RejectStatusModel {

    private String userAccount;

    private String barCode;

    private boolean flag;
    //添加--Y  预览发起方 1：web端  2:H5端 不传或空值默认为1
    private String viewSource;

    public RejectStatusModel(String userAccount, String barCode, boolean flag,String viewSource) {
        this.userAccount = userAccount;
        this.barCode = barCode;
        this.flag = flag;
        this.viewSource = viewSource;
    }

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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
