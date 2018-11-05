package com.sys.test;

import java.util.List;

import com.sys.model.G_rank;
import com.sys.service.G_rankService;
import com.sys.serviceImpl.G_rankServiceImpl;

/**
 * 商品展示区域业务层测试
 * 
 * @author Administrator
 *
 */
public class G_rankServiceImplTest {

	public static void main(String[] args) {
		// addG_rank();
		delG_rank();
		// updateG_rank();
		// queryG_rank();
	}

	public static void addG_rank() {

		G_rankService G_renkService = new G_rankServiceImpl();
		int num = G_renkService.addG_rank("绿66色");
		if (num == 1) {
			System.out.println("添加商品展示区域成功");
		} else {
			System.out.println("添加商品展示区域失败");
		}
	}

	public static void delG_rank() {
		G_rankService G_rankService = new G_rankServiceImpl();
		int num = G_rankService.delG_rank("呼呼");
		if (num == 1) {
			System.out.println("删除商品展示区域成功");
		} else {
			System.out.println("删除商品展示区域失败");
		}
	}

	public static void updateG_rank() {
		G_rankService G_rankService = new G_rankServiceImpl();
		int num = G_rankService.updateG_rank(4, "呼呼");
		if (num == 1) {
			System.out.println("修改商品展示区域成功");
		} else {
			System.out.println("修改商品展示区域失败");
		}
	}

	public static void queryG_rank() {
		G_rankService G_rankService = new G_rankServiceImpl();
		List<G_rank> list = G_rankService.queryG_rank();
		for (G_rank G_rank : list) {
			System.out.println(G_rank);
		}
	}
}
