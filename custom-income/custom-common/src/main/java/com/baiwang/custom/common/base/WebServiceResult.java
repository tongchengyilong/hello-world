package com.baiwang.custom.common.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.baiwang.bop.request.impl.invoice.common.RequestThreadLocal;

import java.util.ArrayList;
import java.util.List;

/**
* WebService返回结果<p>
* @author Li Jiayi
* @version 2018年7月26日 下午6:04:40
* @param <T>
*/

public class WebServiceResult<T> {
    private static final long serialVersionUID = -7532190660864165247L;
    @JSONField
    private boolean success = true;
    @JSONField
    private String errorCode = null;
    @JSONField
    private String message = null;
    private String requestID = null;

    private Long total = Long.valueOf(0L);
    @JSONField
    private List<T> data = new ArrayList();

    public WebServiceResult() {
        String uuid = RequestThreadLocal.getUuid();
        this.requestID = uuid;
    }

    public WebServiceResult(String code,String message){
        this.errorCode = code;
        this.message = message;
    }

    public WebServiceResult(String code, String message, Boolean success){
        if (success){
            this.errorCode = code;
            this.message = message;
            this.success = success;
        }else{
            this.errorCode = code;
            this.message = message;
            this.success = false;
        }
    }

    public WebServiceResult(List<T> data) {
        if(data != null && data.size() > 0) {
            this.data = data;
            this.total = Long.valueOf((long)data.size());
            String uuid = RequestThreadLocal.getUuid();
            this.requestID = uuid;
        }
    }

    public WebServiceResult(List<T> data, Long total) {
        if(data != null && data.size() > 0) {
            this.data = data;
            this.total = total;
            String uuid = RequestThreadLocal.getUuid();
            this.requestID = uuid;
        }
    }

    public WebServiceResult(T data) {
        this.data.add(data);
        this.total = Long.valueOf(1L);
        String uuid = RequestThreadLocal.getUuid();
        this.requestID = uuid;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return this.data;
    }

    public String getRequestID() {
        return this.requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void addData(List<T> data) {
        if(data != null && data.size() > 0) {
            this.data = data;
            this.total = Long.valueOf((long)data.size());
            String uuid = RequestThreadLocal.getUuid();
            this.requestID = uuid;
        }

    }

    public void addData(T data) {
        this.data.add(data);
        this.total = Long.valueOf(1L);
        String uuid = RequestThreadLocal.getUuid();
        this.requestID = uuid;
    }

}
