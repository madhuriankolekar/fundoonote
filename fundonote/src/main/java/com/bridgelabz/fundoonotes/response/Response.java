package com.bridgelabz.fundoonotes.response;

import lombok.Data;

@Data
public class Response {
	private int status;
	private String response;
	public Response(int status, String response) {
		super();
		this.status = status;
		this.response = response;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
}
