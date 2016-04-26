package com.yichen.action;


import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.BigClassDao;
import com.yichen.dao.ProductDao;
import com.yichen.entity.BigClass;
import com.yichen.entity.Product;
import com.yichen.entity.User;
import com.yichen.service.RecommendService;


public class IndexAction extends ActionSupport {
	private List<BigClass> bigclasses;
	private List<Product> jtcbProductTen;
	private List<Product> zxypProductTen;
	private List<Product>  phbTopn;
	private Product[] guessfav;
	private Map<String,Object> session;
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



	public Product[] getGuessfav() {
		return guessfav;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		BigClassDao bigClassDao=new BigClassDao();
		bigclasses=bigClassDao.selectAll();
		ProductDao productDao=new ProductDao();
		jtcbProductTen=productDao.selectAscTop("01",10);
		zxypProductTen=productDao.selectAscTop("02",10);
		phbTopn=productDao.selectphbTopn(5);
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		System.out.println("--------------1");
		if(session!=null){
			User u=(User) session.get("onlineUser");
			System.out.println("--------------2");
			if(u!=null){
				System.out.println("--------------3");
				guessfav=new RecommendService().guessyourfav(u.getU_id());
			}
		}
		return SUCCESS;
	}

}
