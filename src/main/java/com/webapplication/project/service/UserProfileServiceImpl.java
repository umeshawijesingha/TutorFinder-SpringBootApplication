package com.webapplication.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapplication.project.model.UserProfileModel;
import com.webapplication.project.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public String saveProfile(UserProfileModel userProfiledata) {
		userProfileRepository.save(userProfiledata);
		return "Data saved";
	}

}
