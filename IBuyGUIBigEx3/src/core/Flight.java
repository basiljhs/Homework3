package core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import utils.E_Airplanes;
import utils.E_Airports;

/**
 * Class Flight ~ represent a single flight in the system
 * @author Java Course Team 2016
 * @author University Of Haifa
 */
public class Flight{
	
	//-------------------------------Class Members------------------------------
	/**
	 * The flight number - the key
	 */
	private int flightNumber;
	/**
	 * The time when the flight departure from the source
	 */
	private Date flightDateAndTimeSource;
	/**
	 * The time when the flight land in the destination
	 */
	private Date flightDateAndTimeDestination;
	/**
	 * The cost for this flight
	 */
	private double flightCost;
	/**
	 * The flight source airport
	 */
	private E_Airports source;
	/**
	 * The flight destination airport
	 */
	private E_Airports destination;
	/**
	 * collection of all stop in this Flight
	 */
	private Set<Connection> stops;
	/**
	 * collection of all parcels in this flight 
	 */
	private E_Airplanes airplane;
	private Set<Parcel> parcels;
	private Set<FlightAttendant> flightAttendants;
	private ArrayList<Pilot> pilots;
	
	/**
	 * * This method add a new flight attendant
	 * @param pilot
	 * @return
	 */
	  public boolean addFlightAttendant(FlightAttendant flightAttendant)
	  {
	    if ((flightAttendant != null) && (!this.flightAttendants.contains(flightAttendant))) {
	      return this.flightAttendants.add(flightAttendant);
	    }
	    return false;
	  }
	
	
	
	/**
	 * * This method add a new pilot
	 * @param pilot
	 * @return
	 */
	  public boolean addPilot(Pilot pilot)
	  {
	    if ((pilot != null) && (!this.pilots.contains(pilot)) && 
	      (pilot.getLicenses().contains(this.airplane))) {
	      return this.pilots.add(pilot);
	    }
	    return false;
	  }
	  
	  
	
	/**
	 * * This method remove a given pilot from this flight.
	 * @param pilot
	 * @return
	 */
	public boolean removePilot(Pilot pilot){
		return pilots.remove(pilot);
	}
	
	/**
	 * @return the flightAttendants
	 */
	public Set<FlightAttendant> getFlightAttendants() {
		return flightAttendants;
	}

	/**
	 * @return the pilots
	 */
	public ArrayList<Pilot> getPilots() {
		return pilots;
	}

	/**
	 * @param pilots the pilots to set
	 */
	public void setPilots(ArrayList<Pilot> pilots) {
		this.pilots = pilots;
	}

	/**
	 * @param flightAttendants the flightAttendants to set
	 */
	public void setFlightAttendants(Set<FlightAttendant> flightAttendants) {
		this.flightAttendants = flightAttendants;
	}

	//-------------------------------Constructors-----------------------------
	/**
	 * full constructor
	 * @param flightNumber
	 * @param flightDateAndTimeSource
	 * @param flightDateAndTimeDestination
	 * @param flightCost
	 */
	public Flight(int flightNumber, Date flightDateAndTimeSource,
			Date flightDateAndTimeDestination, E_Airports source, E_Airports destination, double flightCost,E_Airplanes airplane) {
		super();
		this.flightNumber = flightNumber;
		this.flightDateAndTimeSource = flightDateAndTimeSource;
		this.flightDateAndTimeDestination = flightDateAndTimeDestination;
		this.flightCost = flightCost;
		this.airplane=airplane;
		this.stops= new HashSet<Connection>();
		this.setFlightAttendants(new HashSet<FlightAttendant>());
		this.setPilots(new ArrayList<Pilot>());
		this.parcels = new HashSet<Parcel>();
		this.source = source;
		this.destination = destination;
	}

	/**
	 * Partial Constructor ~ use for initial key fields
	 * 
	 * @param flightNumber
	 */
	public Flight(int flightNumber) {
		super();
		this.flightNumber = flightNumber;
	}

	//-------------------------------Getters And Setters------------------------------
	/**
	 * @return the flightNumber
	 */
	public int getFlightNumber() {
		return flightNumber;
	}

	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * @return the airplane
	 */
	public E_Airplanes getAirplane() {
		return airplane;
	}

