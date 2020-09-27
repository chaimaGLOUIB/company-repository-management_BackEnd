package com.TECHSUB.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.TECHSUB.Models.Sous_Traitant;
import com.TECHSUB.Models.Type_Prestation;
@CrossOrigin("*")
@RepositoryRestResource
public interface IType_PrestationRepository extends JpaRepository<Type_Prestation, Long> {
	@RestResource(path="/byTypePrestation")
	public Page<Type_Prestation> findByTypePrestationContaining(@Param("mc") String nom,Pageable pageable);
}
