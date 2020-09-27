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

import com.TECHSUB.Metier.Interface.IGestionConsommable;
import com.TECHSUB.Models.Consommable;
import com.TECHSUB.Models.Consommable;
import com.TECHSUB.Repository.IConsommableRepository;
import com.TECHSUB.Models.Consommable;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class ConsommableRestService {

	@Autowired
	private IGestionConsommable gestionConsommable;
	@Autowired
	private IConsommableRepository ConsommableRe;
	@GetMapping(value = "/Consommable/search/byNom") 

	 public Page<Consommable> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionConsommable.getPageConsommables(page, size);
} else {
return ConsommableRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Consommables";
	}

	@GetMapping(value = "/Consommables")
	public List<Consommable> listConsommables() {
		return gestionConsommable.getAllConsommables();
	}
	@GetMapping(value = "/Consommables/{page}/{size}") 
	public Page<Consommable> listConsommablesPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionConsommable.getPageConsommables(page, size);
	}
	@GetMapping(value = "/Consommable/{id}")
	public Consommable Consommable(@PathVariable(name = "id") Long id) {
		return gestionConsommable.getConsommable(id);
	}

	@PostMapping(value = "/Consommable")
	public Consommable save(@RequestBody Consommable Consommable) {
		return gestionConsommable.addConsommable(Consommable);
	}

	@PutMapping(value = "/Consommable/{id}")
	public Consommable update(@PathVariable(name = "id") Long id, @RequestBody Consommable Consommable) {
		return gestionConsommable.updateConsommable(id, Consommable);
	}

	@DeleteMapping(value = "/Consommable/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionConsommable.deleteConsommable(id);
	}

}

