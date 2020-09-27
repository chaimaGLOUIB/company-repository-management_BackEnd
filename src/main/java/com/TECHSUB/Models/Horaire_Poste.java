package com.TECHSUB.Models;

import java.io.Serializable;
import java.text.Format;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor


public class Horaire_Poste implements Serializable{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	 private long id; 
	 private long numPoste;
	
	 @JsonFormat(pattern = "HH:mm")
     private Date heureDebutTh;
	
	 @JsonFormat(pattern = "HH:mm")
     private Date heureFinTh ;
	 
	
	
	
	 
}
