package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionPrestation;
import com.TECHSUB.Models.Prestation;
import com.TECHSUB.Repository.IPrestationRepository;

@Service
@Transactional
public class GestionPrestationImpl implements IGestionPrestation {

	@Autowired
	private IPrestationRepository PrestationRepository;

	@Override
	public List<Prestation> getAllPrestations() {
		List<Prestation> lPrestations = PrestationRepository.findAll();
		return lPrestations;
	}
	
	@Override
	public Page<Prestation> getPagePrestations( int page ,int size){
		return  PrestationRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Prestation getPrestation(Long id) {
		Prestation Prestation = PrestationRepository.findById(id).get();
		if (Prestation == null)
			throw new RuntimeException("Prestation introuvable");
		return Prestation;
	}

	@Override
	public Prestation addPrestation(Prestation e) {
		return PrestationRepository.save(e);
	}

	@Override
	public Prestation updatePrestation(Long id,Prestation e) {
		e.setId(id);
		return PrestationRepository.save(e);
	}

	@Override
	public void deletePrestation(Long id) {
		PrestationRepository.deleteById(id);
	}

}
