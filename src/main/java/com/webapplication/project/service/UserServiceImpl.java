package com.webapplication.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapplication.project.model.UserModel;
import com.webapplication.project.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserModel> findAllUsers() {
		
		List<UserModel> allusers = userRepository.findAll();
		return allusers;
	}

	@Override
	public String saveUser(UserModel userdata) {
		userRepository.save(userdata);
		return "Data saved";
	}

	@Override
	public String updateUser(UserModel newUser) {
		String msg="null";
		if(newUser.getId() != null) {
			userRepository.save(newUser);
			msg="Data Updated";
		}else {
			msg = "Error";
		}
		return msg;
	}

	
	@Override
	public UserModel getUserById(int id) {
		
		Optional < UserModel > optional = userRepository.findById(id);
		UserModel user = null;
	    if (optional.isPresent()) {
	        user = optional.get();
	    } else {
	        throw new RuntimeException(" Employee not found for id :: " + id);
	    }
	    return user;
	}

	
	
	
	
	
	@Override
	public String deleteUser(Integer id) {
		 userRepository.deleteById(id);
		 return "User deleted";
		
	}

	
	

}
