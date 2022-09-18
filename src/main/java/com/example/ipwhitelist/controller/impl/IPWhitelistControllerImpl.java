package com.example.ipwhitelist.controller.impl;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ipwhitelist.com.service.impl.IPWhitelistServiceImpl;
import com.example.ipwhitelist.controller.IIPWhitelistController;
import com.example.ipwhitelist.dto.Whitelist;
import com.example.ipwhitelist.dto.Whitelists;
import com.example.ipwhitelist.entity.IpWhitelist;


@RestController
public class IPWhitelistControllerImpl implements IIPWhitelistController{

	private final IPWhitelistServiceImpl ipWhitelistServiceImpl;
	
	public IPWhitelistControllerImpl(IPWhitelistServiceImpl ipWhitelistServiceImpl) {
		this.ipWhitelistServiceImpl = ipWhitelistServiceImpl;
	}

	@PostMapping(value = "/api/v1/ip-whitelist", 
	produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
	consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	@Override
	public IpWhitelist postIPWhitelist(@RequestBody Whitelist request) {
		
		return ipWhitelistServiceImpl.insertUpdateIPWhitelist(request);
	}

	@GetMapping(value = "/api/v1/ip-whitelist/fetch")
	@Override
	public List<IpWhitelist> getIPWhitelist(@RequestBody Whitelists request) {
		return ipWhitelistServiceImpl.fetchIPWhitelist(request);
	}

}
