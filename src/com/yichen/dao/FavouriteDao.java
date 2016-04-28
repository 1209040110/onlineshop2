package com.yichen.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Delayed;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.entity.Favorite;
import com.yichen.entity.Product;
import com.yichen.entity.ShopCartCompositePK;
import com.yichen.util.ConstVar;
import com.yichen.util.HibernateUtil;

public class FavouriteDao {
	public List<Product> selectAUserAllFav(String uid){
		List<Product> favs=new LinkedList<Product>();
		String hql="from Favorite f where f.shopCpk.u_id=?";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setString(0,uid);
			List<Favorite> favorites=query.list();
			ProductDao pDao=new ProductDao();
			for(Favorite f:favorites){
				Product product=pDao.selectByPId(f.getShopCpk().getP_id());
				favs.add(product);
			}
			tx.commit();
			}catch (RuntimeException e) {
			    if (tx != null) tx.rollback();
			    e.printStackTrace(); // or display error message
			}finally{
				session.close();//一个方法之后就要把session close掉
			}
		return favs;
	}
	
	public boolean addFav(String uid,String pid){
		ShopCartCompositePK CompositePK=new ShopCartCompositePK(uid, pid);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		boolean f=true;
		try{
		tx=session.beginTransaction();
		Favorite favorite=(Favorite) session.get(Favorite.class,CompositePK);
		if(favorite!=null){
			session.close();
			f=false;//这里注意return后finally还会执行,所以上一行要注释掉或者加if(session.isOpen())这个判断
		}
		else{
			Favorite fav=new Favorite();
			fav.setShopCpk(CompositePK);
			fav.setCollecttime(ConstVar.DATE_FORMAT_DATETIME.format(new Date()));
			session.save(fav);
			tx.commit();
		}
		
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
	
	public Long aProFavedSum(String pid,Session session){
		Long r=0l;
		String hql="select count(*) from Favorite f where f.shopCpk.p_id=? ";
		Query query=session.createQuery(hql);
		query.setString(0,pid);
		r=(Long) query.uniqueResult();
		if(r==null) r=0l;
		return r;
	}
	
	public boolean delAfav(String uid,String pid,Session session){
		boolean f=true;
		ShopCartCompositePK CompositePK=new ShopCartCompositePK(uid, pid);
		Favorite fav=(Favorite) session.get(Favorite.class,CompositePK);
		if(fav==null) f=false;
		else{
			session.delete(fav);
		}
		return f;
	}
	
	public static void main(String args[]){
		Session session=HibernateUtil.getSessionFactory().openSession();
		String pid="00001";
		System.out.println(new FavouriteDao().aProFavedSum(pid, session));
	}
	
}
