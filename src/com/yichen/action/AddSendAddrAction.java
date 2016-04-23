package com.yichen.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.SendAddrDao;
import com.yichen.entity.SendAddr;

public class AddSendAddrAction extends ActionSupport {
	private SendAddr sendAddr;
	private String uid;
	
	public SendAddr getSendAddr() {
		return sendAddr;
	}

	public void setSendAddr(SendAddr sendAddr) {
		this.sendAddr = sendAddr;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void add(){
		SendAddrDao sendAddrDao=new SendAddrDao();
		sendAddrDao.add(uid, sendAddr);
	}
}
