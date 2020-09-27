package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionType_Arret;
import com.TECHSUB.Models.TypeArret;
import com.TECHSUB.Repository.ITypeArretRepository;

@Service
@Transactional
public class GestionType_ArretImpl implements IGestionType_Arret {

	@Autowired
	private ITypeArretRepository TypeArretRepository;

	@Override
	public List<TypeArret> getAllTypeArrets() {
		List<TypeArret> lTypeArrets = TypeArretRepository.findAll();
		return lTypeArrets;
	}
	
	@Override
	public Page<TypeArret> getPageTypeArrets( int page ,int size){
		return  TypeArretRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}

	@Override
	public TypeArret getTypeArret(Long id) {
		TypeArret TypeArret = TypeArretRepository.findById(id).get();
		if (TypeArret == null)
			throw new RuntimeException("TypeArret introuvable");
		return TypeArret;
	}

	@Override
	public TypeArret addTypeArret(TypeArret e) {
		return TypeArretRepository.save(e);
	}

	@Override
	public TypeArret updateTypeArret(Long id,TypeArret e) {
		e.setId(id);
		return TypeArretRepository.save(e);
	}

	@Override
	public void deleteTypeArret(Long id) {
		TypeArretRepository.deleteById(id);
	}

}
