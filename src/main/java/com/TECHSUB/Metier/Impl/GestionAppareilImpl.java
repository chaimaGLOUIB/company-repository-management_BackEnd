
package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionAppareil;
import com.TECHSUB.Models.Appareil;
import com.TECHSUB.Repository.IAppareilRepository;

@Service
@Transactional
public class GestionAppareilImpl implements IGestionAppareil {

	@Autowired
	private IAppareilRepository AppareilRepository;

	@Override
	public List<Appareil> getAllAppareils() {
		List<Appareil> lAppareils = AppareilRepository.findAll();
		return lAppareils;
	}
	
	@Override
	public Page<Appareil> getPageAppareils( int page ,int size){
		return AppareilRepository.findAll(PageRequest.of(page, size, Sort.by("nom"))); 
	}

	
	@Override
	public Appareil getAppareil(Long id) {
		Appareil Appareil = AppareilRepository.findById(id).get();
		if (Appareil == null)
			throw new RuntimeException("Appareil introuvable");
		return Appareil;
	}

	@Override
	public Appareil addAppareil(Appareil e) {
		return AppareilRepository.save(e);
	}

	@Override
	public Appareil updateAppareil(Long id,Appareil e) {
		e.setId(id);
		return AppareilRepository.save(e);
	}

	@Override
	public void deleteAppareil(Long id) {
		AppareilRepository.deleteById(id);
	}

}
