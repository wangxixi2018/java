package com.sys.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//校验码 防止服务器压力、安全
//注解  减少xml配置的繁琐,但效果与xml一样
@WebServlet("/image.do")
public class ImageCodeServlet extends HttpServlet {
	public static String ImageCode;//验证码
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/jpeg");
		// 使用java图形界面技术绘制一张图片
		ImageCode = "";//每次访问，之前验证码清空
		int charNum = 4;
		int width = 30 * 4;
		int height = 30;

		// 1. 创建一张内存图片
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 2.获得绘图对象
		Graphics graphics = bufferedImage.getGraphics();

		// 3、绘制背景颜色
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width, height);

		// 4、绘制图片边框
		graphics.setColor(Color.BLUE);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 5、输出验证码内容
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("宋体", Font.BOLD, 20));

		// 随机输出4个字母
		Graphics2D graphics2d = (Graphics2D) graphics;
		 String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		
		 int x = 5;
		 for (int i = 0; i < 4; i++) {
		 int index = random.nextInt(s.length());
		 String content = String.valueOf(s.charAt(index));
		 double theta = random.nextInt(45) * Math.PI / 180;
		 graphics2d.rotate(theta, x, 18);
		 graphics2d.drawString(content, x, 18);
		 graphics2d.rotate(-theta, x, 18);
		 x += 30;
		 ImageCode += content;//存放验证码
		 }
		 System.out.println(ImageCode);
		// 6、绘制干扰线
		graphics.setColor(Color.GRAY);
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(width);

			int y1 = random.nextInt(height);
			int y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}

		// 释放资源
		graphics.dispose();

		// 图书输出 ImageIO
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
