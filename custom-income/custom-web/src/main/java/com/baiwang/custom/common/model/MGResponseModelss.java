package com.baiwang.custom.common.model;

public class MGResponseModelss {
	public MGResponseModelss(String returnCode,String returnMessage){
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }
	 public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnData() {
		return returnData;
	}
	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	private String returnCode;
	 private String  returnData = null;
	 private String  returnMessage;
}
