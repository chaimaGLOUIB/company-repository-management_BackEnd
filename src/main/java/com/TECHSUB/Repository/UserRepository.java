package com.TECHSUB.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TECHSUB.Models.Pays;
import com.TECHSUB.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Page<User> findByNameContaining(String nom,Pageable pageable);

    Optional<User> findByUsername(String username);
     
    Boolean existsByUsername(String username); 
    Boolean existsByEmail(String email);
}