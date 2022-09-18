package com.example.ipwhitelist.com.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ipwhitelist.com.service.IIPWhitelistService;
import com.example.ipwhitelist.dto.Whitelist;
import com.example.ipwhitelist.dto.Whitelists;
import com.example.ipwhitelist.entity.IpWhitelist;
import com.example.ipwhitelist.exception.CustomException;
import com.example.ipwhitelist.repository.IIPWhitelistRepository;
import org.apache.commons.lang3.StringUtils;



@Service
public class IPWhitelistServiceImpl implements IIPWhitelistService{
	
	private final IIPWhitelistRepository iipWhitelistRepository;
	
	public IPWhitelistServiceImpl(IIPWhitelistRepository iipWhitelistRepository) {
		this.iipWhitelistRepository = iipWhitelistRepository;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public IpWhitelist insertUpdateIPWhitelist(Whitelist request) {
		
		if (request == null) {
			throw new CustomException(CustomException.INVALID_REQUEST);
		}		
		
		if (request.getAppName() == null || request.getEnvironment() == null
				|| request.getIpAddress() == null) {
			throw new CustomException(CustomException.INVALID_REQUEST);
		}
		
		IpWhitelist ip = null;
		
		if (request.getId() != null) {
			
			ip = iipWhitelistRepository.findByIdAndActiveTrue(request.getId())
					.orElseThrow(() -> new CustomException(CustomException.DOES_NOT_EXISTS));
			
		} else {
			
			ip = iipWhitelistRepository.findByIpAddressAndEnvironmentAndAppNameAndActiveTrue(
					request.getIpAddress(), request.getEnvironment(), request.getAppName())
					.orElse(new IpWhitelist());
			
			if (StringUtils.equals(ip.getIpAddress(), request.getIpAddress())
					&& StringUtils.equals(ip.getEnvironment(), request.getEnvironment())
					&& StringUtils.equals(ip.getAppName(), request.getAppName())) {
				
				throw new CustomException(CustomException.ALREADY_EXISTS);
			}
		}
			
		return iipWhitelistRepository.save(ip.setIpWhitelist(request));
	}

	@Override
	public List<IpWhitelist> fetchIPWhitelist(Whitelists request) {
		
		if (request == null) {
			return iipWhitelistRepository.findAllByActiveTrue().stream().distinct().collect(Collectors.toList());
		}
		
		// filter all
		if (!request.getAppName().isEmpty()
				&& !request.getEnvironment().isEmpty() && !request.getIpAddress().isEmpty()
				&& !request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByIpAddressInAndEnvironmentInAndAppNameInAndActiveIn(
					request.getIpAddress(), request.getEnvironment(),
					request.getAppName(), request.isActive())
					.stream().distinct().collect(Collectors.toList());
		}
				
		//filter by app name
		if (!request.getAppName().isEmpty()
				&& request.getEnvironment().isEmpty() && request.getIpAddress().isEmpty()
				&& request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByAppNameIn(request.getAppName())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by env
		if (request.getAppName().isEmpty()
				&& !request.getEnvironment().isEmpty() && request.getIpAddress().isEmpty()
				&& request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByEnvironmentIn(request.getEnvironment())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by ip address
		if (request.getAppName().isEmpty()
				&& request.getEnvironment().isEmpty() && !request.getIpAddress().isEmpty()
				&& request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByIpAddressIn(request.getIpAddress())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by active
		if (request.getAppName().isEmpty()
				&& request.getEnvironment().isEmpty() && request.getIpAddress().isEmpty()
				&& !request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByActiveIn(request.isActive())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by app name and env
		if (!request.getAppName().isEmpty()
				&& !request.getEnvironment().isEmpty() && request.getIpAddress().isEmpty()
				&& request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByAppNameInAndEnvironmentIn(request.getAppName(), request.getEnvironment())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by app name and ip address
		if (!request.getAppName().isEmpty()
				&& request.getEnvironment().isEmpty() && !request.getIpAddress().isEmpty()
				&& request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByAppNameInAndIpAddressIn(request.getAppName(), request.getIpAddress())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by app name and active
		if (!request.getAppName().isEmpty()
				&& request.getEnvironment().isEmpty() && request.getIpAddress().isEmpty()
				&& !request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByAppNameInAndActiveIn(request.getAppName(), request.isActive())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by env, and ip address
		if (request.getAppName().isEmpty()
				&& !request.getEnvironment().isEmpty() && !request.getIpAddress().isEmpty()
				&& request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByEnvironmentInAndIpAddressIn(
					request.getEnvironment(), request.getIpAddress())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by env, and active
		if (request.getAppName().isEmpty()
				&& !request.getEnvironment().isEmpty() && request.getIpAddress().isEmpty()
				&& !request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByEnvironmentInAndActiveIn(
					request.getEnvironment(), request.isActive())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by ip address, and active
		if (request.getAppName().isEmpty()
				&& !request.getEnvironment().isEmpty() && request.getIpAddress().isEmpty()
				&& !request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByIpAddressInAndActiveIn(
					request.getIpAddress(), request.isActive())
					.stream().distinct().collect(Collectors.toList());
			
		}
		
		//filter by app name, env, and ip address
		if (!request.getAppName().isEmpty()
				&& !request.getEnvironment().isEmpty() && !request.getIpAddress().isEmpty()
				&& request.isActive().isEmpty()) {
			
			return iipWhitelistRepository.findByAppNameInAndEnvironmentInAndIpAddressIn(
					request.getAppName(), request.getEnvironment(), request.getIpAddress())
					.stream().distinct().collect(Collectors.toList());
			
		}
			
		return iipWhitelistRepository.findAllByActiveTrue().stream().distinct().collect(Collectors.toList());
	}

}
