package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionZone;
import com.TECHSUB.Models.Zone;
import com.TECHSUB.Repository.IzoneRepository;

@Service
@Transactional
public class GestionZoneImpl implements IGestionZone {

	@Autowired
	private IzoneRepository ZoneRepository;

	@Override
	public List<Zone> getAllZones() {
		List<Zone> lZones = ZoneRepository.findAll();
		return lZones;
	}
	
	@Override
	public Page<Zone> getPageZones( int page ,int size){
		return  ZoneRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}

	@Override
	public Zone getZone(Long id) {
		Zone Zone = ZoneRepository.findById(id).get();
		if (Zone == null)
			throw new RuntimeException("Zone introuvable");
		return Zone;
	}

	@Override
	public Zone addZone(Zone e) {
		return ZoneRepository.save(e);
	}

	@Override
	public Zone updateZone(Long id,Zone e) {
		e.setId(id);
		return ZoneRepository.save(e);
	}

	@Override
	public void deleteZone(Long id) {
		ZoneRepository.deleteById(id);
	}

}
