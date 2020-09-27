package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.TECHSUB.Metier.Interface.IGestionRegion;
import com.TECHSUB.Models.Region;
import com.TECHSUB.Repository.IRegionRepository;

@Service
@Transactional
public class GestionRegionImpl implements IGestionRegion {

	@Autowired
	private IRegionRepository RegionRepository;

	@Override
	public List<Region> getAllRegions() {
		List<Region> lRegions = RegionRepository.findAll();
		return lRegions;
	}
	
	@Override
	
	public Page<Region> getPageRegions( int page ,int size){
		return RegionRepository.findAll(PageRequest.of(page, size, Sort.by("nom"))); 
	}

	@Override
	public Region getRegion(Long id) {
		Region Region = RegionRepository.findById(id).get();
		if (Region == null)
			throw new RuntimeException("Region introuvable");
		return Region;
	}

	@Override
	public Region addRegion(Region e) {
		return RegionRepository.save(e);
	}

	@Override
	public Region updateRegion(Long id,Region e) {
		e.setId(id);
		return RegionRepository.save(e);
	}

	@Override
	public void deleteRegion(Long id) {
		RegionRepository.deleteById(id);
	}

}
