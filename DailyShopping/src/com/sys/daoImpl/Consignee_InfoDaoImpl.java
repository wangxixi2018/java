package com.sys.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.Consignee_InfoDao;
import com.sys.model.Consignee_Information;
import com.sys.util.JDBCUtil;

public class Consignee_InfoDaoImpl extends BaseDao implements Consignee_InfoDao{

	public Consignee_InfoDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addConsignee_Info(Consignee_Information consignee_information) {
		String sql = "INSERT INTO consignee_information(o_name,o_phone,o_add,o_area,o_code,u_id)VALUES(?,?,?,?,?,?);";
		int num = 0;
		num = super.executeUpdate(sql,consignee_information.getO_name(),consignee_information.getO_phone(),consignee_information.getO_add(),consignee_information.getO_area(),consignee_information.getO_code(),consignee_information.getU_id());
		return num;
	}

	@Override
	public int delConsignee_Info(int o_takeSiteID) {
		String sql = "DELETE FROM consignee_information WHERE o_takeSiteID = ?;";
		int num = 0;
		num = super.executeUpdate(sql,o_takeSiteID);
		return num;
	}

	@Override
	public int updateConsignee_Info(Consignee_Information consignee_information) {
		String sql = "UPDATE consignee_information SET o_name=?,o_phone=?,o_add=?,o_area=?,o_code=?,u_default_add=?  WHERE o_takeSiteID =?;";
		int num = 0;
		num = super.executeUpdate(sql,consignee_information.getO_name(),consignee_information.getO_phone(),consignee_information.getO_add(),consignee_information.getO_area(),consignee_information.getO_code(),consignee_information.getU_default_add(),consignee_information.getO_takeSiteID());
		return num;
	}

	@Override
	public List<Consignee_Information> findAllConsignee_Info() {
		String sql ="SELECT * FROM consignee_information ORDER BY u_default_add DESC;";
		List<Consignee_Information> list = new ArrayList<Consignee_Information>();
		ResultSet rs = super.executeQuery(sql);
		try {
			while(rs.next()){
				Consignee_Information consignee_information = new Consignee_Information();
				consignee_information.setO_name(rs.getString("o_name"));
				consignee_information.setO_phone(rs.getString("o_phone"));
				consignee_information.setO_add(rs.getString("o_add"));
				consignee_information.setO_area(rs.getString("o_area"));
				consignee_information.setO_code(rs.getString("o_code"));
				consignee_information.setU_id(rs.getInt("u_id"));
				consignee_information.setO_takeSiteID(rs.getInt("o_takeSiteID"));
				consignee_information.setU_default_add(rs.getInt("u_default_add"));
				list.add(consignee_information);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public List<Consignee_Information> findConsignee_InfoByU_Id(int u_id) {
		String sql ="SELECT * FROM consignee_information WHERE u_id = ? ORDER BY u_default_add DESC;";
		List<Consignee_Information> list = new ArrayList<Consignee_Information>();
		ResultSet rs = super.executeQuery(sql,u_id);
		try {
			while(rs.next()){
				Consignee_Information consignee_information = new Consignee_Information();
				consignee_information.setO_name(rs.getString("o_name"));
				consignee_information.setO_phone(rs.getString("o_phone"));
				consignee_information.setO_add(rs.getString("o_add"));
				consignee_information.setO_area(rs.getString("o_area"));
				consignee_information.setO_code(rs.getString("o_code"));
				consignee_information.setU_id(rs.getInt("u_id"));
				consignee_information.setO_takeSiteID(rs.getInt("o_takeSiteID"));
				consignee_information.setU_default_add(rs.getInt("u_default_add"));
				list.add(consignee_information);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public Consignee_Information fidConsignee_InfoById(int o_takeSiteID) {
		String sql ="SELECT * FROM consignee_information WHERE o_takeSiteID = ?;";
		ResultSet rs = super.executeQuery(sql,o_takeSiteID);
		Consignee_Information consignee_information = new Consignee_Information();
		try {
			while(rs.next()){
				consignee_information.setO_name(rs.getString("o_name"));
				consignee_information.setO_phone(rs.getString("o_phone"));
				consignee_information.setO_add(rs.getString("o_add"));
				consignee_information.setO_area(rs.getString("o_area"));
				consignee_information.setO_code(rs.getString("o_code"));
				consignee_information.setU_id(rs.getInt("u_id"));
				consignee_information.setO_takeSiteID(rs.getInt("o_takeSiteID"));
				consignee_information.setU_default_add(rs.getInt("u_default_add"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeAll(null, null, rs);
		}
		return consignee_information;
	}

}
