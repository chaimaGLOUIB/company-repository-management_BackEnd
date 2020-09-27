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

import com.TECHSUB.Metier.Interface.IGestionEquipement;
import com.TECHSUB.Models.Equipement;
import com.TECHSUB.Models.Compte_Analytique;
import com.TECHSUB.Models.Equipement;
import com.TECHSUB.Repository.IEquipementRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class EquipementRestService {

	@Autowired
	private IGestionEquipement gestionEquipement;
	@Autowired
	private IEquipementRepository EquipementRe;
	@GetMapping(value = "/Equipement/search/byNom") 

	 public Page<Equipement> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionEquipement.getPageEquipements(page, size);
} else {
return EquipementRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Equipements";
	}
	@GetMapping(value = "/Equipement/{page}/{size}") 
	public Page<Equipement> listEquipementPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionEquipement.getPageEquipements(page, size);
	}

	@GetMapping(value = "/Equipements")
	public List<Equipement> listEquipements() {
		return gestionEquipement.getAllEquipements();
	}

	@GetMapping(value = "/Equipement/{id}")
	public Equipement Equipement(@PathVariable(name = "id") Long id) {
		return gestionEquipement.getEquipement(id);
	}

	@PostMapping(value = "/Equipement")
	public Equipement save(@RequestBody Equipement Equipement) {
		return gestionEquipement.addEquipement(Equipement);
	}

	@PutMapping(value = "/Equipement/{id}")
	public Equipement update(@PathVariable(name = "id") Long id, @RequestBody Equipement Equipement) {
		return gestionEquipement.updateEquipement(id, Equipement);
	}

	@DeleteMapping(value = "/Equipement/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionEquipement.deleteEquipement(id);
	}

}

