package com.baiwang.custom.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias(value = "DATA")
public class HttpResponseModels {


	public String getRetCode() {
		return retCode;
	}


	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}


	public String getRetMsg() {
		return retMsg;
	}


	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}


	@XStreamAlias(value = "retCode")
    private String retCode;


	@XStreamAlias(value = "retMsg")
    private String retMsg;

}
