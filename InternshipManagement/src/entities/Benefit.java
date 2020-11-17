package entities;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import entities.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Benefit implements Serializable {
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private int codBenefit;
	private char detailsBenefit;
	private char typeBenefit;
	private char nameBenefit;
	
	@ManyToMany
	@JoinTable(name="BenefitPerson", joinColumns = { @JoinColumn(name = "codBenefit") }, 
            inverseJoinColumns = { @JoinColumn(name = "codPerson") })
	private Set<Person> persons = new HashSet<Person>();
	

	public Benefit(){
		super();
	}

	public Benefit(int codBenefit, char detailsBenefit, char typeBenefit, char nameBenefit) {
		super();
		this.codBenefit = codBenefit;
		this.detailsBenefit = detailsBenefit;
		this.typeBenefit = typeBenefit;
		this.nameBenefit = nameBenefit;
		
	}



	public void finalize() throws Throwable {

	}

	public int getCodBenefit() {
		return codBenefit;
	}

	public void setCodBenefit(int codBenefit) {
		this.codBenefit = codBenefit;
	}

	public char getDetailsBenefit() {
		return detailsBenefit;
	}

	public void setDetailsBenefit(char detailsBenefit) {
		this.detailsBenefit = detailsBenefit;
	}

	public char getTypeBenefit() {
		return typeBenefit;
	}

	public void setTypeBenefit(char typeBenefit) {
		this.typeBenefit = typeBenefit;
	}

	public char getNameBenefit() {
		return nameBenefit;
	}

	public void setNameBenefit(char nameBenefit) {
		this.nameBenefit = nameBenefit;
	}
	
	public void setPerson(Person person) {
		this.persons=persons;
		
	}
	
	/**
	 * 
	 * @param benefit
	 */
	
	// calculam numarul de task-uri, iar in functie de acesta se calculeaza procentul pentru beneficii?
	public double calculateBenefit(Benefit benefit, Task task){
			
		
		
		return 0;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codBenefit;
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
		Benefit other = (Benefit) obj;
		if (codBenefit != other.codBenefit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Benefit [codBenefit=" + codBenefit + ", detailsBenefit=" + detailsBenefit + ", typeBenefit="
				+ typeBenefit + ", nameBenefit=" + nameBenefit + ", persons=" + persons + "]";
	}

	




	
	

	
}