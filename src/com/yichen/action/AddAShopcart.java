package com.yichen.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yichen.service.BuyProductService;

public class AddAShopcart extends ActionSupport {
	private String uid;
	private String pid;
	private int amount;
	private float price;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public void  addAShopCart() {
		BuyProductService buyProductService=new BuyProductService();
		buyProductService.addShopCart(uid, pid, amount, price);
		
	}

}
