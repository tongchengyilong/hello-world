package com.baiwang.custom.common.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class MGSynchronizationModel {
	private String BillCode;
    public String getBillCode() {
		return BillCode;
	}
	public void setBillCode(String billCode) {
		BillCode = billCode;
	}
	public List<FpdataModel> getENTRYS() {
		return ENTRYS;
	}
	public void setENTRYS(List<FpdataModel> eNTRYS) {
		ENTRYS = eNTRYS;
	}
	private String ImageCount;
	public String getImageCount() {
		return ImageCount;
	}
	public void setImageCount(String imageCount) {
		ImageCount = imageCount;
	}
	private List<FpdataModel> ENTRYS;

}
