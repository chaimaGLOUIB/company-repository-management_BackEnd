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

import com.TECHSUB.Metier.Interface.IGestionHoraire_Poste;
import com.TECHSUB.Models.Horaire_Poste;
import com.TECHSUB.Models.Horaire_Poste;
import com.TECHSUB.Repository.IHoraire_PosteRepository;
import com.TECHSUB.Models.Horaire_Poste;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Horaire_PosteRestService {

	@Autowired
	private IGestionHoraire_Poste gestionHoraire_Poste;
	@Autowired
	private IHoraire_PosteRepository Horaire_PosteRe;
	@GetMapping(value = "/Horaire_Poste/search/byNom") 

	 public Page<Horaire_Poste> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionHoraire_Poste.getPageHoraire_Postes(page, size);
} else {
return Horaire_PosteRe.findByNumPosteContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Horaire_Postes";
	}
	@GetMapping(value = "/Horaire_Postes/{page}/{size}") 
	public Page<Horaire_Poste> listHoraire_PostesPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionHoraire_Poste.getPageHoraire_Postes(page, size);
	}

	@GetMapping(value = "/Horaire_Postes")
	public List<Horaire_Poste> listHoraire_Postes() {
		return gestionHoraire_Poste.getAllHoraire_Postes();
	}

	@GetMapping(value = "/Horaire_Poste/{id}")
	public Horaire_Poste Horaire_Poste(@PathVariable(name = "id") Long id) {
		return gestionHoraire_Poste.getHoraire_Poste(id);
	}

	@PostMapping(value = "/Horaire_Poste")
	public Horaire_Poste save(@RequestBody Horaire_Poste Horaire_Poste) {
		return gestionHoraire_Poste.addHoraire_Poste(Horaire_Poste);
	}

	@PutMapping(value = "/Horaire_Poste/{id}")
	public Horaire_Poste update(@PathVariable(name = "id") Long id, @RequestBody Horaire_Poste Horaire_Poste) {
		return gestionHoraire_Poste.updateHoraire_Poste(id, Horaire_Poste);
	}

	@DeleteMapping(value = "/Horaire_Poste/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionHoraire_Poste.deleteHoraire_Poste(id);
	}

}

