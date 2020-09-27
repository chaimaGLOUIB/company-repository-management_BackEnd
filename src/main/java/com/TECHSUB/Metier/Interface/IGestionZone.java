package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Zone;

public interface IGestionZone {
	public List<Zone> getAllZones();
	public Page<Zone> getPageZones(int page ,int size);
	public Zone getZone(Long id);
	public Zone addZone(Zone e);
	public Zone updateZone(Long id,Zone e);
	public void deleteZone(Long id);
}
