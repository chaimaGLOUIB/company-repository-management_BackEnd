package com.TECHSUB.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.TECHSUB.Models.TypeArret;
@CrossOrigin("*")
@RepositoryRestResource
public interface ITypeArretRepository extends JpaRepository<TypeArret, Long>{
	@RestResource(path="/byTypeArret")
	public Page<TypeArret> findByTypeArretContaining(@Param("mc") String nom,Pageable pageable);
}
