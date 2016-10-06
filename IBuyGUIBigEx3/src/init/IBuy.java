package init;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.CustomerComparator;
import utils.E_Airplanes;
import utils.E_Airports;
import utils.E_Cities;
import core.Address;
import core.Connection;
import core.Customer;
import core.Employee;
import core.Flight;
import core.FlightAttendant;
import core.Order;
import core.Parcel;
import core.Pilot;
import core.Product;

/**
 * This IBuy class represents the class system
 * @author Java Course 2016
 * @author University Of Haifa
 */
public class IBuy {

	//-------------------------------Class Members------------------------------
	private Map<Integer,Product> products;

	private Map<String,Customer> buyers;
	
	private Map<String,Customer> sellers;
	
	private Map<Integer,Employee> employees;
	
	private Map<Integer,Flight> flights;
	
	//-------------------------------Constructors------------------------------
	/**
	 * Full Constructor ~ use for initial all data structures
	 */
	public IBuy()
	{
		products = new HashMap<Integer,Product>();
		buyers = new  HashMap<String,Customer>();
		sellers = new  HashMap<String,Customer>();
		flights = new HashMap<Integer,Flight>();
		employees = new HashMap<Integer,Employee>();
	}
	
	//-----------------------------------------Getters--------------------------------------
	/**
	 * @return the products
	 */
	public Map<Integer,Product> getProducts() {
		return Collections.unmodifiableMap(products);
	}

	/**
	 * @return the buyers
	 */
	public Map<String,Customer> buyers() {
		return Collections.unmodifiableMap(buyers);
	}

	/**
	 * @return the sellers
	 */
	public Map<String,Customer> sellers() {
		return Collections.unmodifiableMap(sellers);
	}
	
	public Map<Integer, Employee> getEmployees() {
		return Collections.unmodifiableMap(employees);
	}
	
	/**
	 * @return the flights
	 */
	public Map<Integer,Flight> getFlights() {
		return Collections.unmodifiableMap(flights);
	}
	
	//-------------------------------Add && Remove Methods------------------------------
	public boolean addProduct(int productId, String productName, double price){
		//check validity first
		if(productName != null && productId>0 && price>0){						
			if (!products.containsKey(productId)) {
				Product product = new Product(productId,productName,price);
				if (products.put(productId, product) == null)
					return true;
			}
		}
		
		return false;
		
	}// ~ END OF addProduct
	
	/**
	 * Creates and adds a new buyer into the relevant data-structure. 
	 * Account number includes only digits.
	 * @param accountNumber
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param password
	 * @param email
	 * @param buyerAddress
	 * @return true if the buyer was added successfully
	 */
	public boolean addBuyer(String accountNumber, String firstName, String lastName,
			Date birthDate, String password, URL email, Address buyerAddress){
		//check validity first
		if(accountNumber != null && firstName != null && lastName != null && birthDate != null &&
				password != null && email != null && buyerAddress != null){
				for(int i = 0; i < accountNumber.length(); i++)
					if(! Character.isDigit(accountNumber.charAt(i)))
						return false;
						
			if (!buyers.containsKey(accountNumber)) {
				Customer customer = new Customer(accountNumber, firstName, lastName,
						birthDate, password, email, buyerAddress);
				if (buyers.put(accountNumber, customer) == null)
					return true;
			}
		}
		
		return false;
		
	}// ~ END OF addBuyer
	
	/**
	 * Creates and adds a new seller into the relevant data-structure. 
	 * Account number includes only digits.
	 * @param accountNumber
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param password
	 * @param email
	 * @param sellerAddress
	 * @return true if the seller was added successfully
	 */
	public boolean addSeller(String accountNumber, String firstName, String lastName,
			Date birthDate, String password, URL email, Address sellerAddress){
		//check validity first
		if(accountNumber != null && firstName != null && lastName != null && birthDate != null &&
				password != null && email != null && sellerAddress != null){
				for(int i = 0; i < accountNumber.length(); i++)
					if(! Character.isDigit(accountNumber.charAt(i)))
						return false;
			
				if (!sellers.containsKey(accountNumber)) {
					Customer customer = new Customer(accountNumber, firstName, lastName,
							birthDate, password, email, sellerAddress);
					if (sellers.put(accountNumber, customer) == null)
						return true;
				}
		}
		
		return false;
		
	}// ~ END OF addSeller
	