	/**
	 * @param airplane the airplane to set
	 */
	public void setAirplane(E_Airplanes airplane) {
		this.airplane = airplane;
	}

	/**
	 * @return the flightDateAndTimeSource
	 */
	public Date getFlightDateAndTimeSource() {
		return flightDateAndTimeSource;
	}

	/**
	 * @param flightDateAndTimeSource the flightDateAndTimeSource to set
	 */
	public void setFlightDateAndTimeSource(Date flightDateAndTimeSource) {
		this.flightDateAndTimeSource = flightDateAndTimeSource;
	}

	/**
	 * @return the flightDateAndTimeDestination
	 */
	public Date getFlightDateAndTimeDestination() {
		return flightDateAndTimeDestination;
	}

	/**
	 * @param flightDateAndTimeDestination the flightDateAndTimeDestination to set
	 */
	public void setFlightDateAndTimeDestination(Date flightDateAndTimeDestination) {
		this.flightDateAndTimeDestination = flightDateAndTimeDestination;
	}

	/**
	 * @return the source
	 */
	public E_Airports getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(E_Airports source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public E_Airports getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(E_Airports destination) {
		this.destination = destination;
	}

	/**
	 * @return the stops
	 */
	public Set<Connection> getConnections() {
		final Set<Connection> stops2 = this.stops;
		return Collections.unmodifiableSet(stops2);
		//return ((HashSet<Connection>)Collections.unmodifiableCollection(stops));
	}


	/**
	 * @return the flightCost
	 */
	public double getFlightCost() {
		return flightCost;
	}

	/**
	 * @param flightCost the flightCost to set
	 */
	public void setFlightCost(double flightCost) {
		this.flightCost = flightCost;
	}

	
	/**
	 * @return the parcels
	 */
	public Set<Parcel> getParcels() {
		final Set<Parcel> parcels2 = this.parcels;
		return (Set<Parcel>)Collections.unmodifiableSet(parcels2);
	}
	
	//-------------------------------More Methods------------------------------
		//TODO - Add more methods
	
	/**
	 * This method adds a new stop to this Flight IFF the given step doesn't exists already
	 * <b>Notice!</b> check in the stops array and in the source and destination of the flight 
	 * @param stopToAdd
	 * @return true if host added successfully, false otherwise
	 */
	public boolean addStop(Connection stopToAdd)
	{
		if ((stopToAdd != null) && (!this.stops.contains(stopToAdd))) {
		      return this.stops.add(stopToAdd);
		    }
		    return false;
	}
	
	
	/**
	 * This method removes stop from this Flight IFF this step already exists in stop array.
	 * @param stopToRemove
	 * @return true if stepToRemove removed successfully, false otherwise
	 */
	public boolean removeStop(Connection stopToRemove)
	{
		return stops.remove(stopToRemove);
	}
	
	
	/**
	 * This method adds a new parcel to this flight if it isn't already exist.
	 * @param parcel
	 * @return true if the flight order has been added, false otherwise
	 */
	public boolean addParcel(Parcel parcel){
		if(parcel != null)
		{
			if(parcels.contains(parcel))
					return false;			
			
			parcels.add(parcel);
			return true;
		}

		return false;
	}//END OF ~ addParcel
	
	/**
	 * This method removes parcel from this Flight IFF the given parcel already exists in parcels array.
	 * @param parcelToRemove
	 * @return true if the parcel has been removed, false otherwise
	 */
	public boolean removeParcel(Parcel parcelToRemove){
		return parcels.remove(parcelToRemove);
	}//END OF ~ removeParcel
	
	//-------------------------------hashCode equals & toString------------------------------
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String theString = "========================Flight - " + flightNumber + " details============================\n";
		
		theString += "Source date: " + flightDateAndTimeSource + "\nDestination date: " + flightDateAndTimeDestination;
		
		theString += "\nShipment cost: " + flightCost + "\n";
		
		
		theString += "Flight source: " + source + "\nFlight destination: " + destination + "\nFlight stops:" + "\n";
		int i = 1;
		for(Connection stop : stops)
		{	if(stop!=null)
			theString += (i++) + " - " + stop + "\n";
		}
		
		return theString;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flightNumber;
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
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (flightNumber != other.flightNumber)
			return false;
		return true;
	}




}// ~ END OF Class Flight
