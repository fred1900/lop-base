package com.fred1900.lop.base.rpc.service.impl;

import com.fred1900.lop.base.rpc.service.IHello;

public class HelloImpl implements IHello {

	public String sayHello(String name) {
		return "hello:" + name;
	}
}
