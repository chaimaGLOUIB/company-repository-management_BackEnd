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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor



public class Diametre implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id;
	
	@NotBlank
  private String diametre;
	
	private String description;
	private String unite;
	
	private String etat;
	
	@NotFound(action = NotFoundAction.IGNORE)

	@ManyToMany
	@JoinTable(
			 name = "Diametre_Prestation",  
		     joinColumns = {@JoinColumn(name = "diametre_id")},
	   	     inverseJoinColumns = {@JoinColumn(name = "prestation_id")})
    @JsonIgnoreProperties("diametres")

	private List<Prestation> prestations;
	@JsonIgnore
	@OneToMany(mappedBy="diametre")
	private List<Rapport> raports;
	
	@OneToMany(mappedBy="diametre")
	@JsonIgnoreProperties("diametre")
	private List<TypeConsommable> type_consommable;
	
	
}
