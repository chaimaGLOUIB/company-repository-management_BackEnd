package com.TECHSUB.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.TECHSUB.Models.MarqueConsommable;
import com.TECHSUB.Models.Region;

public interface IMarqueConsommable extends JpaRepository<MarqueConsommable, Long> {
	@RestResource(path="/byMarqueConsommable")
	public Page<MarqueConsommable> findByMarqueConsommableContaining(@Param("mc") String  marqueConsommable,Pageable pageable);
}
