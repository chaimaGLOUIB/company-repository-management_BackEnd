package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Diametre;

public interface IGestionDiametre {
	public List<Diametre> getAllDiametres();
	public Page<Diametre> getPageDiametres(int page ,int size);
	public Diametre getDiametre(Long id);
	public Diametre addDiametre(Diametre e);
	public Diametre updateDiametre(Long id,Diametre e);
	public void deleteDiametre(Long id);
}
