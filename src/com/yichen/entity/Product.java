package com.yichen.entity;

import java.util.HashSet;
import java.util.Set;

public class Product {
	private String p_id;//商品编号
	private String p_name;//商品名
	private String sc_id;//所属的小类id
	private float unitprice;//商品单价
	private int stock;//商品库存量
	private int salesvolume;//销量
	private int evaluationsum;//累计评价数
	private int rq;//商品人气（被收藏数）
	private String smallimg;//图片地址
	private float score;//商品评价分  1.0-5.0
	private String other;//其他
	private Set<Review> previews=new HashSet<Review>();//该商品所有评价
	
	public Set<Review> getPreviews() {
		return previews;
	}
	public void setPreviews(Set<Review> previews) {
		this.previews = previews;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getSc_id() {
		return sc_id;
	}
	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}
	public float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(float unitprice) {
		this.unitprice = unitprice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSalesvolume() {
		return salesvolume;
	}
	public void setSalesvolume(int salesvolume) {
		this.salesvolume = salesvolume;
	}
	public int getEvaluationsum() {
		return evaluationsum;
	}
	public void setEvaluationsum(int evaluationsum) {
		this.evaluationsum = evaluationsum;
	}
	public int getRq() {
		return rq;
	}
	public void setRq(int rq) {
		this.rq = rq;
	}
	public String getSmallimg() {
		return smallimg;
	}
	public void setSmallimg(String smallimg) {
		this.smallimg = smallimg;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p_id == null) ? 0 : p_id.hashCode());
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
		Product other = (Product) obj;
		if (p_id == null) {
			if (other.p_id != null)
				return false;
		} else if (!p_id.equals(other.p_id))
			return false;
		return true;
	}
	
	
}
