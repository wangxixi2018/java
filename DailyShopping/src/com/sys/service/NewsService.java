package com.sys.service;

import java.util.List;

import com.sys.model.N_sort;
import com.sys.model.News;

public interface NewsService {
	//1.查询所有新闻
	public List<News> getAllNews();
	//2.删除新闻
	public int delNews(int nid);
	//3.添加新闻
	public int addNews(News news);
	//4.修改新闻
	public int updateNews(News news);
	//5.根据id查询新闻
	public News getNewsById(int id);
	//6.查询新闻分类
	public List<N_sort> getNewsClassify();
}
