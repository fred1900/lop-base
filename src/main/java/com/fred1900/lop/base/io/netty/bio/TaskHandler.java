package com.fred1900.lop.base.io.netty.bio;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.fred1900.bop.utils.StringUtil;

/**
 * 任务处理类
 * 
 * @author Fred
 * @since 2017年2月25日
 *
 */

public class TaskHandler implements Runnable {

	private Socket socket;

	public TaskHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("当前线程：" + Thread.currentThread().getName());
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(this.socket.getOutputStream());
			in = new DataInputStream(this.socket.getInputStream());
			StringBuilder sbData = new StringBuilder();
			String data = in.readUTF();
			sbData.append(data);
			// for (String data = in.readLine(); StringUtil.isNotEmpty(data);) {
			// System.out.println("获取："+data);
			// sbData.append(data);
			// }
			System.out.println("服务器接受到客服端的数据：" + sbData);
			out.writeUTF("已经收到" + sbData);
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Close connection");
			try {
				if (null != in) {
					in.close();
					in = null;
				}
				if (null != out) {
					out.close();
					out = null;
				}

				if (null != socket) {
					socket.close();
					socket = null;
				}
			} catch (IOException e) {
				System.out.println("Close IO fail");
				e.printStackTrace();
			}

		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
