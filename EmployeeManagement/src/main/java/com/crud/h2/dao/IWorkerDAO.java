package com.crud.h2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.h2.Job;
import com.crud.h2.dto.Worker;



public interface IWorkerDAO  extends JpaRepository <Worker, Long>{
	
	//List the workers by job
	public List<Worker> findByJob(Job job); //After findBy an attribute of the class worker have to be in order to work properly (Shoudn't be like this)

}
