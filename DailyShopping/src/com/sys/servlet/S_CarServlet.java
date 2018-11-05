package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sys.model.G_Colors;
import com.sys.model.G_son;
import com.sys.model.G_sort1;
import com.sys.model.G_sort2;
import com.sys.model.Goods;
import com.sys.model.S_Car;
import com.sys.service.G_ColorsService;
import com.sys.service.G_SizeService;
import com.sys.service.G_sonService;
import com.sys.service.G_sort1Service;
import com.sys.service.G_sort2Service;
import com.sys.service.GoodsService;
import com.sys.service.S_CarService;
import com.sys.serviceImpl.G_ColorsServiceImpl;
import com.sys.serviceImpl.G_SizeServiceImpl;
import com.sys.serviceImpl.G_sonServiceImpl;
import com.sys.serviceImpl.G_sort1ServiceImpl;
import com.sys.serviceImpl.G_sort2ServiceImpl;
import com.sys.serviceImpl.GoodsServiceImpl;
import com.sys.serviceImpl.S_CarServiceImpl;

@WebServlet("/s_car.do")
public class S_CarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private S_CarService s_carService = new S_CarServiceImpl();
	private GoodsService goodsService = new GoodsServiceImpl();
	private G_sonService g_sonService = new G_sonServiceImpl();
	private G_sort1Service g_sort1Service = new G_sort1ServiceImpl();
	private G_sort2Service g_sort2Service = new G_sort2ServiceImpl();
	private G_ColorsService g_colorsService = new G_ColorsServiceImpl();
	private G_SizeService g_sizeService = new G_SizeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opr = req.getParameter("opr");
		switch (opr) {
		case "adds_car":
			adds_car(req, resp);
			break;
		case "deletes_car":
			deletes_car(req, resp);
			break;
		case "addUsers_car":
			addUsers_car(req, resp);
			break;
		case "updates_car":
			updates_car(req, resp);
			break;
		default:
			break;
		}
	}

	// 修改购物车
	public void updates_car(HttpServletRequest req, HttpServletResponse resp) {
		int s_carId = Integer.parseInt(req.getParameter("s_carId"));
		int g_count = Integer.parseInt(req.getParameter("g_count"));
		try {
			PrintWriter out = resp.getWriter();
			if (s_carService.updateS_Car(g_count, s_carId)) {
				out.write(JSON.toJSONString("true"));
			} else {
				out.write(JSON.toJSONString("false"));
			}
			out.close();
			List<S_Car> s_carList = (ArrayList<S_Car>) req.getSession().getAttribute("s_carList");
			for (S_Car s : s_carList) {
				if (s.getS_carId() == s_carId) {
					s.setGoods_count(g_count);
				}
			}
			req.getSession().removeAttribute("s_carList");
			req.getSession().setAttribute("s_carList", s_carList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 删除购物车
	public void deletes_car(HttpServletRequest req, HttpServletResponse resp) {
		int s_carId = Integer.parseInt(req.getParameter("s_carId"));
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		try {
			PrintWriter out = resp.getWriter();
			if (s_carService.delS_Car(s_carId)) {
				out.write(JSON.toJSONString("true"));
				List<S_Car> s_carList = (ArrayList<S_Car>) req.getSession().getAttribute("s_carList");
				req.getSession().removeAttribute("s_carList");
				for (S_Car s : s_carList) {
					if (s.getS_carId() == s_carId) {
						s_carList.remove(s);
						break;
					}
				}
				req.getSession().setAttribute("s_carList", s_carList);
			} else {
				out.write(JSON.toJSONString("false"));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 添加购物车
	public void adds_car(HttpServletRequest req, HttpServletResponse resp) {
		int g_id = Integer.parseInt(req.getParameter("g_id"));
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		int g_count = Integer.parseInt(req.getParameter("g_count"));
		List<S_Car> s_carList = s_carService.findS_CarByU_Id(u_id);
		for (S_Car s : s_carList) {
			if (s.getG_id() == g_id) {
				int g_counts = s.getGoods_count() + g_count;
				int s_carId = s.getS_carId();
				if (s_carService.updateS_Car(g_counts, s_carId)) {
					req.getSession().removeAttribute("s_carList");
					req.getSession().setAttribute("s_carList", s_carService.findS_CarByU_Id(u_id));
				}
			} else {
				S_Car s_car = new S_Car();
				s_car.setG_id(g_id);
				s_car.setU_id(u_id);
				s_car.setGoods_count(g_count);
				if (s_carService.addS_Car(s_car)) {
					req.getSession().removeAttribute("s_carList");
					req.getSession().setAttribute("s_carList", s_carService.findS_CarByU_Id(u_id));
				}
			}
		}
	}

	// 添加购物车1
	public void addUsers_car(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(888);
		int g_id = Integer.parseInt(req.getParameter("g_id"));
		int User = Integer.parseInt(req.getParameter("u_id"));
		int g_count = Integer.parseInt(req.getParameter("g_count"));
		String g_colors = req.getParameter("g_colors");
		String G_Size = req.getParameter("G_Size");
		GoodsService goodsServlet = new GoodsServiceImpl();
		List<Goods> listGoods = goodsServlet.queryGoods(g_id);
		G_sort1Service g_sort1Service = new G_sort1ServiceImpl();
		G_sort2Service g_sort2Service = new G_sort2ServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		S_CarService s_CarService = new S_CarServiceImpl();
		S_Car s_car = new S_Car();

		double g_price = 0;// 商品单价
		int g_integral = 0;// 商品积分
		String g_sortofsex = null;// 按性别分类;
		String g_sortofstyle = null;// 按种类分类
		String g_name = null;// 商品（品牌）名称
		for (Goods goods : listGoods) {
			g_price = goods.getG_g_price();
			g_integral = goods.getG_integral();
			G_sort1 g_sort1 = g_sort1Service.getG_sort1ById(goods.getG_sort1ID());
			g_sortofsex = g_sort1.getG_sName();
			G_sort2 g_sort2 = g_sort2Service.getG_sort2ById(goods.getG_sort2ID());
			g_sortofstyle = g_sort2.getG_sName();
			List<G_son> listS_son = g_sonService.queryG_son(goods.getG_sonID());
			for (G_son g_son : listS_son) {
				g_name = g_son.getG_sName();
				break;
			}
		}

		s_car.setG_color(g_colors);
		s_car.setG_id(g_id);
		s_car.setG_integral(g_integral);
		s_car.setG_name(g_name);
		s_car.setG_price(g_price);
		s_car.setG_size(G_Size);
		s_car.setG_sortofsex(g_sortofsex);
		s_car.setG_sortofstyle(g_sortofstyle);
		s_car.setGoods_count(g_count);
		s_car.setU_id(User);

		// System.out.println(s_car.getG_color() + "|" + s_car.getG_id() + "|" +
		// s_car.getG_integral() + "|"
		// + s_car.getG_name() + "|" + s_car.getG_price() + "|" + s_car.getG_size() +
		// "|" + s_car.getG_sortofsex()
		// + "|" + s_car.getG_sortofstyle() + "|" + s_car.getGoods_count() + "|" +
		// s_car.getU_id());
		boolean fal = s_CarService.addS_Car(s_car);
		if (fal) {
			// System.out.println("添加购物车成功");
			try {
				PrintWriter out = resp.getWriter();
				out.write(JSON.toJSONString("true"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			req.getSession().removeAttribute("s_carList");
			req.getSession().setAttribute("s_carList", agiondos_car(User));
		}

	}

	public List<S_Car> agiondos_car(int u_id) {
		List<S_Car> s_carList2 = new ArrayList<S_Car>();
		List<S_Car> s_carList = s_carService.findS_CarByU_Id(u_id);
		for (S_Car s : s_carList) {
			S_Car s_car = new S_Car();
			s_car.setS_carId(s.getS_carId());
			s_car.setU_id(u_id);
			s_car.setGoods_count(s.getGoods_count());
			Goods goods = new Goods();
			s_car.setG_id(s.getG_id());
			List<Goods> goodsList = goodsService.queryGoods(s.getG_id());
			for (Goods g : goodsList) {
				goods.setG_ID(g.getG_ID());
				goods.setG_sort1ID(g.getG_sort1ID());
				goods.setG_sort2ID(g.getG_sort2ID());
				goods.setG_sonID(g.getG_sonID());
				goods.setG_colorsID(g.getG_colorsID());
				goods.setG_sizeID(g.getG_sizeID());
				goods.setG_integral(g.getG_integral());
				goods.setG_g_price(g.getG_g_price());
				goods.setG_src(g.getG_src());
			}
			s_car.setG_integral(goods.getG_integral());
			s_car.setG_price(goods.getG_g_price());
			List<G_son> g_sonList = g_sonService.queryG_son(goods.getG_sonID());
			for (G_son g_son : g_sonList) {
				s_car.setG_name(g_son.getG_sName());
			}
			s_car.setG_sortofsex(g_sort1Service.getG_sort1ById(goods.getG_sort1ID()).getG_sName());
			s_car.setG_sortofstyle(g_sort2Service.getG_sort2ById(goods.getG_sort2ID()).getG_sName());
			List<G_Colors> g_colorsList = g_colorsService.queryG_Colors(goods.getG_colorsID());
			for (G_Colors c : g_colorsList) {
				s_car.setG_color(c.getG_colors());
			}
			s_car.setG_size(g_sizeService.getG_SizeById(goods.getG_sizeID()).getG_size());
			s_carList2.add(s_car);
		}
		return s_carList2;
	}

}
