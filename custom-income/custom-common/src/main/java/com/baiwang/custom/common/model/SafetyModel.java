package com.baiwang.custom.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "safety")
public class SafetyModel {

    private String clientcode; //客户端编码

    private String servicecode;//服务端编码

    private String time;//请求时间 YYYYMMDDHHMMSS

    private String ticket;//请求包编号

    private String safename;//

    public SafetyModel() {
    }

    public SafetyModel(String clientcode, String servicecode, String time, String ticket, String safename) {
        this.clientcode = clientcode;
        this.servicecode = servicecode;
        this.time = time;
        this.ticket = ticket;
        this.safename = safename;
    }

    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode;
    }

    public String getServicecode() {
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        this.servicecode = servicecode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSafename() {
        return safename;
    }

    public void setSafename(String safename) {
        this.safename = safename;
    }

    @Override
    public String toString() {
        return "SafetyModel{" +
                "clientcode='" + clientcode + '\'' +
                ", servicecode='" + servicecode + '\'' +
                ", time='" + time + '\'' +
                ", ticket='" + ticket + '\'' +
                ", safename='" + safename + '\'' +
                '}';
    }
}
