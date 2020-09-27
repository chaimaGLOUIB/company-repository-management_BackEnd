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

import com.TECHSUB.Metier.Interface.IGestionRapportB;
import com.TECHSUB.Models.RapportB;
import com.TECHSUB.Models.RapportB;
import com.TECHSUB.Repository.IAff_EquipementRepository;
import com.TECHSUB.Repository.IRapportBRepository;
import com.TECHSUB.Models.RapportB;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class RapportBRestService {

	@Autowired
	private IGestionRapportB gestionRapportB;
	@Autowired
	private IRapportBRepository RapportBRe;
	@GetMapping(value = "/RapportB/search/byNom") 

	 public Page<RapportB> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionRapportB.getPageRapportBs(page, size);
} else {
return RapportBRe.findByEquipementContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "RapportBs";
	}

	@GetMapping(value = "/RapportBs")
	public List<RapportB> listRapportBs() {
		return gestionRapportB.getAllRapportBs();
	}
	@GetMapping(value = "/RapportBs/{page}/{size}") 
	public Page<RapportB> listRapportBsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionRapportB.getPageRapportBs(page, size);
	}

	@GetMapping(value = "/RapportB/{id}")
	public RapportB RapportB(@PathVariable(name = "id") Long id) {
		return gestionRapportB.getRapportB(id);
	}

	@PostMapping(value = "/RapportB")
	public RapportB save(@RequestBody RapportB RapportB) {
		return gestionRapportB.addRapportB(RapportB);
	}

	@PutMapping(value = "/RapportB/{id}")
	public RapportB update(@PathVariable(name = "id") Long id, @RequestBody RapportB RapportB) {
		return gestionRapportB.updateRapportB(id, RapportB);
	}

	@DeleteMapping(value = "/RapportB/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionRapportB.deleteRapportB(id);
	}

}

