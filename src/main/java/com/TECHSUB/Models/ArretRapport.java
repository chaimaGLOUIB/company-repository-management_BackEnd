package com.TECHSUB.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor



public class ArretRapport implements Serializable{
	
	@NotFound(action = NotFoundAction.IGNORE)

	@ManyToOne(fetch = FetchType.EAGER)
	
   @JoinColumn(name = "typeArret_id")
	private TypeArret typeArret;
	
	 @JsonFormat(pattern = "HH:mm")
     private Date heureDebut;
	
	 @JsonFormat(pattern = "HH:mm")
     private Date heureFin ;
	 
     private String heureArret ;
	 
	 
}
