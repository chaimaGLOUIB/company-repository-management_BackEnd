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

import com.TECHSUB.Metier.Interface.IGestionAppareil;
import com.TECHSUB.Models.Appareil;
import com.TECHSUB.Models.Appareil;
import com.TECHSUB.Repository.IAff_EquipementRepository;
import com.TECHSUB.Repository.IAppareilRepository;
import com.TECHSUB.Models.Appareil;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class AppareilRestService {

	@Autowired
	private IGestionAppareil gestionAppareil;
	@Autowired
	private IAppareilRepository AppareilRe;
	@GetMapping(value = "/Appareil/search/byNom") 

	 public Page<Appareil> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionAppareil.getPageAppareils(page, size);
} else {
return AppareilRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Appareils";
	}

	@GetMapping(value = "/Appareils")
	public List<Appareil> listAppareils() {
		return gestionAppareil.getAllAppareils();
	}
	@GetMapping(value = "/Appareils/{page}/{size}") 
	public Page<Appareil> listAppareilsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionAppareil.getPageAppareils(page, size);
	}

	@GetMapping(value = "/Appareil/{id}")
	public Appareil Appareil(@PathVariable(name = "id") Long id) {
		return gestionAppareil.getAppareil(id);
	}

	@PostMapping(value = "/Appareil")
	public Appareil save(@RequestBody Appareil Appareil) {
		return gestionAppareil.addAppareil(Appareil);
	}

	@PutMapping(value = "/Appareil/{id}")
	public Appareil update(@PathVariable(name = "id") Long id, @RequestBody Appareil Appareil) {
		return gestionAppareil.updateAppareil(id, Appareil);
	}

	@DeleteMapping(value = "/Appareil/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionAppareil.deleteAppareil(id);
	}

}

