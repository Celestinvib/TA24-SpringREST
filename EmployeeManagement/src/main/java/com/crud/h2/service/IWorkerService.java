package com.crud.h2.service;

import java.util.List;

import com.crud.h2.Job;
import com.crud.h2.dto.Worker;


public interface IWorkerService {
		//CRUD methods
		public List<Worker> listWorkers(); //List All 
		
		public Worker saveWorker(Worker worker);	//Save a new Worker "CREATE"
		
		public Worker workerXID(Long id); //Read data from a worker "READ"
				
		public Worker updateWorker(Worker worker); //Update client data "UPDATE"
		
		public void deleteWorker(Long id);// Delete a worker via id "DELETE"
		
     	public List<Worker> listWorkersByJob (Job job);//list workers by job

}
