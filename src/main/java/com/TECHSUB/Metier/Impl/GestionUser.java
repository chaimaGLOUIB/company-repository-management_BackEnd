package com.TECHSUB.Metier.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TECHSUB.Metier.Interface.IGestionUser;
import com.TECHSUB.Models.User;
import com.TECHSUB.Models.User;
import com.TECHSUB.Repository.UserRepository;


@Service
@Transactional
public class GestionUser implements IGestionUser {
	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public Optional<User> getUserbyUsername(String username) {
		Optional<User>  user = UserRepository.findByUsername(username);
		return user;
	}
	

	@Override
	public List<User> getAllUsers() {
		List<User> lUsers = UserRepository.findAll();
		return lUsers;
	}
	
	@Override
	
	public Page<User> getPageUsers( int page ,int size){
		return UserRepository.findAll(PageRequest.of(page, size, Sort.by("name"))); 
	}

	@Override
	public User getUser(Long id) {
		User User = UserRepository.findById(id).get();
		if (User == null)
			throw new RuntimeException("User introuvable");
		return User;
	}

	@Override
	public User addUser(User e) {
		return UserRepository.save(e);
	}

	@Override
	public User updateUser(Long id,User e) {
		e.setId(id);
		return UserRepository.save(e);
	}

	@Override
	public void deleteUser(Long id) {
		UserRepository.deleteById(id);
	}
	
}
