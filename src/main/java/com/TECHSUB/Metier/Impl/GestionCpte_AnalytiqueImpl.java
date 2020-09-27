package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionCpte_Analytique;
import com.TECHSUB.Models.Compte_Analytique;
import com.TECHSUB.Repository.ICompte_AnalytiqueRepository;

@Service
@Transactional
public class GestionCpte_AnalytiqueImpl implements IGestionCpte_Analytique {

	@Autowired
	private ICompte_AnalytiqueRepository Compte_AnalytiqueRepository;

	@Override
	public List<Compte_Analytique> getAllCompte_Analytiques() {
		List<Compte_Analytique> lCompte_Analytiques = Compte_AnalytiqueRepository.findAll();
		return lCompte_Analytiques;
	}
	
	@Override
	public Page<Compte_Analytique> getPageCompte_Analytiques( int page ,int size){
		return Compte_AnalytiqueRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Compte_Analytique getCompte_Analytique(Long id) {
		Compte_Analytique Compte_Analytique = Compte_AnalytiqueRepository.findById(id).get();
		if (Compte_Analytique == null)
			throw new RuntimeException("Compte_Analytique introuvable");
		return Compte_Analytique;
	}

	@Override
	public Compte_Analytique addCompte_Analytique(Compte_Analytique e) {
		return Compte_AnalytiqueRepository.save(e);
	}

	@Override
	public Compte_Analytique updateCompte_Analytique(Long id,Compte_Analytique e) {
		e.setId(id);
		return Compte_AnalytiqueRepository.save(e);
	}

	@Override
	public void deleteCompte_Analytique(Long id) {
		Compte_AnalytiqueRepository.deleteById(id);
	}

}
