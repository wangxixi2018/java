package com.sys.util;

/**
 * 下载文件（展示在页面上）
 */
import java.io.File;
import java.io.IOException;
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

@WebServlet("/getFiles.do")
public class ListFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(99998);
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

		System.out.println(src);
		// System.out.println(fileName + "!!");
		// fileName = new String(fileName.getBytes(), "UTF-8");
		// 上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
		// String fileSaveRootPath =
		// this.getServletContext().getRealPath("C:\\dailyShopping_images");
		String fileSaveRootPath = "C:/dailyShopping_images";
		System.out.println(fileSaveRootPath);
		// 通过文件名找出文件的所在目录
		String path = findFileSavePathByFileName(src, fileSaveRootPath);
		// 得到要下载的文件
		File file = new File(path + "\\" + src);
		System.out.println("test:" + path + "\\" + src);
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