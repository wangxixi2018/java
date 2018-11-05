package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sys.model.N_sort;
import com.sys.model.News;
import com.sys.service.NewsService;
import com.sys.serviceImpl.NewsServiceImpl;

@WebServlet("/news.do")
public class NewsServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private NewsService newsService = new NewsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opr = req.getParameter("opr");
		switch (opr) {
		case "getAllNews":
			getAllNews(req, resp);
			break;
		case "getNewsById":
			getNewsById(req, resp);
			break;
		case "delNews":
			delNews(req, resp);
			break;
		case "addNews":
			addNews(req, resp);
			break;
		case "getNewsClassify":
			getNewsClassify(req, resp);
			break;
		case "updateNews":
			updateNews(req, resp);
			break;
		case "getAllNewsf":
			getAllNewsf(req, resp);
			break;
		case "getNewsByIdf":
			getNewsByIdf(req, resp);
			break;
		}
	}

	public void getAllNews(HttpServletRequest req, HttpServletResponse resp) {
		// 查询所有新闻
		// System.out.println("查询新闻");
		try {
			List<News> list = newsService.getAllNews();
			String json = JSON.toJSONString(list);
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getNewsById(HttpServletRequest req, HttpServletResponse resp) {
		// 查询新闻页面
		try {
			String id = req.getParameter("id");
			System.out.println(id);
			int id2 = Integer.parseInt(id);
			News news = newsService.getNewsById(id2);
			String json = JSON.toJSONString(news);
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delNews(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("删除新闻");
		String n_id = req.getParameter("n_id");
		int nid = Integer.parseInt(n_id);
		newsService.delNews(nid);
		try {
			resp.sendRedirect("item/NewsAdmin.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addNews(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("新增新闻");
		String nSortId = req.getParameter("n_sortId");
		int n_sortId = Integer.parseInt(nSortId);
		System.out.println(n_sortId);
		String n_title = req.getParameter("n_title");
		System.out.println(n_title);
		String n_content = req.getParameter("n_content");
		System.out.println(n_content);
		News news = new News();
		news.setN_sortid(n_sortId);
		news.setN_title(n_title);
		news.setN_content(n_content);
		newsService.addNews(news);
		try {
			resp.sendRedirect("item/NewsAdmin.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateNews(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("修改新闻");
		String id = req.getParameter("id");
		int n_id = Integer.parseInt(id);
		String n_title = req.getParameter("n_title");
		String n_content = req.getParameter("n_content");
		News news = new News();
		news.setN_Id(n_id);
		news.setN_title(n_title);
		news.setN_content(n_content);
		System.out.println(news);
		newsService.updateNews(news);
		try {
			resp.sendRedirect("item/NewsAdmin.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getNewsClassify(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("获取新闻分类页面");
		List<N_sort> list = newsService.getNewsClassify();
		System.out.println(list.size());
		req.getSession().setAttribute("n_sortnames", list);
	}

	public void getAllNewsf(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("加载新闻");
		List<News> list = newsService.getAllNews();
		req.getSession().setAttribute("news", list);
	}

	public void getNewsByIdf(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("n_id");
		int n_id = Integer.parseInt(id);
		News n = newsService.getNewsById(n_id);
		req.getSession().setAttribute("news", n);
		try {
			resp.sendRedirect("item/NewsContent.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}