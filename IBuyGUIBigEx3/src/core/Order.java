/**
 * 
 */
package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Basil Hawari 302373188
 * Class Purchase ~ represent the purchase of a single buyer/seller for a single order
 */
public class Order {
	private static final double TAX=0.13;
	private int orderNumber;
	private Customer buyer;
	private Customer seller;
	private ArrayList<Parcel> parcels;
	
	public Order() {
		parcels=new ArrayList<Parcel>();
	}
	
	/**
	 * Partial Constructor ~ use for initial key fields
	 * @param orderNumber
	 */
	public Order(int orderNumber){
		this();
		this.orderNumber=orderNumber;		
	}
	
	/**
	 * Full Constructor ~ use for initial all fields
	 * @param orderNumber
	 * @param buyer
	 * @param seller
	 */
	public Order(int orderNumber, Customer buyer, Customer seller){
		this(orderNumber);
		this.buyer=buyer;
		this.seller=seller;
	}
	
	/**
	 * This method calculate and returns the total cost of this order by summing the total cost of each parcel associated with this order and add a tax to it.
	 * @return the total cost
	 * @see Parcel.getPrice()
	 */
	public double getOrderCost(){
		Iterator<Parcel> itr=parcels.iterator();
		double total=0;
		while(itr.hasNext())
			total+=itr.next().getPrice();
		
		return total+(total*TAX);
	}
	
	
	/**
	 * This method add a new parcel to the order
	 * @param parcel
	 * @return true if parcel added successfully or false otherwise
	 */
	public boolean addParcel(Parcel parcel){
		if(parcels==null)
		{
			parcels=new ArrayList<Parcel>();
			return parcels.add(parcel);
		}
		if(parcels.contains(parcel))
			return false;
		
		return parcels.add(parcel);
	}
	
	/**
	 * This method remove a given parcel from the parcels array IFF the parcel exists.
	 * @param parcel
	 * @return true if parcel removed successfully or false otherwise
	 */
	public boolean removeParcel(Parcel parcel){
		if(parcels!=null&&parcels.contains(parcel))		
			return parcels.remove(parcel);	
			
		return false;
		
	}
	

	/**
	 * @return the parcels
	 */
	public ArrayList<Parcel> getParcels() {
		final ArrayList<Parcel> parcels2 = this.parcels;
		return (ArrayList<Parcel>)Collections.unmodifiableCollection(parcels2);
	}

	/**
	 * @param parcels the parcels to set
	 */
	public void setParcels(ArrayList<Parcel> parcels) {
		this.parcels = parcels;
	}

	/**
	 * @return the orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the buyer
	 */
	public Customer getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(Customer buyer) {
		this.buyer = buyer;
	}

	/**
	 * @return the seller
	 */
	public Customer getSeller() {
		return seller;
	}

	/**
	 * @param seller the seller to set
	 */
	public void setSeller(Customer seller) {
		this.seller = seller;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", buyer=" + buyer + ", seller=" + seller + ", parcels=" + parcels+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderNumber;
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
		if (!(obj instanceof Order))
			return false;
		Order other = (Order) obj;
		if (orderNumber != other.orderNumber)
			return false;
		return true;
	}
}
