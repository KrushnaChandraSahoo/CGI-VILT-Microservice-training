package com.pritam.productservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
	private String errorCode;
	private String errorMessage;
}
