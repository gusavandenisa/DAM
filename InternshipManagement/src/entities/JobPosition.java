package entities;
import java.io.Serializable;
import javax.persistence.Entity;

import entities.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

@Entity
public class JobPosition implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	private int codPosition;
	private char namePosition;

	public JobPosition(){
		super();
	}

	public JobPosition(int codPosition, char namePosition) {
		super();
		this.codPosition = codPosition;
		this.namePosition = namePosition;
	}


	public void finalize() throws Throwable {

	}

	public int getCodPosition() {
		return codPosition;
	}

	public void setCodPosition(int codPosition) {
		this.codPosition = codPosition;
	}

	public char getNamePosition() {
		return namePosition;
	}

	public void setNamePosition(char namePosition) {
		this.namePosition = namePosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codPosition;
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
		JobPosition other = (JobPosition) obj;
		if (codPosition != other.codPosition)
			return false;
		return true;
	}

	

}