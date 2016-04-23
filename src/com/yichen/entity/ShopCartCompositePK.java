package com.yichen.entity;

import java.io.Serializable;

public class ShopCartCompositePK implements Serializable {
	private String u_id;
	private String p_id;
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p_id == null) ? 0 : p_id.hashCode());
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
		ShopCartCompositePK other = (ShopCartCompositePK) obj;
		if (p_id == null) {
			if (other.p_id != null)
				return false;
		} else if (!p_id.equals(other.p_id))
			return false;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		return true;
	}
	public ShopCartCompositePK(String u_id, String p_id) {
		super();
		this.u_id = u_id;
		this.p_id = p_id;
	}
	public ShopCartCompositePK() {
		super();
	}
}
