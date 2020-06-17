package com.baiwang.custom.common.model;

public class FpmxlistModel {

	// 明细标识

	public String getMXID() {
		return MXID;
	}

	public void setMXID(String mXID) {
		MXID = mXID;
	}

	public String getLINE_NUM() {
		return LINE_NUM;
	}

	public void setLINE_NUM(String lINE_NUM) {
		LINE_NUM = lINE_NUM;
	}

	public String getCommodityCode() {
		return CommodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		CommodityCode = commodityCode;
	}

	public String getCommodityName() {
		return CommodityName;
	}

	public void setCommodityName(String commodityName) {
		CommodityName = commodityName;
	}

	public String getSpecModel() {
		return SpecModel;
	}

	public void setSpecModel(String specModel) {
		SpecModel = specModel;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		UnitPrice = unitPrice;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getTaxRate() {
		return TaxRate;
	}

	public void setTaxRate(String taxRate) {
		TaxRate = taxRate;
	}

	public String getTax() {
		return Tax;
	}

	public void setTax(String tax) {
		Tax = tax;
	}

	private String MXID;
	// 行号

	private String LINE_NUM;
	// 商品编码

	private String CommodityCode;
	// 商品名称

	private String CommodityName;
	// 商品规格编号

	private String SpecModel;
	// 商品单位

	private String Unit;
	// 商品数量

	private String Quantity;
	// 商品单价

	private String UnitPrice;
	// 商品金额

	private String Amount;
	// 商品税率

	private String TaxRate;
	// 商品税额

	private String Tax;



}
