package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.Job;
import com.crud.h2.dto.Worker;
import com.crud.h2.service.WorkerServiceImpl;

@RestController
@RequestMapping("/api")
public class WorkerController {
	
	@Autowired
	WorkerServiceImpl workerServideImpl;
	
	@GetMapping("/trabajadores")
	public List<Worker> listAllWorkers(){
		return workerServideImpl.listWorkers();
	}
	
	//List workers by Job
	@GetMapping("/trabajadores/job/{job}")
	public List<Worker> listWorkersByJob(@PathVariable(name="job") Job job) {
	    return workerServideImpl.listWorkersByJob(job);
	}
	
	
	@PostMapping("/trabajadores")
	public Worker saveWorker(@RequestBody Worker worker) {
		
		return workerServideImpl.saveWorker(worker);
	}
	
	
	@GetMapping("/trabajadores/{id}")
	public Worker workerXID(@PathVariable(name="id") Long id) {
		
		Worker worker_xid= new Worker();
		
		worker_xid= workerServideImpl.workerXID(id);
		
		System.out.println("Worker XID: "+worker_xid);
		
		return worker_xid;
	}
	
	@PutMapping("/trabajadores/{id}")
	public Worker updateWorker(@PathVariable(name="id")Long id,@RequestBody Worker worker) {
		
		Worker selectedWorker= new Worker();
		Worker updatedWorker= new Worker();
		
		selectedWorker= workerServideImpl.workerXID(id);
		
		selectedWorker.setName(worker.getName());
		selectedWorker.setJob(worker.getJob());
		selectedWorker.setSalary(worker.getSalary());
		
		updatedWorker = workerServideImpl.updateWorker(selectedWorker);
		
		System.out.println("El cliente actualizado es: "+ updatedWorker);
		
		return updatedWorker;
	}
	
	@DeleteMapping("/trabajadores/{id}")
	public void deleteWorker(@PathVariable(name="id")Long id) {
		workerServideImpl.deleteWorker(id);
	}

}
