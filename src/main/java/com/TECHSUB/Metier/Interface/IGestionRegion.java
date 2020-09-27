package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Region;

public interface IGestionRegion {
	public List<Region> getAllRegions();
	public Page<Region> getPageRegions( int page ,int size);
	public Region getRegion(Long id);
	public Region addRegion(Region e);
	public Region updateRegion(Long id,Region e);
	public void deleteRegion(Long id);
}
