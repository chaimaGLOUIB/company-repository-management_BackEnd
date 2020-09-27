package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Sondage;

public interface IGestionSondage {
	public List<Sondage> getAllSondages();
	public Page<Sondage> getPageSondages(int page ,int size);
	public Sondage getSondage(Long id);
	public Sondage addSondage(Sondage e);
	public Sondage updateSondage(Long id,Sondage e);
	public void deleteSondage(Long id);
}
