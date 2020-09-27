package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rapport implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @JsonFormat(pattern="yyyy-MM-dd")

	private Date date;
	@ManyToOne
	private Equipement equipement;

	@ManyToOne
	private Sous_Traitant sous_traitant;
	private int nombrePoste;

	@ManyToOne
	private Chantier chantier;

	@ManyToOne
	private Sondage sondage;

	private String etat;

	@ManyToOne
	private Prestation prestation;

	@ManyToOne
	private Diametre diametre;

	@Embedded
	private PosteRapport posteRapport;

	@ElementCollection
	@CollectionTable(name = "rapport_arret", joinColumns = @JoinColumn(name = "rapport_id"))
	private List<ArretRapport> arretRapport;
	
	@ElementCollection
	@CollectionTable(name = "rapport_appareil", joinColumns = @JoinColumn(name = "rapport_id"))
	private List<AppareilRapport> appareilRapport;

	@ElementCollection
	@CollectionTable(name = "rapport_consommable", joinColumns = @JoinColumn(name = "rapport_id"))

	private List<ConsommableRapport> consommableRapport;

	@Embedded
	private ConsommationGasoilRapport consommationGasoilRapport;

	@ElementCollection
	@CollectionTable(name = "rapport_collaborateur", joinColumns = @JoinColumn(name = "rapport_id"))
	private List<CollaborateurRapport> collaborateurRapport;

	private String faitManquante;
}
