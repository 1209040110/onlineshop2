package com.yichen.util;

import java.text.SimpleDateFormat;

public class ConstVar {
	public static final  int FREIGHT_STANDARD=10; 
	public static final  int FREIGHT_FREE_MIN=79; 
	public static final  int VIPONE_CREDIT_MIN=0;
	public static final  int VIPTWO_CREDIT_MIN=100;
	public static final  int VIPTHREE_CREDIT_MIN=1000;
	public static final float VIPONE_DISCOUNT=1.0f;
	public static final float VIPTWO_DISCOUNT=0.95f;
	public static final float VIPTHREE_DISCOUNT=0.9f;
	public static final int ORDER_STATUS_WAITPAY=1;
	public static final int ORDER_STATUS_WAITRECEIVE=2;
	public static final int ORDER_STATUS_COMPLETED=3;
	public static final int ORDER_STATUS_CANCELED=4;
	public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat DATE_FORMAT_DATETIME = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat DATE_FORMAT_DATETIME_PRINT
	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final String REDUCE_COMMAND="reduce";
	public static final String ADD_COMMAND="add";
	public static final String NOT_LOGIN_STRING="nologin";
	public static final String OK_STRING="ok";
	public static final String FAILED_STRING="fail";
}
