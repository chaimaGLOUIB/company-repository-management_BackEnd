
package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionRapport;
import com.TECHSUB.Models.Rapport;
import com.TECHSUB.Repository.IRapportRepository;

@Service
@Transactional
public class GestionRapportImpl implements IGestionRapport {

	@Autowired
	private IRapportRepository RapportRepository;

	@Override
	public List<Rapport> getAllRapports() {
		List<Rapport> lRapports = RapportRepository.findAll();
		return lRapports;
	}
	
	@Override
	public Page<Rapport> getPageRapports( int page ,int size){
		return RapportRepository.findAll(PageRequest.of(page, size, Sort.by("date"))); 
	}

	
	@Override
	public Rapport getRapport(Long id) {
		Rapport Rapport = RapportRepository.findById(id).get();
		if (Rapport == null)
			throw new RuntimeException("Rapport introuvable");
		return Rapport;
	}

	@Override
	public Rapport addRapport(Rapport e) {
		return RapportRepository.save(e);
	}

	@Override
	public Rapport updateRapport(Long id,Rapport e) {
		e.setId(id);
		return RapportRepository.save(e);
	}

	@Override
	public void deleteRapport(Long id) {
		RapportRepository.deleteById(id);
	}

}
