package com.yichen.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.entity.OrderItem;
import com.yichen.util.ConstVar;
import com.yichen.util.HibernateUtil;


public class OrderItemDao {
	public void addANewItem(String oid,String pid,int amount,float price,Session session){
		OrderItem orderItem=new OrderItem();
		orderItem.setAmount(amount);
		orderItem.setO_id(oid);
		orderItem.setO_time(ConstVar.DATE_FORMAT_DATETIME.format(new Date()));
		orderItem.setP_id(pid);
		orderItem.setPrice(price);
		session.save(orderItem);		
	}
	
	
	public Long pamountsum(String pid,Session session){
		Long r=0l;
		String hql="select sum(oi.amount) from OrderItem oi where oi.p_id=?";
		Query query=session.createQuery(hql);
		query.setString(0,pid);
		r=(Long) query.uniqueResult();
		System.out.println("-----1--"+pid+"----"+r);
		if(r==null) r=0l;
		return r;
	}
	public static void main(String args[]){
		Session session=HibernateUtil.getSessionFactory().openSession();
		String pid="00002";
		System.out.println(new OrderItemDao().pamountsum(pid, session));
	}
}
