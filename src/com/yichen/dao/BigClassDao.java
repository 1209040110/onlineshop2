package com.yichen.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.util.HibernateUtil;
import com.yichen.entity.BigClass;
import com.yichen.entity.SmallClass;


public class BigClassDao {
	public List<BigClass> selectAll(){
		String hql="from BigClass";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<BigClass> bigClasses=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			bigClasses=query.list();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
		
		return bigClasses;
	}
	
	
	
	public Set<SmallClass> selectById(String bc_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Set<SmallClass> smallClasses=null;
		try{
			tx=session.beginTransaction();
			BigClass bigClass=(BigClass) session.get(BigClass.class, bc_id);
			smallClasses=bigClass.getSmallClasses();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();
		}
		
		return smallClasses;
	}
	
	public static void main(String args[]){
		BigClassDao bigClassDao=new BigClassDao();
		Collection<SmallClass> smallClasses=bigClassDao.selectById("01");
		Iterator<SmallClass>  it=smallClasses.iterator();
		while(it.hasNext()){
			SmallClass sc=it.next();
			System.out.println(sc.getSc_name());
		}
	}
	
}
