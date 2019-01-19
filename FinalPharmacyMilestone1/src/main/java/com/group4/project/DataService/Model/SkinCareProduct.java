package com.group4.project.DataService.Model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("skincarelist")
public class SkinCareProduct {
	@Id
	private String productId;
	private String productName;
	private Date product_Mfg_Date;
	private Date product_Exp_Date;
	private double price;

	public SkinCareProduct() {

	}

	public SkinCareProduct(String productId, String productName, Date product_Mfg_Date, Date product_Exp_Date,
			double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.product_Mfg_Date = product_Mfg_Date;
		this.product_Exp_Date = product_Exp_Date;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getProduct_Mfg_Date() {
		return product_Mfg_Date;
	}

	public void setProduct_Mfg_Date(Date product_Mfg_Date) {
		this.product_Mfg_Date = product_Mfg_Date;
	}

	public Date getProduct_Exp_Date() {
		return product_Exp_Date;
	}

	public void setProduct_Exp_Date(Date product_Exp_Date) {
		this.product_Exp_Date = product_Exp_Date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SkinCareProduct [productId=" + productId + ", productName=" + productName + ", product_Mfg_Date="
				+ product_Mfg_Date + ", product_Exp_Date=" + product_Exp_Date + ", price=" + price + "]";
	}

}
