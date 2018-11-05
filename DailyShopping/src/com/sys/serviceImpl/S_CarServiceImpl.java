package com.sys.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.S_CarDao;
import com.sys.daoImpl.S_CarDaoImpl;
import com.sys.model.S_Car;
import com.sys.service.S_CarService;
import com.sys.util.JDBCUtil;

public class S_CarServiceImpl implements S_CarService{

	@Override
	public boolean addS_Car(S_Car s_car) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			S_CarDao s_carDao = new S_CarDaoImpl(conn);
			conn.setAutoCommit(false);
			num = s_carDao.addS_Car(s_car);
			if(num==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public boolean delS_Car(int s_carId) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			S_CarDao s_carDao = new S_CarDaoImpl(conn);
			conn.setAutoCommit(false);
			num = s_carDao.delS_Car(s_carId);
			if(num==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public boolean updateS_Car(int count, int s_carId) {
		Connection conn = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnection();
			S_CarDao s_carDao = new S_CarDaoImpl(conn);
			conn.setAutoCommit(false);
			num = s_carDao.updateS_Car(count,s_carId);
			if(num==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return false;
	}

	@Override
	public List<S_Car> findS_Car() {
		Connection conn = null;
		List<S_Car> list = new ArrayList<S_Car>();
		try {
			conn = JDBCUtil.getConnection();
			S_CarDao s_carDao = new S_CarDaoImpl(conn);
			list = s_carDao.findS_Car();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public List<S_Car> findS_CarByU_Id(int u_id) {
		Connection conn = null;
		List<S_Car> list = new ArrayList<S_Car>();
		try {
			conn = JDBCUtil.getConnection();
			S_CarDao s_carDao = new S_CarDaoImpl(conn);
			list = s_carDao.findS_CarByU_Id(u_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return list;
	}

	@Override
	public S_Car findS_CarByS_CarId(int s_carId) {
		Connection conn = null;
		S_Car s_car = new S_Car();
		try {
			conn = JDBCUtil.getConnection();
			S_CarDao s_carDao = new S_CarDaoImpl(conn);
			s_car = s_carDao.findS_CarByS_CarId(s_carId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(conn, null, null);
		}
		return s_car;
	}

}
