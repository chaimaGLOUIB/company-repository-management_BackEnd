package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class TypeConsommable implements Serializable {
	
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)	
 private long id; 

private String typeConsommable;


@NotFound(action = NotFoundAction.IGNORE)

@ManyToOne
@JsonIgnoreProperties("type_consommable")

private Diametre diametre;


private String description;


private String etat;

@OneToMany(mappedBy="typeConsommable")
@JsonIgnoreProperties("typeConsommable") 
private List<MarqueConsommable> marques;




}
