package com.joalvarez.productservice.data.dto;

import com.joalvarez.productservice.data.dto.generals.BaseDTO;

public class ProductDTO implements BaseDTO {

	private Long id;
	private String sku;
	private String description;
	private Double price;
	private boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
