package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
	public class CategorieArret implements Serializable {
		
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
		
	private String categorieArret;
	
    private String description;
    
    @JsonIgnore 
    @OneToMany(mappedBy="categorieArret")
    private List<TypeArret> types;
}
