package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Type_Prestation;



public interface IGestionType_Prestation {
	public List<Type_Prestation> getAllType_Prestations();
	public Page<Type_Prestation> getPageType_Prestations(int page ,int size);
	public Type_Prestation getType_Prestation(Long id);
	public Type_Prestation addType_Prestation(Type_Prestation e);
	public Type_Prestation updateType_Prestation(Long id,Type_Prestation e);
	public void deleteType_Prestation(Long id);
	
}
