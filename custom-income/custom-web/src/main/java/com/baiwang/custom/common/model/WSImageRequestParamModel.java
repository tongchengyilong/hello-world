package com.baiwang.custom.common.model;

public class WSImageRequestParamModel {
	//单据编号
	private String billCode;
	
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public String getImageCount() {
		return imageCount;
	}
	public void setImageCount(String imageCount) {
		this.imageCount = imageCount;
	}
	public String getBillUser() {
		return billUser;
	}
	public void setBillUser(String billUser) {
		this.billUser = billUser;
	}
	//影像状态 2影像已就绪 或者 1：已扫描待推送
	private String billStatus;
	//单据下的影像数量
	private String imageCount;
	//user_account提交人账号ID
	private String billUser;
}
