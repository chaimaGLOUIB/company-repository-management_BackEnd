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

import com.TECHSUB.Metier.Interface.IGestionType_Prestation;
import com.TECHSUB.Models.Type_Prestation;
import com.TECHSUB.Models.Region;
import com.TECHSUB.Models.Type_Prestation;
import com.TECHSUB.Repository.IType_PrestationRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Type_PrestationRestService {

	@Autowired
	private IGestionType_Prestation gestionType_Prestation;
	@Autowired
	private IType_PrestationRepository Type_PrestationRe;
	@GetMapping(value = "/Type_Prestations/search/byNom") 

	 public Page<Type_Prestation> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionType_Prestation.getPageType_Prestations(page, size);
} else {
return Type_PrestationRe.findByTypePrestationContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Type_Prestations";
	}
	@GetMapping(value = "/Type_Prestations/{page}/{size}") 
	public Page<Type_Prestation> listType_PrestationPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionType_Prestation.getPageType_Prestations(page, size);
	}

	@GetMapping(value = "/Type_Prestations")
	public List<Type_Prestation> listType_Prestations() {
		return gestionType_Prestation.getAllType_Prestations();
	}

	@GetMapping(value = "/Type_Prestation/{id}")
	public Type_Prestation Type_Prestation(@PathVariable(name = "id") Long id) {
		return gestionType_Prestation.getType_Prestation(id);
	}

	@PostMapping(value = "/Type_Prestation")
	public Type_Prestation save(@RequestBody Type_Prestation Type_Prestation) {
		return gestionType_Prestation.addType_Prestation(Type_Prestation);
	}

	@PutMapping(value = "/Type_Prestation/{id}")
	public Type_Prestation update(@PathVariable(name = "id") Long id, @RequestBody Type_Prestation Type_Prestation) {
		return gestionType_Prestation.updateType_Prestation(id, Type_Prestation);
	}

	@DeleteMapping(value = "/Type_Prestation/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionType_Prestation.deleteType_Prestation(id);
	}

}

