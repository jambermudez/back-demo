package com.example.demoback.interceptor.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demoback.exception.Operation400Exception;
import com.example.demoback.exception.OperationException;



@RestControllerAdvice
public class OperationInterceptorAdviser implements HandlerInterceptor {
	
	private static final Logger LOG = LoggerFactory.getLogger(OperationInterceptorAdviser.class);
	 
		@ExceptionHandler(OperationException.class)
		@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
		@ResponseBody
		public String obtenerExceptionDto(OperationException operationException, WebRequest request) throws OperationException {
			LOG.info("Se ha producido una excepci\u00f3n controlada: ", operationException);
			return operationException.getMessage();
		}
		
		@ExceptionHandler(Operation400Exception.class)
		@ResponseStatus(value = HttpStatus.BAD_REQUEST)
		@ResponseBody
		public String obtenerException400Dto(Operation400Exception operationException, WebRequest request) throws Operation400Exception {
			LOG.info("Se ha producido una excepci\u00f3n controlada: ", operationException);
			return operationException.getMessage();
		}
}
