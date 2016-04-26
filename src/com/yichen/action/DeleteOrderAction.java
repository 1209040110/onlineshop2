package com.yichen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.OrderDao;
import com.yichen.dao.UserDao;
import com.yichen.entity.User;
import com.yichen.util.ConstVar;

public class DeleteOrderAction extends ActionSupport {
	private String oid;
	private Map<String,Object> session;
	

	public void setOid(String oid) {
		this.oid = oid;
	}



	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



	public void deleteOrder(){
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		String admin=(String) session.get("onlineAdmin");
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer=null;
		try{
			writer= response.getWriter();  
		if(admin!=null){
			OrderDao od=new OrderDao();
			boolean f=od.deleteAOrder(oid);
			if(f)
				writer.write(ConstVar.OK_STRING);
			else
				writer.write(ConstVar.FAILED_STRING);
		}else
			writer.write(ConstVar.NOT_LOGIN_STRING);
			
		}
		catch(IOException ex){
			ex.printStackTrace();
		}finally{
			if(writer!=null){
			writer.flush();
			writer.close();}
		}
		
	}

}
