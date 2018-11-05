package com.sys.model;

import java.io.Serializable;

/**
 * 历史订单类
 * @author xiong
 *
 */
public class HistoryOrder implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   private int historyOrderID;
   private int o_ID;
   private int o_statusID;
public int getHistoryOrderID() {
	return historyOrderID;
}
public void setHistoryOrderID(int historyOrderID) {
	this.historyOrderID = historyOrderID;
}
public int getO_ID() {
	return o_ID;
}
public void setO_ID(int o_ID) {
	this.o_ID = o_ID;
}
public int getO_statusID() {
	return o_statusID;
}
public void setO_statusID(int o_statusID) {
	this.o_statusID = o_statusID;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
   
}
