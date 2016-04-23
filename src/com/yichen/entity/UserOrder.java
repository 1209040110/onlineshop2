package com.yichen.entity;

import java.util.HashSet;
import java.util.Set;

public class UserOrder {
	private String o_id;//主键
	private String u_id;
	private String o_time;
	private float totalprice;
	private int o_status;
	private float freight;//运费
	private String paymentmode;//支付方式
	private String sendaddrId;
	private Set<OrderItem> orderItems=new HashSet<OrderItem>();
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getO_time() {
		return o_time;
	}
	public void setO_time(String o_time) {
		this.o_time = o_time;
	}

	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	
	
	public int getO_status() {
		return o_status;
	}
	public void setO_status(int o_status) {
		this.o_status = o_status;
	}
	public float getFreight() {
		return freight;
	}
	public void setFreight(float freight) {
		this.freight = freight;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getSendaddrId() {
		return sendaddrId;
	}
	public void setSendaddrId(String sendaddrId) {
		this.sendaddrId = sendaddrId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((o_id == null) ? 0 : o_id.hashCode());
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
		UserOrder other = (UserOrder) obj;
		if (o_id == null) {
			if (other.o_id != null)
				return false;
		} else if (!o_id.equals(other.o_id))
			return false;
		return true;
	}
}
