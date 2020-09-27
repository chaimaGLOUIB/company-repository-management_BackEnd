package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionMrq_Consommable;
import com.TECHSUB.Models.MarqueConsommable;
import com.TECHSUB.Repository.IMarqueConsommable;


@Service
@Transactional
public class GestionMrq_ConsommableImpl implements IGestionMrq_Consommable {

	@Autowired
	private IMarqueConsommable MarqueConsommableRepository;

	@Override
	public List<MarqueConsommable> getAllMarqueConsommables() {
		List<MarqueConsommable> lMarqueConsommables = MarqueConsommableRepository.findAll();
		return lMarqueConsommables;
	}
	
	@Override
	public Page<MarqueConsommable> getPageMarqueConsommables( int page ,int size){
		return  MarqueConsommableRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}

	@Override
	public MarqueConsommable getMarqueConsommable(Long id) {
		MarqueConsommable MarqueConsommable = MarqueConsommableRepository.findById(id).get();
		if (MarqueConsommable == null)
			throw new RuntimeException("MarqueConsommable introuvable");
		return MarqueConsommable;
	}

	@Override
	public MarqueConsommable addMarqueConsommable(MarqueConsommable e) {
		return MarqueConsommableRepository.save(e);
	}

	@Override
	public MarqueConsommable updateMarqueConsommable(Long id,MarqueConsommable e) {
		e.setId(id);
		return MarqueConsommableRepository.save(e);
	}

	@Override
	public void deleteMarqueConsommable(Long id) {
		MarqueConsommableRepository.deleteById(id);
	}

}
