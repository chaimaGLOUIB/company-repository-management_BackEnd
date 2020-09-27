package com.TECHSUB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TECHSUB.Metier.Interface.IGestionZone;
import com.TECHSUB.Models.Zone;


import com.TECHSUB.Repository.IzoneRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class ZoneRestService {

	@Autowired
	private IGestionZone gestionZone;
	@Autowired
	private IzoneRepository ZoneRe;
	@GetMapping(value = "/Zone/search/byNom") 

	 public Page<Zone> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionZone.getPageZones(page, size);
} else {
return ZoneRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Zones";
	}
	@GetMapping(value = "/Zones/{page}/{size}") 
	public Page<Zone> listZonesPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionZone.getPageZones(page,size);
	}

	@GetMapping(value = "/Zones")
	public List<Zone> listZones() {
		return gestionZone.getAllZones();
	}

	@GetMapping(value = "/Zone/{id}")
	public Zone Zone(@PathVariable(name = "id") Long id) {
		return gestionZone.getZone(id);
	}

	@PostMapping(value = "/Zone")
	public Zone save(@RequestBody Zone Zone) {
		return gestionZone.addZone(Zone);
	}

	@PutMapping(value = "/Zone/{id}")
	public Zone update(@PathVariable(name = "id") Long id, @RequestBody Zone Zone) {
		return gestionZone.updateZone(id, Zone);
	}

	@DeleteMapping(value = "/Zone/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionZone.deleteZone(id);
	}

}

