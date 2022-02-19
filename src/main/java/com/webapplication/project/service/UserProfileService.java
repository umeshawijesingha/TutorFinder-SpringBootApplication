package com.webapplication.project.service;

import org.springframework.stereotype.Service;

import com.webapplication.project.model.UserProfileModel;


public interface UserProfileService {

	String saveProfile(UserProfileModel userdata);
}
