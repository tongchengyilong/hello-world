package com.baiwang.custom.web.base;

import java.io.Serializable;

public class RequestBean implements Serializable{
    private static final long serialVersionUID = -5948896495722278074L;

    private String uuid;

    //	private Object[] args;//必须传输序列化对象，否则会报错
    public RequestBean() {
    }
    public RequestBean(String uuid) {
        this.uuid = uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUuid() {
        return uuid;
    }
}
