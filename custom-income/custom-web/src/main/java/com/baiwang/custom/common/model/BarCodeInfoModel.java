package com.baiwang.custom.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias(value = "barCodeInfo")
public class BarCodeInfoModel {
	//单据编号
	@XStreamAlias(value = "barCode")
	private String barCode;
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getImageCount() {
		return imageCount;
	}
	public void setImageCount(String imageCount) {
		this.imageCount = imageCount;
	}
	//单据下的影像数量
	@XStreamAlias(value = "imageCount")
	private String imageCount;
}
