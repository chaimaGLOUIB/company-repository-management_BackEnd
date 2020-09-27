package com.TECHSUB.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.TECHSUB.Models.RapportC;

public interface IRapportCRepository extends JpaRepository<RapportC,Long>{
	public Page<RapportC> findByDateContaining(@Param("mc") String appareil,Pageable pageable);

}
