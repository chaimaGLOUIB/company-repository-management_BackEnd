package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionCategorie_Arret;
import com.TECHSUB.Models.CategorieArret;
import com.TECHSUB.Repository.ICategorieArretRepository;

@Service
@Transactional
public class GestionCategorie_ArretImpl implements IGestionCategorie_Arret {

	@Autowired
	private ICategorieArretRepository CategorieArretRepository;

	@Override
	public List<CategorieArret> getAllCategorieArrets() {
		List<CategorieArret> lCategorieArrets = CategorieArretRepository.findAll();
		return lCategorieArrets;
	}
	
	@Override
	public Page<CategorieArret> getPageCategorieArrets( int page ,int size){
		return CategorieArretRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public CategorieArret getCategorieArret(Long id) {
		CategorieArret CategorieArret = CategorieArretRepository.findById(id).get();
		if (CategorieArret == null)
			throw new RuntimeException("CategorieArret introuvable");
		return CategorieArret;
	}

	@Override
	public CategorieArret addCategorieArret(CategorieArret e) {
		return CategorieArretRepository.save(e);
	}

	@Override
	public CategorieArret updateCategorieArret(Long id,CategorieArret e) {
		e.setId(id);
		return CategorieArretRepository.save(e);
	}

	@Override
	public void deleteCategorieArret(Long id) {
		CategorieArretRepository.deleteById(id);
	}

}
