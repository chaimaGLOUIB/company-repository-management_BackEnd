package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Appareil;

public interface IGestionAppareil {
	public List<Appareil> getAllAppareils();
	public Page<Appareil> getPageAppareils(int page ,int size);
	public Appareil getAppareil(Long id);
	public Appareil addAppareil(Appareil e);
	public Appareil updateAppareil(Long id,Appareil e);
	public void deleteAppareil(Long id);
}
