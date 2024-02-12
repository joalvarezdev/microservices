package com.joalvarez.orderservice.data.dto;

import com.joalvarez.orderservice.data.dto.generals.BaseDTO;

import java.util.UUID;

public class ItemDTO implements BaseDTO {

	private Long id;
	private String sku;
	private Double price;
	private Long quantity;
	private UUID orderId;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}
}
