package com.sys.test;

import java.util.List;

import com.sys.model.G_sort2;
import com.sys.service.G_sort2Service;
import com.sys.serviceImpl.G_sort2ServiceImpl;

/**
 * 商品类型业务层测试
 * 
 * @author Administrator
 *
 */
public class G_sort2ServiceImplTest {

	public static void main(String[] args) {
		// addG_sort2();
		delG_sort2();
		// updateG_sort2();
		// queryG_sort2();
	}

	public static void addG_sort2() {
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		int num = G_sort2Service.addG_sort2("绿66色");
		if (num == 1) {
			System.out.println("添加商品类型2成功");
		} else {
			System.out.println("添加商品类型2失败");
		}
	}

	public static void delG_sort2() {
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		int num = G_sort2Service.delG_sort2("呼呼");
		if (num == 1) {
			System.out.println("删除商品类型2成功");
		} else {
			System.out.println("删除商品类型2失败");
		}
	}

	public static void updateG_sort2() {
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		int num = G_sort2Service.updateG_sort2(6, "呼呼");
		if (num == 1) {
			System.out.println("修改商品类型2成功");
		} else {
			System.out.println("修改商品类型2失败");
		}
	}

	public static void queryG_sort2() {
		G_sort2Service G_sort2Service = new G_sort2ServiceImpl();
		List<G_sort2> list = G_sort2Service.queryG_sort2();
		for (G_sort2 G_sort2 : list) {
			System.out.println(G_sort2);
		}
	}
}
