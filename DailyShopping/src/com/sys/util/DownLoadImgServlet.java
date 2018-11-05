package com.sys.util;

/**
 * 下载文件：下载到本地（由于不能直接访问 WEB-INF	中的文件 ，需要经过后台处理才能访问） 加密
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sys.model.Goods;
import com.sys.service.GoodsService;
import com.sys.serviceImpl.GoodsServiceImpl;

@WebServlet("/downFileImg.do")
public class DownLoadImgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(999);
		/*
		 * //中文编码 request.setCharacterEncoding("UTF-8");
		 */

		// 得到要下载的文件名
		String fileName = request.getParameter("opr"); // 23239283-92489-阿凡达.avi
		int num = Integer.parseInt(fileName);
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> list = goodsService.queryGoods(num);
		String src = null;
		Iterator<Goods> it = list.iterator();
		while (it.hasNext()) {
			Goods goods = (Goods) it.next();
			src = goods.getG_src();
		}
		// System.out.println(src);
		// System.out.println(fileName + "!!");
		// fileName = new String(fileName.getBytes(), "UTF-8");
		// 上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
		// String fileSaveRootPath =
		// this.getServletContext().getRealPath("C:\\dailyShopping_images");
		String fileSaveRootPath = "C:/dailyShopping_images";
		// System.out.println(fileSaveRootPath);
		// 通过文件名找出文件的所在目录
		String path = findFileSavePathByFileName(src, fileSaveRootPath);
		// System.out.println("@@@");
		String number = path + src;
		// System.out.println("路径：" + number);
		// 得到要下载的文件
		File file = new File(path + "\\" + src);
		// System.out.println("test:" + path + "\\" + src);
		// 如果文件不存在
		if (!file.exists()) {
			request.setAttribute("message", "您要下载的资源已被删除！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		// 处理文件名
		String realname = src.substring(src.indexOf("_") + 1);
		// 设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		// 读取要下载的文件，保存到文件输入流
		FileInputStream in = new FileInputStream(path + "\\" + src);
		// 创建输出流
		OutputStream out = response.getOutputStream();
		// 创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		// 循环将输入流中的内容读取到缓冲区当中
		while ((len = in.read(buffer)) > 0) {
			// 输出缓冲区的内容到浏览器，实现文件下载
			out.write(buffer, 0, len);
		}
		// 关闭文件输入流
		in.close();
		// 关闭输出流
		out.close();
	}

	/**
	 * @Method: findFileSavePathByFileName
	 * @Description: 通过文件名和存储上传文件根目录找出要下载的文件的所在路径
	 * @Anthor:孤傲苍狼
	 * @param filename
	 *            要下载的文件名
	 * @param saveRootPath
	 *            上传文件保存的根目录，也就是/WEB-INF/upload目录
	 * @return 要下载的文件的存储目录
	 */
	public String findFileSavePathByFileName(String filename, String saveRootPath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		String dir = saveRootPath + "\\" + dir1 + "\\" + dir2; // upload\2\3 upload\3\5
		File file = new File(dir);
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}