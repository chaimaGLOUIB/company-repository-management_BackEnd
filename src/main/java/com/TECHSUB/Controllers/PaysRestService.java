package com.TECHSUB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TECHSUB.Metier.Interface.IGestionPays;
import com.TECHSUB.Models.Pays;
import com.TECHSUB.Repository.IPaysRepository;
import com.TECHSUB.Models.Pays;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class PaysRestService {

	@Autowired
	private IGestionPays gestionPays;
	@Autowired
	private IPaysRepository paysRe;
	@GetMapping(value = "/pays/search/byNom") 

	 public Page<Pays> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionPays.getPagePayss(page, size);
} else {
return paysRe.findByNomContaining(nom, PageRequest.of(page, size, Sort.by("nom")));
}
}

	public String index() {
		return "Payss";
	}
	@GetMapping(value = "/Pays/{page}/{size}") 
	public Page<Pays> listPayssPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionPays.getPagePayss(page,size);
	}
	@GetMapping(value = "/Payss")
	public List<Pays> listPayss() {
		return gestionPays.getAllPayss();
	}

	@GetMapping(value = "/Pays/{id}")
	public Pays Pays(@PathVariable(name = "id") Long id) {
		return gestionPays.getPays(id);
	}

	@PostMapping(value = "/Pays")
	public Pays save(@RequestBody Pays Pays) {
		return gestionPays.addPays(Pays);
	}

	@PutMapping(value = "/Pays/{id}")
	public Pays update(@PathVariable(name = "id") Long id, @RequestBody Pays Pays) {
		return gestionPays.updatePays(id, Pays);
	}

	@DeleteMapping(value = "/Pays/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionPays.deletePays(id);
	}

}

