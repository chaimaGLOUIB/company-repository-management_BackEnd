package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionConsommable;
import com.TECHSUB.Models.Consommable;
import com.TECHSUB.Repository.IConsommableRepository;

@Service
@Transactional
public class GestionConsommableImpl implements IGestionConsommable {

	@Autowired
	private IConsommableRepository ConsommableRepository;

	@Override
	public List<Consommable> getAllConsommables() {
		List<Consommable> lConsommables = ConsommableRepository.findAll();
		return lConsommables;
	}
	
	@Override
	public Page<Consommable> getPageConsommables( int page ,int size){
		return ConsommableRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}

	@Override
	public Consommable getConsommable(Long id) {
		Consommable Consommable = ConsommableRepository.findById(id).get();
		if (Consommable == null)
			throw new RuntimeException("Consommable introuvable");
		return Consommable;
	}

	@Override
	public Consommable addConsommable(Consommable e) {
		return ConsommableRepository.save(e);
	}

	@Override
	public Consommable updateConsommable(Long id,Consommable e) {
		e.setId(id);
		return ConsommableRepository.save(e);
	}

	@Override
	public void deleteConsommable(Long id) {
		ConsommableRepository.deleteById(id);
	}

}
