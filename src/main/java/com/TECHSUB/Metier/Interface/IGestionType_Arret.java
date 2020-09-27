package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.TypeArret;

public interface IGestionType_Arret {
	public List<TypeArret> getAllTypeArrets();
	public Page<TypeArret> getPageTypeArrets(int page ,int size);
	public TypeArret getTypeArret(Long id);
	public TypeArret addTypeArret(TypeArret e);
	public TypeArret updateTypeArret(Long id,TypeArret e);
	public void deleteTypeArret(Long id);
}
