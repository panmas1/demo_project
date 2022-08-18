package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.servicelayer.Servicelayer;

@RestController
@RequestMapping("/api")
public class UserController
{

	@Autowired
	private Servicelayer Servicelayer;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User u)
	{
		
		  User user =Servicelayer.addUser(u);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
		
		
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User u) {
		Optional<User> user = Servicelayer.singleUser(id);
              if (user.isPresent()) 
              {
			User _user = user.get();
			_user.setUserId(u.getUserId());
			_user.setFirstName(u.getFirstName());
			_user.setEmail(u.getEmail());
			_user.setLastName(u.getLastName());
			return new ResponseEntity<>(Servicelayer.addUser(_user), HttpStatus.OK);
		} 
		else
		{
			throw new UserNotFoundException("user not found exception");
		}
	}
	
	@GetMapping(value = "/alldata")
	public List<User> retrieveAll()
	{
		List<User>user=Servicelayer.retieveAll();
		return user;
		
	}
	@GetMapping(value = "/single_User/{id}")
	public Optional<User> singleUser(@PathVariable long id)
	{
	    Optional<User> u=Servicelayer.singleUser(id);
	    if(u.isPresent())
	        return u;
	    else
	      throw new UserNotFoundException("user not found with this id" +id);
	    
	    
	}

	@DeleteMapping("/users_del/{id}")
	public ResponseEntity<String> deleteSingleData(@PathVariable long id)
	{
	    Optional<User> u=Servicelayer.singleUser(id);
	     if(u.isPresent()) {
	           
	        Servicelayer.delete(id);
	        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	    }
       
         else
         throw  new UserNotFoundException("Please enter exist id");
   
    
       
	}
	
}
