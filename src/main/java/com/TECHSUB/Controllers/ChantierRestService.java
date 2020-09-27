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

import com.TECHSUB.Metier.Interface.IGestionChantier;
import com.TECHSUB.Models.Chantier;
import com.TECHSUB.Models.Categorie_Prestation;
import com.TECHSUB.Models.Chantier;
import com.TECHSUB.Repository.IChantierRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class ChantierRestService {

	@Autowired
	private IGestionChantier gestionChantier;
	@Autowired
	private IChantierRepository ChantierRe;
	@GetMapping(value = "/Chantier/search/byNom") 

	 public Page<Chantier> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionChantier.getPageChantiers(page, size);
} else {
return ChantierRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Chantiers";
	}

	@GetMapping(value = "/Chantiers")
	public List<Chantier> listChantiers() {
		return gestionChantier.getAllChantiers();
	}

	@GetMapping(value = "/Chantier/{id}")
	public Chantier Chantier(@PathVariable(name = "id") Long id) {
		return gestionChantier.getChantier(id);
	}

	@PostMapping(value = "/Chantier")
	public Chantier save(@RequestBody Chantier Chantier) {
		return gestionChantier.addChantier(Chantier);
	}
	@GetMapping(value = "/Chantiers/{page}/{size}") 
	public Page<Chantier> listChantiersPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionChantier.getPageChantiers(page, size);
	}

	@PutMapping(value = "/Chantier/{id}")
	public Chantier update(@PathVariable(name = "id") Long id, @RequestBody Chantier Chantier) {
		return gestionChantier.updateChantier(id, Chantier);
	}

	@DeleteMapping(value = "/Chantier/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionChantier.deleteChantier(id);
	}

}

