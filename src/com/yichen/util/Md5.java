package com.yichen.util;
import java.security.*;

public class Md5 {

	public static String MD5Encrypt(String strIn){
		String strOut=null;
		MessageDigest md=null;
		
		try {
			 md = MessageDigest.getInstance("MD5");
			 byte [] digest = md.digest(strIn.getBytes());
			 strOut=bytetoString(digest);
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		return  strOut;
	}
	
	public static String bytetoString(byte [] digest)
	{
		String str="";
		String tempStr="";
		for(int i=1;i<digest.length;i++){
			tempStr=(Integer.toHexString(digest[i]&0xff));
			if(tempStr.length()==1)
			{
				str=str+"0"+tempStr;
			}
			else{
				str=str+tempStr;
			}
		}
		return str.toLowerCase();
	}
	public static void main(String[] args) {
		
		System.out.println(Md5.MD5Encrypt("admin"));
		
		

	}
	

}
