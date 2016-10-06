/**
 * 
 */
package core;

import java.util.Arrays;

import utils.E_Cities;

/**
 * @author Basil Hawari 302373188
 * Class Address ~ represent the address used by some entities in the system. The key of this class is all the fields
 */
public class Address {
	private String country;
	private E_Cities city;
	private String street;
	private int houseNumber;
	private String[] phoneNumber;

	public Address() {}
	/**
	 * Full constructor ~ use for initial all fields
	 * @param country
	 * @param city
	 * @param street
	 * @param houseNumber
	 * @param phoneNumber
	 */
	public Address(String country, E_Cities city,String street, int houseNumber, String[] phoneNumber){
		this.country=country;
		this.city=city;
		this.street=street;
		this.houseNumber=houseNumber;
		this.phoneNumber=phoneNumber;		
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the city
	 */
	public E_Cities getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(E_Cities city) {
		this.city = city;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}
	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	/**
	 * @return the phoneNumber
	 */
	public String[] getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + houseNumber;
		result = prime * result + Arrays.hashCode(phoneNumber);
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		if (city != other.city)
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (houseNumber != other.houseNumber)
			return false;
		if (!Arrays.equals(phoneNumber, other.phoneNumber))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", street=" + street + ", houseNumber=" + houseNumber
				+ ", phoneNumber=" + Arrays.toString(phoneNumber) + "]";
	}
	

}
