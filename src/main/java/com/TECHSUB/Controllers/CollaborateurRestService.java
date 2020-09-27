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

import com.TECHSUB.Metier.Interface.IGestionCollaborateur;
import com.TECHSUB.Models.Collaborateur;
import com.TECHSUB.Models.Collaborateur;
import com.TECHSUB.Repository.ICollaborateurRepository;
import com.TECHSUB.Models.Collaborateur;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class CollaborateurRestService {

	@Autowired
	private IGestionCollaborateur gestionCollaborateur;
	@Autowired
	private ICollaborateurRepository CollaborateurRe;
	@GetMapping(value = "/Collaborateur/search/byNom") 

	 public Page<Collaborateur> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionCollaborateur.getPageCollaborateurs(page, size);
} else {
return CollaborateurRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Collaborateurs";
	}

	@GetMapping(value = "/Collaborateurs")
	public List<Collaborateur> listCollaborateurs() {
		return gestionCollaborateur.getAllCollaborateurs();
	}
	@GetMapping(value = "/Collaborateurs/{page}/{size}") 
	public Page<Collaborateur> listCollaborateursPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionCollaborateur.getPageCollaborateurs(page, size);
	}

	@GetMapping(value = "/Collaborateur/{id}")
	public Collaborateur Collaborateur(@PathVariable(name = "id") Long id) {
		return gestionCollaborateur.getCollaborateur(id);
	}

	@PostMapping(value = "/Collaborateur")
	public Collaborateur save(@RequestBody Collaborateur Collaborateur) {
		return gestionCollaborateur.addCollaborateur(Collaborateur);
	}

	@PutMapping(value = "/Collaborateur/{id}")
	public Collaborateur update(@PathVariable(name = "id") Long id, @RequestBody Collaborateur Collaborateur) {
		return gestionCollaborateur.updateCollaborateur(id, Collaborateur);
	}

	@DeleteMapping(value = "/Collaborateur/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionCollaborateur.deleteCollaborateur(id);
	}

}

