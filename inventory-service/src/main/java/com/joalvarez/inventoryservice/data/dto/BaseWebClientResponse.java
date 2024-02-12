package com.joalvarez.inventoryservice.data.dto;

import com.joalvarez.inventoryservice.data.dto.generals.BaseDTO;

import java.util.List;
import java.util.Objects;

public record BaseWebClientResponse(List<String> errorMessages) implements BaseDTO {

	public boolean hasErrors() {
		return Objects.nonNull(this.errorMessages) && !this.errorMessages.isEmpty();
	}
}
