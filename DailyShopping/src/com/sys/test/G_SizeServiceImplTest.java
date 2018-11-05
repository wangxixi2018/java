package com.sys.test;

import java.util.List;

import com.sys.model.G_Size;
import com.sys.service.G_SizeService;
import com.sys.serviceImpl.G_SizeServiceImpl;

/**
 * 商品规格业务层测试
 * 
 * @author Administrator
 *
 */
public class G_SizeServiceImplTest {

	public static void main(String[] args) {
		// addG_Size();
		delG_Size();
		// updateG_Size();
		// queryG_Size();
	}

	public static void addG_Size() {
		G_SizeService G_SizeService = new G_SizeServiceImpl();
		int num = G_SizeService.addG_Size("XXXXX");
		if (num == 1) {
			System.out.println("添加商品规格成功");
		} else {
			System.out.println("添加商品规格失败");
		}
	}

	public static void delG_Size() {
		G_SizeService G_SizeService = new G_SizeServiceImpl();
		int num = G_SizeService.delG_Size("LLLLL");
		if (num == 1) {
			System.out.println("删除商品规格成功");
		} else {
			System.out.println("删除商品规格失败");
		}
	}

	public static void updateG_Size() {
		G_SizeService G_SizeService = new G_SizeServiceImpl();
		int num = G_SizeService.updateG_Size(6, "LLLLL");
		if (num == 1) {
			System.out.println("修改商品规格成功");
		} else {
			System.out.println("修改商品规格失败");
		}
	}

	public static void queryG_Size() {
		G_SizeService g_SizeService = new G_SizeServiceImpl();
		List<G_Size> list = g_SizeService.queryG_Size();
		for (G_Size G_Size : list) {
			System.out.println(G_Size);
		}
	}
}
