package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Horaire_Poste;

public interface IGestionHoraire_Poste {
	public List<Horaire_Poste> getAllHoraire_Postes();
	public Page<Horaire_Poste> getPageHoraire_Postes(int page ,int size);
	public Horaire_Poste getHoraire_Poste(Long id);
	public Horaire_Poste addHoraire_Poste(Horaire_Poste e);
	public Horaire_Poste updateHoraire_Poste(Long id,Horaire_Poste e);
	public void deleteHoraire_Poste(Long id);
}
