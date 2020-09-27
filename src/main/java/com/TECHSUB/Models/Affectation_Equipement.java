package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Affectation_Equipement implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id;
	
	@NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
	private Equipement equipement;
	
	
	private double compte;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	private Zone zone;
	
	
	private Date dateDebut;
	
	
	private Date dateFin;
	private int etat; 
	
	

}
