package com.yichen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.FavouriteDao;
import com.yichen.entity.Product;
import com.yichen.entity.User;
import com.yichen.service.FavoriteService;
import com.yichen.util.ConstVar;

public class FavAction extends ActionSupport {
	private Map<String,Object> session;
	private List<Product> favpros;
	private String pid;
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<Product> getFavpros() {
		return favpros;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
		//格式化数字显示
		public String formatDouble(double s){
		DecimalFormat fmt = new DecimalFormat("\u00A4##0.00");
		return fmt.format(s);
		}
	public String show(){
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User u=(User) session.get("onlineUser");
		if(u==null) return LOGIN;
		else{
			FavouriteDao fd=new FavouriteDao();
			favpros=fd.selectAUserAllFav(u.getU_id());
		}
		return SUCCESS;
	}
	
	
	public void del(){
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User u=(User) session.get("onlineUser");
		HttpServletResponse response = ServletActionContext.getResponse();  
        PrintWriter writer;
		try {
			writer = response.getWriter();
			if(u==null) writer.write(ConstVar.NOT_LOGIN_STRING);
			else{
				FavoriteService fs=new FavoriteService();
				System.out.println("70--"+pid);
				boolean f=fs.delAFav(u.getU_id(), pid);
				System.out.println("72--"+f);
				if(f) writer.write(ConstVar.OK_STRING);
				else writer.write(ConstVar.FAILED_STRING);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
	}
	
	
}
