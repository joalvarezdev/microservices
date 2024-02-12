package com.joalvarez.orderservice.data.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	private UUID id;
	private Long number;
	@OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
	private List<Item> details;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public List<Item> getDetails() {
		return details;
	}

	public void setDetails(List<Item> details) {
		this.details = details;
	}
}
