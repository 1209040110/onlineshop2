package com.yichen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.ShopCartDao;
import com.yichen.entity.ShopCart;
import com.yichen.entity.User;
import com.yichen.util.ConstVar;

public class AmountChangeAction extends ActionSupport {
	private String pid;
	private String command;
	private Map<String,Object> session;
	//先不判断库存
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void amountChange() throws IOException{
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		User user=(User) session.get("onlineUser");
		ShopCartDao shopCartDao=new ShopCartDao();
		ShopCart shopCart=shopCartDao.checkHav(user.getU_id(),pid);
		HttpServletResponse response = ServletActionContext.getResponse();  
        PrintWriter writer = response.getWriter();
		if(command.equals(ConstVar.ADD_COMMAND)){
			shopCartDao.updateAmount(shopCart, shopCart.getAmount()+1);
		}
		else if(command.equals(ConstVar.REDUCE_COMMAND)){
			shopCartDao.updateAmount(shopCart, shopCart.getAmount()-1);
		}
		Set<ShopCart> shopCarts=shopCartDao.selectAUserAllShopCart(user.getU_id());
		System.out.println(shopCarts);
		writer.flush();
		writer.close();
	}
}
