package com.yichen.action;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.entity.ShopCart;
import com.yichen.entity.User;
import com.yichen.entity.UserOrder;
import com.yichen.service.BuyProductService;

public class SubmitOrderAction extends ActionSupport {
	private UserOrder userOrder;
	private String uid;
	private Set<ShopCart> shopCarts;
	private Map<String,Object> session;
	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Set<ShopCart> getShopCarts() {
		return shopCarts;
	}

	public void setShopCarts(Set<ShopCart> shopCarts) {
		this.shopCarts = shopCarts;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		BuyProductService buyProductService=new BuyProductService();
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User user=(User) session.get("onlineUser");
		if(user!=null){
			uid=user.getU_id();
			shopCarts=buyProductService.showMyShopCart(uid);
			buyProductService.submitOrder(uid, shopCarts, userOrder.getPaymentmode(),userOrder.getSendaddrId());
			return SUCCESS;
		}else
			return LOGIN;
		
		
		
	}
	
}
