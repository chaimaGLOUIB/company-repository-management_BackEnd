package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionSous_Traitant;
import com.TECHSUB.Models.Sous_Traitant;
import com.TECHSUB.Repository.ISous_TraitantRepository;

@Service
@Transactional
public class GestionSous_TraitantImpl implements IGestionSous_Traitant {

	@Autowired
	private ISous_TraitantRepository Sous_TraitantRepository;

	@Override
	public List<Sous_Traitant> getAllSous_Traitants() {
		List<Sous_Traitant> lSous_Traitants = Sous_TraitantRepository.findAll();
		return lSous_Traitants;
	}
	
	@Override
	public Page<Sous_Traitant> getPageSous_Traitants( int page ,int size){
		return  Sous_TraitantRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Sous_Traitant getSous_Traitant(Long id) {
		Sous_Traitant Sous_Traitant = Sous_TraitantRepository.findById(id).get();
		if (Sous_Traitant == null)
			throw new RuntimeException("Sous_Traitant introuvable");
		return Sous_Traitant;
	}

	@Override
	public Sous_Traitant addSous_Traitant(Sous_Traitant e) {
		return Sous_TraitantRepository.save(e);
	}

	@Override
	public Sous_Traitant updateSous_Traitant(Long id,Sous_Traitant e) {
		e.setId(id);
		return Sous_TraitantRepository.save(e);
	}

	@Override
	public void deleteSous_Traitant(Long id) {
		Sous_TraitantRepository.deleteById(id);
	}

}

