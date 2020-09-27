package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Pays implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id;

	private String nom;
	
	private String description;
	
	@NotFound(action = NotFoundAction.IGNORE)

    @ManyToOne
	private Region region;
	
	@JsonIgnore 
	@OneToMany(mappedBy="pays")
	private List<Client> clients;
	
	
	private String Etat;
	

}
