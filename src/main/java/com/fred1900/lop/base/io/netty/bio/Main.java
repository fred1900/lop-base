package com.fred1900.lop.base.io.netty.bio;

/**
 * 主程序
 * 
 * @author Fred
 * @since 2017年2月25日
 *
 */

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new TaskClient(), "t1").start();
		}
	}

}
