package org.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "ca_products")
public class CaProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ca_Id")
	private Integer id;

	@NonNull
	@Column(name = "ca_Name")
	private String name;

	@NonNull
	@Column(name = "ca_Type")
	private String type;

	@NonNull
	@Column(name = "ca_FinalPrice")
	private float finalPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

}
