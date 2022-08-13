package com.crud.h2.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.crud.h2.Job;


@Entity
@Table(name="workers") //I set the table name manually because spring does not convert it to plural automatically
public class Worker {

	/**Attributes */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Find last value and increment from final id of db
	private Long id;

	private String name;
	
	private String job;
	
	private Double salary;

	/**Constructors */
	public Worker() {

	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param job
	 */
	public Worker(Long id, String name, String job) {
		this.id = id;
		this.name = name;
		this.job = job;
		
		this.salary = 22000.0; //Remove <--  does not affect nothing
		
		if(job.equals(Job.programmer.toString())) {
			this.salary = 44000.0;
		}
		else if(job.equals(Job.dataTester.toString())) {
			this.salary = 30000.0;
		
		}else if(job.equals(Job.assistant.toString())) {
			this.salary = 25000.0;			
		}
		
		
	}



	/**Getters y Setters*/


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}



	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}


	//Method printing data by console
	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + name + ", trabajo=" + job + ", salario=" + salary;
	}


}
