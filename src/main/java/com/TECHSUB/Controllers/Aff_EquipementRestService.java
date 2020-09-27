package com.TECHSUB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TECHSUB.Metier.Interface.IGestionAff_Equipement;
import com.TECHSUB.Models.Affectation_Equipement;
import com.TECHSUB.Repository.IAff_EquipementRepository;
import com.TECHSUB.Models.Affectation_Equipement;
import com.TECHSUB.Models.Affectation_Equipement;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Aff_EquipementRestService {

	@Autowired
	private IGestionAff_Equipement gestionAffectation_Equipement;
	@Autowired
	private IAff_EquipementRepository Affectation_EquipementRe;
	@GetMapping(value = "/Affectation_Equipement/search/byNom") 

	 public Page<Affectation_Equipement> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionAffectation_Equipement.getPageAffectation_Equipements(page, size);
} else {
return Affectation_EquipementRe.findByEquipementContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Affectation_Equipements";
	}

	@GetMapping(value = "/Affectation_Equipements")

	public List<Affectation_Equipement> listAffectation_Equipements() {
		return gestionAffectation_Equipement.getAllAffectation_Equipements();
	}
	@GetMapping(value = "/Affectation_Equipements/{page}/{size}")

	public Page<Affectation_Equipement> listAffectation_EquipementsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionAffectation_Equipement.getPageAffectation_Equipements(page, size);
	}
	@GetMapping(value = "/Affectation_Equipement/{id}")

	public Affectation_Equipement Affectation_Equipement(@PathVariable(name = "id") Long id) {
		return gestionAffectation_Equipement.getAffectation_Equipement(id);
	}

	@PostMapping(value = "/Affectation_Equipement")
	public Affectation_Equipement save(@RequestBody Affectation_Equipement Affectation_Equipement) {
		return gestionAffectation_Equipement.addAffectation_Equipement(Affectation_Equipement);
	}

	@PutMapping(value = "/Affectation_Equipement/{id}")
	public Affectation_Equipement update(@PathVariable(name = "id") Long id, @RequestBody Affectation_Equipement Affectation_Equipement) {
		return gestionAffectation_Equipement.updateAffectation_Equipement(id, Affectation_Equipement);
	}

	@DeleteMapping(value = "/Affectation_Equipement/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionAffectation_Equipement.deleteAffectation_Equipement(id);
	}

}

