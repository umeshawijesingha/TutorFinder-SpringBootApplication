package com.webapplication.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapplication.project.model.SubjectModel;


@Repository
public interface SubjectRepository extends JpaRepository <SubjectModel,Integer> {

	//getAllSubjects
	
}