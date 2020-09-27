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

import com.TECHSUB.Metier.Interface.IGestionType_Arret;
import com.TECHSUB.Models.TypeArret;
import com.TECHSUB.Models.TypeArret;
import com.TECHSUB.Models.TypeArret;
import com.TECHSUB.Repository.ITypeArretRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Type_ArretRestService {

	@Autowired
	private IGestionType_Arret gestionTypeArret;
	@Autowired
	private ITypeArretRepository TypeArretRe;
	@GetMapping(value = "/TypeArret/search/byNom") 

	 public Page<TypeArret> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionTypeArret.getPageTypeArrets(page, size);
} else {
return TypeArretRe.findByTypeArretContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "TypeArrets";
	}
	@GetMapping(value = "/TypeArrets/{page}/{size}") 
	public Page<TypeArret> listTypeArretsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionTypeArret.getPageTypeArrets(page, size);
	}

	@GetMapping(value = "/TypeArrets")
	public List<TypeArret> listTypeArrets() {
		return gestionTypeArret.getAllTypeArrets();
	}

	@GetMapping(value = "/TypeArret/{id}")
	public TypeArret TypeArret(@PathVariable(name = "id") Long id) {
		return gestionTypeArret.getTypeArret(id);
	}

	@PostMapping(value = "/TypeArret")
	public TypeArret save(@RequestBody TypeArret TypeArret) {
		return gestionTypeArret.addTypeArret(TypeArret);
	}

	@PutMapping(value = "/TypeArret/{id}")
	public TypeArret update(@PathVariable(name = "id") Long id, @RequestBody TypeArret TypeArret) {
		return gestionTypeArret.updateTypeArret(id, TypeArret);
	}

	@DeleteMapping(value = "/TypeArret/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionTypeArret.deleteTypeArret(id);
	}

}

