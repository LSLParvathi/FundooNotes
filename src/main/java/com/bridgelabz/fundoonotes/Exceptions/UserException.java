package com.bridgelabz.fundoonotes.Exceptions;
public class UserException 
{

	private Object data;
	private int status;
	private String message;
	
	public UserException() {
		 
	}
	public UserException(Object data, int status, String message) {
		 
		this.setData(data);
		this.setStatus(status);
		this.setMessage(message);
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
