package com.sys.utils;

import org.springframework.stereotype.Component;

@Component
public class MessageInfo {
  private Boolean flag;
  private String mistake;
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public String getMistake() {
		return mistake;
	}
	public void setMistake(String mistake) {
		this.mistake = mistake;
	}
  
}
