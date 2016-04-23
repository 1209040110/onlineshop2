package com.yichen.service;

import com.yichen.dao.FavouriteDao;
import com.yichen.dao.ProductDao;
import com.yichen.entity.Product;


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
}
