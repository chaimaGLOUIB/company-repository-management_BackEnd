package com.TECHSUB.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.TECHSUB.Models.Categorie_Prestation;
@CrossOrigin("*")
@RepositoryRestResource
public interface ICategorie_PrestRepository extends JpaRepository<Categorie_Prestation, Long> {
	@RestResource(path="/byCategoriePrestation")
	public Page<Categorie_Prestation> findByCategoriePrestationContaining(@Param("mc") String categorie,Pageable pageable);
}
