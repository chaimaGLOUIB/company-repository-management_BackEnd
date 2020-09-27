package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Chantier;

public interface IGestionChantier {
	public List<Chantier> getAllChantiers();
	public Page<Chantier> getPageChantiers(int page ,int size);
	public Chantier getChantier(Long id);
	public Chantier addChantier(Chantier e);
	public Chantier updateChantier(Long id,Chantier e);
	public void deleteChantier(Long id);
}
