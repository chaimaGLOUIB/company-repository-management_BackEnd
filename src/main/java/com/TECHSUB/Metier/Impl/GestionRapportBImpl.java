
package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionRapportB;
import com.TECHSUB.Models.RapportB;
import com.TECHSUB.Repository.IRapportBRepository;

@Service
@Transactional
public class GestionRapportBImpl implements IGestionRapportB {

	@Autowired
	private IRapportBRepository RapportBRepository;

	@Override
	public List<RapportB> getAllRapportBs() {
		List<RapportB> lRapportBs = RapportBRepository.findAll();
		return lRapportBs;
	}
	
	@Override
	public Page<RapportB> getPageRapportBs( int page ,int size){
		return RapportBRepository.findAll(PageRequest.of(page, size)); 
	}

	
	@Override
	public RapportB getRapportB(Long id) {
		RapportB RapportB = RapportBRepository.findById(id).get();
		if (RapportB == null)
			throw new RuntimeException("RapportB introuvable");
		return RapportB;
	}

	@Override
	public RapportB addRapportB(RapportB e) {
		return RapportBRepository.save(e);
	}

	@Override
	public RapportB updateRapportB(Long id,RapportB e) {
		e.setId(id);
		return RapportBRepository.save(e);
	}

	@Override
	public void deleteRapportB(Long id) {
		RapportBRepository.deleteById(id);
	}

}
