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
import com.TECHSUB.Metier.Interface.IGestionCpte_Analytique;
import com.TECHSUB.Models.Compte_Analytique;
import com.TECHSUB.Models.Client;
import com.TECHSUB.Models.Compte_Analytique;
import com.TECHSUB.Repository.ICompte_AnalytiqueRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class Compte_AnalytiqueRestService {

	@Autowired
	private IGestionCpte_Analytique gestionCompte_Analytique;
	@Autowired
	private ICompte_AnalytiqueRepository Compte_AnalytiqueRe;
	@GetMapping(value = "/Compte_Analytique/search/byNom") 

	 public Page<Compte_Analytique> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionCompte_Analytique.getPageCompte_Analytiques(page, size);
} else {
return Compte_AnalytiqueRe.findByCompteContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Compte_Analytiques";
	}
	@GetMapping(value = "/Compte_Analytiques/{page}/{size}") 
	public Page<Compte_Analytique> listCompte_AnalytiquesPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionCompte_Analytique.getPageCompte_Analytiques(page, size);
	}

	@GetMapping(value = "/Compte_Analytiques")
	public List<Compte_Analytique> listCompte_Analytiques() {
		return gestionCompte_Analytique.getAllCompte_Analytiques();
	}

	@GetMapping(value = "/Compte_Analytique/{id}")
	public Compte_Analytique Compte_Analytique(@PathVariable(name = "id") Long id) {
		return gestionCompte_Analytique.getCompte_Analytique(id);
	}

	@PostMapping(value = "/Compte_Analytique")
	public Compte_Analytique save(@RequestBody Compte_Analytique Compte_Analytique) {
		return gestionCompte_Analytique.addCompte_Analytique(Compte_Analytique);
	}

	@PutMapping(value = "/Compte_Analytique/{id}")
	public Compte_Analytique update(@PathVariable(name = "id") Long id, @RequestBody Compte_Analytique Compte_Analytique) {
		return gestionCompte_Analytique.updateCompte_Analytique(id, Compte_Analytique);
	}

	@DeleteMapping(value = "/Compte_Analytique/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionCompte_Analytique.deleteCompte_Analytique(id);
	}

}

