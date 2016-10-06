/**
 * 
 */
package core;

import utils.E_Airports;

/**
 * @author Basil Hawari 302373188
 * Class Connection ~ represent the stops of a single flight from the beginning of the flight till the land
 */
public class Connection {
	private int stepNumber;
	/**
	 * @return the stepNumber
	 */
	public int getStepNumber() {
		return stepNumber;
	}

	/**
	 * @param stepNumber the stepNumber to set
	 */
	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * @return the airport
	 */
	public E_Airports getAirport() {
		return airport;
	}

	/**
	 * @param airport the airport to set
	 */
	public void setAirport(E_Airports airport) {
		this.airport = airport;
	}

	Flight flight;
	E_Airports airport;
	/**
	 * empty constructor
	 */
	public Connection(){}

	/**
	 * Partial Constructor ~ use for initial key fields
	 * @param stepNumber
	 */
	public Connection(int stepNumber) {
		this.stepNumber=stepNumber;
	}
	
	/**
	 * Full Constructor ~ use for initial all fields
	 * @param stepNumber
	 * @param flight
	 * @param airport
	 */
	public Connection(int stepNumber,Flight flight,E_Airports airport) {
		this(stepNumber);
		this.airport=airport;
		this.flight=flight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StepIn [airport: " + airport + " "+airport.getCity()+", "+airport.getCountry()+"]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airport == null) ? 0 : airport.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + stepNumber;
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
		if (!(obj instanceof Connection))
			return false;
		Connection other = (Connection) obj;
		if (airport != other.airport)
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (stepNumber != other.stepNumber)
			return false;
		return true;
	}
	
	

}
