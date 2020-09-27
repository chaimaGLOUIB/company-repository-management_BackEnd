package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionSondage;
import com.TECHSUB.Models.Sondage;
import com.TECHSUB.Repository.ISondageRepository;

@Service
@Transactional
public class GestionSondageImpl implements IGestionSondage {

	@Autowired
	private ISondageRepository SondageRepository;

	@Override
	public List<Sondage> getAllSondages() {
		List<Sondage> lSondages = SondageRepository.findAll();
		return lSondages;
	}
	
	@Override
	public Page<Sondage> getPageSondages( int page ,int size){
		return  SondageRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}

	@Override
	public Sondage getSondage(Long id) {
		Sondage Sondage = SondageRepository.findById(id).get();
		if (Sondage == null)
			throw new RuntimeException("Sondage introuvable");
		return Sondage;
	}

	@Override
	public Sondage addSondage(Sondage e) {
		return SondageRepository.save(e);
	}

	@Override
	public Sondage updateSondage(Long id,Sondage e) {
		e.setId(id);
		return SondageRepository.save(e);
	}

	@Override
	public void deleteSondage(Long id) {
		SondageRepository.deleteById(id);
	}

}
