package com.baiwang.custom.common.model;

import org.apache.poi.ss.formula.functions.T;

/**
 * @Description: 响应体封装
 * @Author: Guoyongzheng
 * @Date: 2018/10/23-9:04
 */
public class MGRetuenResponse {
    private String RETURN_CODE;
    private String RETURN_MESSAGE;
    private T RETURN_DATA;

    public String getRETURN_CODE() {
        return RETURN_CODE;
    }

    public void setRETURN_CODE(String RETURN_CODE) {
        this.RETURN_CODE = RETURN_CODE;
    }

    public String getRETURN_MESSAGE() {
        return RETURN_MESSAGE;
    }

    public void setRETURN_MESSAGE(String RETURN_MESSAGE) {
        this.RETURN_MESSAGE = RETURN_MESSAGE;
    }

    public T getRETURN_DATA() {
        return RETURN_DATA;
    }

    public void setRETURN_DATA(T RETURN_DATA) {
        this.RETURN_DATA = RETURN_DATA;
    }
}
