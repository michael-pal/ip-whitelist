package com.example.ipwhitelist.controller;

import java.util.List;

import com.example.ipwhitelist.dto.Whitelist;
import com.example.ipwhitelist.dto.Whitelists;
import com.example.ipwhitelist.entity.IpWhitelist;


public interface IIPWhitelistController {

	IpWhitelist postIPWhitelist(Whitelist request);

	List<IpWhitelist> getIPWhitelist(Whitelists request);
}
