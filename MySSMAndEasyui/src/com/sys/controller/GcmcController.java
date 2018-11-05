package com.sys.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.sys.pojo.DatagridLoadFilter;
import com.sys.pojo.Gcmc;
import com.sys.pojo.Khgl;
import com.sys.service.GcmcService;
import com.sys.service.KhglService;
import com.sys.service.Impl.KhglServiceImpl;
import com.sys.son.GcmcSon;
import com.sys.utils.MessageInfo;


@Controller
public class GcmcController {
	@Autowired
	private GcmcService gcmcService;
	@Autowired
	private GcmcSon gcmcSon;
	    //查新所有工程信息（REST参数风格的使用）
		@RequestMapping("getListGcmc/{id}")
		@ResponseBody  
		public DatagridLoadFilter getListGcmc(@PathVariable("id")int id) throws Exception{
			System.out.println("id:---"+id);
			DatagridLoadFilter datagridLoadFilter=new DatagridLoadFilter();
			List<Gcmc> GcmcList=gcmcService.getListGcmc();
			datagridLoadFilter.setTotal(1000);
			datagridLoadFilter.setRows(GcmcList);
			//返回过滤数据 模板
			return datagridLoadFilter;
		}
		//删除工程（单个或多个）
		@RequestMapping("delGc")
		@ResponseBody
		public MessageInfo del(int[] Gcmcid) throws Exception {
			/*for (int i : Gcmcid) {
				System.out.println(i);
			}*/
			return gcmcService.delGcmc(Gcmcid);	
		}
		//查询(单一查询)
		@RequestMapping("selectGcmc/{select}")
		@ResponseBody
		public DatagridLoadFilter selectGcmc(@PathVariable("select")String select) throws Exception {
			System.out.println("前端页面值："+select);
			//使用分页组件 
			//PageHelper.startPage(page, rows);
			return gcmcService.selectGcmc(select);	
		}
		
		//查询(多查询，使用的是Easyui框架内置的查询)
		@RequestMapping("selectGcmcs/{id}/{key}/{value}")
		@ResponseBody  
		public DatagridLoadFilter selectGcmcs(@PathVariable("id")int id,@PathVariable("key")String key,@PathVariable("value")String value,int page,int rows) throws Exception{
			
			System.out.println("id:---"+id);
			System.out.println("key~~~:"+key);
			System.out.println("value~~~:"+value);
			System.out.println("page:---"+page);
			System.out.println("rows:---"+rows);
			
			Khgl khgl=new Khgl();
			GcmcSon gcmcSon=new GcmcSon();
			if(key.equals("all")) {//查询所有
				khgl.setKhmc_id(id);
			}else if(key.equals("gcmc_name")) {//工程名称查询
				gcmcSon.setGcmc_name(value);
			}else if(key.equals("khmc_name")) {//客户名称查询
				khgl.setKhmc_name(value);
			}else {//客户id查询
				khgl.setKhmc_id(Integer.parseInt(value));
			}
			gcmcSon.setKhgl(khgl);
			//使用分页组件 
			PageHelper.startPage(page, rows);
			return gcmcService.getGcId(gcmcSon);
			
			//返回过滤数据 模板
			
		}
		
		//添加方式1 使用REST参数风格 拼接数据
		@RequestMapping("addGcmc1/{khmc_id}/{gcmc_name}/{khmc_name}")
		 @ResponseBody
		public MessageInfo addGcmc(@PathVariable("khmc_id")int khmc_id,@PathVariable("gcmc_name")String gcmc_name,@PathVariable("khmc_name")String khmc_name) throws Exception {
			Khgl khgl=new Khgl();
			khgl.setKhmc_id(khmc_id);
			khgl.setKhmc_name(khmc_name);
			gcmcSon.setGcmc_name(gcmc_name);
			gcmcSon.setKhgl(khgl);
			System.out.println(gcmcSon.getKhgl().getKhmc_id());
			//System.out.println(add.length());
			/*System.out.println("gcmc_id:"+gcmc_id);
			System.out.println("gcmc_name:"+gcmc_name);
			System.out.println("khmc_name:"+khmc_name);*/
			
			return gcmcService.addGcmc(gcmcSon);	
		}
		
		
		//添加方式2 使用ajax
				@RequestMapping("addGcmc2")
				 @ResponseBody
				public MessageInfo addGcmcs(String[] add) throws Exception {
					System.out.println(777);
					//System.out.println(add.length);
					/*System.out.println("gcmc_id:"+gcmc_id);
					System.out.println("gcmc_name:"+gcmc_name);
					System.out.println("khmc_name:"+khmc_name);*/
					Khgl khgl=new Khgl();
					khgl.setKhmc_id(Integer.parseInt(add[0]));
					khgl.setKhmc_name(add[1]);
					gcmcSon.setGcmc_name(add[2]);
					gcmcSon.setKhgl(khgl);
					return gcmcService.addGcmc(gcmcSon);	
				}
		//添加方式3
				@RequestMapping("addGcmc2/{khmc_id}/{gcmc_name}/{khmc_name}")
				 @ResponseBody
				public MessageInfo addGcmcss(@PathVariable("khmc_id")int khmc_id,@PathVariable("gcmc_name")String gcmc_name,@PathVariable("khmc_name")String khmc_name) throws Exception {
					Khgl khgl=new Khgl();
					khgl.setKhmc_id(khmc_id);
					khgl.setKhmc_name(khmc_name);
					gcmcSon.setGcmc_name(gcmc_name);
					gcmcSon.setKhgl(khgl);
					System.out.println(gcmcSon.getKhgl().getKhmc_id());
					//System.out.println(add.length());
					/*System.out.println("khmc_id:"+khmc_id);
					System.out.println("gcmc_name:"+gcmc_name);
					System.out.println("khmc_name:"+khmc_name);*/
					
					return gcmcService.addGcmc(gcmcSon);	
				}
				
				//添加方式4 使用Easyui框架 提交到后台
				@RequestMapping("addGcmc3")
				 @ResponseBody
				public MessageInfo addGcmcsss(int khmc_id,String gcmc_name,int dept) throws Exception {
					
					//System.out.println(add.length());
					System.out.println(888);
					System.out.println("khmc_id:"+khmc_id);
					System.out.println("gcmc_name:"+gcmc_name);
					System.out.println("khmc_name:"+dept);
					String khmc_name=null;
					if(dept==1) {
						khmc_name="范彬彬";
					}else if(dept==2) {
						khmc_name="周杰伦";
					}
					Khgl khgl=new Khgl();
					khgl.setKhmc_id(khmc_id);
					khgl.setKhmc_name(khmc_name);
					gcmcSon.setGcmc_name(gcmc_name);
					gcmcSon.setKhgl(khgl);
					System.out.println(gcmcSon.getKhgl().getKhmc_id());
					MessageInfo messageInfo=gcmcService.addGcmc(gcmcSon);
					System.out.println("###"+messageInfo.getMistake());
					return messageInfo;
				}
				
}
