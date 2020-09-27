package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Categorie_Prestation;

public interface IGestionCategorie_Prest {
	public List<Categorie_Prestation> getAllCategorie_Prestations();
	public Page<Categorie_Prestation> getPageCategorie_Prestations(int page ,int size);
	public Categorie_Prestation getCategorie_Prestation(Long id);
	public Categorie_Prestation addCategorie_Prestation(Categorie_Prestation e);
	public Categorie_Prestation updateCategorie_Prestation(Long id,Categorie_Prestation e);
	public void deleteCategorie_Prestation(Long id);
}
