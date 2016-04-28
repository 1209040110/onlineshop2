package com.yichen.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.dao.ProductDao;
import com.yichen.dao.ProductDetailDao;
import com.yichen.entity.Product;
import com.yichen.entity.ProductDetail;
import com.yichen.util.HibernateUtil;

public class ProductService {
	public boolean addAPro(Product p,ProductDetail pd){
		boolean f=true;
		Session session=HibernateUtil.getSessionFactory().openSession();
		ProductDao pdao=new ProductDao();
		ProductDetailDao pdd=new ProductDetailDao();
		Transaction tx=null;
		try{
		tx=session.beginTransaction();
		session.save(p);
		session.save(pd);
		tx.commit();
		}
		catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		    f=false;
		}finally{
			if(session.isOpen())
				session.close();//一个方法之后就要把session close掉
		}
		return f;
	}
}
