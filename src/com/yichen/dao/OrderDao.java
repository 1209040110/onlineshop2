package com.yichen.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import com.yichen.entity.Product;
import com.yichen.entity.Review;
import com.yichen.entity.UserOrder;
import com.yichen.util.HibernateUtil;

public class OrderDao {
	public String getOid(){
		//订单号=yyyyMMdd+10000
		//每天的流水号从10000开始
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		session.beginTransaction();
		String oid=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		String hql="select max(o_id) from UserOrder o ";
		String maxoid=(String)session.createQuery(hql).uniqueResult();
		int i;
		if(maxoid!=null&&maxoid.startsWith(date)){
			int lsh=Integer.parseInt(maxoid.substring(maxoid.length()-5,maxoid.length()));
			System.out.println(maxoid.substring(maxoid.length()-5,maxoid.length()));
			lsh++;
			oid=date+lsh;
			//System.out.println(oid);
			return oid;
		}else{
			String retu=date+"10000";
			return retu;
		}
		
		
		

	}
	
	
	public void addANewOrder(UserOrder userOrder){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			session.save(userOrder);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
	}
	
	public int selectAOrderStatus(String o_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int status=0;
		try{
			tx=session.beginTransaction();
			UserOrder userOrder=(UserOrder) session.get(UserOrder.class,o_id);
			if(userOrder!=null) 
				status=userOrder.getO_status();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		return status;
	}
	public void updateAOrderStatus(String o_id,int status){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx=session.beginTransaction();
			UserOrder userOrder=(UserOrder) session.get(UserOrder.class,o_id);
			if(userOrder!=null){
			userOrder.setO_status(status);
			session.update(userOrder);
			}
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
	}
	public static void main(String args[]){
		OrderDao orderDao=new OrderDao();
		//orderDao.addANewOrder();
		System.out.println();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new Date());
		System.out.print(date);
	}
	
	
}
