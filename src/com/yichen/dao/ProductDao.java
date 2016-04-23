package com.yichen.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.util.HibernateUtil;
import com.yichen.entity.Product;
import com.yichen.entity.Review;


public class ProductDao {
	//select product  top(limit) ? of a bigclass 
	public List<Product> selectAscTop(String bc_id,int max){
		String hql="from Product as p where p.sc_id like ?";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Product> products=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setString(0,bc_id+"__");
			query.setFirstResult(0);//从第一条记录开始
			query.setMaxResults(max);
			products=query.list();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
		
		return products;
	}
	
	
	//排行榜销量Top n
	public List<Product> selectphbTopn(int n){
		String hql="from Product as p order by p.salesvolume desc";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Product> products=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setFirstResult(0);//从第一条记录开始
			query.setMaxResults(n);
			products=query.list();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
		
		return products;
	}
	
	//select all smallclass product
	public List<Product> selectAllscPro(String sc_id){
		String hql="from Product as p where p.sc_id=?";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Product> products=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setString(0,sc_id);
			products=query.list();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
		
		return products;
	}
	
	
		public boolean updatePro(Product product){
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			boolean f=true;
			try{
				tx=session.beginTransaction();
				session.update(product);
				tx.commit();
			}catch (RuntimeException e) {
			    if (tx != null) tx.rollback();
			    e.printStackTrace(); // or display error message
			    f=false;
			}finally{
				if(session.isOpen())
					session.close();//一个方法之后就要把session close掉
			}
			return f;
		}
	
	//单个产品-需求即是商品详情
	public Product selectByPId(String p_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Product p=null;
		Set<Review>  reviews=new HashSet<Review>();
		String hql="from Review as r where r.p_id=?";    //1对多行不通那就用原始的，逻辑总要是对的
		Query query;
		try{
			tx=session.beginTransaction();
			p=(Product)session.get(Product.class, p_id);
			//reviews=p.getPreviews();
			query=session.createQuery(hql);
			query.setString(0,p_id);
			List<Review> reList=query.list();
			for(Review r:reList){
				reviews.add(r);
			}
			p.setPreviews(reviews);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		
		return p;
	}
	
	public static void main(String args[]){
		ProductDao productDao=new ProductDao();
		System.out.println(productDao.selectByPId("00001").getPreviews().size());
	}
	
}
