package com.fred1900.lop.base.rpc.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

import com.fred1900.lop.base.rpc.server.RpcObject;

/**
 * 客户端接口代理 当客户端接口方法被调用的时候，把方法名，方法参数作为参数。 传送给远程服务执行，然后获取返回值
 * 
 * @author cdwangzijian
 *
 */
@SuppressWarnings("rawtypes")
public class RpcProxy implements InvocationHandler, Serializable {
	private String ip;
	private int port;
	private Class c;

	private static final long serialVersionUID = 1L;

	public RpcProxy(String ip, int port, Class c) {
		this.ip = ip;
		this.port = port;
		this.c = c;
	}

	/**
	 * 动态代理类，当调用接口方法的时候转为调用此方法
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object o = new Object(); // 用作返回值
		// 通过socket调用远程服务
		@SuppressWarnings("resource")
		Socket s = new Socket(ip, port);
		// 组装为一个保留了要调用的类，方法名及参数的对象，然后序列化之后传给远程
		RpcObject rpcObject = new RpcObject(c, method.getName(), args);
		ObjectOutputStream os = null;
		ObjectInputStream is = null;
		try {
			os = new ObjectOutputStream(s.getOutputStream());
			os.writeObject(rpcObject);
			os.flush();
			// 从远程得到返回结果
			is = new ObjectInputStream(s.getInputStream());
			o = is.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.close();
			}

			if (is != null) {
				is.close();
			}
		}

		return o;
	}

}
