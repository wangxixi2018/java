package com.sys.dao;

import java.util.List;

import com.sys.model.N_sort;
import com.sys.model.News;

public interface NewsDao {
	//1.查询所有新闻
	public List<News> getAllNews();
	//2.删除新闻 根据新闻id
	public int delNews(int nid);
	//3.增加新闻
	public int addNews(News news);
	//4.修改新闻
	public int updateNews(News news);
	//5.根据ID查询新闻
	public News getNewsByNid(int nid);
	//6.查询所有新闻分类
	public List<N_sort> getNewsClassify();
}
