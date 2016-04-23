package com.yichen.entity;

public class SmallClass {
	private String sc_id;//小类id
	private String sc_name;//小类名称
	
	private BigClass bc;
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
	

	

}
