package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionHoraire_Poste;
import com.TECHSUB.Models.Horaire_Poste;
import com.TECHSUB.Repository.IHoraire_PosteRepository;

@Service
@Transactional
public class GestionHoraire_PosteImpl implements IGestionHoraire_Poste {

	@Autowired
	private IHoraire_PosteRepository Horaire_PosteRepository;

	@Override
	public List<Horaire_Poste> getAllHoraire_Postes() {
		List<Horaire_Poste> lHoraire_Postes = Horaire_PosteRepository.findAll();
		return lHoraire_Postes;
	}
	
	@Override
	public Page<Horaire_Poste> getPageHoraire_Postes( int page ,int size){
		return  Horaire_PosteRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Horaire_Poste getHoraire_Poste(Long id) {
		Horaire_Poste Horaire_Poste = Horaire_PosteRepository.findById(id).get();
		if (Horaire_Poste == null)
			throw new RuntimeException("Horaire_Poste introuvable");
		return Horaire_Poste;
	}

	@Override
	public Horaire_Poste addHoraire_Poste(Horaire_Poste e) {
		return Horaire_PosteRepository.save(e);
	}

	@Override
	public Horaire_Poste updateHoraire_Poste(Long id,Horaire_Poste e) {
		e.setId(id);
		return Horaire_PosteRepository.save(e);
	}

	@Override
	public void deleteHoraire_Poste(Long id) {
		Horaire_PosteRepository.deleteById(id);
	}

}
