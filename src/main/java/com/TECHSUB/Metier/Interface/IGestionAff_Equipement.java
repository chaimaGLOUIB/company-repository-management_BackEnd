package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Affectation_Equipement;

public interface IGestionAff_Equipement {
	public List<Affectation_Equipement> getAllAffectation_Equipements();
	public Page<Affectation_Equipement> getPageAffectation_Equipements(int page ,int size);
	public Affectation_Equipement getAffectation_Equipement(Long id);
	public Affectation_Equipement addAffectation_Equipement(Affectation_Equipement e);
	public Affectation_Equipement updateAffectation_Equipement(Long id,Affectation_Equipement e);
	public void deleteAffectation_Equipement(Long id);
}
