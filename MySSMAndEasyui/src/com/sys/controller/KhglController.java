package com.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.sys.pojo.DatagridLoadFilter;
import com.sys.pojo.Gcmc;
import com.sys.pojo.Khgl;
import com.sys.service.KhglService;
import com.sys.utils.PageUtil;

@Controller
public class KhglController {
	@Autowired
   private KhglService khglService;
	
	@RequestMapping("/getKhgls")
	@ResponseBody      //json数据自动转换
	public List<Khgl> getKhgls(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		System.out.println("KhglController层");
		List<Khgl> listKhgl=khglService.getKhgls();
		req.getServletContext().setAttribute("listKhgl", listKhgl);
		return listKhgl;
		
	}
	//由于静态页面与动态页面分开：一般用于js中的请求后台地址（动态页面，直接访问不到：就需要通过后台方法再返回到动态页面中）用于静态页面到动态页面
	@RequestMapping("/khgl")
	public String getKhglPage() {
		return "khgl";
	}
	
	
	//树的事件   (用来 操作表格，也就是关联表格  ) 
	@RequestMapping("getGcId/{id}")
	@ResponseBody  
	public DatagridLoadFilter getGcId(@PathVariable("id")int id,int page,int rows) throws Exception{
		System.out.println("id:---"+id);
		System.out.println("page:---"+page);
		System.out.println("rows:---"+rows);
		
		//使用分页组件 
		PageHelper.startPage(page, rows);
		
		//返回过滤数据 模板
		return khglService.getGcId(id);
	}
	
	
}
