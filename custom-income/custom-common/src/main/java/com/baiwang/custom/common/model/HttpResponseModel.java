package com.baiwang.custom.common.model;

/**
 * @Author: gankunjian
 * @Description: 影像平台接口返回值实体
 * @Date: Created in 18:22 2018/6/13
 * @Modified By:
 */
public class HttpResponseModel {

    private boolean success;

    private String errorCode;

    private String message;

    private Object data;

    public HttpResponseModel(boolean success, String errorCode, String message) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
    }

    public HttpResponseModel() {
    }

    public boolean getSuccess() {
        return success;
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
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResponseModel{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
