package com.baiwang.custom.common.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "DATA")
public class WSRequestParamModels {
	//单据list
	private List<BarCodeInfoModel> barCodeList;
	
	public List<BarCodeInfoModel> getBarCodeList() {
		return barCodeList;
	}

	public void setBarCodeList(List<BarCodeInfoModel> barCodeList) {
		this.barCodeList = barCodeList;
	}

	public String getImageState() {
		return imageState;
	}

	public void setImageState(String imageState) {
		this.imageState = imageState;
	}

	public String getUpdaterID() {
		return updaterID;
	}

	public void setUpdaterID(String updaterID) {
		this.updaterID = updaterID;
	}

	public String getUpdReason() {
		return updReason;
	}

	public void setUpdReason(String updReason) {
		this.updReason = updReason;
	}
	//影像状态 2影像已就绪 或者 1：已扫描待推送
	private String imageState;
	//提交人账号ID
	private String updaterID;
	//提示信息
	private String updReason;
}
