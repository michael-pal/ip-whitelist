package com.example.ipwhitelist.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ResponseResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1128496290577528243L;

	private T data;
	
	@JsonInclude(Include.NON_NULL)
	private Integer totalRecord;
	
	private String message;

	public ResponseResult() {}

	public ResponseResult(T data, Integer totalRecord, String message) {
		this.data = data;
		this.message = message;
		this.totalRecord = totalRecord;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Integer getTotalRecord() {
		return this.totalRecord;
	}
	
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
