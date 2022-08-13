package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.Job;
import com.crud.h2.dao.IWorkerDAO;
import com.crud.h2.dto.Worker;


@Service
public class WorkerServiceImpl implements IWorkerService{

	//We use the methods of the IClienteDAO interface, it is as if we were instantiating.
	@Autowired
	IWorkerDAO iworkerDAO;
	
	@Override
	public List<Worker> listWorkers() {
		
		return iworkerDAO.findAll();
	}

	@Override
	public Worker saveWorker(Worker worker) {
		
		return iworkerDAO.save(worker);
	}

	@Override
	public Worker workerXID(Long id) {
		
		return iworkerDAO.findById(id).get();

	}

	@Override
	public Worker updateWorker(Worker worker) {
		
		return iworkerDAO.save(worker);

	}

	@Override
	public void deleteWorker(Long id) {
		
		iworkerDAO.deleteById(id);
		
	}

	@Override
	public List<Worker> listWorkersByJob(Job job) {
		return iworkerDAO.findByJob(job);		
	}
	
	
}
