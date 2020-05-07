package com.capgemini.hcm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.hcm.exception.ErrorInfo;
import com.capgemini.hcm.exception.TestsException;

@RestControllerAdvice
public class TestAdvice {
	
		@ExceptionHandler(value = {TestsException.class})
		@ResponseStatus(code=HttpStatus.BAD_REQUEST)
		public ErrorInfo handleException1(Exception ex) {
			return new ErrorInfo(ex.getMessage());
		}

}
