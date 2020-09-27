package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionType_Prestation;
import com.TECHSUB.Models.Type_Prestation;
import com.TECHSUB.Repository.IType_PrestationRepository;

@Service
@Transactional
public class GestionType_PrestationImpl implements IGestionType_Prestation {

	@Autowired
	private IType_PrestationRepository Type_PrestationRepository;

	@Override
	public List<Type_Prestation> getAllType_Prestations() {
		List<Type_Prestation> lType_Prestations = Type_PrestationRepository.findAll();
		return lType_Prestations;
	}
	
	@Override
	public Page<Type_Prestation> getPageType_Prestations( int page ,int size){
		return  Type_PrestationRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}

	@Override
	public Type_Prestation getType_Prestation(Long id) {
		Type_Prestation Type_Prestation = Type_PrestationRepository.findById(id).get();
		if (Type_Prestation == null)
			throw new RuntimeException("Type_Prestation introuvable");
		return Type_Prestation;
	}

	@Override
	public Type_Prestation addType_Prestation(Type_Prestation e) {
		return Type_PrestationRepository.save(e);
	}

	@Override
	public Type_Prestation updateType_Prestation(Long id,Type_Prestation e) {
		e.setId(id);
		return Type_PrestationRepository.save(e);
	}

	@Override
	public void deleteType_Prestation(Long id) {
		Type_PrestationRepository.deleteById(id);
	}

}
