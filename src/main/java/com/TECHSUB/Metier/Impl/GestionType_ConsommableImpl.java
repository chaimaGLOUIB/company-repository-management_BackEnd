package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.TECHSUB.Metier.Interface.IGestionType_Consommable;
import com.TECHSUB.Models.TypeConsommable;
import com.TECHSUB.Repository.ITypeConsommableRepository;

@Service
@Transactional
public class GestionType_ConsommableImpl implements IGestionType_Consommable {

	@Autowired
	private ITypeConsommableRepository TypeConsommableRepository;

	@Override
	public List<TypeConsommable> getAllTypeConsommables() {
		List<TypeConsommable> lTypeConsommables = TypeConsommableRepository.findAll();
		return lTypeConsommables;
	}
	
	@Override
	public Page<TypeConsommable> getPageTypeConsommables( int page ,int size){
		return  TypeConsommableRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public TypeConsommable getTypeConsommable(Long id) {
		TypeConsommable TypeConsommable = TypeConsommableRepository.findById(id).get();
		if (TypeConsommable == null)
			throw new RuntimeException("TypeConsommable introuvable");
		return TypeConsommable;
	}

	@Override
	public TypeConsommable addTypeConsommable(TypeConsommable e) {
		return TypeConsommableRepository.save(e);
	}

	@Override
	public TypeConsommable updateTypeConsommable(Long id,TypeConsommable e) {
		e.setId(id);
		return TypeConsommableRepository.save(e);
	}

	@Override
	public void deleteTypeConsommable(Long id) {
		TypeConsommableRepository.deleteById(id);
	}

}
