package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;

import com.TECHSUB.Models.RapportC;

public interface IGestionRapportC {
	public List<RapportC> getAllRapportCs();
	public Page<RapportC> getPageRapportCs(int page ,int size);
	public RapportC getRapportC(Long id);
	public RapportC addRapportC(RapportC e);
	public RapportC updateRapportC(Long id,RapportC e);
	public void deleteRapportC(Long id);
}
