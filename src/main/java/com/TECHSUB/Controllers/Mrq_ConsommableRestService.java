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

import com.TECHSUB.Metier.Interface.IGestionMrq_Consommable;
import com.TECHSUB.Models.MarqueConsommable;
import com.TECHSUB.Repository.IMarqueConsommable;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Mrq_ConsommableRestService {

	@Autowired
	private IGestionMrq_Consommable gestionMarqueConsommable;
	@Autowired
	private IMarqueConsommable MarqueConsommableRe;
	@GetMapping(value = "/MarqueConsommable/search/byNom") 

	 public Page<MarqueConsommable> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionMarqueConsommable.getPageMarqueConsommables(page, size);
} else {
return MarqueConsommableRe.findByMarqueConsommableContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "MarqueConsommables";
	}

	@GetMapping(value = "/MarqueConsommables")
	public List<MarqueConsommable> listMarqueConsommables() {
		return gestionMarqueConsommable.getAllMarqueConsommables();
	}
	@GetMapping(value = "/MarqueConsommables/{page}/{size}") 
	public Page<MarqueConsommable> listMarqueConsommablesPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionMarqueConsommable.getPageMarqueConsommables(page, size);
	}
	@GetMapping(value = "/MarqueConsommable/{id}")
	public MarqueConsommable MarqueConsommable(@PathVariable(name = "id") Long id) {
		return gestionMarqueConsommable.getMarqueConsommable(id);
	}

	@PostMapping(value = "/MarqueConsommable")
	public MarqueConsommable save(@RequestBody MarqueConsommable MarqueConsommable) {
		return gestionMarqueConsommable.addMarqueConsommable(MarqueConsommable);
	}

	@PutMapping(value = "/MarqueConsommable/{id}")
	public MarqueConsommable update(@PathVariable(name = "id") Long id, @RequestBody MarqueConsommable MarqueConsommable) {
		return gestionMarqueConsommable.updateMarqueConsommable(id, MarqueConsommable);
	}

	@DeleteMapping(value = "/MarqueConsommable/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionMarqueConsommable.deleteMarqueConsommable(id);
	}

}

