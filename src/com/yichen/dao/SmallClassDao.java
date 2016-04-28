package com.yichen.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.entity.Product;
import com.yichen.entity.SmallClass;
import com.yichen.util.HibernateUtil;

public class SmallClassDao {
	
	//传进来的是用户小类id的list
	public Set<SmallClass> selectScsByScs(Session session,Set<String> scids){
		Set<SmallClass>  scset=new HashSet<SmallClass>();
		for(String scid:scids){
			SmallClass sc=(SmallClass) session.get(SmallClass.class,scid);
			scset.add(sc);
		}
		return scset;
	}
	
	
	public List<SmallClass> selectAllSc(){
		String hql="from SmallClass";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<SmallClass> scs=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			scs=query.list();
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			if(session.isOpen())
				session.close();//一个方法之后就要把session close掉
		}
		
		return scs;
	}
}
