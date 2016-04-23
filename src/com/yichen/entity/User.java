package com.yichen.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.components.Else;
import org.apache.struts2.components.If;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yichen.util.ConstVar;

public class User {
	private String u_id;
	private String pwd;
	private String truename;
	private String sex;
	private String birthday;
	private String email;
	private String phone;
	private String address;
	private String regtime;
	private int credit;//0-99 100-999  1000-
	private int rank; //1,2,3
	private String securityqu1;
	private String securityans1;
	private String securityqu2;
	private String securityans2;
	private String lastlogintime;
	private float discount;//1.0 9.5 9
	private Set<Review> reviews=new HashSet<Review>();
	private Set<UserOrder> userOrders=new HashSet<UserOrder>();
	private ShopCart shopCart;
	private Set<SendAddr> sendAddrs=new HashSet<SendAddr>();
	private List<Product> favpros=new ArrayList<Product>();
	public Set<SendAddr> getSendAddrs() {
		return sendAddrs;
	}
	public void setSendAddrs(Set<SendAddr> sendAddrs) {
		this.sendAddrs = sendAddrs;
	}
	public Set<UserOrder> getUserOrders() {
		return userOrders;
	}
	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}
	public ShopCart getShopCart() {
		return shopCart;
	}
	public void setShopCart(ShopCart shopCart) {
		this.shopCart = shopCart;
	}
	
	public float getDiscount(int urank) 
	{
		if(urank==1)
			return ConstVar.VIPONE_DISCOUNT;
		else if(urank==2)
			return ConstVar.VIPTWO_DISCOUNT;
		else //程序不够严谨
			return ConstVar.VIPTHREE_DISCOUNT;
		
			
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getSecurityqu1() {
		return securityqu1;
	}
	public void setSecurityqu1(String securityqu1) {
		this.securityqu1 = securityqu1;
	}
	public String getSecurityans1() {
		return securityans1;
	}
	public void setSecurityans1(String securityans1) {
		this.securityans1 = securityans1;
	}
	public String getSecurityqu2() {
		return securityqu2;
	}
	public void setSecurityqu2(String securityqu2) {
		this.securityqu2 = securityqu2;
	}
	public String getSecurityans2() {
		return securityans2;
	}
	public void setSecurityans2(String securityans2) {
		this.securityans2 = securityans2;
	}
	public String getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	
	
	
	public List<Product> getFavpros() {
		return favpros;
	}
	public void setFavpros(List<Product> favpros) {
		this.favpros = favpros;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		return true;
	}
}
