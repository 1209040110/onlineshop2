package com.yichen.entity;

public class ProductDetail {
	private String p_id;
	private String brand;
	private String size;//规格
	private String cpjx;//产品剂型
	private String ypfl;//药品分类
	private String pzwh;//批准文号
	private String syjl;//使用剂量
	private String expire;//有效期
	private String manufacturer;//
	private String yf;//用法
	private String detailimg;
	private String description;
	private String syz;//适应症
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCpjx() {
		return cpjx;
	}
	public void setCpjx(String cpjx) {
		this.cpjx = cpjx;
	}
	public String getYpfl() {
		return ypfl;
	}
	public void setYpfl(String ypfl) {
		this.ypfl = ypfl;
	}
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}
	public String getSyjl() {
		return syjl;
	}
	public void setSyjl(String syjl) {
		this.syjl = syjl;
	}
	public String getExpire() {
		return expire;
	}
	public void setExpire(String expire) {
		this.expire = expire;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getYf() {
		return yf;
	}
	public void setYf(String yf) {
		this.yf = yf;
	}
	public String getDetailimg() {
		return detailimg;
	}
	public void setDetailimg(String detailimg) {
		this.detailimg = detailimg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSyz() {
		return syz;
	}
	public void setSyz(String syz) {
		this.syz = syz;
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
		ProductDetail other = (ProductDetail) obj;
		if (p_id == null) {
			if (other.p_id != null)
				return false;
		} else if (!p_id.equals(other.p_id))
			return false;
		return true;
	}
	
}
