package com.example.ipwhitelist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4713146868063932876L;
	
	private String code;
	
	private ResponseResult<?> result;
	
	private List<?> error;

	public Response(){
		this.error = new ArrayList<>();
	}

	public Response(String code, ResponseResult<?> result, List<String> error) {
		this.code = code;
		this.result = result;
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ResponseResult<?> getResult() {
		return result;
	}
	
	public void setResult(ResponseResult<?> result) {
		this.result = result;
	}

	public List<?> getError() {
		return error;
	}

	public void setError(List<?> error) {
		this.error = error;
	}
}
