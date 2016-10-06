/**
 * 
 */
package core;

import utils.E_Airplanes;

/**
 * @author Basil Hawari 302373188
 * Class Airplane ~ represent a single airplane use for a flight
 */
public class Airplane {
	int airplaneNumber;
	E_Airplanes type;
	
	/**
	 * Partial Constructor ~ use for initial key fields
	 * @param airplaneNumber airplane number
	 */
	public Airplane(int airplaneNumber){
		this.airplaneNumber=airplaneNumber;
	}
	/**
	 * Full constructor ~ use for initial all fields
	 * @param airplaneNumber airplane number
	 * @param type airplane type
	 */
	public Airplane(int airplaneNumber,E_Airplanes type){
		this(airplaneNumber);
		this.type=type;
	}
	/**
	 * @return the airplaneNumber
	 */
	public int getAirplaneNumber() {
		return airplaneNumber;
	}
	/**
	 * @param airplaneNumber the airplaneNumber to set
	 */
	public void setAirplaneNumber(int airplaneNumber) {
		this.airplaneNumber = airplaneNumber;
	}
	/**
	 * @return the type
	 */
	public E_Airplanes getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(E_Airplanes type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + airplaneNumber;
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
		if (!(obj instanceof Airplane))
			return false;
		Airplane other = (Airplane) obj;
		if (airplaneNumber != other.airplaneNumber)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Airplane [airplaneNumber=" + airplaneNumber + ", type=" + type + "]";
	}
}
