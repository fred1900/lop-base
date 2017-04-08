package com.fred1900.lop.base.rpc;

import com.fred1900.lop.base.rpc.client.ProxyFactory;
import com.fred1900.lop.base.rpc.service.IHello;

public class RpcClient {
	public static void main(String[] args) {
		String ip = "localhost";
		int port = 9001;
		IHello hello = ProxyFactory.create(IHello.class, ip, port);
		System.out.println(hello.sayHello("wzj").toString());
	}
}
