package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor


public class Consommable implements Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id; 
	private String numSerie;
	private String nom;
	private String description;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	@JsonIgnoreProperties("consommables") 
	private MarqueConsommable marque;
	
	private String etat;
	
	
	
}
