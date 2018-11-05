package com.sys.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.sys.model.N_sort;
import com.sys.model.News;
import com.sys.service.NewsService;
import com.sys.serviceImpl.NewsServiceImpl;

@WebFilter("/item/NewsAdmin.html")
public class NewsFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub	
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
			NewsService news=new NewsServiceImpl();
			List<N_sort>list=news.getNewsClassify();
			HttpServletRequest requset=(HttpServletRequest) req;
			requset.getSession().setAttribute("n_sortnames", list);
			chain.doFilter(requset, resp);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
