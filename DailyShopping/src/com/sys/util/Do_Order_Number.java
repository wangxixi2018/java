package com.sys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Do_Order_Number {
	public static String getOrderNumber(){
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddHHmmss");
		String now = dateFormat.format(date);
		int num = (int)(Math.random()*10000);
		String nums=now+num;
		return nums;
	}
}
