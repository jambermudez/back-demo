package com.example.demoback.exception;

public class OperationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Class throws Exception.
	 */
	private Class<?> classException;
	
	public OperationException(Class<?> classException, String message) {
		this.setClassException(classException);
	}

	public Class<?> getClassException() {
		return classException;
	}

	public void setClassException(Class<?> classException) {
		this.classException = classException;
	}

}
