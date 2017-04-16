package com.fred1900.lop.base.other.copybooleanproterty;

import java.io.Serializable;
import java.math.BigDecimal;

class PayResult2 implements Serializable {
	private static final long serialVersionUID = -6803749610802622296L;
	private BigDecimal id;

	private Boolean flag;

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public Boolean isFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "id=" + id + "flag=" + flag;
	}

}