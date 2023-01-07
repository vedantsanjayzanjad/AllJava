package com.yash.ophs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tab_id")
	private int tabletId;
	
	@Column(name = "tab_name")
	private String tabletName;
	
	@Column(name = "tab_price")
	private double tabletPrice;
	
	@Column(name = "tab_quant")
	private int tabletQuantity;
	
	private double price;
	
	Medicine()
	{
		
	}

	public Medicine(int tabletId, String tabletName, double tabletPrice, int tabletQuantity, double price) {
		super();
		this.tabletId = tabletId;
		this.tabletName = tabletName;
		this.tabletPrice = tabletPrice;
		this.tabletQuantity = tabletQuantity;
		this.price = price;
	}

	public int getTabletId() {
		return tabletId;
	}

	public void setTabletId(int tabletId) {
		this.tabletId = tabletId;
	}

	public String getTabletName() {
		return tabletName;
	}

	public void setTabletName(String tabletName) {
		this.tabletName = tabletName;
	}

	public double getTabletPrice() {
		return tabletPrice;
	}

	public void setTabletPrice(double tabletPrice) {
		this.tabletPrice = tabletPrice;
	}

	public int getTabletQuantity() {
		return tabletQuantity;
	}

	public void setTabletQuantity(int tabletQuantity) {
		this.tabletQuantity = tabletQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
