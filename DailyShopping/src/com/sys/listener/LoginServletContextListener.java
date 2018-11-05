package com.sys.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sys.model.G_son;
import com.sys.service.G_sonService;
import com.sys.serviceImpl.G_sonServiceImpl;

@WebListener
public class LoginServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// System.out.println("初始化监听 Web容器启动，部署Web应用时，触发上下文的创建方法");
		// 创建非法字符
		Map<String, String> map = new HashMap<String, String>();
		map.put("靠", "*");
		map.put("操", "*");
		map.put("日", "*");
		// 存入上下文中
		// 1.获取上下文对象 一个应用只有一个ServletContext,作用域最大,全局变量
		ServletContext context = arg0.getServletContext();

		G_sonService g_sonService = new G_sonServiceImpl();
		List<G_son> listG_son = g_sonService.queryG_son();
		context.setAttribute("listG_son", listG_son);
		// 2.放入Context 中
		context.setAttribute("FeiFaZiFu", map);
	}

}
