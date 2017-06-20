package com.fred1900.lop.base.jetty;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JettyMain {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "lop-base-jetty.xml" });
		context.registerShutdownHook();

		System.out.println("lop-base-jetty Server started.");
	}

}
