package com.sys.serviceImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.sys.dao.NewsDao;
import com.sys.daoImpl.NewsDaoImpl;
import com.sys.model.N_sort;
import com.sys.model.News;
import com.sys.service.NewsService;
import com.sys.util.JDBCUtil;

public class NewsServiceImpl implements NewsService {
	@Override
	public List<News> getAllNews() {
		Connection conn=null;
		List<News>list=null;
		try {
			conn=JDBCUtil.getConnection();
			NewsDao newsdao=new NewsDaoImpl(conn);
			list=newsdao.getAllNews();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}
	@Override
	public int delNews(int nid) {
		Connection conn=null;
		int num=-1;
		try {
			conn=JDBCUtil.getConnection();
			NewsDao newsdao=new NewsDaoImpl(conn);
			num=newsdao.delNews(nid);
			if(num==1){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败:"+num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return num;
	}

	@Override
	public int addNews(News news) {
		int num=-1;
		Connection conn=null;
		try {
			conn=JDBCUtil.getConnection();
			NewsDao newsdao=new NewsDaoImpl(conn);
			num=newsdao.addNews(news);
			if(num==1){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return num;
	}
	@Override
	public int updateNews(News news) {
		Connection conn=null;
		int num=-1;
		try {
			conn=JDBCUtil.getConnection();
			NewsDao newsdao=new NewsDaoImpl(conn);
			num=newsdao.updateNews(news);
			if(num==1){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return num;
	}
	@Override
	public News getNewsById(int id) {
		Connection conn=null;
		News news=new News();
		try {
			conn=JDBCUtil.getConnection();
			NewsDao newsdao=new NewsDaoImpl(conn);
			news=newsdao.getNewsByNid(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return news;
	}
	@Override
	public List<N_sort> getNewsClassify() {
		Connection conn=null;
		List<N_sort>list=null;
		try {
			conn=JDBCUtil.getConnection();
			NewsDao newsDao=new NewsDaoImpl(conn);
			list=newsDao.getNewsClassify();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}
}