package com.TECHSUB.Models;

import java.io.Serializable;

import javax.persistence.Embeddable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor



public class ConsommationGasoilRapport implements Serializable{
	private double compteurDebut;
	private double compteurF;
	private double consommationGasoil;
	private String commentaire;
	 
}
