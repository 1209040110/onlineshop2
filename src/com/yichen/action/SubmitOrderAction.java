package com.yichen.action;

import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.SendAddrDao;
import com.yichen.dao.UserDao;
import com.yichen.entity.SendAddr;
import com.yichen.entity.ShopCart;
import com.yichen.entity.User;
import com.yichen.entity.UserOrder;
import com.yichen.service.BuyProductService;
import com.yichen.util.ConstVar;

public class SubmitOrderAction extends ActionSupport {
	private UserOrder userOrder;
	private String uid;
	private Set<ShopCart> shopCarts;
	private Map<String,Object> session;
	private String addrName;
	private String cnee;
	private String cnee_tel;
	private String postcode;
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
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

	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	public void setCnee_tel(String cnee_tel) {
		this.cnee_tel = cnee_tel;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@Override
	public String execute() throws Exception {
		BuyProductService buyProductService=new BuyProductService();
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User user=(User) session.get("onlineUser");
		if(user!=null&&userOrder.getSendaddrId()==null){
			SendAddr sa=new SendAddr();
			sa.setAddrName(addrName);
			sa.setCnee(cnee);
			sa.setCnee_tel(cnee_tel);
			sa.setPostcode(postcode);
			SendAddrDao sendAddrDao=new SendAddrDao();
			boolean f=sendAddrDao.add(user.getU_id(), sa);
			if(f){
				userOrder.setSendaddrId(sendAddrDao.selectNewAddr(user.getU_id()));
				UserDao ud=new UserDao();
				user=ud.selectById(user.getU_id());
				if(user!=null)
					session.put("onlineUser",user);
			}
		}
		if(user!=null){
			uid=user.getU_id();
			shopCarts=buyProductService.showMyShopCart(uid);
			buyProductService.submitOrder(uid, shopCarts, userOrder.getPaymentmode(),userOrder.getSendaddrId());
			return SUCCESS;
		}else
			return LOGIN;
		
		
		
	}
	
}
