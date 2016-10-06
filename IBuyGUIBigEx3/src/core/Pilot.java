/**
 * 
 */
package core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import utils.E_Airplanes;

/**
 * @author Basil Hawari 302373188
 * represent one of our company pilots
 */
public class Pilot extends Employee{
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pilot [" + super.toString() + ", licenses= " + this.licenses + "]";
	}
	private Set<E_Airplanes> licenses;
	private Set<Flight> flights;
	
	/**
	 * adds a new flight
	 * @param flight
	 * @return
	 */
	public boolean addFlight(Flight flight)  {
	    if ((flight == null) || (this.flights.contains(flight))) {
	        return false;
	      }
	      for (Flight f : this.flights) {
	        if ((!flight.getFlightDateAndTimeDestination().before(f.getFlightDateAndTimeSource())) && 
	          (!flight.getFlightDateAndTimeSource().after(f.getFlightDateAndTimeDestination()))) {
	          return false;
	        }
	      }
	      return this.flights.add(flight);
	    }
	
	/**
	 * this method remove flight from this FlightAttendant flights data base.
	 * @param flight
	 * @return true if the flight successfully removed, false otherwise
	 */
	  public boolean removeFlight(Flight flight)
	  {
	    if ((flight == null) || (!this.flights.contains(flight))) {
	      return false;
	    }
	    return this.flights.remove(flight);
	  }
	/**
	 * This method add a new license to this pilot flights data base.
	 * @return true if the flight successfully added, false otherwise
	 */
	  public boolean addLicense(E_Airplanes license)
	  {
	    if ((license == null) || (this.licenses.contains(license))) {
	      return false;
	    }
	    return this.licenses.add(license);
	  }
	
	
	/**
	 * @return the flights
	 */
	public Set<Flight> getFlights() {
		final Set<Flight> flights2 = this.flights;
		return ((Set<Flight>) Collections.unmodifiableCollection(flights2));
	}
	/**
	 * @param flights the flights to set
	 */
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	/**
	 * @return the licenses
	 */
	public Set<E_Airplanes> getLicenses() {
		final Set<E_Airplanes> license2 = this.licenses;
		return ((Set<E_Airplanes>)Collections.unmodifiableSet(license2));
	}
	/**
	 * @param licenses the licenses to set
	 */
	public void setLicenses(Set<E_Airplanes> licenses) {
		this.licenses = licenses;
	}
	/**
	 * Partial Constructor ~ use for initial key fields
	 * @param employeeNumber
	 */
	public Pilot(){
		flights=new HashSet<Flight>();
		licenses=new HashSet<E_Airplanes>();
	}
	/**
	 * @param employeeNumber
	 */
	public Pilot(int employeeNumber){
		super(employeeNumber);
		flights=new HashSet<Flight>();
		licenses=new HashSet<E_Airplanes>();	
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
	public Pilot(int employeeNumber, java.lang.String firstName, java.lang.String lastName, java.util.Date birthDate, java.util.Date startWorkingDate, java.lang.String password, Address address)
	{
		super(employeeNumber,firstName,lastName,birthDate,startWorkingDate, password,address);
		flights=new HashSet<Flight>();
		licenses=new HashSet<E_Airplanes>();	
	}
	
	

}
