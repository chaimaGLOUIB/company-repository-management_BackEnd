package com.TECHSUB.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TECHSUB.Models.Rapport;

public interface IRapportRepository extends JpaRepository<Rapport,Long> {
	public Page<Rapport> findByDateContaining(@Param("mc") Date date ,Pageable pageable);
	
	@Query("SELECT r FROM Rapport r WHERE r.date = ?1 AND r.posteRapport.numPoste = ?2")
   Rapport findByDateAndNum(Date date, long numPoste);
}


