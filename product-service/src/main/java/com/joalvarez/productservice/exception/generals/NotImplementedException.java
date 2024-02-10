package com.joalvarez.productservice.exception.generals;

import com.joalvarez.productservice.constants.ErrorCode;
import org.springframework.http.HttpStatus;

public class NotImplementedException extends GenericException {

	public NotImplementedException() {
		super(HttpStatus.NOT_IMPLEMENTED, ErrorCode.NOT_IMPLEMENTED_ERROR);
	}
}