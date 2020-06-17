package com.baiwang.custom.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias(value = "serverbody")
public class ServerBodyModel<T> {

    private String servername;//请求名称

    private String servertype;//请求类型

    private List<T> services;//数据列表

    public ServerBodyModel() {
    }

    public ServerBodyModel(String servername, String servertype, List<T> services) {
        this.servername = servername;
        this.servertype = servertype;
        this.services = services;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getServertype() {
        return servertype;
    }

    public void setServertype(String servertype) {
        this.servertype = servertype;
    }

    public List<T> getServices() {
        return services;
    }

    public void setServices(List<T> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        StringBuilder listStr = new StringBuilder();
        if (services != null) {
            for (T t : services) {
                listStr.append(t.toString()).append(" ");
            }
        }
        return "ServerBodyModel{" +
                "servername='" + servername + '\'' +
                ", servertype='" + servertype + '\'' +
                ", services=[" + listStr.toString() +
                "]}";
    }
}
