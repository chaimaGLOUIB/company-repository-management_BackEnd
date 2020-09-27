package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionPays;
import com.TECHSUB.Models.Pays;
import com.TECHSUB.Models.Pays;
import com.TECHSUB.Repository.IPaysRepository;

@Service
@Transactional
public class GestionPaysImpl implements IGestionPays {

	@Autowired
	private IPaysRepository PaysRepository;

	@Override
	public List<Pays> getAllPayss() {
		List<Pays> lPayss = PaysRepository.findAll();
		return lPayss;
	}
	
	@Override
	public Page<Pays> getPagePayss( int page ,int size){
		return PaysRepository.findAll(PageRequest.of(page, size, Sort.by("nom"))); 
	}

	@Override
	public Pays getPays(Long id) {
		Pays Pays = PaysRepository.findById(id).get();
		if (Pays == null)
			throw new RuntimeException("Pays introuvable");
		return Pays;
	}

	@Override
	public Pays addPays(Pays e) {
		return PaysRepository.save(e);
	}

	@Override
	public Pays updatePays(Long id,Pays e) {
		e.setId(id);
		return PaysRepository.save(e);
	}

	@Override
	public void deletePays(Long id) {
		PaysRepository.deleteById(id);
	}

}
