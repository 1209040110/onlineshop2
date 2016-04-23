package com.yichen.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.entity.SendAddr;
import com.yichen.util.HibernateUtil;


public class SendAddrDao {
	
	public void add(String uid,SendAddr sendAddr){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		String hql="select count(*) from SendAddr sa where sa.uid=?";
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setString(0,uid);
			Long cnt=(Long) query.uniqueResult();
			sendAddr.setUid(uid);
			sendAddr.setAddrId(sendAddr.getUid()+(++cnt));
			session.save(sendAddr);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			session.close();//一个方法之后就要把session close掉
		}
	}
	
	public static void main(String[] args) {
		SendAddr sendAddr=new SendAddr();
		sendAddr.setAddrName("广东梅州");
		sendAddr.setCnee("刘鑫");
		sendAddr.setCnee_tel("13691865928");
		sendAddr.setPostcode("514200");
		SendAddrDao sendAddrDao=new SendAddrDao();
		sendAddrDao.add("597429882", sendAddr);
	}

}
