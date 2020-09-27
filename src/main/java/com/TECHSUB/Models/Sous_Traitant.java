package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Sous_Traitant implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id; 
	 
	private String nom;
	private String activite;
	
	private String contact1;
	
	private String contact2;
	
	private String adresse;
	
	private String telephone;
	
	private String fax;
	
	private String email;
	
	private String etat;
	
	
}
