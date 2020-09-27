package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionChantier;
import com.TECHSUB.Models.Chantier;
import com.TECHSUB.Repository.IChantierRepository;

@Service
@Transactional
public class GestionChantierImpl implements IGestionChantier {

	@Autowired
	private IChantierRepository ChantierRepository;

	@Override
	public List<Chantier> getAllChantiers() {
		List<Chantier> lChantiers = ChantierRepository.findAll();
		return lChantiers;
	}
	
	@Override
	public Page<Chantier> getPageChantiers( int page ,int size){
		return ChantierRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Chantier getChantier(Long id) {
		Chantier Chantier = ChantierRepository.findById(id).get();
		if (Chantier == null)
			throw new RuntimeException("Chantier introuvable");
		return Chantier;
	}

	@Override
	public Chantier addChantier(Chantier e) {
		return ChantierRepository.save(e);
	}

	@Override
	public Chantier updateChantier(Long id,Chantier e) {
		e.setId(id);
		return ChantierRepository.save(e);
	}

	@Override
	public void deleteChantier(Long id) {
		ChantierRepository.deleteById(id);
	}

}
