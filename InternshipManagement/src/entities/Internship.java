package entities;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import entities.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import static javax.persistence.TemporalType.DATE;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;


@Entity
public class Internship implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private int codInternship;
	private char nameInternship;
	
	@Column(name = "START_DATE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "END_DATE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date endDate;
	
	private char detailsInternship;
	
	@Enumerated(STRING)
	private StatusInternship statusInternship;
	
	@ManyToMany
	@JoinTable(name="TaskInternship", joinColumns = { @JoinColumn(name = "codInternship") }, 
            inverseJoinColumns = { @JoinColumn(name = "codTask") })
	private Set<Task> tasks = new HashSet<Task>();
	
	public void addTaskToInternship(int codTask, char nameTask, char detailsTask, StatusTask statusTask, int estimatedTime, int loggedTime) {
		 Task task = new Task(   codTask, nameTask,  detailsTask, statusTask, estimatedTime, loggedTime);
			this.tasks.add(task);
			task.setInternship(this);
		}
	 
		public void removeTaskFromInternship(Task task) {
			this.tasks.remove(task);
			task.setInternship(null);
		}
		 public List<Task> getInternshipTasks() {
				return Collections.unmodifiableList(new LinkedList(tasks));
			}
	
	@OneToMany
	private Set<Team> teams = new HashSet<Team>();
	
	 public void addTeamToInternship( int codTeam, char nameTeam, Set<Intern> interns, Set<Employee> employees, Internship internship) {
		 Team team = new Team(codTeam, nameTeam, interns, employees, internship);
			this.teams.add(team);
			team.setInternship(this);
		}
	 
		public void removeTeamFromInternship(Team team) {
			this.teams.remove(team);
			team.setInternship(null);
		}
		 public List<Team> getTeamsInternship() {
				return Collections.unmodifiableList(new LinkedList(teams));
			}


	public Internship(){
		super();
	}


	public Internship(int codInternship, char nameInternship, Date startDate, Date endDate, char detailsInternship,
			StatusInternship statusInternship, Set<Task> tasks, Set<Team> teams) {
		super();
		this.codInternship = codInternship;
		this.nameInternship = nameInternship;
		this.startDate = startDate;
		this.endDate = endDate;
		this.detailsInternship = detailsInternship;
		this.statusInternship = statusInternship;
		this.tasks = tasks;
		this.teams = teams;
	}

	public void finalize() throws Throwable {

	}

	
	public int getCodInternship() {
		return codInternship;
	}

	public void setCodInternship(int codInternship) {
		this.codInternship = codInternship;
	}

	public char getNameInternship() {
		return nameInternship;
	}

	public void setNameInternship(char nameInternship) {
		this.nameInternship = nameInternship;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public char getDetailsInternship() {
		return detailsInternship;
	}

	public void setDetailsInternship(char detailsInternship) {
		this.detailsInternship = detailsInternship;
	}

	public StatusInternship getStatusInternship() {
		return statusInternship;
	}

	public void setStatusInternship(StatusInternship statusInternship) {
		this.statusInternship = statusInternship;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}


	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	
	/**
	 * 
	 * @param status
	 */
	public void changeStatusInternship(StatusInternship status){
		
		

	}

	/**
	 * 
	 * @param internship
	 */
	public void deleteInternship(Internship internship){

	}

	/**
	 * 
	 * @param internship
	 */
	public void updateInternship(Internship internship){

	}

	/**
	 * 
	 * @param task
	 */
	public char showsTask(Task task){
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codInternship;
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
		Internship other = (Internship) obj;
		if (codInternship != other.codInternship)
			return false;
		return true;
	}

	
}