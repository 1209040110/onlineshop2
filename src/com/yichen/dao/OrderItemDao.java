package com.yichen.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.entity.OrderItem;
import com.yichen.util.ConstVar;
import com.yichen.util.HibernateUtil;


public class OrderItemDao {
	public void addANewItem(String oid,String pid,int amount,float price){
		OrderItem orderItem=new OrderItem();
		orderItem.setAmount(amount);
		orderItem.setO_id(oid);
		orderItem.setO_time(ConstVar.DATE_FORMAT_DATETIME.format(new Date()));
		orderItem.setP_id(pid);
		orderItem.setPrice(price);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			session.save(orderItem);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		
	}
}
