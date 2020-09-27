package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Prestation;

public interface IGestionPrestation  {
	public List<Prestation> getAllPrestations();
	public Page<Prestation> getPagePrestations(int page ,int size);
	public Prestation getPrestation(Long id);
	public Prestation addPrestation(Prestation e);
	public Prestation updatePrestation(Long id,Prestation e);
	public void deletePrestation(Long id);
}
