package com.TECHSUB.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.TECHSUB.Models.RapportB;

public interface IRapportBRepository extends JpaRepository<RapportB,Long> {
	public Page<RapportB> findByEquipementContaining(@Param("mc") String appareil,Pageable pageable);

}
