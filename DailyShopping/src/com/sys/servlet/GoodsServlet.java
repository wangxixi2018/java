package com.sys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.sys.model.G_Colors;
import com.sys.model.G_Size;
import com.sys.model.G_rank;
import com.sys.model.G_son;
import com.sys.model.G_sort1;
import com.sys.model.G_sort2;
import com.sys.model.Goods;
import com.sys.service.G_ColorsService;
import com.sys.service.G_SizeService;
import com.sys.service.G_rankService;
import com.sys.service.G_sonService;
import com.sys.service.G_sort1Service;
import com.sys.service.G_sort2Service;
import com.sys.service.GoodsService;
import com.sys.serviceImpl.G_ColorsServiceImpl;
import com.sys.serviceImpl.G_SizeServiceImpl;
import com.sys.serviceImpl.G_rankServiceImpl;
import com.sys.serviceImpl.G_sonServiceImpl;
import com.sys.serviceImpl.G_sort1ServiceImpl;
import com.sys.serviceImpl.G_sort2ServiceImpl;
import com.sys.serviceImpl.GoodsServiceImpl;

@WebServlet("/Goods.do")
public class GoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private int nus = 0;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("opr");
		switch (key) {
		case "addGoods":
			addGoods(req, resp);
			break;
		case "AddGoods": // 后台添加
			AddGoods(req, resp);
			break;
		case "GoodsAlterGoods": // 修改商品
			GoodsAlterGoods(req, resp);
			break;
		case "showindex":
			showindex(req, resp);
			break;
		case "showindex1":
			showindex1(req, resp);
			break;
		case "showImg":
			showImg(req, resp);
			break;
		case "showG_son":
			showG_son(req, resp);
			break;
		case "showG_son1":
			showG_son1(req, resp);
			break;
		case "shownanzhuang":
			shownanzhuang(req, resp);
			break;
		case "showGoods_gson2":
			showGoods_gson2(req, resp);
			break;
		case "GoodsG_g_priceDown":
			GoodsG_g_priceDown(req, resp);
			break;
		case "GoodsG_g_priceUp":
			GoodsG_g_priceUp(req, resp);
			break;
		case "showProduct": // 商品详情页面
			showProduct(req, resp);
			break;
		case "showProductColors": // 商品详情页面
			showProductColors(req, resp);
			break;
		case "GoodsG_g_priceSonDown": // 商品详情页面
			GoodsG_g_priceSonDown(req, resp);
			break;
		case "GoodsG_g_priceSonUp": // 商品详情页面
			GoodsG_g_priceSonUp(req, resp);
			break;
		case "queryAllGoods": // 查询所有商品
			queryAllGoods(req, resp);
			break;
		case "AddGoodss": // 后台添加商品2
			AddGoodss(req, resp);
			break;
		/*
		 * case "queryAppGoods": // 查询指定商品 queryAppGoods(req, resp); break;
		 */

		default:
			break;
		}
	}

	/**
	 * // 修改商品
	 * 
	 * @param req
	 * @param resp
	 */
	public void GoodsAlterGoods(HttpServletRequest req, HttpServletResponse resp) {
		int g_ID = Integer.parseInt(req.getParameter("g_ID"));
		System.out.println("g_ID:" + g_ID);
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		GoodsService goodsService = new GoodsServiceImpl();
		G_rankService g_rankService = new G_rankServiceImpl();
		G_SizeService g_SizeService = new G_SizeServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		List<G_Colors> listG_Colors = g_ColorsService.queryG_Colors();
		List<G_rank> listG_rank = g_rankService.queryG_rank();
		List<G_Size> listG_Size = g_SizeService.queryG_Size();
		List<G_son> listG_son = g_sonService.queryG_son();
		List<G_sort1> listG_sort1 = G_sort1Service.queryG_sort1();
		List<G_sort2> listG_sort2 = G_sort2Service.queryG_sort2();
		List<Goods> listGoods = goodsService.queryGoods(g_ID);
		req.setAttribute("listGoods", listGoods);
		req.setAttribute("listG_Colors", listG_Colors);
		req.setAttribute("listG_rank", listG_rank);
		req.setAttribute("listG_Size", listG_Size);
		req.setAttribute("listG_son", listG_son);
		req.setAttribute("listG_sort1", listG_sort1);
		req.setAttribute("listG_sort2", listG_sort2);
		try {
			req.getRequestDispatcher("GoodsManage/GoodsAlterGoods.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 查询所有商品
	 * 
	 * @param req
	 * @param resp
	 */
	public void queryAllGoods(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(99);
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoods();
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * for (Goods goods : listGoods) { System.out.println(goods); }
		 */
		/*
		 * req.setAttribute("listGoods", listGoods); try {
		 * req.getRequestDispatcher("GoodsManage/GoodsQueryGoods.jsp").forward(req,
		 * resp); } catch (ServletException | IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
	}

	/**
	 * 后台添加商品2
	 * 
	 * @param req
	 * @param resp
	 */
	public void AddGoodss(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		/*
		 * G_ColorsService g_ColorsService = new G_ColorsServiceImpl(); G_rankService
		 * g_rankService = new G_rankServiceImpl(); G_SizeService g_SizeService = new
		 * G_SizeServiceImpl(); G_sonService g_sonService = new G_sonServiceImpl();
		 * G_sort1Service G_sort1Service = new G_sort1ServiceImpl(); G_sort2Service
		 * G_sort2Service = new G_sort2ServiceImpl();
		 */
		/*
		 * List<G_Colors> listG_Colors = g_ColorsService.queryG_Colors(); List<G_rank>
		 * listG_rank = g_rankService.queryG_rank(); List<G_Size> listG_Size =
		 * g_SizeService.queryG_Size(); List<G_son> listG_son =
		 * g_sonService.queryG_son(); List<G_sort1> listG_sort1 =
		 * G_sort1Service.queryG_sort1(); List<G_sort2> listG_sort2 =
		 * G_sort2Service.queryG_sort2();
		 */
		// goodsService.

		/*
		 * for (G_sort1 g_sort1 : listG_sort1) {
		 * System.out.println(g_sort1.getG_sort1ID()); } for (G_sort2 g_sort2 :
		 * listG_sort2) { System.out.println(g_sort2); }
		 */
		/*
		 * req.setAttribute("listG_Colors", listG_Colors);
		 * req.setAttribute("listG_rank", listG_rank); req.setAttribute("listG_Size",
		 * listG_Size); req.setAttribute("listG_son", listG_son);
		 * req.setAttribute("listG_sort1", listG_sort1); req.setAttribute("listG_sort2",
		 * listG_sort2);
		 */

		// cookies.

		Cookie cookie = new Cookie("num", "num");
		// 2.添加Cookie
		cookie.setMaxAge(5);
		resp.addCookie(cookie);// 设置个短暂的时间 从而达到进入商品后台时中间部位没有任何显示
		// req.setAttribute("num", num);

		try {
			resp.sendRedirect("GoodsManage/GoodsManage.jsp");
			// req.getRequestDispatcher("GoodsManage/GoodsManage.jsp").forward(req, resp);
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 后台添加商品
	 * 
	 * @param req
	 * @param resp
	 */
	public void AddGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		G_rankService g_rankService = new G_rankServiceImpl();
		G_SizeService g_SizeService = new G_SizeServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		List<G_Colors> listG_Colors = g_ColorsService.queryG_Colors();
		List<G_rank> listG_rank = g_rankService.queryG_rank();
		List<G_Size> listG_Size = g_SizeService.queryG_Size();
		List<G_son> listG_son = g_sonService.queryG_son();
		List<G_sort1> listG_sort1 = G_sort1Service.queryG_sort1();
		List<G_sort2> listG_sort2 = G_sort2Service.queryG_sort2();
		// goodsService.

		/*
		 * for (G_sort1 g_sort1 : listG_sort1) {
		 * System.out.println(g_sort1.getG_sort1ID()); } for (G_sort2 g_sort2 :
		 * listG_sort2) { System.out.println(g_sort2); }
		 */
		req.setAttribute("listG_Colors", listG_Colors);
		req.setAttribute("listG_rank", listG_rank);
		req.setAttribute("listG_Size", listG_Size);
		req.setAttribute("listG_son", listG_son);
		req.setAttribute("listG_sort1", listG_sort1);
		req.setAttribute("listG_sort2", listG_sort2);

		try {
			req.getRequestDispatcher("GoodsManage/GoodsAddGoods.jsp").forward(req, resp);
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 添加商品
	 * 
	 * @param req
	 * @param resp
	 */
	public void addGoods(HttpServletRequest req, HttpServletResponse resp) {
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		G_rankService g_rankService = new G_rankServiceImpl();
		G_SizeService g_SizeService = new G_SizeServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		List<G_Colors> listG_Colors = g_ColorsService.queryG_Colors();
		List<G_rank> listG_rank = g_rankService.queryG_rank();
		List<G_Size> listG_Size = g_SizeService.queryG_Size();
		List<G_son> listG_son = g_sonService.queryG_son();
		List<G_sort1> listG_sort1 = G_sort1Service.queryG_sort1();
		List<G_sort2> listG_sort2 = G_sort2Service.queryG_sort2();
		// goodsService.

		/*
		 * for (G_sort1 g_sort1 : listG_sort1) {
		 * System.out.println(g_sort1.getG_sort1ID()); } for (G_sort2 g_sort2 :
		 * listG_sort2) { System.out.println(g_sort2); }
		 */
		req.setAttribute("listG_Colors", listG_Colors);
		req.setAttribute("listG_rank", listG_rank);
		req.setAttribute("listG_Size", listG_Size);
		req.setAttribute("listG_son", listG_son);
		req.setAttribute("listG_sort1", listG_sort1);
		req.setAttribute("listG_sort2", listG_sort2);
		try {
			req.getRequestDispatcher("addGoods.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 首页展示商品
	 */
	public void showindex(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(123456);
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		List<G_sort1> listG_sort1 = G_sort1Service.queryG_sort1();
		List<G_sort2> listG_sort2 = G_sort2Service.queryG_sort2();
		List<G_son> listG_son = g_sonService.queryG_son();
		Map<String, List<?>> map = new HashMap<String, List<?>>();
		map.put("listG_sort1", listG_sort1);
		map.put("listG_sort2", listG_sort2);
		map.put("listG_son", listG_son);
		String json = JSON.toJSONString(map);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 首页展示商品1
	 */
	public void showindex1(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(123);
		int g_sonID = Integer.parseInt(req.getParameter("g_sonID"));
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoodsg_sonID(g_sonID);
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 首页图片展示1
	 * 
	 * @param req
	 * @param resp
	 */
	public void showImg(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(888);
		int g_ID = Integer.parseInt(req.getParameter("g_ID"));
		// System.out.println(g_ID);
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoods(g_ID);
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}

	}

	/**
	 * 首页图片展示2 ()
	 */
	public void showG_son(HttpServletRequest req, HttpServletResponse resp) {
		int g_sonID = Integer.parseInt(req.getParameter("g_sonID"));
		G_sonService g_sonService = new G_sonServiceImpl();
		List<G_son> listG_son = g_sonService.queryG_son(g_sonID);
		String json = JSON.toJSONString(listG_son);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}

	/**
	 * 首页图片展示3 () 限时特卖
	 */
	public void showG_son1(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println("//////999");
		String nuo = req.getParameter("number");
		char[] opo = nuo.toCharArray();
		String nuy = "";
		for (int i = 1; i < opo.length - 1; i++) {
			nuy += opo[i];
		}
		// System.out.println(nuy);
		String num[] = nuy.split(",");
		GoodsService goodsService = new GoodsServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		List<Goods> listGoods = null;
		List<G_son> listG_son = null;
		// System.out.println(num.length);
		int op = 0;
		Map<String, Map<String, List<?>>> map = new HashMap<String, Map<String, List<?>>>();

		for (int i = 0; i < num.length; i++) {
			map.put("map" + i, new HashMap<String, List<?>>());
			// System.out.println(num[i]);
			listGoods = goodsService.queryGoods(Integer.parseInt(num[i]));
			for (Goods goods : listGoods) {
				// System.out.println(goods);
				listG_son = g_sonService.queryG_son(goods.getG_sonID());
				/*
				 * for (G_son g_son : listG_son) { System.out.println(g_son); }
				 */
			}
			map.get("map" + i).put("listGoods", listGoods);
			map.get("map" + i).put("listG_son", listG_son);
		}
		// System.out.println(map.size());
		String json = JSON.toJSONString(map);

		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}

	public void shownanzhuang(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(8585);
		int g_sort1ID = Integer.parseInt(req.getParameter("g_sort1ID"));
		GoodsService goodsService = new GoodsServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		List<Goods> listGoods = goodsService.queryGoodsg_sort1ID(g_sort1ID);
		List<G_son> listG_son = new ArrayList<G_son>();
		G_son g_son = null;
		// System.out.println(listGoods.size());
		for (Goods goods : listGoods) {
			List<G_son> listG_son1 = g_sonService.queryG_son(goods.getG_sonID());
			g_son = new G_son();
			for (G_son g_son2 : listG_son1) {
				g_son.setG_sonID(g_son2.getG_sonID());
				g_son.setG_sName(g_son2.getG_sName());
				g_son.setG_describe(g_son2.getG_describe());
			}
			listG_son.add(g_son);
		}

		// System.out.println(listG_son.size());
		String json = JSON.toJSONString(listG_son);

		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}

	/**
	 * 查询指定类型2的所有商品
	 */
	public void showGoods_gson2(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(8888);
		int g_sort2ID = Integer.parseInt(req.getParameter("g_sort2ID"));
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoodsg_sort2ID(g_sort2ID);
		// System.out.println(listG_son.size());
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}

	/**
	 * 查询指定类型2的所有商品 按价格（降序）sort
	 */
	public void GoodsG_g_priceDown(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(8888);
		int g_sort2ID = Integer.parseInt(req.getParameter("g_sort2ID"));
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoodsg_g_priceDown(g_sort2ID);
		/*
		 * for (Goods goods : listGoods) { System.out.println(goods.getG_g_price()); }
		 */
		// System.out.println(listG_son.size());
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}

	/**
	 * 查询指定类型2的所有商品 按价格（升序）sort
	 */
	public void GoodsG_g_priceUp(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(8888);
		int g_sort2ID = Integer.parseInt(req.getParameter("g_sort2ID"));
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoodsg_g_priceUp(g_sort2ID);
		// System.out.println(listG_son.size());
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}

	/**
	 * 查询指定类型2的所有商品 按价格（降序）son
	 */
	public void GoodsG_g_priceSonDown(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(8888);
		int g_sonID = Integer.parseInt(req.getParameter("g_sonID"));
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoodsg_g_priceSonDown(g_sonID);
		/*
		 * for (Goods goods : listGoods) { System.out.println(goods.getG_g_price()); }
		 */
		// System.out.println(listG_son.size());
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}

	/**
	 * 查询指定类型2的所有商品 按价格（升序） son
	 */
	public void GoodsG_g_priceSonUp(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(8888);
		int g_sonID = Integer.parseInt(req.getParameter("g_sonID"));
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoodsg_g_priceSonUp(g_sonID);
		// System.out.println(listG_son.size());
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}

	/**
	 * 商品详情页面
	 */
	public void showProduct(HttpServletRequest req, HttpServletResponse resp) {
		int g_ID = Integer.parseInt(req.getParameter("g_ID"));
		// System.out.println(g_ID);
		GoodsService goodsService = new GoodsServiceImpl();
		G_ColorsService g_ColorsService = new G_ColorsServiceImpl();
		G_SizeService g_SizeService = new G_SizeServiceImpl();
		G_sonService g_sonService = new G_sonServiceImpl();
		List<Goods> listGoods = goodsService.queryGoods(g_ID);
		List<Goods> listGoods1 = null;
		List<Goods> listGoods2 = null;
		List<G_son> listG_son = null;
		List<Goods> listGoods3 = null;
		List<G_Colors> listG_Colors = null;

		Goods goods1 = new Goods();
		for (Goods goods : listGoods) {
			goods1.setG_ID(goods.getG_ID());
			goods1.setG_sort1ID(goods.getG_sort1ID());
			goods1.setG_sort2ID(goods.getG_sort2ID());
			goods1.setG_sonID(goods.getG_sonID());

		}
		listGoods1 = goodsService.queryGoodsSrc(goods1);
		listGoods2 = goodsService.queryGoodsort(goods1);

		Goods goods2 = new Goods();
		/*
		 * for (int i = 0; i < listGoods2.size(); i++) { System.out.println("id:" +
		 * listGoods2.get(i).getG_colorsID()); }
		 */
		listG_son = g_sonService.queryG_son(goods1.getG_sonID());
		Map<String, Map<String, List<?>>> map = new HashMap<String, Map<String, List<?>>>();
		for (int i = 0; i < listGoods2.size(); i++) {
			map.put("map" + i, new HashMap<String, List<?>>());
			listG_Colors = g_ColorsService.queryG_Colors(listGoods2.get(i).getG_colorsID());
			for (Goods goods : listGoods) {
				goods.setG_ID(goods.getG_ID());
				goods2.setG_sort1ID(goods.getG_sort1ID());
				goods2.setG_sort2ID(goods.getG_sort2ID());
				goods2.setG_sonID(goods.getG_sonID());
				goods2.setG_colorsID(listGoods2.get(i).getG_colorsID());
				// 根据颜色再去商品表里面去查
				// System.out.println("listGoods2中的G_colorsID：" +
				// listGoods2.get(i).getG_colorsID());

			}
			// System.out.println("998877:" + goods2);
			listGoods3 = goodsService.queryGoodsColors(goods2);
			/*
			 * for (Goods good : listGoods3) { System.out.println("goods值：" + good); }
			 */
			map.get("map" + i).put("listGoods3", listGoods3);
			map.get("map" + i).put("listG_Colors", listG_Colors);

		}
		// listGoods2 = goodsService.queryGoodsSrc(goods.);
		List<G_Size> listG_Size = g_SizeService.queryG_Size();
		HttpSession session = req.getSession();
		session.setAttribute("listProduct", listGoods);
		session.setAttribute("listProduct1", listGoods1);
		session.setAttribute("listG_Size", listG_Size);
		session.setAttribute("listG_son", listG_son);
		session.setAttribute("MAP", map);
		try {
			req.getRequestDispatcher("Product.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过商品颜色找商品 ）
	 * 
	 * @param req
	 * @param resp
	 */
	public void showProductColors(HttpServletRequest req, HttpServletResponse resp) {
		int g_ID = Integer.parseInt(req.getParameter("g_ID"));
		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> listGoods = goodsService.queryGoods(g_ID);
		String json = JSON.toJSONString(listGoods);
		try {
			PrintWriter out = resp.getWriter();
			out.write(json);
			out.close();
		} catch (IOException e) { //

		}
	}
}
