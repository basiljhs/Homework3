/**
 * 
 */
package core;

import java.net.URL;
import java.util.Date;
import java.util.Iterator;

import utils.Rating;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Basil Hawari 302373188
 * Class Customer ~ represent the entity of (Buyer or seller).
 */
public class Customer implements Rating,Comparable<Customer> {
	private String accountNumber;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String password;
	private URL email;
	private Address customerAddress;
	private ArrayList<Order> orders;
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName=" + lastName+"]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
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
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		
		return true;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	 * @return the email
	 */
	public URL getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(URL email) {
		this.email = email;
	}

	/**
	 * @return the customerAddress
	 */
	public Address getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * @return the orders
	 */
	public ArrayList<Order> getOrders() {
		final ArrayList<Order> orders2 = this.orders;
		return new ArrayList<Order>(Collections.unmodifiableCollection(orders2));
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	/**
	 * This method adds a new Order to the orders array IFF the given order doesn't already exists in the customer's orders array.
	 * @param order
	 */
	public boolean addOrder(Order order){
		if(orders==null)			
			orders=new ArrayList<Order>();	
		return orders.add(order);
	}
	
	/**
	 * This method counts the number of the orders belongs to the customer.
	 * @return number of orders
	 */
	public int getNumOfCustomerOrders(){
		return orders==null?0:orders.size();
	}
	
	/**
	 * This method removes an existing order from the orders array IFF the order exists
	 * @param order
	 * @return true if this order removed successful or false otherwise
	 */
	public boolean removeOrder(Order order){
		if(orders!=null&&orders.contains(order))		
			return orders.remove(order);	
		
		return false;
	}

	public Customer() {
		orders=new ArrayList<Order>();
		}
	
	/**
	 * Partial Constructor ~ use for initial key fields
	 * @param accountNumber
	 */
	public Customer(String accountNumber) {
		this();
		this.accountNumber=accountNumber;
	}
	
	/**
	 * Full Constructor ~ use for initial all fields
	 * @param accountNumber
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param password
	 * @param email
	 * @param customerAddress
	 */
	public Customer(String accountNumber, String firstName, String lastName, Date birthDate, String password, URL email, Address customerAddress){
		this(accountNumber);
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthDate=birthDate;
		this.password=password;
		this.email=email;
		this.customerAddress=customerAddress;		
	}
	
	@Override
	public String getPrimaryKey() {
		return accountNumber;
	}

	@Override
	public double calcRating() {
		Iterator<Order> it=this.orders.iterator();
		double totalCost=0;
		while(it.hasNext())		
			totalCost+=it.next().getOrderCost();
				
		return totalCost;
	}

	@Override
	public int compareTo(Customer o) {
		int comp=this.firstName.compareTo(o.firstName);
		return comp==0?this.lastName.compareTo(o.lastName):comp;		
	}

}
