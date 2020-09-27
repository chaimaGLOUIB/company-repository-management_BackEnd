package com.TECHSUB.Models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Collaborateur implements Serializable{
	
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)	
 private long id; 

private String matricule;

private String nom;

private String prenom;

@NotFound(action = NotFoundAction.IGNORE)
@ManyToOne
private Zone zone;

private String fonction;

private Date date_embauche ;

private Date date_depart;



}
