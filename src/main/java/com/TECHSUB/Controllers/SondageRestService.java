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

import com.TECHSUB.Metier.Interface.IGestionSondage;
import com.TECHSUB.Models.Sondage;
import com.TECHSUB.Models.Sondage;
import com.TECHSUB.Repository.ISondageRepository;
import com.TECHSUB.Models.Sondage;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class SondageRestService {

	@Autowired
	private IGestionSondage gestionSondage;
	@Autowired
	private ISondageRepository SondageRe;
	@GetMapping(value = "/Sondage/search/byNom") 

	 public Page<Sondage> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionSondage.getPageSondages(page, size);
} else {
return SondageRe.findBySondageContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Sondages";
	}

	@GetMapping(value = "/Sondages")
	public List<Sondage> listSondages() {
		return gestionSondage.getAllSondages();
	}
	@GetMapping(value = "/Sondages/{page}/{size}") 
	public Page<Sondage> listSondagesPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionSondage.getPageSondages(page, size);
	}

	@GetMapping(value = "/Sondage/{id}")
	public Sondage Sondage(@PathVariable(name = "id") Long id) {
		return gestionSondage.getSondage(id);
	}

	@PostMapping(value = "/Sondage")
	public Sondage save(@RequestBody Sondage Sondage) {
		return gestionSondage.addSondage(Sondage);
	}

	@PutMapping(value = "/Sondage/{id}")
	public Sondage update(@PathVariable(name = "id") Long id, @RequestBody Sondage Sondage) {
		return gestionSondage.updateSondage(id, Sondage);
	}

	@DeleteMapping(value = "/Sondage/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionSondage.deleteSondage(id);
	}

}

