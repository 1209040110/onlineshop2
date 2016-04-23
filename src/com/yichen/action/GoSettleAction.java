package com.yichen.action;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.ShopCartDao;
import com.yichen.dao.UserDao;
import com.yichen.entity.ShopCart;
import com.yichen.entity.User;
import com.yichen.service.BuyProductService;
import com.yichen.service.ShopCartService;
import com.yichen.util.ConstVar;

public class GoSettleAction extends ActionSupport {
	private Set<ShopCart>   shopCarts;
	private User user;
	private Map<String,Object> session;
	private float moneysum;//不含运费
	private float freight;
	public Set<ShopCart> getShopCarts() {
		return shopCarts;
	}
	public void setShopCarts(Set<ShopCart> shopCarts) {
		this.shopCarts = shopCarts;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public float getMoneysum() {
		return moneysum;
	}
	public void setMoneysum(float moneysum) {
		this.moneysum = moneysum;
	}
		public float getFreight() {
		return freight;
	}
	public void setFreight(float freight) {
		this.freight = freight;
	}
		//格式化数字显示
		public String formatDouble(double s){
		DecimalFormat fmt = new DecimalFormat("\u00A4##0.00");
		return fmt.format(s);
		}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		BuyProductService buyProductService=new BuyProductService();
		user=(User) session.get("onlineUser");
		ShopCartService shopCartService=new ShopCartService();
		if(user!=null){
			String uid=user.getU_id();
			shopCarts=buyProductService.showMyShopCart(uid);
			for(ShopCart s:shopCarts){
				s.setDiscountprice(user.getDiscount(user.getRank())*s.getPrice());
			}
			moneysum=shopCartService.moneySum(shopCarts);
			if(moneysum>=ConstVar.FREIGHT_FREE_MIN)
				freight=0f;
			else
				freight=ConstVar.FREIGHT_STANDARD;
			return SUCCESS;
		}else
			return LOGIN;
		
	}
	
}
