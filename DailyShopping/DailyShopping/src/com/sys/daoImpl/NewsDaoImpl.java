package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.NewsDao;
import com.sys.model.News;
import com.sys.util.JDBCUtil;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	public NewsDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<News> GetAllNews() {
		String sql="SELECT n_id,n_sortid,n_title,n_content FROM news";
		ResultSet rs = super.executeQuery(sql);
		List<News>list=new ArrayList<News>();
		try {
			while(rs.next()){
				News news=new News();
				news.setN_Id(rs.getInt("n_id"));
				news.setN_sortid(rs.getInt("n_sortid"));
				news.setN_title(rs.getString("n_title"));
				news.setN_content(rs.getString("n_content"));
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public int DelNews(int nid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int AddNews() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateNews(int nid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<News> GetNewsByNid(int nid) {
		// TODO Auto-generated method stub
		return null;
	}

}
