package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Equipement;

public interface IGestionEquipement {
	public List<Equipement> getAllEquipements();
	public Page<Equipement> getPageEquipements(int page ,int size);
	public Equipement getEquipement(Long id);
	public Equipement addEquipement(Equipement e);
	public Equipement updateEquipement(Long id,Equipement e);
	public void deleteEquipement(Long id);
}
