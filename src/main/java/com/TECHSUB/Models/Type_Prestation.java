package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Type_Prestation implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id;
	
	@NotBlank
     private String typePrestation;
     
     private String description;
     
     @JsonIgnore 
     @OneToMany(mappedBy="type_prestation")
     private List<Categorie_Prestation> categories;
     
     @NotBlank
     private String etat;
}
