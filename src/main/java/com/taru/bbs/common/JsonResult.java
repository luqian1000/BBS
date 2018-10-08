package com.taru.bbs.common;

public class JsonResult <T>{

	private String status;
	private T data;
	private String message;

	public JsonResult(String message, String status,T data) {
		this.data=data;
		this.message = message;
		this.status = status;
	}
	public JsonResult(String message, String status) {
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}