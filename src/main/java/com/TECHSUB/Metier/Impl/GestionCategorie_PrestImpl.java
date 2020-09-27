package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionCategorie_Prest;
import com.TECHSUB.Models.Categorie_Prestation;
import com.TECHSUB.Repository.ICategorie_PrestRepository;

@Service
@Transactional
public class GestionCategorie_PrestImpl implements IGestionCategorie_Prest {

	@Autowired
	private ICategorie_PrestRepository Categorie_PrestationRepository;

	@Override
	public List<Categorie_Prestation> getAllCategorie_Prestations() {
		List<Categorie_Prestation> lCategorie_Prestations = Categorie_PrestationRepository.findAll();
		return lCategorie_Prestations;
	}
	
	@Override
	public Page<Categorie_Prestation> getPageCategorie_Prestations( int page ,int size){
		return Categorie_PrestationRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Categorie_Prestation getCategorie_Prestation(Long id) {
		Categorie_Prestation Categorie_Prestation = Categorie_PrestationRepository.findById(id).get();
		if (Categorie_Prestation == null)
			throw new RuntimeException("Categorie_Prestation introuvable");
		return Categorie_Prestation;
	}

	@Override
	public Categorie_Prestation addCategorie_Prestation(Categorie_Prestation e) {
		return Categorie_PrestationRepository.save(e);
	}

	@Override
	public Categorie_Prestation updateCategorie_Prestation(Long id,Categorie_Prestation e) {
		e.setId(id);
		return Categorie_PrestationRepository.save(e);
	}

	@Override
	public void deleteCategorie_Prestation(Long id) {
		Categorie_PrestationRepository.deleteById(id);
	}

}
