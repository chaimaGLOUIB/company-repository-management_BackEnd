package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionEquipement;
import com.TECHSUB.Models.Equipement;
import com.TECHSUB.Repository.IEquipementRepository;

@Service
@Transactional
public class GestionEquipementImpl implements IGestionEquipement {

	@Autowired
	private IEquipementRepository EquipementRepository;

	@Override
	public List<Equipement> getAllEquipements() {
		List<Equipement> lEquipements = EquipementRepository.findAll();
		return lEquipements;
	}
	
	@Override
	public Page<Equipement> getPageEquipements( int page ,int size){
		return EquipementRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Equipement getEquipement(Long id) {
		Equipement Equipement = EquipementRepository.findById(id).get();
		if (Equipement == null)
			throw new RuntimeException("Equipement introuvable");
		return Equipement;
	}

	@Override
	public Equipement addEquipement(Equipement e) {
		return EquipementRepository.save(e);
	}

	@Override
	public Equipement updateEquipement(Long id,Equipement e) {
		e.setId(id);
		return EquipementRepository.save(e);
	}

	@Override
	public void deleteEquipement(Long id) {
		EquipementRepository.deleteById(id);
	}

}
