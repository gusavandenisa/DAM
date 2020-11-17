package entities;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import entities.*;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import javax.persistence.ManyToMany;


@Entity
public class Employee extends Person implements Serializable {

	
	@ManyToOne
	private JobPosition jobPosition;
	
	@ManyToMany
	@JoinTable(name="TeamEmployee", joinColumns = { @JoinColumn(name = "codEmployee") }, 
            inverseJoinColumns = { @JoinColumn(name = "codTeam") })
	private Set<Team> teams = new HashSet<Team>();
	
	private char jobTitle;
	
	@Column(name = "HIRE_DATE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date hireDate;
	
	public Employee(){
		super();
	}

	public Employee(int codPerson, char firstname, char lastname, char department){
		super(codPerson, firstname, lastname, department);
	}

	public Employee(int codPerson, char firstname, char lastname, char department, JobPosition jobPosition, Set<Team> teams, char jobTitle, Date hireDate) {
		super(codPerson, firstname, lastname, department);
		this.jobPosition = jobPosition;
		this.teams = teams;
		this.jobTitle = jobTitle;
		this.hireDate = hireDate;
	}

	public Employee(JobPosition jobPosition, Set<Team> teams, char jobTitle, Date hireDate) {
		super();
		this.jobPosition = jobPosition;
		this.teams = teams;
		this.jobTitle = jobTitle;
		this.hireDate = hireDate;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public JobPosition getPosition() {
		return jobPosition;
	}

	public void setPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}



	public void setJobTitle(char jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public void setTeam(Team team) {
		this.teams =teams;
		
	}
	




	

}