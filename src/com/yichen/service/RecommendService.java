package com.yichen.service;

import java.util.Collections;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.Transaction;






import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.yichen.dao.FavouriteDao;
import com.yichen.dao.OrderDao;
import com.yichen.dao.OrderItemDao;
import com.yichen.dao.ProductDao;
import com.yichen.dao.SmallClassDao;

import com.yichen.entity.Favorite;
import com.yichen.entity.OrderItem;
import com.yichen.entity.Product;
import com.yichen.entity.SmallClass;
import com.yichen.entity.UserOrder;
import com.yichen.util.HibernateUtil;

public class RecommendService {
	//得分第1的小类推荐2个商品     得分第2的小类推荐2个商品
	public Product[] guessyourfav(String uid){
		Product[] parray=new Product[4];
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			SmallClassDao scd=new SmallClassDao();
			ProductDao pd=new ProductDao();
			FavouriteDao fd=new FavouriteDao();
			OrderItemDao oidao=new OrderItemDao();
			OrderDao od=new OrderDao();
			HashSet<String> scids=new HashSet<String>();
			List<UserOrder> uostmp=od.selectAUserOrders(uid);
			for(UserOrder o:uostmp){
				Set<OrderItem> oistmp=o.getOrderItems();
				for(OrderItem oi:oistmp){
					scids.add(pd.selectByPId(oi.getP_id()).getSc_id());
				}
			}
			List<Product> AUserAllFavs=fd.selectAUserAllFav(uid);
			for(Product p:AUserAllFavs){
				scids.add(p.getSc_id());
			}
			Set<SmallClass> ssSet=scd.selectScsByScs(session, scids);
			List<SmallClass> sList=new LinkedList<SmallClass>();
			for(SmallClass sc:ssSet)
				sList.add(sc);
			float scoretmp;
			for(SmallClass sc:sList){
				List<Product> ps=pd.selectAllscPro(sc.getSc_id());
				scoretmp=0.0f;
				for(Product p:ps)
					scoretmp+=p.getSalesvolume()+p.getRq();
				sc.setRecomscore(scoretmp);
			}
			for(SmallClass sc:sList)
				System.out.println("---------0---"+sc.getSc_id()+"---"+sc.getRecomscore());
			System.out.println("---------1"+sList);
			Collections.sort(sList);
			System.out.println("---------2"+sList);
			String top1scid=sList.get(0).getSc_id();
			System.out.println("---------3"+top1scid);
			String top2scid=sList.get(1).getSc_id();
			System.out.println("---------4"+top2scid);
			if(top1scid!=null){
				List<Product> pList1=pd.selectAllscProForScore(session,top1scid);
				Collections.sort(pList1);
				parray[0]=pList1.get(0);
				parray[1]=pList1.get(1);
			}
			if(top2scid!=null){
				List<Product> pList2=pd.selectAllscProForScore(session,top2scid);
				Collections.sort(pList2);
				parray[2]=pList2.get(0);
				parray[3]=pList2.get(1);
			}
			tx.commit();
		}catch (RuntimeException e) {
		   // if (tx != null) tx.rollback();
		    e.printStackTrace(); // or display error message
		}finally{
			if(session.isOpen())
				session.close();//一个方法之后就要把session close掉
		}
		return parray;
	}
}
