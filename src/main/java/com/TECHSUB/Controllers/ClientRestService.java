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

import com.TECHSUB.Metier.Interface.IGestionClient;
import com.TECHSUB.Models.Client;
import com.TECHSUB.Models.Client;
import com.TECHSUB.Repository.IClientRepository;
import com.TECHSUB.Models.Client;


@RestController
@CrossOrigin(origins = "http://localhost:4200" )

public class ClientRestService {

	@Autowired
	private IGestionClient gestionClient;
	@Autowired
	private IClientRepository ClientRe;
	@GetMapping(value = "/Client/search/byNom") 

	 public Page<Client> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionClient.getPageClients(page, size);
} else {
return ClientRe.findByNomContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "Clients";
	}

	@GetMapping(value = "/Clients")
	public List<Client> listClients() {
		return gestionClient.getAllClients();
	}

	@GetMapping(value = "/Client/{id}")
	public Client Client(@PathVariable(name = "id") Long id) {
		return gestionClient.getClient(id);
	}
	@GetMapping(value = "/Clients/{page}/{size}") 
	public Page<Client> listClientsPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionClient.getPageClients(page, size);
	}
	@PostMapping(value = "/Client")
	public Client save(@RequestBody Client Client) {
		return gestionClient.addClient(Client);
	}

	@PutMapping(value = "/Client/{id}")
	public Client update(@PathVariable(name = "id") Long id, @RequestBody Client Client) {
		return gestionClient.updateClient(id, Client);
	}

	@DeleteMapping(value = "/Client/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionClient.deleteClient(id);
	}

}

