package com.example.ipwhitelist.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.ipwhitelist.dto.Whitelist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ip_whitelist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class IpWhitelist implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1841537509500779203L;

	private Long id;
	
	private String ipAddress;
	
	private String environment;
	
	private String appName;
	
	private boolean active;

	public IpWhitelist() {}

	public IpWhitelist(Long id, String ipAddress, String environment, String appName, boolean active) {
		this.id = id;
		this.ipAddress = ipAddress;
		this.environment = environment;
		this.appName = appName;
		this.active = active;
	}
	
	public IpWhitelist setIpWhitelist(Whitelist request) {
		this.id = request.getId();
		this.ipAddress = request.getIpAddress();
		this.environment = request.getEnvironment();
		this.appName = request.getAppName();
		this.active = request.isActive();
		return this;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Override
	public int hashCode() {
		return Objects.hash(active, appName, environment, ipAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IpWhitelist other = (IpWhitelist) obj;
		return active == other.active && Objects.equals(appName, other.appName)
				&& Objects.equals(environment, other.environment) && Objects.equals(ipAddress, other.ipAddress);
	}
	
}
