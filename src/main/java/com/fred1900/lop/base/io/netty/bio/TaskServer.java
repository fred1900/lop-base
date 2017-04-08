package com.fred1900.lop.base.io.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.fred1900.bop.base.AppException;
import com.fred1900.lop.base.constant.io.IOExceptionConst;

/**
 * io通信服务端
 * 
 * @author Fred
 * @since 2017年2月25日
 *
 */

public class TaskServer {

	/**
	 * 服务器监听端口
	 */
	private static int SERVER_PORT = 8080;

	public static void main(String[] sargs) throws AppException {
		ServerSocket serverSocket = null;
		try {
			System.out.println("Start build socket ,port=" + SERVER_PORT);
			serverSocket = new ServerSocket(SERVER_PORT);
			Socket socket = null;
			while (true) {
				socket = serverSocket.accept();
				new Thread(new TaskHandler(socket)).start();
			}
		} catch (IOException ioException) {
			throw new AppException(IOExceptionConst.ACCESS_NET_FAIL, ioException);
		} finally {
			System.out.println("Close socket");
			if (null != serverSocket) {
				try {
					serverSocket.close();
				} catch (IOException ioException) {
					System.out.println("Close socket fail");
					throw new AppException(IOExceptionConst.CLOSE_IO_FAIL, ioException);
				}
				serverSocket = null;
			}
		}

	}
}
