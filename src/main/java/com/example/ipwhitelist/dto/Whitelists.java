package com.example.ipwhitelist.dto;

import java.io.Serializable;
import java.util.List;

public class Whitelists implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2873787407390923567L;

	private List<Long> id;
	
	private List<String> ipAddress;
	
	private List<String> environment;
	
	private List<String> appName;
	
	private List<Boolean> active;
	
	public Whitelists() {}

	public Whitelists(List<Long> id, List<String> ipAddress, List<String> environment, List<String> appName, List<Boolean> active) {
		this.id = id;
		this.ipAddress = ipAddress;
		this.environment = environment;
		this.appName = appName;
		this.active = active;
	}
	
	public List<Long> getId() {
		return id;
	}

	public void setId(List<Long> id) {
		this.id = id;
	}

	public List<String> getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(List<String> ipAddress) {
		this.ipAddress = ipAddress;
	}

	public List<String> getEnvironment() {
		return environment;
	}

	public void setEnvironment(List<String> environment) {
		this.environment = environment;
	}

	public List<String> getAppName() {
		return appName;
	}

	public void setAppName(List<String> appName) {
		this.appName = appName;
	}

	public List<Boolean> isActive() {
		return active;
	}

	public void setActive(List<Boolean> active) {
		this.active = active;
	}

}
