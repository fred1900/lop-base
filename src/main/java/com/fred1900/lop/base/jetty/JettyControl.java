package com.fred1900.lop.base.jetty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jetty/test")
public class JettyControl {

	@RequestMapping("/hello")
	public void testHello() {
		System.out.println("hello jetty");

	}

}
