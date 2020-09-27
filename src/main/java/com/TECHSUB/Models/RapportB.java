package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	public class RapportB implements Serializable{
		
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		 private long id;
		
		@ManyToOne
		private Equipement equipement;
		@ManyToOne
		private Prestation prestation;
		@ManyToOne
		private Zone zone;
		
		private String periode;
		@ElementCollection
		@CollectionTable(name = "rapport_Machine_finance", joinColumns = @JoinColumn(name = "rapport_id"))
		private List<FinanceMachineRapport> finance;
		
		
}
