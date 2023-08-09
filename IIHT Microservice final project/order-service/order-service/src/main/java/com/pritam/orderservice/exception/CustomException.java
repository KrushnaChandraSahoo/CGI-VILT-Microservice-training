package com.pritam.orderservice.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{
	public String errorCode;
    public int status;

    public CustomException(String message, String errorCode, int status){
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
