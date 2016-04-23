package com.yichen.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTool {
	/**
	 *    计算两天日期之差
	 * @param startDay  开始的日期
	 * @param endDay     结束的日期
	 * @return   两天日期之差
	 */
	public static int diffDate(java.util.Date startDay,java.util.Date endDay){
		return  (int)  ((getMillis(endDay)  -  getMillis(startDay))  /  (24  *  3600  *  1000)); 
	}
	public static long getMillis(java.util.Date date){
		java.util.Calendar  c  =  java.util.Calendar.getInstance();  
        c.setTime(date);  
        return  c.getTimeInMillis(); 
	}
	
	public static java.util.Date parseDate(String dateString) throws ParseException{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
		return dateFormat.parse(dateString);
	}
	
	

}
