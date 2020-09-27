package com.TECHSUB.Metier.Interface;
 
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.TECHSUB.Models.User;

public interface IGestionUser {
	public Optional<User> getUserbyUsername(String username);
	public List<User> getAllUsers();
	public Page<User> getPageUsers( int page ,int size);
	public User getUser(Long id);
	public User addUser(User e);
	public User updateUser(Long id,User e);
	public void deleteUser(Long id);

}
