package com.TECHSUB.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TECHSUB.Metier.Interface.IGestionRapport;
import com.TECHSUB.Models.Rapport;
import com.TECHSUB.Models.Rapport;
import com.TECHSUB.Repository.IAff_EquipementRepository;
import com.TECHSUB.Repository.IRapportRepository;
import com.TECHSUB.Models.Rapport;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class RapportRestService {

	@Autowired
	private IGestionRapport gestionRapport;
	@Autowired
	private IRapportRepository RapportRe;
	@GetMapping(value = "/Rapport/search/byDate") 

	 public Page<Rapport> findByName( @RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date ,@RequestParam("page") int page,@RequestParam("size") int size) {

if (date == null) {
return gestionRapport.getPageRapports(page, size);
} else {
return RapportRe.findByDateContaining(date, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Rapports";
	}

	@GetMapping(value = "/Rapports")
	public List<Rapport> listRapports() {
		return gestionRapport.getAllRapports();
	}
	
	@GetMapping(value = "/Rapports/{page}/{size}") 
	public Page<Rapport> listRapportsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionRapport.getPageRapports(page, size);
	}

	@GetMapping(value = "/Rapport/{id}")
	public Rapport Rapport(@PathVariable(name = "id") Long id) {
		return gestionRapport.getRapport(id);
	}

	@PostMapping(value = "/Rapport")
	public Rapport save(@RequestBody Rapport Rapport) {
		return gestionRapport.addRapport(Rapport);
	}

	@PutMapping(value = "/Rapport/{id}")
	public Rapport update(@PathVariable(name = "id") Long id, @RequestBody Rapport Rapport) {
		return gestionRapport.updateRapport(id, Rapport);
	}

	@DeleteMapping(value = "/Rapport/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionRapport.deleteRapport(id);
	}

}

