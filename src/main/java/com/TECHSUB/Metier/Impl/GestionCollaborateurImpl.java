package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionCollaborateur;
import com.TECHSUB.Models.Collaborateur;
import com.TECHSUB.Repository.ICollaborateurRepository;

@Service
@Transactional
public class GestionCollaborateurImpl implements IGestionCollaborateur {

	@Autowired
	private ICollaborateurRepository CollaborateurRepository;

	@Override
	public List<Collaborateur> getAllCollaborateurs() {
		List<Collaborateur> lCollaborateurs = CollaborateurRepository.findAll();
		return lCollaborateurs;
	}
	
	@Override
	public Page<Collaborateur> getPageCollaborateurs( int page ,int size){
		return CollaborateurRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Collaborateur getCollaborateur(Long id) {
		Collaborateur Collaborateur = CollaborateurRepository.findById(id).get();
		if (Collaborateur == null)
			throw new RuntimeException("Collaborateur introuvable");
		return Collaborateur;
	}

	@Override
	public Collaborateur addCollaborateur(Collaborateur e) {
		return CollaborateurRepository.save(e);
	}

	@Override
	public Collaborateur updateCollaborateur(Long id,Collaborateur e) {
		e.setId(id);
		return CollaborateurRepository.save(e);
	}

	@Override
	public void deleteCollaborateur(Long id) {
		CollaborateurRepository.deleteById(id);
	}

}
