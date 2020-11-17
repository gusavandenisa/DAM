package entities;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import entities.*;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

@Entity 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int codPerson;
	private char firstname;
	private char lastname;
	private char department;
	
	@ManyToMany
	@JoinTable(name="TeamEmployee", joinColumns = { @JoinColumn(name = "codPerson") }, 
            inverseJoinColumns = { @JoinColumn(name = "codBenefit") })
	private Set<Benefit> benefits = new HashSet<Benefit>();

	public Person(){
		super();
	}
	
	 public void addBenefitToPerson( int codBenefit, char detailsBenefit, char typeBenefit, char nameBenefit) {
		 Benefit  benefit = new Benefit(   codBenefit, detailsBenefit, typeBenefit, nameBenefit );
			this.benefits.add(benefit);
			benefit.setPerson(this);
		}
	 
		public void remove(Benefit benefit) {
			this.benefits.remove(benefit);
			benefit.setPerson(null);
		}
		 public List<Benefit> getBenefitsPerson() {
				return Collections.unmodifiableList(new LinkedList(benefits ));
			}
	
	public Person(int codPerson, char firstname, char lastname, char department) {

		this.codPerson = codPerson;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
	}

	public void finalize() throws Throwable {

	}

	public int getCodPerson() {
		return codPerson;
	}

	public void setCodPerson(int codPerson) {
		this.codPerson = codPerson;
	}

	public char getFirstname() {
		return firstname;
	}

	public void setFirstname(char firstname) {
		this.firstname = firstname;
	}

	public char getLastname() {
		return lastname;
	}

	public void setLastname(char lastname) {
		this.lastname = lastname;
	}

	public char getDepartment() {
		return department;
	}

	public void setDepartment(char department) {
		this.department = department;
	}

	public Set<Benefit> getBenefits() {
		return benefits;
	}

	public void setBenefits(Set<Benefit> benefits) {
		this.benefits = benefits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codPerson;
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
		Person other = (Person) obj;
		if (codPerson != other.codPerson)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [codPerson=" + codPerson + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", department=" + department + ", benefits=" + benefits + "]";
	}

	public boolean isEmpty() {
		return false;
	}	

}