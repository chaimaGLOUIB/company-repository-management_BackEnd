package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;

import com.TECHSUB.Models.Rapport;

public interface IGestionRapport {
	public List<Rapport> getAllRapports();
	public Page<Rapport> getPageRapports(int page ,int size);
	public Rapport getRapport(Long id);
	public Rapport addRapport(Rapport e);
	public Rapport updateRapport(Long id,Rapport e);
	public void deleteRapport(Long id);
}
