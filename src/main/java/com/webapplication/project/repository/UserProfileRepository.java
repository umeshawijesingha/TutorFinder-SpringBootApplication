package com.webapplication.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapplication.project.model.UserProfileModel;



public interface UserProfileRepository extends JpaRepository <UserProfileModel,Integer> {

}
