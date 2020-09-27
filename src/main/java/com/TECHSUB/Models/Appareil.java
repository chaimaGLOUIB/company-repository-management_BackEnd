package com.TECHSUB.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Entity
	@Data @NoArgsConstructor @AllArgsConstructor
	public class Appareil implements Serializable{
		
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		 private long id;
		
		private String nom;
		private String description;
		private double mesure;
		
		private String etat;
}
