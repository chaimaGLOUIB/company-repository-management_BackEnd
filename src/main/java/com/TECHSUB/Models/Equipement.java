package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Equipement implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id;
	
	
	private String nom;
	
	private String description;
	
		
	private double Compte;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	private Prestation prestation;
	
	@JsonIgnore 
	@OneToMany(mappedBy="equipement")
	private List<Affectation_Equipement> affectations;
	
	@JsonIgnore 
	@OneToMany(mappedBy="equipement")
	private List<Sondage> sondages;
	
	@JsonIgnore 
	@OneToMany(mappedBy="equipement")
	private List<Rapport> raports;
	
	
	private long nombre_poste;
	
	@NotBlank
	private String etat;
}
