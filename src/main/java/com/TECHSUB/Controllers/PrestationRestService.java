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

import com.TECHSUB.Metier.Interface.IGestionPrestation;
import com.TECHSUB.Models.Prestation;
import com.TECHSUB.Models.Prestation;
import com.TECHSUB.Repository.IPrestationRepository;
import com.TECHSUB.Models.Prestation;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class PrestationRestService {

	@Autowired
	private IGestionPrestation gestionPrestation;
	@Autowired
	private IPrestationRepository PrestationRe;
	@GetMapping(value = "/Prestation/search/byNom") 

	 public Page<Prestation> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionPrestation.getPagePrestations(page, size);
} else {
return PrestationRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	public String index() {
		return "Prestations";
	}

	@GetMapping(value = "/Prestations")
	public List<Prestation> listPrestations() {
		return gestionPrestation.getAllPrestations();
	}
	@GetMapping(value = "/Prestations/{page}/{size}") 
	public Page<Prestation> listPrestationsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionPrestation.getPagePrestations(page, size);
	}

	@GetMapping(value = "/Prestation/{id}")
	public Prestation Prestation(@PathVariable(name = "id") Long id) {
		return gestionPrestation.getPrestation(id);
	}

	@PostMapping(value = "/Prestation")
	public Prestation save(@RequestBody Prestation Prestation) {
		return gestionPrestation.addPrestation(Prestation);
	}

	@PutMapping(value = "/Prestation/{id}")
	public Prestation update(@PathVariable(name = "id") Long id, @RequestBody Prestation Prestation) {
		return gestionPrestation.updatePrestation(id, Prestation);
	}

	@DeleteMapping(value = "/Prestation/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionPrestation.deletePrestation(id);
	}

}

