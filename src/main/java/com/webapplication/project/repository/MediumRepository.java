package com.webapplication.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapplication.project.model.MediumModel;


@Repository

public interface MediumRepository extends JpaRepository <MediumModel,Integer> {

}
