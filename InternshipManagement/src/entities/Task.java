package entities;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;

import entities.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.Enumerated;

@Entity
public class Task implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int codTask;
	private char nameTask;
	private char detailsTask;
	
	@Enumerated(EnumType.STRING)
	private StatusTask statusTask;
	private int estimatedTime;
	private int loggedTime;
	private int remainingTime;
	
	@ManyToMany
	@JoinTable(name="TaskInternship", joinColumns = { @JoinColumn(name = "codTask") }, 
            inverseJoinColumns = { @JoinColumn(name = "codInternship") })
	private Set<Internship> internships = new HashSet<Internship>();

	public Task() {
		super();
	}

	public Task(int codTask, char nameTask, char detailsTask, StatusTask statusTask, int estimatedTime, int loggedTime) {
		super();
		this.codTask = codTask;
		this.nameTask = nameTask;
		this.detailsTask = detailsTask;
		this.statusTask = statusTask;
		this.estimatedTime = estimatedTime;
		this.loggedTime = loggedTime;
		
	}

	public Task(int codTask, char nameTask, char detailsTask, StatusTask statusTask, int estimatedTime, int loggedTime,
			Set<Internship> internships ) {
		super();
		this.codTask = codTask;
		this.nameTask = nameTask;
		this.detailsTask = detailsTask;
		this.statusTask = statusTask;
		this.estimatedTime = estimatedTime;
		this.loggedTime = loggedTime;
		this.internships = internships;
	}

	public void finalize() throws Throwable {

	}

	public int getCodTask() {
		return codTask;
	}

	public void setCodTask(int codTask) {
		this.codTask = codTask;
	}

	public char getNameTask() {
		return nameTask;
	}

	public void setNameTask(char nameTask) {
		this.nameTask = nameTask;
	}

	public char getDetailsTask() {
		return detailsTask;
	}

	public void setDetailsTask(char detailsTask) {
		this.detailsTask = detailsTask;
	}

	public StatusTask getStatusTask() {
		return statusTask;
	}

	public void setStatusTask(StatusTask statusTask) {
		this.statusTask = statusTask;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public int getLoggedTime() {
		return loggedTime;
	}

	public void setLoggedTime(int loggedTime) {
		this.loggedTime = loggedTime;
	}

	

	/**
	 * 
	 * @param task
	 */
	public int estimateRemainingTime(Task task) {
		remainingTime = task.estimatedTime - task.loggedTime;
		if(remainingTime<=0) System.out.println("Timpul pentru task-ul " + task.codTask + "s-a terminat!");
			return remainingTime; 
		
	}

	/**
	 * 
	 * @param task
	 */
	public void asignTask(Task task) {

	}


	/**
	 * 
	 * @param task
	 */
	public void modifyTask(Task task) {

	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codTask;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (codTask != other.codTask)
			return false;
		return true;
	}

	public void setInternship(Internship internship) {
		this.internships = internships;
		
	}
	
	

}