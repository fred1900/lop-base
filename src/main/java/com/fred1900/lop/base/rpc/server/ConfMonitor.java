package com.fred1900.lop.base.rpc.server;

import java.util.HashMap;
import java.util.Map;

import com.fred1900.lop.base.rpc.service.impl.HelloImpl;

/**
 * 模拟配置，实际的框架中大部分都是使用xml进行配置的，比如Hessian是配置在web.xml的servlet属性里的
 * 
 * @author cdwangzijian
 *
 */
public class ConfMonitor {
	@SuppressWarnings("rawtypes")
	public static Map<String, Class> conf = new HashMap<String, Class>();

	static {
		conf.put("com.fred1900.lop.base.rpc.service.IHello", HelloImpl.class);
	}
}
