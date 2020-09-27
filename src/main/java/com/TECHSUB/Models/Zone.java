package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Zone implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id; 


	private String nom;

	private String description;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	private Client client;

	private String etat;
	
	@JsonIgnore 
	@OneToMany(mappedBy="zone")
	private List<Chantier> chantiers;
	
	@JsonIgnore 
	@OneToMany(mappedBy="zone")
	private List<Affectation_Equipement> affectations;
	
	@JsonIgnore 
	@OneToMany(mappedBy="zone")
	private List<Sondage> sondages;
}
