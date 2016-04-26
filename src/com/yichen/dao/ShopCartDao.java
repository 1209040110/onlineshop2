package com.yichen.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.entity.ShopCart;
import com.yichen.entity.ShopCartCompositePK;
import com.yichen.util.HibernateUtil;

public class ShopCartDao {
	
	public ShopCart checkHav(String u_id,String p_id){
		ShopCart shopCart=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		ShopCartCompositePK  sPk=new ShopCartCompositePK(u_id,p_id);
		try{
		tx=session.beginTransaction();
		shopCart=(ShopCart) session.get(ShopCart.class,sPk);
		tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
		return shopCart;
	}

	
	public void updateAmount(ShopCart shopCart,int amount){
		ShopCart myshopCart=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		myshopCart=(ShopCart) session.get(ShopCart.class,shopCart.getShopCpk());
		myshopCart.setAmount(amount);
		session.save(myshopCart);
		tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
	}
	
	
	public void addANewRecord(String u_id,String p_id,int amount,float price){
		ShopCart shopCart=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		ShopCartCompositePK  sPk=new ShopCartCompositePK(u_id,p_id);
		shopCart=new ShopCart();
		shopCart.setAmount(amount);
		shopCart.setPrice(price);
		shopCart.setShopCpk(sPk);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String datetime = sdf.format(new Date());
		shopCart.setShoptime(datetime);
		try{
		tx=session.beginTransaction();
		session.save(shopCart);
		tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
	}
	
	public Set<ShopCart> selectAUserAllShopCart(String uid){
		Set<ShopCart> shopCarts=null;
		String hql="from ShopCart s where s.shopCpk.u_id=?";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			Query query=session.createQuery(hql);
			query.setString(0,uid);
			List<ShopCart> shopCartsList=query.list();
			System.out.println(shopCartsList);
			shopCarts=new HashSet<ShopCart>(shopCartsList);
			
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
		
		return shopCarts;
	}
	
	
	public void deleteAUserShopCarts(String uid,Session session){
		String hql="delete ShopCart as s where s.shopCpk.u_id=? ";
			Query query=session.createQuery(hql);
			query.setString(0,uid);
			query.executeUpdate();
	}
}
