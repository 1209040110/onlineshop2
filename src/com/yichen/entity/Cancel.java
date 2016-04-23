package com.yichen.entity;

public class Cancel {
	private String o_id;//主键
	private String cancelreason;
	private String canceltime;
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public String getCancelreason() {
		return cancelreason;
	}
	public void setCancelreason(String cancelreason) {
		this.cancelreason = cancelreason;
	}
	public String getCanceltime() {
		return canceltime;
	}
	public void setCanceltime(String canceltime) {
		this.canceltime = canceltime;
	}
	
}
