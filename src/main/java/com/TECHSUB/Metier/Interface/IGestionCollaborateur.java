package com.TECHSUB.Metier.Interface;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.TECHSUB.Models.Collaborateur;

public interface IGestionCollaborateur {
	public List<Collaborateur> getAllCollaborateurs();
	public Page<Collaborateur> getPageCollaborateurs(int page ,int size);
	public Collaborateur getCollaborateur(Long id);
	public Collaborateur addCollaborateur(Collaborateur e);
	public Collaborateur updateCollaborateur(Long id,Collaborateur e);
	public void deleteCollaborateur(Long id);
}
