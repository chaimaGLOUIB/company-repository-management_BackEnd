package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;

import com.TECHSUB.Models.RapportB;

public interface IGestionRapportB {
	public List<RapportB> getAllRapportBs();
	public Page<RapportB> getPageRapportBs(int page ,int size);
	public RapportB getRapportB(Long id);
	public RapportB addRapportB(RapportB e);
	public RapportB updateRapportB(Long id,RapportB e);
	public void deleteRapportB(Long id);
}
