package com.fred1900.lop.base.other.copybooleanproterty;

import java.io.Serializable;
import java.math.BigDecimal;

class PayResult implements Serializable {
	private static final long serialVersionUID = -6803749610802622296L;
	private BigDecimal id;

	private boolean flag;

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public boolean isFlag() {
		return flag;
	}

	@Override
	public String toString() {
		return "id=" + id + "flag=" + flag;
	}

}