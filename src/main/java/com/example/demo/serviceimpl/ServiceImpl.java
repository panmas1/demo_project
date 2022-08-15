package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.servicelayer.Servicelayer;

@Service
public class ServiceImpl implements Servicelayer{

	@Autowired UserRepository userrepository;
	
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userrepository.save(u);
	}

	@Override
	public List<User> retieveAll() {
 List<User>user=userrepository.findAll();
         return user;
	}

	@Override
	public void delete(long id) {
	    userrepository.deleteById(id);
		
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return userrepository.save(u);
	}

	@Override
	public Optional<User> singleUser(long id) {
		// TODO Auto-generated method stub
		return userrepository.findById(id);
	}

}
