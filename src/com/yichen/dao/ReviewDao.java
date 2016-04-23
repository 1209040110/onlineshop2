package com.yichen.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.yichen.entity.Review;
import com.yichen.util.ConstVar;
import com.yichen.util.HibernateUtil;

public class ReviewDao {
	
	public List<Review> selectByPId(String p_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Review>  reviews=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("from Review as r where r.p_id=? ");
			query.setString(0,p_id);
			reviews=query.list();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		
		return reviews;
	}
	
	
	public boolean addReview(String uid,String pid,String content,float score){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Review review=new Review();
		review.setUid(uid);
		System.out.println("-------"+pid);
		review.setP_id(pid);
		review.setR_content(content);
		review.setScore(score);
		String datetime=ConstVar.DATE_FORMAT_DATETIME.format(new Date());
		review.setR_id(pid+datetime);
		review.setR_time(datetime);
		boolean f=true;
		try{
			tx=session.beginTransaction();
			session.save(review);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		    f=false;
		}finally{
			session.close();
		}
		return f;
	}
	
	public static void main(String args[]){
		ReviewDao rDao=new ReviewDao();
		System.out.println(rDao.selectByPId("00001").size());
	}
	
}
