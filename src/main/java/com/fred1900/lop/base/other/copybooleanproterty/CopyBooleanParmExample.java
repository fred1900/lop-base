package com.fred1900.lop.base.other.copybooleanproterty;

import java.math.BigDecimal;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class CopyBooleanParmExample {

	@Test
	public void test() {

		PayResult2 source = new PayResult2();
		source.setId(new BigDecimal("2"));
		source.setFlag(true);

		PayResult target = new PayResult();
		target.setId(new BigDecimal("1"));

		BeanUtils.copyProperties(source, target);
		System.out.println(target.toString());
	}

}
