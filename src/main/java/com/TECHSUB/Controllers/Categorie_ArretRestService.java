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

import com.TECHSUB.Metier.Interface.IGestionCategorie_Arret;
import com.TECHSUB.Models.CategorieArret;
import com.TECHSUB.Models.CategorieArret;
import com.TECHSUB.Repository.ICategorieArretRepository;
import com.TECHSUB.Models.CategorieArret;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Categorie_ArretRestService {

	@Autowired
	private IGestionCategorie_Arret gestionCategorieArret;
	@Autowired
	private ICategorieArretRepository CategorieArretRe;
	@GetMapping(value = "/CategorieArret/search/byNom") 

	 public Page<CategorieArret> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionCategorieArret.getPageCategorieArrets(page, size);
} else {
return CategorieArretRe.findByCategorieArretContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "CategorieArrets";
	}
	@GetMapping(value = "/CategorieArrets/{page}/{size}") 
	public Page<CategorieArret> listCategorieArretsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionCategorieArret.getPageCategorieArrets(page, size);
	}
	@GetMapping(value = "/CategorieArrets")
	public List<CategorieArret> listCategorieArrets() {
		return gestionCategorieArret.getAllCategorieArrets();
	}

	@GetMapping(value = "/CategorieArret/{id}")
	public CategorieArret CategorieArret(@PathVariable(name = "id") Long id) {
		return gestionCategorieArret.getCategorieArret(id);
	}

	@PostMapping(value = "/CategorieArret")
	public CategorieArret save(@RequestBody CategorieArret CategorieArret) {
		return gestionCategorieArret.addCategorieArret(CategorieArret);
	}

	@PutMapping(value = "/CategorieArret/{id}")
	public CategorieArret update(@PathVariable(name = "id") Long id, @RequestBody CategorieArret CategorieArret) {
		return gestionCategorieArret.updateCategorieArret(id, CategorieArret);
	}

	@DeleteMapping(value = "/CategorieArret/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionCategorieArret.deleteCategorieArret(id);
	}

}

