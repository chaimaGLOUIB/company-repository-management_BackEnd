package com.TECHSUB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TECHSUB.Metier.Interface.IGestionRegion;
import com.TECHSUB.Models.Region;
import com.TECHSUB.Models.Region;
import com.TECHSUB.Repository.IRegionRepository;


@RestController
@CrossOrigin("*")


public class RegionRestService {

	@Autowired
	private IGestionRegion gestionRegion;
	@Autowired
	private IRegionRepository RegionRe;
	@GetMapping(value = "/Region/search/byNom") 
	@Secured("ROLE_USER")
	 public Page<Region> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionRegion.getPageRegions(page, size);
} else {
return RegionRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Regions";
	}

	@GetMapping(value = "/Regionss")
	@Secured("ROLE_USER")

	public List<Region> listRegions() {
		return gestionRegion.getAllRegions();
	}
	
	
	@Secured("ROLE_USER")

	
	@GetMapping(value = "/Regionsss/{page}/{size}") 

	public Page<Region> listRegionsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionRegion.getPageRegions(page,size);
	}

	@GetMapping(value = "/Region/{id}")
	@Secured("ROLE_USER")

	public Region Region(@PathVariable(name = "id") Long id) {
		return gestionRegion.getRegion(id);
	}

	@PostMapping(value = "/Region")
	@Secured("ROLE_USER")

	public Region save(@RequestBody Region Region) {
		return gestionRegion.addRegion(Region);
	}

	@PutMapping(value = "/Region/{id}")

	public Region update(@PathVariable(name = "id") Long id, @RequestBody Region Region) {
		return gestionRegion.updateRegion(id, Region);
	}

	@DeleteMapping(value = "/Region/{id}")
	@Secured("ROLE_USER")

	public void delete(@PathVariable(name = "id") Long id) {
		gestionRegion.deleteRegion(id);
	}

}

