package com.yichen.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.entity.SendAddr;
import com.yichen.util.HibernateUtil;


public class SendAddrDao {
	
	public boolean add(String uid,SendAddr sendAddr){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		String hql="select count(*) from SendAddr sa where sa.uid=?";
		boolean f=true;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setString(0,uid);
			Long cnt=(Long) query.uniqueResult();
			if(sendAddr!=null){
				sendAddr.setUid(uid);
				sendAddr.setAddrId(sendAddr.getUid()+(++cnt));
				session.save(sendAddr);
			}else
				f=false;
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
	
	public String selectNewAddr(String uid){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		String hql="select count(*) from SendAddr sa where sa.uid=?";
		String addrId=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setString(0,uid);
			Long cnt=(Long) query.uniqueResult();
			addrId=uid+cnt;
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			if(session.isOpen())
				session.close();//一个方法之后就要把session close掉
		}
		return addrId;
	}
	
	public SendAddr selectAOrderSendAddr(String addrId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		SendAddr sa=null;
		try{
			tx=session.beginTransaction();
			sa=(SendAddr) session.get(SendAddr.class,addrId);
			tx.commit();
		}catch (RuntimeException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			if(session.isOpen())
				session.close();//一个方法之后就要把session close掉
		}
		return sa;
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
