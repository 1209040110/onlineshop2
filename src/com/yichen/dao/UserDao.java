package com.yichen.dao;


import java.util.Date;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.util.ConstVar;
import com.yichen.util.HibernateUtil;
import com.yichen.util.Md5;
import com.yichen.entity.Review;
import com.yichen.entity.SendAddr;
import com.yichen.entity.User;


public class UserDao {
	
	
	
	public Set<Review> selectReById(String u_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		User u=null;
		Set<Review> reviews=null;
		try{
			tx=session.beginTransaction();
			u=(User)session.get(User.class,u_id);
			reviews=u.getReviews();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		
		return reviews;
	}
	
	public Set<SendAddr> selectSAById(String u_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		User u=null;
		Set<SendAddr> sendAddrs=null;
		try{
			tx=session.beginTransaction();
			u=(User)session.get(User.class,u_id);
			sendAddrs=u.getSendAddrs();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		
		return sendAddrs;
	}
	
	public User selectById(String u_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		User u=null;
		try{
			tx=session.beginTransaction();
			u=(User)session.get(User.class,u_id);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			if(session.isOpen())
				session.close();
		}
		
		return u;
	}
	
	public User checkLogin(String uname,String upwd)
	{
		
		User user=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			
			tx=session.beginTransaction();
			User utmp=(User)session.get(User.class,uname);
			if(utmp!=null&&utmp.getPwd().equals(Md5.MD5Encrypt(upwd)))
				user=utmp;
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		return user;
	}
	
	
	public boolean addANewUser(User user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		if(user.getSex().equals("female"))
			user.setSex("女");
		else
			user.setSex("男");
		user.setCredit(0);
		user.setRank(1);
		user.setRegtime(ConstVar.DATE_FORMAT_DATETIME.format(new Date()));
		user.setPwd(Md5.MD5Encrypt(user.getPwd()));
		try{
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		return true;
	}
	
	public static void main(String args[]){
		UserDao userDao=new UserDao();
		Set<Review> reviews=userDao.selectReById("597429882");
		for(Review r:reviews){
			System.out.println(r.getR_content());
		}
		Set<SendAddr> sendAddrs=userDao.selectSAById("597429882");
		for(SendAddr sa:sendAddrs){
			System.out.println(sa.getAddrName());
		}
		
		
		
	}
	
}
