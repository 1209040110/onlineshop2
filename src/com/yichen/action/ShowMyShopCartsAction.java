package com.yichen.action;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.entity.ShopCart;
import com.yichen.entity.User;
import com.yichen.service.BuyProductService;

public class ShowMyShopCartsAction extends ActionSupport {
	private String uid;
	private Set<ShopCart>   shopCarts;
	private Map<String,Object> session;
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
	//格式化数字显示
	public String formatDouble(double s){
	DecimalFormat fmt = new DecimalFormat("\u00A4##0.00");
	return fmt.format(s);
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		BuyProductService buyProductService=new BuyProductService();
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User user=(User) session.get("onlineUser");
		if(user!=null){
			uid=user.getU_id();
			shopCarts=buyProductService.showMyShopCart(uid);
			for(ShopCart s:shopCarts){
				s.setDiscountprice(user.getDiscount(user.getRank())*s.getPrice());
			}
			return SUCCESS;
		}else
			return LOGIN;
		
	}

}
