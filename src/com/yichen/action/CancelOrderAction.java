package com.yichen.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yichen.service.BuyProductService;

public class CancelOrderAction extends ActionSupport {
	private String uid;
	private String oid;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	@Override
	public String execute() throws Exception {
		BuyProductService buyProductService=new BuyProductService();
		buyProductService.cancelOrder(oid);
		return SUCCESS;
	}
	
}
