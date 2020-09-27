package com.TECHSUB.Controllers;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TECHSUB.Metier.Interface.IGestionRegion;
import com.TECHSUB.Metier.Interface.IGestionUser;
import com.TECHSUB.Models.Region;
import com.TECHSUB.Models.User;
import com.TECHSUB.Repository.IRegionRepository;
import com.TECHSUB.Repository.UserRepository;
import com.TECHSUB.Models.User;



@RestController
@CrossOrigin(origins = "http://localhost:4200" )
public class UserRestService {
	
	@Autowired
	private IGestionUser gestionUser;
	@Autowired
	private UserRepository userRe;
	
	@GetMapping(value = "/User/search/byNom") 

	 public Page<User> findByName( @RequestParam("nom") String nom,@RequestParam("page") int page,@RequestParam("size") int size) {

if (nom == null) {
return gestionUser.getPageUsers(page, size);
} else {
return userRe.findByNameContaining(nom, PageRequest.of(page, size));
}
}
	
	public String index() {
		return "users";
	}
	@GetMapping(value = "/user/{username}")
	public Optional<User> thisUser(@PathVariable(name = "username") String username) {
		return gestionUser.getUserbyUsername(username);
	}
	@GetMapping(value = "/Users")
	public List<User> listUsers() {
		return gestionUser.getAllUsers();
	}
	
	@GetMapping(value = "/Users/{page}/{size}") 
	public Page<User> listUsersPage(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size) {
		return gestionUser.getPageUsers(page,size);
	}

	@GetMapping(value = "/User/{id}")
	public User User(@PathVariable(name = "id") Long id) {
		return gestionUser.getUser(id);
	}

	@PostMapping(value = "/User")
	public User save(@RequestBody User User) {
		return gestionUser.addUser(User);
	}

	@PutMapping(value = "/User/{id}")
	public User update(@PathVariable(name = "id") Long id, @RequestBody User User) {
		return gestionUser.updateUser(id, User);
	}

	@DeleteMapping(value = "/User/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		gestionUser.deleteUser(id);
	}
}
