package com.TECHSUB.Metier.Impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionAff_Equipement;
import com.TECHSUB.Models.Affectation_Equipement;
import com.TECHSUB.Repository.IAff_EquipementRepository;

@Service
@Transactional
public class GestionAff_EquipementImpl implements IGestionAff_Equipement {

	@Autowired
	private IAff_EquipementRepository Aff_EquipementRepository;

	@Override
	public List<Affectation_Equipement> getAllAffectation_Equipements() {
		List<Affectation_Equipement> lAffectation_Equipement = Aff_EquipementRepository.findAll();
		return lAffectation_Equipement;
	}
	

	

	@Override
	public Affectation_Equipement getAffectation_Equipement(Long id) {
		Affectation_Equipement Aff_Equipement = Aff_EquipementRepository.findById(id).get();
		if (Aff_Equipement == null)
			throw new RuntimeException("Aff_Equipement introuvable");
		return Aff_Equipement;
	}

	@Override
	public Affectation_Equipement addAffectation_Equipement(Affectation_Equipement e) {
		return Aff_EquipementRepository.save(e);
	}

	@Override
	public Affectation_Equipement updateAffectation_Equipement(Long id,Affectation_Equipement e) {
		e.setId(id);
		return Aff_EquipementRepository.save(e);
	}

	@Override
	public void deleteAffectation_Equipement(Long id) {
		Aff_EquipementRepository.deleteById(id);
	}




	@Override
	public Page<Affectation_Equipement> getPageAffectation_Equipements(int page, int size) {
		return Aff_EquipementRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}

}
