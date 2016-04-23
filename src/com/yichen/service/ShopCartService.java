package com.yichen.service;

import java.util.Set;

import com.yichen.entity.ShopCart;



public class ShopCartService {
	public float moneySum(Set<ShopCart> shopCarts){
		float sum=0;
		for(ShopCart s:shopCarts){
			sum+=s.getDiscountprice()*s.getAmount();
		}
		return  sum;
	}
}
