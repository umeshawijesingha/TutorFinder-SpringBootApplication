package com.webapplication.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapplication.project.model.MediumModel;
import com.webapplication.project.repository.MediumRepository;



@Service
public class MediumServiceImpl implements MediumService{

	@Autowired
	private MediumRepository mediumRepository;
	
	@Override
	public List<MediumModel> findAllMediums() {
		
		List<MediumModel> allMediums = mediumRepository.findAll();
		return allMediums;
	}
}
