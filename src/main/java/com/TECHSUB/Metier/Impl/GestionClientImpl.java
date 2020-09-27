package com.TECHSUB.Metier.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionClient;
import com.TECHSUB.Models.Client;
import com.TECHSUB.Repository.IClientRepository;

@Service
@Transactional
public class GestionClientImpl implements IGestionClient {

	@Autowired
	private IClientRepository ClientRepository;

	@Override
	public List<Client> getAllClients() {
		List<Client> lClients = ClientRepository.findAll();
		return lClients;
	}
	
	@Override
	public Page<Client> getPageClients( int page ,int size){
		return ClientRepository.findAll(PageRequest.of(page, size, Sort.by("id"))); 
	}


	@Override
	public Client getClient(Long id) {
		Client Client = ClientRepository.findById(id).get();
		if (Client == null)
			throw new RuntimeException("Client introuvable");
		return Client;
	}

	@Override
	public Client addClient(Client e) {
		return ClientRepository.save(e);
	}

	@Override
	public Client updateClient(Long id,Client e) {
		e.setId(id);
		return ClientRepository.save(e);
	}

	@Override
	public void deleteClient(Long id) {
		ClientRepository.deleteById(id);
	}

}
