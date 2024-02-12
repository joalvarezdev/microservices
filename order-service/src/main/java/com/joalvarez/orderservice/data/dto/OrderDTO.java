package com.joalvarez.orderservice.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.joalvarez.orderservice.data.dto.generals.BaseDTO;

import java.util.List;
import java.util.UUID;

public class OrderDTO implements BaseDTO {

	private UUID id;
	private Long number;
	private List<ItemDTO> details;

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

	public List<ItemDTO> getDetails() {
		return details;
	}

	public void setDetails(List<ItemDTO> details) {
		this.details = details;
	}
}