	/**
	 * Creates and adds new employee
	 * into the appropriate data-structure
	 * @param employee
	 * @return true if this employee added successfully or false otherwise
	 */
	public boolean addEmployee(Employee employee){
		if(employee==null)return false;
		employees.put(employee.getEmployeeNumber(), employee);
		return true;
	}// ~ END OF addEmployee
	
	/**
	 * This method adds a license to a pilot
	 * @param employeeNumber
	 * @param license
	 * @return True if it was added succesfully, False otherwise.
	 */
	public boolean AddLicenseToPilot(int employeeNumber,E_Airplanes license){

		Employee e=employees.get(employeeNumber);
		if(e instanceof Pilot)		
			return ((Pilot)e).addLicense(license);
		
		return false;
	}

	/**
	 * This method adds a new Flight to IBuy IFF these conditions are valid:
	 * - Landing date must be after 'take off' date
	 * - This flight doesn't already exist
	 * - All the variables are valid( positive number and objects are not null)
	 * - Source and destination can't be the same airport
	 * @param flightNumber
	 * @param flightDateAndTimeSource
	 * @param flightDateAndTimeDestination
	 * @param flightCost
	 * @return true if the Flight was added successfully, otherwise false  
	 */
	public boolean addFlight(int flightNumber, Date flightDateAndTimeSource,
			Date flightDateAndTimeDestination, double flightCost, E_Airports source, E_Airports destination,int airplaneNumber,E_Airplanes license){
		
			if (flightNumber > 0 && flightDateAndTimeSource != null && flightDateAndTimeDestination != null && 
					flightCost > 0 && source != null && destination != null)
			{
				if(flightDateAndTimeSource.before(flightDateAndTimeDestination) && 
						!source.equals(destination) && !flights.containsKey(flightNumber))
				{
					Flight flightToAdd = new Flight(flightNumber, flightDateAndTimeSource, flightDateAndTimeDestination, source, destination, flightCost,license);
					 flights.put(flightNumber,flightToAdd);
					 return true;
				}
			}

			return false;	
	
		
	}// ~ END OF addFlight
	
	/**
	 * This method adds a stop to a specific flight IFF the stop isn't already part of the flight path.
	 * stepNumber of the connection represent the stop number 
	 * @return true if step was added successfully, otherwise false 
	 */
public boolean addStepInToFlight(int flightNumber,E_Airports stepLocation){
		
	 if ((flightNumber > 0) && (stepLocation != null)) {
	      if (this.flights.containsKey(flightNumber))
	      {
	        Flight flight = (Flight)this.flights.get((flightNumber));
	        if ((!flight.getDestination().equals(stepLocation)) && (!flight.getSource().equals(stepLocation)))
	        {
	          for (Connection s : flight.getConnections()) {
	            if ((s != null) && (s.getAirport().equals(stepLocation))) {
	              return false;
	            }
	          }
	          int stopsCount = 0;
	          for (Connection c : flight.getConnections()) {
	            if (c != null) {
	              stopsCount++;
	            }
	          }
	          Connection stopToAdd = new Connection(stopsCount + 1, flight, stepLocation);
	          return flight.addStop(stopToAdd);
	        }
	      }
	    }
	    return false;
	} //~ END OF addStepInToFlight
	
	/**
	 * This method first add a given flight to a given employee (pilot or FlightAttendant)
	 * and do the opposite (use instanceof operation).
	 * If the employee unsuccessfully added to the flight ==> Roll back is needed
	 * @param employee
	 * @param flight
	 * @return true if the connection added successfully, false otherwise
	 */
public boolean addPilotOrFlightAttendantToFlight(Employee employee, Flight flight) {
	if (employee != null && flight != null) {
        if (employee instanceof FlightAttendant) {
            if (((FlightAttendant)employee).addFlight(flight)) {
                if (flight.addFlightAttendant((FlightAttendant)employee)) {
                    return true;
                }
                ((FlightAttendant)employee).removeFlight(flight);
            }
        } else if (employee instanceof Pilot && ((Pilot)employee).addFlight(flight)) {
            if (flight.addPilot((Pilot)employee)) {
                return true;
            }
            ((Pilot)employee).removeFlight(flight);
        }
    }
    return false;
}
	
