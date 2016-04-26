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

public class ShowAllOrderService {
	List<UserOrder> uolist=null;
	OrderDao od;
	public ShowAllOrderService(){
		this.od=new OrderDao();
		this.uolist=od.selectAllOrders();
	}

	

	
	public Map<String,List<Product>> selectAllOrdersProducts(){
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
	
	public  Map<String,String> selectAllOrdersCnee(){
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
