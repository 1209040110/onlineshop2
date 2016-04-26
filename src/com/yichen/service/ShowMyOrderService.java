package com.yichen.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yichen.dao.OrderDao;
import com.yichen.dao.ProductDao;
import com.yichen.dao.SendAddrDao;
import com.yichen.entity.OrderItem;
import com.yichen.entity.Product;
import com.yichen.entity.UserOrder;

public class ShowMyOrderService {
	List<UserOrder> uolist=null;
	OrderDao od;
	String uid;
	public ShowMyOrderService(String uid){
		this.od=new OrderDao();
		this.uid=uid;
		this.uolist=od.selectAUserOrders(uid);
	}
	public List<UserOrder> showMyOrders(){
		
		
		return uolist;
	}
	
	public Map<String,List<String>> selectAUserOrdersImgs(){
		Map<String,List<String>> imgsMap=new HashMap<String, List<String>>();
		Set<OrderItem> ois;
		ProductDao pd=new ProductDao();
		for(UserOrder o:uolist){
			ois=o.getOrderItems();
			List<String> imgs=new LinkedList<String>();
			for(OrderItem oi:ois){
				imgs.add(pd.selectByPId(oi.getP_id()).getSmallimg());
			}
			imgsMap.put(o.getO_id(),imgs);//map<k,v>  v存的是引用
		}
		return imgsMap;
		
		
	}
	
	public Map<String,List<Product>> selectAUserOrdersProducts(){
		Map<String,List<Product>> pMap=new HashMap<String, List<Product>>();
		Set<OrderItem> ois;
		ProductDao pd=new ProductDao();
		for(UserOrder o:uolist){
			ois=o.getOrderItems();
			List<Product> ps=new LinkedList<Product>();
			for(OrderItem oi:ois){
				ps.add(pd.selectByPId(oi.getP_id()));
			}
			pMap.put(o.getO_id(),ps);//map<k,v>  v存的是引用
		}
		return pMap;
		
		
	}
	
	public  Map<String,String> selectAUserOrdersCnee(){
		Map<String,String> cneeMap=new HashMap<String, String>();
		SendAddrDao sd=new SendAddrDao();
		StringBuilder addrName=new StringBuilder();
		for(UserOrder uo:uolist){
			addrName.setLength(0);
			addrName.append(sd.selectAOrderSendAddr(uo.getSendaddrId()).getAddrName());
			cneeMap.put(uo.getO_id(),addrName.toString());
		}
		return cneeMap;
	}
}
