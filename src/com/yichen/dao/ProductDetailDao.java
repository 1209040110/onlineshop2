package com.yichen.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.entity.ProductDetail;
import com.yichen.util.HibernateUtil;

public class ProductDetailDao {
	public ProductDetail selectByPId(String p_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		ProductDetail pd=null;
		try{
			tx=session.beginTransaction();
			pd=(ProductDetail) session.get(ProductDetail.class, p_id);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		
		return pd;
	}
	public static void main(String args[]){
		ProductDetailDao pDetailDao=new ProductDetailDao();
		System.out.println(pDetailDao.selectByPId("00001").getManufacturer());
	}
}
