package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Prestation implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id;
	
	@NotBlank
	private  String nom;
	
	private String description;
	
	@NotFound(action = NotFoundAction.IGNORE)

	@ManyToOne
	private Categorie_Prestation categorie;
	
	@JsonIgnore 
	@OneToMany(mappedBy="prestation")
	private List<Equipement> equipements;
	
	private double temps_ouverture;
	
	@NotBlank
	private String etat;
	
	@NotFound(action = NotFoundAction.IGNORE)

	@ManyToMany(mappedBy="prestations")
    @JsonIgnoreProperties("prestations")
	private List<Diametre> diametres;
	
	@JsonIgnore 
	@OneToMany(mappedBy="prestation")
	private List<Rapport> raports;
}