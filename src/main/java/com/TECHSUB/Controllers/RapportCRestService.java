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

import com.TECHSUB.Metier.Interface.IGestionRapportC;
import com.TECHSUB.Models.RapportC;
import com.TECHSUB.Models.RapportC;
import com.TECHSUB.Repository.IAff_EquipementRepository;
import com.TECHSUB.Repository.IRapportCRepository;
import com.TECHSUB.Models.RapportC;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class RapportCRestService {

	@Autowired
	private IGestionRapportC gestionRapportC;
	@Autowired
	private IRapportCRepository RapportCRe;
	@GetMapping(value = "/RapportC/search/byNom") 

	 public Page<RapportC> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionRapportC.getPageRapportCs(page, size);
} else {
return RapportCRe.findByDateContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "RapportCs";
	}

	@GetMapping(value = "/RapportCs")
	public List<RapportC> listRapportCs() {
		return gestionRapportC.getAllRapportCs();
	}
	@GetMapping(value = "/RapportCs/{page}/{size}") 
	public Page<RapportC> listRapportCsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionRapportC.getPageRapportCs(page, size);
	}

	@GetMapping(value = "/RapportC/{id}")
	public RapportC RapportC(@PathVariable(name = "id") Long id) {
		return gestionRapportC.getRapportC(id);
	}

	@PostMapping(value = "/RapportC")
	public RapportC save(@RequestBody RapportC RapportC) {
		return gestionRapportC.addRapportC(RapportC);
	}

	@PutMapping(value = "/RapportC/{id}")
	public RapportC update(@PathVariable(name = "id") Long id, @RequestBody RapportC RapportC) {
		return gestionRapportC.updateRapportC(id, RapportC);
	}

	@DeleteMapping(value = "/RapportC/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionRapportC.deleteRapportC(id);
	}

}

