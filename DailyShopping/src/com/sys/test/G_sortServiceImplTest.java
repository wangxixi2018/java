package com.sys.test;

import java.util.List;

import com.sys.model.G_sort;
import com.sys.service.G_sortService;
import com.sys.serviceImpl.G_sortServiceImpl;

/**
 * 商品类型业务层测试
 * 
 * @author Administrator
 *
 */
public class G_sortServiceImplTest {

	public static void main(String[] args) {
		// addG_sort();
		delG_sort();
		// updateG_sort();
		// queryG_sort();
	}

	public static void addG_sort() {
		G_sortService G_sortService = new G_sortServiceImpl();
		int num = G_sortService.addG_sort("绿66色");
		if (num == 1) {
			System.out.println("添加商品类型成功");
		} else {
			System.out.println("添加商品类型失败");
		}
	}

	public static void delG_sort() {
		G_sortService G_sortService = new G_sortServiceImpl();
		int num = G_sortService.delG_sort("呼呼");
		if (num == 1) {
			System.out.println("删除商品类型成功");
		} else {
			System.out.println("删除商品类型失败");
		}
	}

	public static void updateG_sort() {
		G_sortService G_sortService = new G_sortServiceImpl();
		int num = G_sortService.updateG_sort(6, "呼呼");
		if (num == 1) {
			System.out.println("修改商品类型成功");
		} else {
			System.out.println("修改商品类型失败");
		}
	}

	public static void queryG_sort() {
		G_sortService G_sortService = new G_sortServiceImpl();
		List<G_sort> list = G_sortService.queryG_sort();
		for (G_sort G_sort : list) {
			System.out.println(G_sort);
		}
	}
}
