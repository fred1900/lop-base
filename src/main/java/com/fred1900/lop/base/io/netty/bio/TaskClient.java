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
 * Bio客户端
 * 
 * @author Fred
 * @since 2017年2月25日
 *
 */

public class TaskClient implements Runnable {

	public final static String SERVER_ADDR = "127.0.0.1";
	public final static int SERVER_PORT = 8080;

	public void run() {
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			socket = new Socket(SERVER_ADDR, SERVER_PORT);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("发送信息：hello");
			out.writeUTF("发送信息：hello");
			StringBuilder sbData = new StringBuilder();
			String data = in.readUTF();
			sbData.append(data);
			System.out.println("接受到服务器返回的数据：" + sbData);
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
}
