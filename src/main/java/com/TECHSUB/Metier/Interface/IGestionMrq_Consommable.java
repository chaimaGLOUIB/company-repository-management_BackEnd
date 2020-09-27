package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.MarqueConsommable;

public interface IGestionMrq_Consommable {
	public List<MarqueConsommable> getAllMarqueConsommables();
	public Page<MarqueConsommable> getPageMarqueConsommables(int page ,int size);
	public MarqueConsommable getMarqueConsommable(Long id);
	public MarqueConsommable addMarqueConsommable(MarqueConsommable e);
	public MarqueConsommable updateMarqueConsommable(Long id,MarqueConsommable e);
	public void deleteMarqueConsommable(Long id);
}
