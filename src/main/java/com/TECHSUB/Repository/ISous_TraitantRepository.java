package com.TECHSUB.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.TECHSUB.Models.Region;
import com.TECHSUB.Models.Sous_Traitant;
@CrossOrigin("*")
@RepositoryRestResource
public interface ISous_TraitantRepository extends JpaRepository<Sous_Traitant, Long>{
	@RestResource(path="/byNom")
	public Page<Sous_Traitant> findByNomContaining(@Param("mc") String nom,Pageable pageable);
}
