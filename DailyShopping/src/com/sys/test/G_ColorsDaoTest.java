package com.sys.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.sys.dao.G_ColorsDao;
import com.sys.daoImpl.G_ColorsDaoImpl;
import com.sys.util.JDBCUtil;

/**
 * 商品颜色业务层测试
 * 
 * @author Administrator
 *
 */
public class G_ColorsDaoTest {

	public static void main(String[] args) {
		// addG_Colors();
		delG_Colors();
	}

	public static void addG_Colors() {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			G_ColorsDao G_ColorsDao = new G_ColorsDaoImpl(conn);
			num = G_ColorsDao.addG_Colors("哦色");
			if (num == 1) {
				System.out.println("添加颜色成功");
			} else {
				System.out.println("添加颜色失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, null, null);
		}
	}

	public static void delG_Colors() {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			G_ColorsDao G_ColorsDao = new G_ColorsDaoImpl(conn);
			num = G_ColorsDao.delG_Colors("黄色");
			if (num == 1) {
				System.out.println("删除颜色成功");
			} else {
				System.out.println("删除颜色失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(conn, null, null);
		}
	}

}
