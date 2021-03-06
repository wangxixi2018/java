package com.sys.dao;

import java.util.List;

import com.sys.model.S_Car;

public interface S_CarDao {
	public int addS_Car(S_Car s_car);//添加购物车
	public int delS_Car(int s_carId);//通过id删除
	public int updateS_Car(int count,int s_carId);//修改
	public List<S_Car> findS_Car();//查询所有
	public List<S_Car> findS_CarByU_Id(int u_id);//通过u_id查询
	public S_Car findS_CarByS_CarId(int s_carId);//通过购物车id查询
}
