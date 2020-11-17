package entities;
import java.io.Serializable;
import javax.persistence.Entity;

import entities.*;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;


@Entity
public class Intern extends Person implements Serializable {
	
	private char studiesIntern;
	
	@ManyToOne
	private Team team;

	public Intern(){
		super();
	}
	

	public Intern( int codPerson, char firstname, char lastname, char department) {
		super(codPerson, firstname, lastname, department);
	}

	public Intern(int codPerson, char firstname, char lastname, char department,char studiesIntern, Team team) {
		super(codPerson, firstname, lastname, department);
		this.studiesIntern = studiesIntern;
		this.team = team;
	}

	public Intern(char studiesIntern, Team team) {
		super();
		this.studiesIntern = studiesIntern;
		this.team = team;
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

	public char getStudiesIntern() {
		return studiesIntern;
	}

	public void setStudiesIntern(char studiesIntern) {
		this.studiesIntern = studiesIntern;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}


}