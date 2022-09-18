package com.example.ipwhitelist.com.service;

import java.util.List;

import com.example.ipwhitelist.dto.Whitelist;
import com.example.ipwhitelist.dto.Whitelists;
import com.example.ipwhitelist.entity.IpWhitelist;


public interface IIPWhitelistService {
	
	IpWhitelist insertUpdateIPWhitelist(Whitelist request);

	List<IpWhitelist> fetchIPWhitelist(Whitelists request);
}
