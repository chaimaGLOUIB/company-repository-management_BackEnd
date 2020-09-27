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

import com.TECHSUB.Metier.Interface.IGestionCategorie_Prest;
import com.TECHSUB.Models.Categorie_Prestation;
import com.TECHSUB.Models.Categorie_Prestation;
import com.TECHSUB.Repository.ICategorie_PrestRepository;
import com.TECHSUB.Models.Categorie_Prestation;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Categorie_PrestationRestService {

	@Autowired
	private IGestionCategorie_Prest gestionCategorie_Prestation;
	@Autowired
	private ICategorie_PrestRepository Categorie_PrestationRe;
	@GetMapping(value = "/Categorie_Prestation/search/byNom") 

	 public Page<Categorie_Prestation> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionCategorie_Prestation.getPageCategorie_Prestations(page, size);
} else {
return Categorie_PrestationRe.findByCategoriePrestationContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Categorie_Prestations";
	}
	@GetMapping(value = "/Categorie_Prestations/{page}/{size}") 
	public Page<Categorie_Prestation> listCategorie_PrestationsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionCategorie_Prestation.getPageCategorie_Prestations(page, size);
	}
	@GetMapping(value = "/Categorie_Prestations")
	public List<Categorie_Prestation> listCategorie_Prestations() {
		return gestionCategorie_Prestation.getAllCategorie_Prestations();
	}

	@GetMapping(value = "/Categorie_Prestation/{id}")
	public Categorie_Prestation Categorie_Prestation(@PathVariable(name = "id") Long id) {
		return gestionCategorie_Prestation.getCategorie_Prestation(id);
	}

	@PostMapping(value = "/Categorie_Prestation")
	public Categorie_Prestation save(@RequestBody Categorie_Prestation Categorie_Prestation) {
		return gestionCategorie_Prestation.addCategorie_Prestation(Categorie_Prestation);
	}

	@PutMapping(value = "/Categorie_Prestation/{id}")
	public Categorie_Prestation update(@PathVariable(name = "id") Long id, @RequestBody Categorie_Prestation Categorie_Prestation) {
		return gestionCategorie_Prestation.updateCategorie_Prestation(id, Categorie_Prestation);
	}

	@DeleteMapping(value = "/Categorie_Prestation/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionCategorie_Prestation.deleteCategorie_Prestation(id);
	}

}

