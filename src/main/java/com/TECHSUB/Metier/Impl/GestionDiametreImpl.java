package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionDiametre;
import com.TECHSUB.Models.Diametre;
import com.TECHSUB.Repository.IDiametreRepository;

@Service
@Transactional
public class GestionDiametreImpl implements IGestionDiametre {

	@Autowired
	private IDiametreRepository DiametreRepository;

	@Override
	public List<Diametre> getAllDiametres() {
		List<Diametre> lDiametres = DiametreRepository.findAll();
		return lDiametres;
	}
	
	@Override
	public Page<Diametre> getPageDiametres( int page ,int size){
		return DiametreRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Diametre getDiametre(Long id) {
		Diametre Diametre = DiametreRepository.findById(id).get();
		if (Diametre == null)
			throw new RuntimeException("Diametre introuvable");
		return Diametre;
	}

	@Override
	public Diametre addDiametre(Diametre e) {
		return DiametreRepository.save(e);
	}

	@Override
	public Diametre updateDiametre(Long id,Diametre e) {
		e.setId(id);
		return DiametreRepository.save(e);
	}

	@Override
	public void deleteDiametre(Long id) {
		DiametreRepository.deleteById(id);
	}

}
