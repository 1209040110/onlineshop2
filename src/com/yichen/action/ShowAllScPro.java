package com.yichen.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.ProductDao;
import com.yichen.entity.Product;

public class ShowAllScPro extends  ActionSupport{
	private List<Product>  products; 
	private String sc_id;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getSc_id() {
		return sc_id;
	}
	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}
	@Override
	public String execute() throws Exception {
		ProductDao productDao=new ProductDao();
		products=productDao.selectAllscPro(sc_id);
		return SUCCESS;
	}
	
}
