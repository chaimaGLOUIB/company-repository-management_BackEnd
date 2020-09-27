package com.TECHSUB.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.TECHSUB.Models.Diametre;
import com.TECHSUB.Models.Region;
@CrossOrigin("*")
@RepositoryRestResource
public interface IDiametreRepository extends JpaRepository<Diametre, Long> {
	@RestResource(path="/byDiametre")
	public Page<Diametre> findByDiametreContaining(@Param("mc") String diametre,Pageable pageable);
}