	/**
	 * This method adds a new parcel to an order.
	 * Conditions that need to be checked (all of the conditions need to be valid in order to return true):
	 * - The given Flight/(Buyer and Seller) already exist in the system. 
	 * - The parcel Object not already existed <b>(Notice which fields needs to create this objects primary key)</b>.
	 * - If the given order is one of the given buyer and seller orders, create a parcel with the given details and add it to the order.
	 * otherwise, if there is no such order in seller and buyer orders, create a new order to  the given buyer and seller orders. then create a new parcel and add it 
	 * to the order.
	 * @param buyerAccountNumber
	 * @param sellerAccountNumber
	 * @param orderNumber
	 * @param productID
	 * @param flightNumber
	 * @return true if the parcel added successfully, false otherwise
	 */
	public boolean addParcel(String buyerAccountNumber,String sellerAccountNumber, int orderNumber, int productID, int flightNumber){
//		if(buyerAccountNumber!=null&&sellerAccountNumber!=null&&orderNumber>0&&productID>0&&flightNumber>0)
//		{
//			if(buyers.containsKey(buyerAccountNumber)&&sellers.containsKey(sellerAccountNumber)&&flights.containsKey(flightNumber)){
//				Customer buyer=buyers.get(buyers.get(buyerAccountNumber));
//				Customer seller=sellers.get(sellers.get(sellerAccountNumber));
//				if(buyer==null||seller==null)return false;
//				if(buyer.getOrders().contains(new Order(orderNumber))){
//					if(seller.getOrders().contains(new Order(orderNumber))){
//						ArrayList<Order> buyerOrders=buyer.getOrders();
//						Order currentOrder=buyerOrders.get(buyerOrders.indexOf(new Order(orderNumber)));
//						return currentOrder.addParcel(new Parcel(flights.get(flights.get(flightNumber)),currentOrder,products.get(products.get(productID))));
//					}
//				}
//				else{
//					if(seller.getOrders().contains(new Order(orderNumber)))
//						return false;//then order number is incorrect					
//					
//					Order newOrder=new Order(orderNumber,buyer,seller);
//					buyer.addOrder(newOrder);
//					seller.addOrder(newOrder);
//					return newOrder.addParcel(new Parcel(flights.get(flights.get(flightNumber)),newOrder,products.get(products.get(productID))));										
//				}
//			}
//		}
//		return false;
		if ((buyerAccountNumber != null) && (sellerAccountNumber != null) && 
			      (productID > 0) && (orderNumber > 0) && (flightNumber > 0)) {
			      if ((this.buyers.containsKey(buyerAccountNumber)) && 
			        (this.products.containsKey(Integer.valueOf(productID))) && (this.flights.containsKey(Integer.valueOf(flightNumber))))
			      {
			        Flight flight = (Flight)this.flights.get(Integer.valueOf(flightNumber));
			        
			        Customer buyer = (Customer)this.buyers.get(buyerAccountNumber);
			        Customer seller = (Customer)this.sellers.get(sellerAccountNumber);
			        Product product = (Product)this.products.get(Integer.valueOf(productID));
			        
			        Order order = new Order(orderNumber);
			        boolean isNew = true;
			        for (Order ord : buyer.getOrders()) {
			          if ((ord != null) && (ord.equals(order)))
			          {
			            isNew = false;
			            order = ord;
			          }
			        }
			        if (isNew)
			        {
			          order = new Order(orderNumber, buyer, seller);
			          buyer.addOrder(order);
			          seller.addOrder(order);
			        }
			        Parcel parcel = new Parcel(flight, order, product);
			        
			        order.addParcel(parcel);
			        if (!flight.addParcel(parcel))
			        {
			          if (isNew)
			          {
			            buyer.removeOrder(order);
			            seller.removeOrder(order);
			          }
			          else
			          {
			            for (Order ordr : buyer.getOrders()) {
			              if (ordr != null) {
			                for (int i = 0; i < ordr.getParcels().size(); i++) {
			                  if ((ordr.getParcels().get(i) != null) && (((Parcel)ordr.getParcels().get(i)).equals(parcel))) {
			                    ordr.removeParcel(parcel);
			                  }
			                }
			              }
			            }
			            for (Order ordr : seller.getOrders()) {
			              if (ordr != null) {
			                for (int i = 0; i < ordr.getParcels().size(); i++) {
			                  if ((ordr.getParcels().get(i) != null) && (((Parcel)ordr.getParcels().get(i)).equals(parcel))) {
			                    ordr.removeParcel(parcel);
			                  }
			                }
			              }
			            }
			          }
			          return false;
			        }
			        return true;
			      }
			    }
			    return false;
	}// ~ END OF addParcel
	
	
	/**
	 * This method change the address of existing buyer IFF the buyer already exist and the Address details are valid.
	 * @param accountNumber
	 * @param country
	 * @param city
	 * @param street
	 * @param houseNumber
	 * @param phonenumbers
	 * @return true if succeeded, otherwise false.
	 */
	public boolean changeBuyerAddress(String accountNumber,String country, E_Cities city,String street
			,int houseNumber,String[] phonenumbers){
		if(accountNumber!=null&&country!=null&&city!=null&&street!=null&&houseNumber>0&&phonenumbers!=null){
			if(buyers.containsKey(accountNumber))
			{
				Customer buyer=buyers.get(buyers.get(accountNumber));
				buyer.setCustomerAddress(new Address(country,city,street,houseNumber,phonenumbers));
				return true;
			}
		}
		return false;
	} // ~ END OF changeBuyerAddress
	
