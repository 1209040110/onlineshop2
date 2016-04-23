package com.yichen.entity;

public class Favorite {
	private ShopCartCompositePK shopCpk;
	private String collecttime;
	public String getCollecttime() {
		return collecttime;
	}
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}
	public ShopCartCompositePK getShopCpk() {
		return shopCpk;
	}
	public void setShopCpk(ShopCartCompositePK shopCpk) {
		this.shopCpk = shopCpk;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shopCpk == null) ? 0 : shopCpk.hashCode());
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
		Favorite other = (Favorite) obj;
		if (shopCpk == null) {
			if (other.shopCpk != null)
				return false;
		} else if (!shopCpk.equals(other.shopCpk))
			return false;
		return true;
	}
}
