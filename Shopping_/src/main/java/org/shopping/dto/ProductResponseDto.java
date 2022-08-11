package org.shopping.dto;

import java.util.List;

import org.shopping.entity.ProductDetails;

public class ProductResponseDto {

	private List<ProductDetails> productDetails;
	private String productType;

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
