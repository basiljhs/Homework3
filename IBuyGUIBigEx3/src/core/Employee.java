package core;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Basil Hawari 302373188
 *
 */
public class Employee {
	int employeeNumber;
	String firstName;
	String lastName;
	Date birthDate;
	Date startWorkingDate;
	String password;
	Address address;
	
	/**
	 * empty constuctor
	 */
	public Employee(){}
	/**
	 * Partial Constructor ~ use for initial key fields
	 * @param employeeNumber
	 */
	public Employee(int employeeNumber){
		this.employeeNumber=employeeNumber;
	}
	
	/**
	 * Full Constructor ~ use for initial all fields
	 * @param employeeNumber
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param startWorkingDate
	 * @param password
	 * @param address
	 */
	public Employee(int employeeNumber, java.lang.String firstName, java.lang.String lastName, java.util.Date birthDate, java.util.Date startWorkingDate, java.lang.String password, Address address){
		this(employeeNumber);
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthDate=birthDate;
		this.startWorkingDate=startWorkingDate;
		this.password=password;
		this.address=address;
	}

	/**
	 * @return the employeeNumber
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the startWorkingDate
	 */
	public Date getStartWorkingDate() {
		return startWorkingDate;
	}

	/**
	 * @param startWorkingDate the startWorkingDate to set
	 */
	public void setStartWorkingDate(Date startWorkingDate) {
		this.startWorkingDate = startWorkingDate;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * This method calculate this employee seniority (in years).
	 * @return seniority (in years)
	 */
	public int getEmployeeSeniority(){
		Calendar currentCal=Calendar.getInstance();
		currentCal.setTime(this.startWorkingDate);
		return Calendar.getInstance().get(Calendar.YEAR)-currentCal.get(Calendar.YEAR);
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeNumber;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (employeeNumber != other.employeeNumber)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return 
			    
			      "employeeNumber=" + this.employeeNumber + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthDate=" + this.birthDate + ", startWorkingDate=" + this.startWorkingDate;
		}
	
}
