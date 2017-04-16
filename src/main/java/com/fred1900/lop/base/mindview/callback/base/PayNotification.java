package com.fred1900.lop.base.mindview.callback.base;

/**
 * 付款通知
 * 
 * @author Fred
 * @since 2017年4月15日
 *
 */
public interface PayNotification {

	/**
	 * 付款通知
	 * 
	 * @param product
	 */
	void payNotify(ProductPayResult result);

}
