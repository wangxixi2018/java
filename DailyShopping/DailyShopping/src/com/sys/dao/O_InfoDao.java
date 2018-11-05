package com.sys.dao;

import java.sql.SQLException;
import java.util.List;

import com.sys.model.O_Info;

public interface O_InfoDao {
    //查看订单详情
	public List<O_Info> getAllO_Info() throws SQLException;
}
