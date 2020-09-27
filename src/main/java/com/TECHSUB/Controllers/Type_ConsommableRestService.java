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

import com.TECHSUB.Metier.Interface.IGestionType_Consommable;
import com.TECHSUB.Models.TypeConsommable;
import com.TECHSUB.Models.TypeConsommable;
import com.TECHSUB.Repository.ITypeConsommableRepository;
import com.TECHSUB.Models.TypeConsommable;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Type_ConsommableRestService {

	@Autowired
	private IGestionType_Consommable gestionTypeConsommable;
	@Autowired
	private ITypeConsommableRepository TypeConsommableRe;
	@GetMapping(value = "/TypeConsommable/search/byNom") 

	 public Page<TypeConsommable> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionTypeConsommable.getPageTypeConsommables(page, size);
} else {
return TypeConsommableRe.findByTypeConsommableContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "TypeConsommables";
	}
	@GetMapping(value = "/TypeConsommables/{page}/{size}") 
	public Page<TypeConsommable> listTypeConsommablesPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionTypeConsommable.getPageTypeConsommables(page, size);
	}
	@GetMapping(value = "/TypeConsommables")
	public List<TypeConsommable> listTypeConsommables() {
		return gestionTypeConsommable.getAllTypeConsommables();
	}

	@GetMapping(value = "/TypeConsommable/{id}")
	public TypeConsommable TypeConsommable(@PathVariable(name = "id") Long id) {
		return gestionTypeConsommable.getTypeConsommable(id);
	}

	@PostMapping(value = "/TypeConsommable")
	public TypeConsommable save(@RequestBody TypeConsommable TypeConsommable) {
		return gestionTypeConsommable.addTypeConsommable(TypeConsommable);
	}

	@PutMapping(value = "/TypeConsommable/{id}")
	public TypeConsommable update(@PathVariable(name = "id") Long id, @RequestBody TypeConsommable TypeConsommable) {
		return gestionTypeConsommable.updateTypeConsommable(id, TypeConsommable);
	}

	@DeleteMapping(value = "/TypeConsommable/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionTypeConsommable.deleteTypeConsommable(id);
	}

}

