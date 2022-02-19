package com.webapplication.project.service;

import java.util.List;
import java.util.Optional;

import com.webapplication.project.model.UserModel;



public interface UserService {

	List<UserModel> findAllUsers();

	String saveUser(UserModel userdata);

	String updateUser(UserModel newUser);

	UserModel getUserById(int id);

	String deleteUser(Integer id);

}
