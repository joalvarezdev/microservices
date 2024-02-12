package com.joalvarez.inventoryservice.data.dto;

import com.joalvarez.inventoryservice.data.dto.generals.BaseDTO;

public class InventoryDTO implements BaseDTO {

	private Long id;
	private String sku;
	private Long quantity;

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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
