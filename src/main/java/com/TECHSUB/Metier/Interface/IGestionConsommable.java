package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Consommable;

public interface IGestionConsommable  {
	public List<Consommable> getAllConsommables();
	public Page<Consommable> getPageConsommables(int page ,int size);
	public Consommable getConsommable(Long id);
	public Consommable addConsommable(Consommable e);
	public Consommable updateConsommable(Long id,Consommable e);
	public void deleteConsommable(Long id);
}
