package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Entity
	@Data @NoArgsConstructor @AllArgsConstructor
	public class RapportC implements Serializable{
		
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		 private long id;
		private  Date date;
		private String numPoste;
		@ManyToOne
		private Equipement equipement;
		@ManyToOne
		private Chantier chantier;
		
		private double compteurDebut;
		private double compteurFin;
		
		
		private double consommationGasoil;
		private String commentaire;
		
}
