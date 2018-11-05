package com.sys.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
	public  static String getTime(ResultSet rs,String str) throws SQLException{
		Date time1=new Date(rs.getTimestamp(str).getTime());//java.util.Date
		SimpleDateFormat formattime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pubtime=formattime.format(time1);
		return pubtime;
	}
}
