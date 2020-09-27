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

import com.TECHSUB.Metier.Interface.IGestionSous_Traitant;
import com.TECHSUB.Models.Sous_Traitant;
import com.TECHSUB.Models.Sous_Traitant;
import com.TECHSUB.Repository.ISous_TraitantRepository;
import com.TECHSUB.Models.Sous_Traitant;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Sous_TraitantRestService {

	@Autowired
	private IGestionSous_Traitant gestionSous_Traitant;
	@Autowired
	private ISous_TraitantRepository Sous_TraitantRe;
	@GetMapping(value = "/Sous_Traitant/search/byNom") 

	 public Page<Sous_Traitant> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionSous_Traitant.getPageSous_Traitants(page, size);
} else {
return Sous_TraitantRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Sous_Traitants";
	}

	@GetMapping(value = "/Sous_Traitants")
	public List<Sous_Traitant> listSous_Traitants() {
		return gestionSous_Traitant.getAllSous_Traitants();
	}
	@GetMapping(value = "/Sous_Traitants/{page}/{size}") 
	public Page<Sous_Traitant> listSous_TraitantsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionSous_Traitant.getPageSous_Traitants(page, size);
	}
	@GetMapping(value = "/Sous_Traitant/{id}")
	public Sous_Traitant Sous_Traitant(@PathVariable(name = "id") Long id) {
		return gestionSous_Traitant.getSous_Traitant(id);
	}

	@PostMapping(value = "/Sous_Traitant")
	public Sous_Traitant save(@RequestBody Sous_Traitant Sous_Traitant) {
		return gestionSous_Traitant.addSous_Traitant(Sous_Traitant);
	}

	@PutMapping(value = "/Sous_Traitant/{id}")
	public Sous_Traitant update(@PathVariable(name = "id") Long id, @RequestBody Sous_Traitant Sous_Traitant) {
		return gestionSous_Traitant.updateSous_Traitant(id, Sous_Traitant);
	}

	@DeleteMapping(value = "/Sous_Traitant/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionSous_Traitant.deleteSous_Traitant(id);
	}

}

