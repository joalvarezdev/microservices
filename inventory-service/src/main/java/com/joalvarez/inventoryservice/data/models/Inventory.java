package com.joalvarez.inventoryservice.data.models;

import jakarta.persistence.*;

@Entity
@Table(name = "inventories")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sku;
	private Long quantity;

	public Inventory() {}

	public Inventory(String sku, Long quantity) {
		this.sku = sku;
		this.quantity = quantity;
	}

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
