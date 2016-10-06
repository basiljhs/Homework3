/**
 * 
 */
package core;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 * @author Basil Hawari 302373188
 * represent one of our company FlightAttendants
 */
public class FlightAttendant extends Employee{
	Double rank;
	Set<Flight> flights;
	
	/**
	 * This method add a new flight to this pilot flights data base.
	 * @param flight
	 * @return true if the flight successfully added, false otherwise
	 */
	public boolean addFlight(Flight flight)
	  {
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
	public boolean removeFlight(Flight flight){
		return flights.remove(flight);
	}

		

	/**
	 * @return the rank
	 */
	public Double getRank() {
		return rank;
	}

	/**
	 * @return the flights
	 */
	public Set<Flight> getFlights() {
		final Set<Flight> flights2 = this.flights;
		return ((Set<Flight>)Collections.unmodifiableSet(flights2));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlightAttendant [" + super.toString() + ", " + "Rank=" + this.rank + "]";
		}

	/**
	 * @param flights the flights to set
	 */
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Double rank) {
		this.rank = rank;
	}

	/**
	 * Partial Constructor ~ use for initial key fields
	 * @param employeeNumber
	 */
	public FlightAttendant (int employeeNumber){
		super(employeeNumber);
		flights=new HashSet<Flight>();
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
	 * @param rank
	 */
	public FlightAttendant (int employeeNumber,String firstName, String lastName, Date birthDate, Date startWorkingDate, String password, Address address, Double rank){
		super(employeeNumber,firstName,lastName,birthDate,startWorkingDate,password,address);
		this.rank=rank;
		flights=new HashSet<Flight>();
	}
	/**
	 * This method add a new license to this pilot flights data base.
	 * @param license
	 * @return
	 */
	
	

}
