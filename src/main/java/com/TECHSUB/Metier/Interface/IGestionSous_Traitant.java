package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Sous_Traitant;

public interface IGestionSous_Traitant {
	public List<Sous_Traitant> getAllSous_Traitants();
	public Page<Sous_Traitant> getPageSous_Traitants(int page ,int size);
	public Sous_Traitant getSous_Traitant(Long id);
	public Sous_Traitant addSous_Traitant(Sous_Traitant e);
	public Sous_Traitant updateSous_Traitant(Long id,Sous_Traitant e);
	public void deleteSous_Traitant(Long id);
	
}
