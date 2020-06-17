package com.baiwang.custom.common.model;

/**
 * @Description: 记账查库响应体
 * @Author: Guoyongzheng
 * @Date: 2018/10/15-11:59
 */
public class MGAccountResponse {

    private String errorCode;

    private String message;

    private boolean success;


    public MGAccountResponse(String code,String message,boolean flag){
        if (flag) {
            this.errorCode = code;
            this.message =  message;
            this.success = true;
        }else{
            this.errorCode = code;
            this.message = message;
            this.success = false;
        }
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
