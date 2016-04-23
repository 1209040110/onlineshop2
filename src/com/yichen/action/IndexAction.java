package com.yichen.action;


import java.util.List;


import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.BigClassDao;
import com.yichen.dao.ProductDao;
import com.yichen.entity.BigClass;
import com.yichen.entity.Product;


public class IndexAction extends ActionSupport {
	private List<BigClass> bigclasses;
	private List<Product> jtcbProductTen;
	private List<Product> zxypProductTen;
	private List<Product>  phbTopn;
	

	public List<Product> getPhbTopn() {
		return phbTopn;
	}

	public void setPhbTopn(List<Product> phbTopn) {
		this.phbTopn = phbTopn;
	}

	public List<Product> getZxypProductTen() {
		return zxypProductTen;
	}

	public void setZxypProductTen(List<Product> zxypProductTen) {
		this.zxypProductTen = zxypProductTen;
	}

	public List<Product> getJtcbProductTen() {
		return jtcbProductTen;
	}

	public void setJtcbProductTen(List<Product> jtcbProductTen) {
		this.jtcbProductTen = jtcbProductTen;
	}

	public List<BigClass> getBigclasses() {
		return bigclasses;
	}

	public void setBigclasses(List<BigClass> bigclasses) {
		this.bigclasses = bigclasses;
	}



	@Override
	public String execute() throws Exception {
		BigClassDao bigClassDao=new BigClassDao();
		bigclasses=bigClassDao.selectAll();
		ProductDao productDao=new ProductDao();
		jtcbProductTen=productDao.selectAscTop("01",10);
		zxypProductTen=productDao.selectAscTop("02",10);
		phbTopn=productDao.selectphbTopn(5);
		return SUCCESS;
	}

}
