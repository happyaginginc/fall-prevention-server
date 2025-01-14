package com.happyaging.fallprevention.region.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happyaging.fallprevention.region.entity.Region;
import com.happyaging.fallprevention.region.exception.RegionNotFoundException;
import com.happyaging.fallprevention.region.persistence.RegionRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionService {
	private final RegionRepository regionRepository;

	public Region getRegionByRegionName(String regionName) {
		return regionRepository.findByRegionName(regionName)
			.orElseThrow(RegionNotFoundException::new);
	}

	@Transactional
	public Region createRegion(@Valid Region region) {
		return regionRepository.save(region);
	}

	@Transactional
	public Region updateRegion(String currentRegionName, String newRegionName) {
		Region region = regionRepository.findByRegionName(currentRegionName)
			.orElseThrow(RegionNotFoundException::new);
		return region.updateRegionName(newRegionName);
	}

	@Transactional
	public void deleteRegion(String regionName) {
		Region region = regionRepository.findByRegionName(regionName)
			.orElseThrow(RegionNotFoundException::new);
		regionRepository.delete(region);
	}

	public List<Region> getAllRegions() {
		return regionRepository.findAll();
	}
}
