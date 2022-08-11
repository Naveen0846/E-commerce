package org.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_type")
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prodTypeId;

	@Column(name = "product_tax")
	private float tax;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", unique = true)
	private ProductTypeCategory productTypeCategory;

	public Integer getProdTypeId() {
		return prodTypeId;
	}

	public void setProdTypeId(Integer prodTypeId) {
		this.prodTypeId = prodTypeId;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public ProductTypeCategory getProductTypeCategory() {
		return productTypeCategory;
	}

	public void setProductTypeCategory(ProductTypeCategory productTypeCategory) {
		this.productTypeCategory = productTypeCategory;
	}

}
