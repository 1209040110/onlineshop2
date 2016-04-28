package com.yichen.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yichen.dao.ProductDao;
import com.yichen.dao.SmallClassDao;
import com.yichen.entity.Product;
import com.yichen.entity.ProductDetail;
import com.yichen.entity.SmallClass;
import com.yichen.service.ProductService;
import com.yichen.util.ConstVar;

public class ProductAction extends ActionSupport {
	private Product p;
	private ProductDetail pd;
	private File file; // 上传的文件
	private List<SmallClass> scList;
	private Map<String,Object> session;
	private String file1FileName; // 文件名称有后缀名
	private String file1ContentType; // 文件类型
	
	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public ProductDetail getPd() {
		return pd;
	}

	public void setPd(ProductDetail pd) {
		this.pd = pd;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<SmallClass> getScList() {
		return scList;
	}

	public void setScList(List<SmallClass> scList) {
		this.scList = scList;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}



	public String getFile1FileName() {
		return file1FileName;
	}

	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}

	public String getFile1ContentType() {
		return file1ContentType;
	}

	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	public String addPro() throws IOException{
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		String admin=(String) session.get("onlineAdmin");
		if(admin==null) return LOGIN;
		else{
			FileInputStream fileInputStream=new FileInputStream(file);
			String typeStr=file1FileName.split(".")[1];
			// 设置上传文件目录  
	        String uploadPath = ServletActionContext.getServletContext()  
	                .getRealPath("images/productimg");  
	        String fileName=ConstVar.DATE_FORMAT_DATETIME.format(new Date());
	        fileName=fileName+"."+typeStr;
			File desFile=new File(uploadPath,fileName);
			FileOutputStream fileOutputStream=new FileOutputStream(desFile);
			byte[] buffer=new byte[64];
			int count=0;
			while((count=fileInputStream.read(buffer))!=-1){
				fileOutputStream.write(buffer, 0, count);
			}
			fileOutputStream.flush();
			fileInputStream.close();
			fileOutputStream.close();
			System.out.println(fileName);
			p.setSmallimg(fileName);
			if(p==null||pd==null) return INPUT;
			else{
				scList=new SmallClassDao().selectAllSc();
				ProductService ps=new ProductService();
				boolean f=ps.addAPro(p, pd);
				if(!f) return ERROR;
			}
		}
		
		return SUCCESS;
	}
	
	
	public String  showscs(){
		SmallClassDao scd=new SmallClassDao();
		ActionContext actionContext=ActionContext.getContext();
		session=actionContext.getSession();
		String admin=(String) session.get("onlineAdmin");
		if(admin==null) return LOGIN;
		else{scList=scd.selectAllSc();
		return SUCCESS;}
	}
	
}
