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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
	public class Sondage implements Serializable {
		
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
		
    private String sondage;
    
    private String description;
    
    private String type;
	@NotFound(action = NotFoundAction.IGNORE)

    @ManyToOne
    private Zone zone;
    
    @ManyToOne
    private Equipement equipement;
    
    private double Code_initiale;
    
    private double Code_cible;
    
    private String etat;
    
    @JsonIgnore 
    @OneToMany(mappedBy="sondage")
    private List<Rapport> raports;
    
}
