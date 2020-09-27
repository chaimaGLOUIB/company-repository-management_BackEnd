package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Compte_Analytique;

public interface IGestionCpte_Analytique {
	public List<Compte_Analytique> getAllCompte_Analytiques();
	public Page<Compte_Analytique> getPageCompte_Analytiques(int page ,int size);
	public Compte_Analytique getCompte_Analytique(Long id);
	public Compte_Analytique addCompte_Analytique(Compte_Analytique e);
	public Compte_Analytique updateCompte_Analytique(Long id,Compte_Analytique e);
	public void deleteCompte_Analytique(Long id);
}
