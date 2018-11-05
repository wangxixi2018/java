package com.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sys.util.JDBCUtil;

public class BaseDao {
	Connection conn = null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	
	public BaseDao(Connection conn){
		this.conn=conn;
	}
	//修改
		public int executeUpdate(String sql,Object...params){
			int num = -1;
			try {
				//创建数据库
				pstmt = conn.prepareStatement(sql);
				//传递参数
				if(params != null){
					for(int i=0;i<params.length;i++){
						pstmt.setObject(i+1, params[i]);
					}
				}
				//执行sql
				num = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JDBCUtil.closeAll(null, pstmt, rs);
			}
			return num;
		}
		//查询
		public ResultSet executeQuery(String sql,Object...params){
			try{
				//创建数据库
				pstmt = conn.prepareStatement(sql);
				//传递参数
				if(params != null){
					for(int i=0;i<params.length;i++){
						pstmt.setObject(i+1, params[i]);
					}
				}
				//执行sql
				rs = pstmt.executeQuery();
			}catch(Exception e){
				e.printStackTrace();
			}
			return rs;
		}
}
