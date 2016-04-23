package com.yichen.service;

import java.util.List;

import com.yichen.dao.FavouriteDao;
import com.yichen.dao.UserDao;
import com.yichen.entity.Product;
import com.yichen.entity.User;

public class UserCenterService {
	public User selectAUserAllInfo(String uid){
		User user=null;
		UserDao uDao=new UserDao();
		user=uDao.selectById(uid);
		FavouriteDao fDao=new FavouriteDao();
		List<Product> favpros=fDao.selectAUserAllFav(uid);
		user.setFavpros(favpros);
		return user;
	}
	public static void main(String args[]){
		UserCenterService ser=new UserCenterService();
		User u=ser.selectAUserAllInfo("597429882");
		
	}
}
