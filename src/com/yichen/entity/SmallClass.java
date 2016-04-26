package com.yichen.entity;

import java.util.Set;



public class SmallClass implements Comparable<SmallClass> {
	private String sc_id;//小类id
	private String sc_name;//小类名称
	private BigClass bc;
	private Set<Product> products;
	private float recomscore=0;//推荐模块得分
	private int buyamountsum=0;
	private int favamouontsum=0;
	public BigClass getBc() {
		return bc;
	}
	public void setBc(BigClass bc) {
		this.bc = bc;
	}
	public String getSc_id() {
		return sc_id;
	}
	public void setSc_id(String sc_id) {
		this.sc_id = sc_id;
	}
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

	
	public float getRecomscore() {
		return recomscore;
	}
	public void setRecomscore(float recomscore) {
		this.recomscore = recomscore;
	}
	public int getBuyamountsum() {
		return buyamountsum;
	}
	public void setBuyamountsum(int buyamountsum) {
		this.buyamountsum = buyamountsum;
	}
	public int getFavamouontsum() {
		return favamouontsum;
	}
	public void setFavamouontsum(int favamouontsum) {
		this.favamouontsum = favamouontsum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sc_id == null) ? 0 : sc_id.hashCode());
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
		SmallClass other = (SmallClass) obj;
		if (sc_id == null) {
			if (other.sc_id != null)
				return false;
		} else if (!sc_id.equals(other.sc_id))
			return false;
		return true;
	}
	@Override
	public int compareTo(SmallClass o) {
		if(this.recomscore<o.recomscore)
			return 1;
		else if(this.recomscore==o.recomscore)
			return 0;
		else
			return -1;

	}
	

	

}
