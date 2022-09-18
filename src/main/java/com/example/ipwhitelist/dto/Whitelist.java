package com.example.ipwhitelist.dto;

import java.io.Serializable;

public class Whitelist implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2873787407390923567L;

	private Long id;
	
	private String ipAddress;
	
	private String environment;
	
	private String appName;
	
	private boolean active;
	
	public Whitelist() {}

	public Whitelist(Long id, String ipAddress, String environment, String appName, boolean active) {
		this.id = id;
		this.ipAddress = ipAddress;
		this.environment = environment;
		this.appName = appName;
		this.active = active;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
