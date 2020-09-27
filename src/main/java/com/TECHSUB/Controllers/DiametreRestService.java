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

import com.TECHSUB.Metier.Interface.IGestionDiametre;
import com.TECHSUB.Models.Diametre;
import com.TECHSUB.Models.Diametre;
import com.TECHSUB.Repository.IDiametreRepository;
import com.TECHSUB.Models.Diametre;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class DiametreRestService {

	@Autowired
	private IGestionDiametre gestionDiametre;
	@Autowired
	private IDiametreRepository DiametreRe;
	@GetMapping(value = "/Diametre/search/byNom") 

	 public Page<Diametre> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionDiametre.getPageDiametres(page, size);
} else {
return DiametreRe.findByDiametreContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Diametres";
	}

	@GetMapping(value = "/Diametres")
	public List<Diametre> listDiametres() {
		return gestionDiametre.getAllDiametres();
	}
	@GetMapping(value = "/Diametres/{page}/{size}") 
	public Page<Diametre> listDiametresPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionDiametre.getPageDiametres(page, size);
	}
	@GetMapping(value = "/Diametre/{id}")
	public Diametre Diametre(@PathVariable(name = "id") Long id) {
		return gestionDiametre.getDiametre(id);
	}

	@PostMapping(value = "/Diametre")
	public Diametre save(@RequestBody Diametre Diametre) {
		return gestionDiametre.addDiametre(Diametre);
	}

	@PutMapping(value = "/Diametre/{id}")
	public Diametre update(@PathVariable(name = "id") Long id, @RequestBody Diametre Diametre) {
		return gestionDiametre.updateDiametre(id, Diametre);
	}

	@DeleteMapping(value = "/Diametre/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionDiametre.deleteDiametre(id);
	}

}

