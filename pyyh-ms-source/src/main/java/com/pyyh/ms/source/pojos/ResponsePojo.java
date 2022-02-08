package com.pyyh.ms.source.pojos;

public class ResponsePojo {
	private String message;
	private String state;
	private Object resultData;
	private int total;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Object getResultData() {
		return resultData;
	}
	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
