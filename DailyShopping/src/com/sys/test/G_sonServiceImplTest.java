package com.sys.test;

import java.util.List;

import com.sys.model.G_son;
import com.sys.service.G_sonService;
import com.sys.serviceImpl.G_sonServiceImpl;

/**
 * 商品品牌业务层测试
 * 
 * @author Administrator
 *
 */
public class G_sonServiceImplTest {

	public static void main(String[] args) {
		// addG_son();
		// delG_son();
		// updateG_son();
		queryG_son();
	}

	public static void addG_son() {
		G_sonService G_sonService = new G_sonServiceImpl();
		int num = G_sonService.addG_son("绿66色", "5496");
		if (num == 1) {
			System.out.println("添加商品品牌成功");
		} else {
			System.out.println("添加商品品牌失败");
		}
	}

	public static void delG_son() {
		G_sonService G_sonService = new G_sonServiceImpl();
		int num = G_sonService.delG_son(15);
		if (num == 1) {
			System.out.println("删除商品品牌成功");
		} else {
			System.out.println("删除商品品牌失败");
		}
	}

	public static void updateG_son() {
		G_sonService G_sonService = new G_sonServiceImpl();
		G_son G_son = new G_son();
		G_son.setG_describe("999");
		G_son.setG_sName("66666");
		int num = G_sonService.updateG_son(15, G_son);
		if (num == 1) {
			System.out.println("修改商品品牌成功");
		} else {
			System.out.println("修改商品品牌失败");
		}
	}

	public static void queryG_son() {
		G_sonService G_sonService = new G_sonServiceImpl();
		List<G_son> list = G_sonService.queryG_son();
		for (G_son G_son : list) {
			System.out.println(G_son);
		}
	}
}
