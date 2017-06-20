package com.fred1900.lop.base.memcache.base;

import java.io.Serializable;

//实体需要序列化  
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}