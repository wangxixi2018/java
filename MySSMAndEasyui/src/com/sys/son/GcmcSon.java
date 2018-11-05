package com.sys.son;

import org.springframework.stereotype.Component;

import com.sys.pojo.Gcmc;
import com.sys.pojo.Khgl;

/**
 * 工程管理子类
 * @author Administrator
 *
 */
@Component
public class GcmcSon extends Gcmc{
    private Khgl khgl;

	public Khgl getKhgl() {
		return khgl;
	}

	public void setKhgl(Khgl khgl) {
		this.khgl = khgl;
	}

}
