package com.example.ipwhitelist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ipwhitelist.entity.IpWhitelist;

@Repository
public interface IIPWhitelistRepository extends JpaRepository<IpWhitelist, Long>{
	
	List<IpWhitelist> findAllByActiveTrue();
	
	List<IpWhitelist> findByIpAddressIn(@Param("ipAddress") List<String> ipAddress);
	
	List<IpWhitelist> findByEnvironmentIn(@Param("environment") List<String> environment);
	
	List<IpWhitelist> findByAppNameInAndEnvironmentIn(
			@Param("appName") List<String> appName,
			@Param("environment") List<String> environment);
	
	List<IpWhitelist> findByAppNameIn(@Param("appName") List<String> appName);
	
	Optional<IpWhitelist> findByIpAddressAndEnvironmentAndAppNameAndActiveTrue(
			@Param("ipAddress") String ipAddress,
			@Param("environment") String environment,
			@Param("appName") String appName);
	
	List<IpWhitelist> findByAppNameInAndEnvironmentInAndIpAddressIn(
			@Param("appName") List<String> appName,
			@Param("environment") List<String> environment,
			@Param("ipAddress") List<String> ipAddress);
	
	Optional<IpWhitelist> findByIdAndActiveTrue(@Param("id") Long id);
	
	List<IpWhitelist> findByIpAddressInAndEnvironmentInAndAppNameInAndActiveIn(
			@Param("ipAddress") List<String> ipAddress,
			@Param("environment") List<String> environment,
			@Param("appName") List<String> appName,
			@Param("active") List<Boolean> active);
	
	List<IpWhitelist> findByIdIn(@Param("id") List<Long> id);
	
	List<IpWhitelist> findByActiveIn(@Param("active") List<Boolean> active);
	
	List<IpWhitelist> findByAppNameInAndIpAddressIn(
			@Param("appName") List<String> appName,
			@Param("ipAddress") List<String> ipAddress);

	List<IpWhitelist> findByAppNameInAndActiveIn(
			@Param("appName") List<String> appName,
			@Param("active") List<Boolean> active);
	
	List<IpWhitelist> findByEnvironmentInAndIpAddressIn(
			@Param("environment") List<String> environment,
			@Param("ipAddress") List<String> ipAddress);
	
	List<IpWhitelist> findByEnvironmentInAndActiveIn(
			@Param("environment") List<String> environment,
			@Param("active") List<Boolean> active);
	
	List<IpWhitelist> findByIpAddressInAndActiveIn(
			@Param("ip") List<String> ip,
			@Param("active") List<Boolean> active);
}
