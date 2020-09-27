package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Client;

public interface IGestionClient {
	public List<Client> getAllClients();
	public Page<Client> getPageClients(int page ,int size);
	public Client getClient(Long id);
	public Client addClient(Client e);
	public Client updateClient(Long id,Client e);
	public void deleteClient(Long id);
}
