package com.webapplication.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapplication.project.model.SubjectModel;

import com.webapplication.project.repository.SubjectRepository;


@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<SubjectModel> findAllSubject() {

		List<SubjectModel> allsubject = subjectRepository.findAll();
		return allsubject;
	}

}
