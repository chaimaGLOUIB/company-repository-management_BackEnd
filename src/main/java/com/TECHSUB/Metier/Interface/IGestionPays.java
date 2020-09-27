package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;

import com.TECHSUB.Models.Pays;

public interface IGestionPays {
	public List<Pays> getAllPayss();
	public Page<Pays> getPagePayss( int page ,int size);
	public Pays getPays(Long id);
	public Pays addPays(Pays e);
	public Pays updatePays(Long id,Pays e);
	public void deletePays(Long id);
}