	/**
	 * This method change the address of existing seller IFF the seller already exist and the Address details are valid.
	 * @param accountNumber
	 * @param country
	 * @param city
	 * @param street
	 * @param houseNumber
	 * @param phonenumbers
	 * @return true if succeeded, otherwise false.
	 */
	public boolean changeSellerAddress(String accountNumber,String country, E_Cities city,String street
			,int houseNumber,String[] phonenumbers){
		if(accountNumber!=null&&country!=null&&city!=null&&street!=null&&houseNumber>0&&phonenumbers!=null){
			if(sellers.containsKey(accountNumber))
			{
				Customer seller=sellers.get(accountNumber);
				seller.setCustomerAddress(new Address(country,city,street,houseNumber,phonenumbers));
				return true;
			}
		}
		return false;
		
	} // ~ END OF changeSellerAddress
	
	/**
	 * This method cancels order from the system using the orderNumber (Primary Key).
	 * The order will be canceled IFF all related objects will delete from order
	 * Hint: use disconnectParcel() helper method.
	 * @param orderNumber
	 * @return true if order completely canceled, false otherwise
	 */
	public boolean cancelOrder(int orderNumber) {
        if (orderNumber > 0) {
            Iterator<Parcel> iterator;
            Order orderToRemove = new Order(orderNumber);
            for (Customer c2 : this.buyers.values()) {
                if (!c2.getOrders().contains((Object)orderToRemove) || !(iterator = (orderToRemove = (Order)c2.getOrders().get(c2.getOrders().indexOf((Object)orderToRemove))).getParcels().iterator()).hasNext()) continue;
                Parcel p = (Parcel)iterator.next();
                this.disconnectParcel(p);
                c2.removeOrder(orderToRemove);
                return true;
            }
            for (Customer c2 : this.sellers.values()) {
                if (!c2.getOrders().contains((Object)orderToRemove) || !(iterator = (orderToRemove = (Order)c2.getOrders().get(c2.getOrders().indexOf((Object)orderToRemove))).getParcels().iterator()).hasNext()) continue;
                Parcel p = (Parcel)iterator.next();
                this.disconnectParcel(p);
                c2.removeOrder(orderToRemove);
                return true;
            }
        }
        return false;
    }
	
	/**
	 * This helper method removes this Parcel from the related flight and the related order.
	 * <b>Hint!</b> The related order and flight can be accessed from the Parcel object.
	 * @param Parcel
	 */
	private void disconnectParcel(Parcel parcel) {
        if (parcel != null) {
            if (parcel.getFlight() != null) {
                parcel.getFlight().removeParcel(parcel);
            }
            if (parcel.getOrder() != null) {
                parcel.getOrder().removeParcel(parcel);
            }
        }
    }
	
	
	//-------------------------------Queries------------------------------
	
	//===================================================
	// 					HW_1_Queries
	//===================================================
	/**
	 * This method returns all the orders of the most profitable buyer.
	 * Most profitable buyer is the customer  with the most number of orders.  
	 * @return profitable customer
	 */
	public ArrayList<Order> getAllOrdersOfMostProfitableBuyer(){
		int numberOfOrders = 0;
        Customer profitableCustomer = null;
        for (Customer customer : this.buyers.values()) {
            if (customer.getNumOfCustomerOrders() <= numberOfOrders) continue;
            numberOfOrders = customer.getNumOfCustomerOrders();
            profitableCustomer = customer;
        }
        if(profitableCustomer==null)return new ArrayList<Order>();
        return profitableCustomer.getOrders();
	} // ~ END OF getAllOrdersOfMostProfitableBuyer
			
	
	/**
	 * This method return the most profitable order.
	 * The most Profitable order is the order with the 
	 * highest amount of money from all the orders existed in the company.
	 * <b>use the helper method!</b>
	 * @see Order#getOrderCost()
	 * @return order or null
	 */
	public Order getTheMostProfitableOrder()
	{
		Order maxOrder = null;
        double maxAmount = 0.0;
        for (Customer c : this.buyers.values()) {
            for (Order o : c.getOrders()) {
                if (o == null || o.getOrderCost() < maxAmount) continue;
                maxAmount = o.getOrderCost();
                maxOrder = o;
            }
        }
        return maxOrder;
	}// ~ END OF getTheMostProfitableOrder


