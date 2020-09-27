package com.TECHSUB.Models;

import java.util.Date;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class FinanceMachineRapport {

	

	 @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
	private double budget;
	private double planifieActualise;
	private double forecast1;
	private double forecast2;
}
