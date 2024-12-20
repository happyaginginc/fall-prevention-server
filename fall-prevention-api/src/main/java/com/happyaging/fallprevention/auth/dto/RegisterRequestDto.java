package com.happyaging.fallprevention.auth.dto;

import com.happyaging.fallprevention.account.entity.Account;
import com.happyaging.fallprevention.account.entity.AccountRole;
import com.happyaging.fallprevention.region.entity.Region;
import com.happyaging.fallprevention.region.service.RegionService;

public record RegisterRequestDto(
	String email,
	String password,
	String name,
	String phoneNumber,
	String regionName
) {
	public Account toEntity(RegionService regionService) {
		Region region = regionService.getRegionByRegionName(regionName);
		return Account.builder()
			.email(email)
			.password(password)
			.username(name)
			.phoneNumber(phoneNumber)
			.region(region)
			.role(AccountRole.USER)
			.build();
	}
}
