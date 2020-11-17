package entities;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import entities.*;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Team implements Serializable{

	@Id
	@GeneratedValue(strategy = AUTO)
	private int codTeam;
	private char nameTeam;
	
	@OneToMany
	private Set<Intern> interns = new HashSet<Intern >();
	
	 public void addInternToTheTeam( char studiesIntern, Team team) {
		 Intern intern = new Intern(studiesIntern, team);
			this.interns.add(intern);
			intern.setTeam(this);
		}
	 
		public void removeInternFromTeam(Intern intern) {
			this.interns.remove(intern);
			intern.setTeam(null);
		}
		 public List<Team> getTeamInterns() {
				return Collections.unmodifiableList(new LinkedList(interns));
			}	

	@ManyToMany
	@JoinTable(name="TeamEmployee", joinColumns = { @JoinColumn(name = "fk_team") }, 
            inverseJoinColumns = { @JoinColumn(name = "fk_employee") })
	private Set<Employee> employees = new HashSet<Employee>();
	
	@ManyToOne
	private Internship internship;

	public Team() {
		super();
	}

	public void addEmployeeToTeam(JobPosition jobPosition, Set<Team> teams, char jobTitle, Date hireDate) {
		 Employee employee = new Employee(jobPosition,  teams, jobTitle, hireDate);
			this.employees.add(employee);
			employee.setTeam(this);
		}
	 
		public void removeEmployeeFromTeam(Employee employee) {
			this.employees.remove(employee);
			employee.setTeam(null);
		}
		 public List<Employee> getTeamEmployees() {
				return Collections.unmodifiableList(new LinkedList(employees));
			}
	

	public Team(int codTeam, char nameTeam, Set<Intern> interns, Set<Employee> employees, Internship internship) {
			super();
			this.codTeam = codTeam;
			this.nameTeam = nameTeam;
			this.interns = interns;
			this.employees = employees;
			this.internship = internship;
		}

	public void finalize() throws Throwable {

	}

	public int getCodTeam() {
		return codTeam;
	}

	public void setCodTeam(int codTeam) {
		this.codTeam = codTeam;
	}

	public char getNameTeam() {
		return nameTeam;
	}

	public void setNameTeam(char nameTeam) {
		this.nameTeam = nameTeam;
	}


	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codTeam;
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
		Team other = (Team) obj;
		if (codTeam != other.codTeam)
			return false;
		return true;
	}
	
	

}