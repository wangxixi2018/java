package com.sys.test;

import java.util.List;

import com.sys.model.G_sort1;
import com.sys.service.G_sort1Service;
import com.sys.serviceImpl.G_sort1ServiceImpl;

/**
 * 商品类型业务层测试
 * 
 * @author Administrator
 *
 */
public class G_sort1ServiceImplTest {

	public static void main(String[] args) {
		// addG_sort1();
		// delG_sort1();
		// updateG_sort1();
		queryG_sort1();
	}

	public static void addG_sort1() {
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		int num = G_sort1Service.addG_sort1("绿66色");
		if (num == 1) {
			System.out.println("添加商品类型1成功");
		} else {
			System.out.println("添加商品类型1失败");
		}
	}

	public static void delG_sort1() {
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		int num = G_sort1Service.delG_sort1("呼呼");
		if (num == 1) {
			System.out.println("删除商品类型1成功");
		} else {
			System.out.println("删除商品类型1失败");
		}
	}

	public static void updateG_sort1() {
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		int num = G_sort1Service.updateG_sort1(6, "呼呼");
		if (num == 1) {
			System.out.println("修改商品类型1成功");
		} else {
			System.out.println("修改商品类型1失败");
		}
	}

	public static void queryG_sort1() {
		G_sort1Service G_sort1Service = new G_sort1ServiceImpl();
		List<G_sort1> list = G_sort1Service.queryG_sort1();
		for (G_sort1 G_sort1 : list) {
			System.out.println(G_sort1);
		}
	}
}
