
package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionRapportC;
import com.TECHSUB.Models.RapportC;
import com.TECHSUB.Repository.IRapportCRepository;

@Service
@Transactional
public class GestionRapportCImpl implements IGestionRapportC {

	@Autowired
	private IRapportCRepository RapportCRepository;

	@Override
	public List<RapportC> getAllRapportCs() {
		List<RapportC> lRapportCs = RapportCRepository.findAll();
		return lRapportCs;
	}
	
	@Override
	public Page<RapportC> getPageRapportCs( int page ,int size){
		return RapportCRepository.findAll(PageRequest.of(page, size, Sort.by("nom"))); 
	}

	
	@Override
	public RapportC getRapportC(Long id) {
		RapportC RapportC = RapportCRepository.findById(id).get();
		if (RapportC == null)
			throw new RuntimeException("RapportC introuvable");
		return RapportC;
	}

	@Override
	public RapportC addRapportC(RapportC e) {
		return RapportCRepository.save(e);
	}

	@Override
	public RapportC updateRapportC(Long id,RapportC e) {
		e.setId(id);
		return RapportCRepository.save(e);
	}

	@Override
	public void deleteRapportC(Long id) {
		RapportCRepository.deleteById(id);
	}

}
