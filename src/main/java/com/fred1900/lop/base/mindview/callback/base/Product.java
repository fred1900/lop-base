package com.fred1900.lop.base.mindview.callback.base;

import java.math.BigDecimal;

/**
 * 商品信息
 * 
 * @author Fred
 * @since 2017年4月15日
 *
 */
public class Product {

	/**
	 * 商品id
	 */
	private String id;

	/**
	 * 商品名称
	 */
	private String productName;

	/**
	 * 商品价格
	 */
	private BigDecimal productPrice;

	/**
	 * 商品购买地址
	 */
	private String shopUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

}
