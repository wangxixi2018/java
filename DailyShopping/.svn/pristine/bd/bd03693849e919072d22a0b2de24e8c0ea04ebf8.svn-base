package com.sys.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sys.dao.NewsDao;
import com.sys.daoImpl.NewsDaoImpl;
import com.sys.model.News;
import com.sys.util.JDBCUtil;

public class NewsTest {
	public static void main(String[] args) {
		try {
			Connection conn=JDBCUtil.getConnection();
			NewsDao news=new NewsDaoImpl(conn);
			List<News>list=news.GetAllNews();
			for(News n:list){
				System.out.println(n.getN_title());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
