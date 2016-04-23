package com.yichen.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yichen.dao.OrderDao;
import com.yichen.dao.OrderItemDao;
import com.yichen.dao.ProductDao;
import com.yichen.dao.ShopCartDao;
import com.yichen.dao.UserDao;
import com.yichen.entity.Product;
import com.yichen.entity.ShopCart;
import com.yichen.entity.User;
import com.yichen.entity.UserOrder;
import com.yichen.util.ConstVar;
import com.yichen.util.HibernateUtil;

public class BuyProductService {
//加入购物车 ->我的购物车预览(购物车结算)->去结算(立即购买)->提交订单
	
//取消订单
	ShopCartDao shopCartDao=new ShopCartDao();
	
	//加入购物车逻辑
	public void addShopCart(String uid,String p_id,int amount,float price)
	{
		ShopCart shopCart=shopCartDao.checkHav(uid, p_id);
		if(shopCart==null)
			shopCartDao.addANewRecord(uid, p_id, amount,price);
		else
			shopCartDao.updateAmount(shopCart, shopCart.getAmount()+amount);
		
	}
	
	//我的购物车预览
	public Set<ShopCart> showMyShopCart(String uid){
		ShopCart shopCart=null;
		Set<ShopCart> shopCarts=shopCartDao.selectAUserAllShopCart(uid);
		StringBuilder pname=new StringBuilder();
		
		ProductDao productDao=new ProductDao();
		for(ShopCart s:shopCarts){
			System.out.println(s);
			pname.append(productDao.selectByPId(s.getShopCpk().getP_id()).getP_name());
			s.setPname(pname.toString());
			pname.setLength(0);
			
		}
		return shopCarts;
		
	}
	
	//去结算==立即购买  业务逻辑
	public Set<ShopCart> goSettle(String uid)
	{
		return showMyShopCart(uid);
	}
	
	
	//提交订单业务逻辑
	public void submitOrder(String uid,Set<ShopCart> shopCarts,String paymentmode,String sendAddrId) {
		//System.out.println(uid);
		//System.out.println(shopCarts);
		//System.out.println(paymentmode);
		//System.out.println(sendAddrId);
		OrderDao orderDao=new OrderDao();
		UserOrder uOrder=new UserOrder();
		uOrder.setPaymentmode(paymentmode);
		uOrder.setSendaddrId(sendAddrId);
		String oid=orderDao.getOid();
		uOrder.setO_id(oid);
		uOrder.setU_id(uid);
		String datetime = ConstVar.DATE_FORMAT_DATETIME.format(new Date());
		uOrder.setO_time(datetime);
		uOrder.setO_status(ConstVar.ORDER_STATUS_WAITPAY);
		float totalprice=0;
		UserDao userDao=new UserDao();
		User user=userDao.selectById(uid);
		OrderItemDao orderItemDao=new OrderItemDao();
		float discount=user.getDiscount(user.getRank());
		for(ShopCart s:shopCarts){
			//System.out.println("----");
			totalprice+=s.getAmount()*s.getPrice();
			orderItemDao.addANewItem(oid,s.getShopCpk().getP_id(), s.getAmount(), s.getPrice());
		}
		totalprice*=discount;
		uOrder.setTotalprice(totalprice);
		if(totalprice>=ConstVar.FREIGHT_FREE_MIN)
			uOrder.setFreight(0);
		else
			uOrder.setFreight(ConstVar.FREIGHT_STANDARD);
		orderDao.addANewOrder(uOrder);
		shopCartDao.deleteAUserShopCarts(uid);
	}
	
	
	//取消订单业务逻辑
	public boolean cancelOrder(String o_id){
		OrderDao orderDao=new OrderDao();
		int status=orderDao.selectAOrderStatus(o_id);
		if(status!=1) return false;//包含这个订单不存在的状况
		orderDao.updateAOrderStatus(o_id,ConstVar.ORDER_STATUS_CANCELED);
		return true;
	}
}
