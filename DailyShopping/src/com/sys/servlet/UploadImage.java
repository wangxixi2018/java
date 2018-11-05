package com.sys.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.sys.model.User;
import com.sys.service.UserService;
import com.sys.serviceImpl.UserServiceImpl;

@WebServlet("/uploadPic.do")
@MultipartConfig
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---这里是上传图片的servlet----");
		String picflag = request.getParameter("picture");
		System.out.println(picflag);
		String picPath = null;
		if("uploadpic".equals(picflag)){
			User user = (User)request.getSession().getAttribute("user");
			String userPath = userService.getU_picpathByU_id(user.getU_id());
			System.out.println("----上传----");
			Part part = request.getPart("pic");//前台的文件标签的name,若ajax直接提交表单，这里无法获取
			System.out.println("part:"+part);
			String file = part.getHeader("Content-Disposition");
			//获取文件名
			String fileName = file.substring(file.lastIndexOf("=")+2, file.length()-1);
			System.out.println(fileName);
			//获取项目的部署路劲
			//String basePath = getServletContext().getRealPath("/");
			String basePath = "E:\\pic\\";
			//System.out.println(basePath);
			String uuid = makeFileName(fileName);
			picPath = basePath+uuid;
			//上传文件到部署路劲
			part.write(basePath+uuid);
			//保存路径到用户字段
			PrintWriter out = response.getWriter();
			if(userService.updateU_picpath(picPath,user.getU_id())){
				//删除用户之前的图片
				File files = new File(userPath);
				files.delete();
			}
			user.setU_path(picPath);
			User user1 = user;
			request.getSession().setAttribute("user",user1);
			//将路径存在session中方便下面显示是用
			response.setContentType("text/json;charset=utf-8");//设置响应的方式为json
			request.getSession().setAttribute("PIC", picPath);
			System.out.println("picPath"+picPath);
			out.write(JSON.toJSONString("true"));
			out.close();
		}else if("showpic".equals(picflag)){
				System.out.println("这里是上传图片里面显示图片的servlet");
				//从前台获取图片的路劲（部署项目的根路径）此路劲必须包含到图片，
				Object obj = request.getSession().getAttribute("PIC");
				String picpath = null;
				if(obj != null && obj instanceof String){
					picpath = (String) obj;
				}
				System.out.println(picpath);
				//以该路劲创建一个新文件，只需要找到图片的路劲就可以
				File file = new File(picpath);
				response.setCharacterEncoding("gb2312");
				response.setContentType("doc");
				response.setHeader("Content-Disposition", "attachment; filename=" + new String(file.getName().getBytes("gb2312"),"iso8859-1"));
	 
				System.out.println(new String(file.getName().getBytes("gb2312"),"gb2312"));
	 
				OutputStream output = null;
				FileInputStream fis = null;
				try{
					output = response.getOutputStream();
					fis = new FileInputStream(file);
			
					byte[] b = new byte[1024];
					int i = 0;
			
					while((i = fis.read(b))!=-1){
						output.write(b, 0, i);
					}
					output.write(b, 0, b.length);
			
					output.flush();
					response.flushBuffer();
				}
				catch(Exception e){
					System.out.println("Error!");
					e.printStackTrace();
				}
				finally{
					if(fis != null){
						fis.close();
						fis = null;
					}if(output != null){
						output.close();
						output = null;
					}
				}	
		}	
	}
	 /**
	    * @Method: makeFileName
	    * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
	    * @param filename 文件的原始名称
	    * @return uuid+"_"+文件的原始名称
	    */ 
	    private String makeFileName(String filename){  //2.jpg
	        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
	        return UUID.randomUUID().toString() + "_" + filename;
	    }
	    
	    /**
	     * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
	    * @Method: makePath
	    * @param filename 文件名，要根据文件名生成存储目录
	    * @param savePath 文件存储路径
	    * @return 新的存储目录
	    */ 
	    private String makePath(String filename,String savePath){
	        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
	        int hashcode = filename.hashCode();
	        int dir1 = hashcode&0xf;  //0--15
	        int dir2 = (hashcode&0xf0)>>4;  //0-15
	        //构造新的保存目录
	        String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
	        //File既可以代表文件也可以代表目录
	        File file = new File(dir);
	        //如果目录不存在
	        if(!file.exists()){
	            //创建目录
	            file.mkdirs();
	        }
	        return dir;
	    }
}
