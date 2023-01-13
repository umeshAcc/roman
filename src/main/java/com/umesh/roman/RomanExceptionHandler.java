package com.umesh.roman;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RomanExceptionHandler {
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(NumberFormatException ex, WebRequest request) {
       
       return ex.getMessage();
    }
}
