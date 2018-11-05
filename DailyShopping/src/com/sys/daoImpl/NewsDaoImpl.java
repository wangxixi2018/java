package com.sys.daoImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sys.dao.BaseDao;
import com.sys.dao.NewsDao;
import com.sys.model.N_sort;
import com.sys.model.News;
import com.sys.util.JDBCUtil;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	public NewsDaoImpl(Connection conn) {
		super(conn);
	}
	@Override
	public List<News> getAllNews() {
		String sql="SELECT n_id,n_sortid,n_title,n_content FROM news order by newscreatetime desc limit 5";
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
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int delNews(int nid) {
		String sql="delete from news where n_id=?";
		int num=-1;
		num=super.executeUpdate(sql, nid);
		return num;
	}

	@Override
	public int addNews(News news) {
		String sql="INSERT INTO news(n_sortid,n_title,n_content)VALUES"
				+ "(?,?,?)";
		int num=-1;
		num=super.executeUpdate(sql, news.getN_sortid(),news.getN_title(),news.getN_content());
		if(num!=1){
			System.out.println("添加失败");
		}else{
			System.out.println("添加成功");
		}
		return num;
	}
	@Override
	public int updateNews(News news) {
		String sql="UPDATE news SET n_title=?,n_content=? WHERE n_id=?";
		int num=-1;
		num=super.executeUpdate(sql, news.getN_title(),news.getN_content(),news.getN_Id());
		if(num==1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		return num;
	}
	@Override
	public News getNewsByNid(int nid) {
		ResultSet rs=null;
		News news=new News();
		try {
			String sql="SELECT n_id,n_sortid,n_title,n_content FROM news WHERE N_ID=?";
			rs=super.executeQuery(sql, nid);
			rs.next();
			news.setN_Id(rs.getInt("n_id"));
			news.setN_content(rs.getNString("n_content"));
			news.setN_title(rs.getString("n_title"));
			news.setN_sortid(rs.getInt("n_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(null, null, rs);
		}
		return news;
	}
	@Override
	public List<N_sort> getNewsClassify() {
		String sql="select n_sortname,n_sortid from n_sort";
		List<N_sort>list=new ArrayList<N_sort>();
		try {
			ResultSet rs=super.executeQuery(sql);
			while(rs.next()){
				N_sort n_sort=new N_sort();
				n_sort.setN_SortId(rs.getInt("n_SortID"));
				n_sort.setN_SortName(rs.getString("n_sortname"));
				list.add(n_sort);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}