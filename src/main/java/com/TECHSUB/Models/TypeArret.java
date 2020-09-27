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
	public class TypeArret implements Serializable {
		
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
		
	private String typeArret;
	
    private String description;
	@NotFound(action = NotFoundAction.IGNORE)

    @ManyToOne
    private CategorieArret categorieArret;
    
	@NotFound(action = NotFoundAction.IGNORE)

    @ManyToOne
    private Client client;
    
    private String productivite;
    
   
    
    
   
    
}
