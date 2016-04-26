package com.yichen.action;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.OrderDao;
import com.yichen.entity.Product;
import com.yichen.entity.User;
import com.yichen.entity.UserOrder;
import com.yichen.service.ShowAllOrderService;
import com.yichen.service.ShowMyOrderService;
import com.yichen.util.ConstVar;
import com.yichen.util.DateTool;

public class ShowAllOrders extends ActionSupport {
	private List<UserOrder> uoList;
	private Map<String,Object> session;
	private Map<String,List<Product>> pmap;
	private Map<String,String> cneeMap;
	public List<UserOrder> getUoList() {
		return uoList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	public Map<String, String> getCneeMap() {
		return cneeMap;
	}

	public Map<String, List<Product>> getPmap() {
		return pmap;
	}
	//格式化数字显示
	public String formatDouble(double s){
		DecimalFormat fmt = new DecimalFormat("\u00A4##0.00");
		return fmt.format(s);
	}
	@Override
	public String execute() throws Exception {
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		String admin=(String) session.get("onlineAdmin");
		if(admin!=null){
			OrderDao od=new OrderDao();
			uoList=od.selectAllOrders();
			DateTool dt=new DateTool();
			Date date;
			for(UserOrder o:uoList){
				date=dt.parseDateTime(o.getO_time());
				o.setO_time(ConstVar.DATE_FORMAT_DATETIME_PRINT.format(date));
			
			}
			ShowAllOrderService smos=new ShowAllOrderService();
			pmap=smos.selectAllOrdersProducts();
			cneeMap=smos.selectAllOrdersCnee();
			dt=null;
			return SUCCESS;
		}else
			return LOGIN;
	}
	
}
