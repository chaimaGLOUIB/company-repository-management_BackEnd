package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.CategorieArret;

public interface IGestionCategorie_Arret {
	public List<CategorieArret> getAllCategorieArrets();
	public Page<CategorieArret> getPageCategorieArrets(int page ,int size);
	public CategorieArret getCategorieArret(Long id);
	public CategorieArret addCategorieArret(CategorieArret e);
	public CategorieArret updateCategorieArret(Long id,CategorieArret e);
	public void deleteCategorieArret(Long id);
}
