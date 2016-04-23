package com.yichen.entity;

public class SendAddr {
	private String addrId;
	private String uid;
	private String addrName;
	private String postcode;
	private String cnee;
	private String cnee_tel;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrId == null) ? 0 : addrId.hashCode());
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
		SendAddr other = (SendAddr) obj;
		if (addrId == null) {
			if (other.addrId != null)
				return false;
		} else if (!addrId.equals(other.addrId))
			return false;
		return true;
	}
	public String getAddrId() {
		return addrId;
	}
	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAddrName() {
		return addrName;
	}
	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCnee() {
		return cnee;
	}
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	public String getCnee_tel() {
		return cnee_tel;
	}
	public void setCnee_tel(String cnee_tel) {
		this.cnee_tel = cnee_tel;
	}
	
}
