package com.awsports.util;

/**
 * 
 * @author: Fu
 * @time: 2017年5月26日下午9:16:45
 * @description: 自定义异常类
 *
 */
public class CustomException extends Exception {
	
	private static final long serialVersionUID = -2912999915466660979L;
	
	private String message;
	
	public CustomException(String message){
		super(message);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
