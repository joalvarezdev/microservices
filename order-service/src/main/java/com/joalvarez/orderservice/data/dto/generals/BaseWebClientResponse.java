package com.joalvarez.orderservice.data.dto.generals;

import java.util.List;
import java.util.Objects;

public record BaseWebClientResponse(List<String> errorMessages) implements BaseDTO {

	public boolean hasErrors() {
		return Objects.nonNull(this.errorMessages) && !this.errorMessages.isEmpty();
	}
}
