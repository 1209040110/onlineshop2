package com.yichen.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yichen.dao.FavouriteDao;
import com.yichen.dao.ProductDao;
import com.yichen.entity.Product;
import com.yichen.util.HibernateUtil;


public class FavoriteService {
	public boolean addAFavorite(String uid,String pid){
		FavouriteDao fDao=new FavouriteDao();
		boolean f1=fDao.addFav(uid, pid);
		if(!f1)
			return false;
		ProductDao pDao=new ProductDao();
		Product product=pDao.selectByPId(pid);
		product.setRq(product.getRq()+1);
		boolean f2=pDao.updatePro(product);
		return f2;
	}
	
	
	
	public boolean delAFav(String uid,String pid){
		boolean f=true;
		FavouriteDao fd=new FavouriteDao();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			f=fd.delAfav(uid, pid, session);
			System.out.println("35--"+f);
			if(f){
				ProductDao pd=new ProductDao();
				Product p=pd.selectByPId(pid);
				p.setRq(p.getRq()-1);
				pd.updatePro(p);
			}
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
}
