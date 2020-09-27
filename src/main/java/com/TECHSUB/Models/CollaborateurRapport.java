package com.TECHSUB.Models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor



public class CollaborateurRapport implements Serializable{
	
	
	private String nom;
	private String prenom;
	private String matricule;
	private String fonction; 
	private String motif;
	private String absence;
}
