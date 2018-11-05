package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.S_CarDao;
import com.sys.model.S_Car;
import com.sys.util.JDBCUtil;

public class S_CarDaoImpl extends BaseDao implements S_CarDao {

	public S_CarDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addS_Car(S_Car s_car) {
		String sql = "INSERT INTO s_car(g_ID,u_ID,goods_count,u_add_time)VALUES(?,?,?,NOW());";
		int num = 0;
		num = super.executeUpdate(sql, s_car.getG_id(), s_car.getU_id(), s_car.getGoods_count());
		return num;
	}

	@Override
	public int delS_Car(int s_carId) {
		String sql = "DELETE FROM s_car WHERE s_CarID = ?;";
		int num = 0;
		num = super.executeUpdate(sql, s_carId);
		return num;
	}

	@Override
	public int updateS_Car(int count, int s_carId) {
		String sql = "UPDATE s_car SET goods_count = ?,u_add_time = NOW()  WHERE s_CarID = ?;";
		int num = 0;
		num = super.executeUpdate(sql, count, s_carId);
		return num;
	}

	@Override
	public List<S_Car> findS_Car() {
		String sql = "SELECT * FROM s_car;";
		List<S_Car> list = new ArrayList<S_Car>();
		ResultSet rs = super.executeQuery(sql);
		try {
			while (rs.next()) {
				S_Car s_car = new S_Car();
				s_car.setS_carId(rs.getInt("s_CarID"));
				s_car.setG_id(rs.getInt("g_ID"));
				s_car.setGoods_count(rs.getInt("goods_count"));
				list.add(s_car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public List<S_Car> findS_CarByU_Id(int u_id) {
		String sql = "SELECT * FROM s_car WHERE u_ID = ?  ORDER BY u_add_time DESC;";
		List<S_Car> list = new ArrayList<S_Car>();
		ResultSet rs = super.executeQuery(sql, u_id);
		try {
			while (rs.next()) {
				S_Car s_car = new S_Car();
				s_car.setS_carId(rs.getInt("s_CarID"));
				s_car.setG_id(rs.getInt("g_ID"));
				s_car.setGoods_count(rs.getInt("goods_count"));
				list.add(s_car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public S_Car findS_CarByS_CarId(int s_carId) {
		String sql = "select * from s_car where s_CarID = ?;";
		ResultSet rs = super.executeQuery(sql, s_carId);
		S_Car s_car = new S_Car();
		try {
			while (rs.next()) {
				s_car.setS_carId(rs.getInt("s_CarID"));
				s_car.setG_id(rs.getInt("g_ID"));
				s_car.setGoods_count(rs.getInt("goods_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return s_car;
	}

}
