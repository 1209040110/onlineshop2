package com.yichen.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.ProductDao;
import com.yichen.dao.ProductDetailDao;
import com.yichen.entity.Product;
import com.yichen.entity.ProductDetail;


public class ShowProDetail extends ActionSupport {
	private String p_id;
	private ProductDetail productDetail;
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	@Override
	public String execute() throws Exception {
		ProductDetailDao pDetailDao=new ProductDetailDao();
		productDetail=pDetailDao.selectByPId(p_id);
		ProductDao productDao=new ProductDao();
		product=productDao.selectByPId(p_id);
		return SUCCESS;
	}
}
