package com.fred1900.lop.base.mindview.callback.base;

/**
 * 商品付款结果
 * 
 * @author Fred
 * @since 2017年4月15日
 *
 */
public class ProductPayResult {

	/**
	 * 付款成功code
	 */
	public final static String RESP_CODE_SUCCESS = "00";

	/**
	 * 付款失败，正忙，没时间
	 */
	public final static String RESP_CODE_FAIL_BUSY = "01";

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 返回码
	 */
	private String respCode;

	/**
	 * 返回信息
	 */
	private String respMsg;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

}