	//===================================================
	// 					HW_2_Queries
	//===================================================
	
	/**
	 * FlightAttendant of the month is the FlightAttendant that takes part in the highest 
	 * number of flights in the given month, and have at least 2 connections
	 * @param month
	 * @return FilightAttendant
	 */
	public Employee flightAttendantOfTheMonth(Date month){
		int max = 0;
        Employee employeeOfTheMonth = null;
        int maxEmployee = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(month);
        int monthNum = cal.get(Calendar.MONTH);
        int yearNum=cal.get(Calendar.YEAR);
        Calendar caltmp = Calendar.getInstance();
        for (Employee e : this.employees.values()) {
            max = 0;
            if (!(e instanceof FlightAttendant)) continue;
            Set<Flight> flights = ((FlightAttendant)e).getFlights();
            for (Flight f : flights) {
            	
            	caltmp.setTime(f.getFlightDateAndTimeSource());
                int monthNumTmp = cal.get(Calendar.MONTH);
                int yearNumTmp=cal.get(Calendar.YEAR);
                if (monthNumTmp  != monthNum || yearNumTmp != yearNum || f.getConnections().size() < 2) continue;
                ++max;
            }
            if (max <= maxEmployee) continue;
            maxEmployee = max;
            employeeOfTheMonth = e;
        }
        return employeeOfTheMonth;

	}// ~ END OF flightAttendantOfTheMonth
	
	/**
	 * Returns all sellers sorted by name
	 * @return list of sellers
	 */
	public List<Customer> getAllSellersSortedByName(){
        ArrayList<Customer> allSellers = new ArrayList<Customer>();
        for (Customer s : this.sellers.values()) {
            allSellers.add(s);
        }
        Collections.sort(allSellers);
        return allSellers;

	} // ~ END OF getAllSellersSortedByName
	
	/**
	 * Returns all sellers sorted by rating
	 * @return list of sellers
	 */
	public List<Customer> getAllSellersSortedByRating(){
		ArrayList<Customer> allSellers = new ArrayList<Customer>();
        for (Customer s : this.sellers.values()) {
            allSellers.add(s);
        }
        Collections.sort(allSellers, new CustomerComparator());
        return allSellers;
	} // ~ END OF getAllSellersSortedByRating
	
	/**
	 * Returns all pilots sorted by seniority
	 * @return list of pilots
	 */
	public List<Employee> getAllPilotsSortedBySeniority(){
        ArrayList<Employee> allPilots = new ArrayList<Employee>();
        for (Employee emp : this.employees.values()) {
            if (!(emp instanceof Pilot)) continue;
            allPilots.add(emp);
        }
        Collections.sort(allPilots, new Comparator<Employee>(){
			@Override
			public int compare(Employee emp1, Employee emp2)
			  {
			    return emp2.getEmployeeSeniority() - emp1.getEmployeeSeniority();
			  }});
        //Collections.sort(allPilots, new /* Unavailable Anonymous Inner Class!! */);
        return allPilots;
	} // ~ END OF getAllPilotsSortedBySeniority
	
	/**
	 * This method return for each Buyer a list of his/her orders.
	 * The order list is sorted by price.
	 * @return map
	 */
	public Map<Customer, ArrayList<Order>> getBuyersOrdersSortedByCost(){
		Map<Customer, ArrayList<Order>> allBuyersAndOrders = new HashMap<Customer, ArrayList<Order>>();
	    for (Customer buyer : this.buyers.values())
	    {
	      ArrayList<Order> orderList = new ArrayList<Order>(buyer.getOrders());
	      
	      Collections.sort(orderList, new Comparator<Order>(){
	    	  @Override
	    	  public int compare(Order o1, Order o2)
	    	  {
	    	    return (int)o1.getOrderCost() - (int)o2.getOrderCost();
	    	  }
	      });
	      
	      allBuyersAndOrders.put(buyer, orderList);
	    }
	    return allBuyersAndOrders;
	} // ~ END OF getBuyersOrdersSortedByCost
	

}// ~ END OF Class IBuy
