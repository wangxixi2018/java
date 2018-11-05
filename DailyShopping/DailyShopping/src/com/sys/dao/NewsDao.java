package com.sys.dao;

import java.util.List;

import com.sys.model.News;

public interface NewsDao {
	//1.查询所有新闻
	public List<News> GetAllNews();
	//2.删除新闻 根据新闻id
	public int DelNews(int nid);
	//3.增加新闻
	public int AddNews();
	//4.修改新闻
	public int UpdateNews(int nid);
	//5.查询新闻
	public List<News> GetNewsByNid(int nid);
}
