package com.yichen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.SendAddrDao;
import com.yichen.dao.UserDao;
import com.yichen.entity.SendAddr;
import com.yichen.entity.User;
import com.yichen.util.ConstVar;

public class AddSendAddrAction extends ActionSupport {
	private SendAddr sa;
	private Map<String,Object> session;

	public void setSa(SendAddr sa) {
		System.out.println("sendaddrName:"+sa);
		this.sa = sa;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public void add(){
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User u=(User) session.get("onlineUser");
		HttpServletResponse response = ServletActionContext.getResponse();  
        PrintWriter w=null;
        System.out.println("sendaddr-------------------:"+sa.getCnee());
		try {
			w = response.getWriter();
			boolean f=false;
			if(u!=null&&sa!=null){
				SendAddrDao sendAddrDao=new SendAddrDao();
				f=sendAddrDao.add(u.getU_id(), sa);
				if(f){
					UserDao ud=new UserDao();
					u=ud.selectById(u.getU_id());
					if(u!=null)
						session.put("onlineUser", u);
					w.write(ConstVar.OK_STRING);
				}
			}
			if(u==null) w.write(ConstVar.NOT_LOGIN_STRING);
			w.write(ConstVar.FAILED_STRING);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(w!=null){
				w.flush();
				w.close();
			}
			
		}
		
		
		
	}
}
