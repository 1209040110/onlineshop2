package com.yichen.entity;

import java.io.Serializable;

public class ShopCart implements Serializable {
	private ShopCartCompositePK shopCpk;
	private int amount;
	private String shoptime;
	private float price;
	private String pname;
	private float discountprice;
	
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public ShopCartCompositePK getShopCpk() {
		return shopCpk;
	}
	public void setShopCpk(ShopCartCompositePK shopCpk) {
		this.shopCpk = shopCpk;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getShoptime() {
		return shoptime;
	}
	public void setShoptime(String shoptime) {
		this.shoptime = shoptime;
	}
	public float getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(float discountprice) {
		this.discountprice = discountprice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shopCpk == null) ? 0 : shopCpk.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopCart other = (ShopCart) obj;
		if (shopCpk == null) {
			if (other.shopCpk != null)
				return false;
		} else if (!shopCpk.equals(other.shopCpk))
			return false;
		return true;
	}
	

	
}
