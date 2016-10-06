package init;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

import core.Address;
import core.Customer;
import core.Employee;
import core.Flight;
import core.FlightAttendant;
import core.Order;
import core.Pilot;
import utils.E_Airplanes;
import utils.E_Airports;
import utils.E_Cities;
import utils.MyFileLogWriter;

/**
 * The Main Class -The program runner 
 * @author Java Course 2016
 * @author University Of Haifa
 */
public class MainClass {
	
	/**
	 *  The command read from the input file 
	 */
	private static String command;
	
	/**
	 *  To check if the command updated the objects 
	 */
	private static boolean isUpdated;
	
	/**
	 * The date format
	 */
	private static DateFormat df;
	
	/**
	 * The main object for the program	
	 */
	private static IBuy IBuy;
	
	/**
	 * Scanner for input
	 */
	private static Scanner input;
			
	/**
	 * The main method of this system, gets input from input.txt 
	 * and Writes output to output.txt file
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException{
		
		input = new Scanner(new File("input.txt")); //Create Scanner for the text file named "input.txt"

		df = new SimpleDateFormat("dd/MM/yyyy");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
		
		 
		MyFileLogWriter.initializeMyFileWriter(); // Writer buffer creation used after update
		
		// if the file has next - not empty 
		if (input.hasNext()) {
			IBuy = new IBuy();			
		}
		
		/*
		 * read the commands. loop while input file [input.hasnext()]
		 * and the IBuy is not null 
		 */
		while (input.hasNext() && IBuy != null) {
			/* 
			 * read the command, must be first at line because command value 
			 * determine which method will be activated in IFurniture object.
			 */
			command = input.next();
			isUpdated = false;
			
			// ================			Building Command			================
			 if (command.equals("addProduct")) {
				//  create and add new Product to IBuy
				int productNumber	  = Integer.parseInt(input.next());
				String productName 	  = input.next();
				double price		  = Double.parseDouble(input.next());
								
				isUpdated = IBuy.addProduct(productNumber, productName, price);
				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("addProduct returns: "
									+ "Successfully added Product with account " + productNumber
									+ " to IBuy");
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("addProduct returns: "
									+ "Failed to add new Product with account " + productNumber
									+ " to IBuy");
				}
			}
			
			// ================			Building Command			================
			 else if (command.equals("addSeller")) {
				//  create and add new Customer to IBuy
				String accountNumber = input.next();
				String firstName 	  = input.next();
				String lastName 	  = input.next();
				Date birthDate        = df.parse(input.next());
				String password 	  = input.next();
				URL email			  = new URL(input.next());
				
				String country		  = input.next();
				E_Cities city 		  = E_Cities.valueOf(input.next());
				String street		  = input.next();
				int housNumber		  = Integer.parseInt(input.next());
				String[] phoneNumber  = {input.next()};
				
				Address address = new Address(country, city, street, housNumber, phoneNumber);
				
				isUpdated = IBuy.addSeller(accountNumber, firstName, lastName, birthDate, password, email, address);
				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("addSeller returns: "
									+ "Successfully added Seller with account " + accountNumber
									+ " to IBuy");
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("addSeller returns: "
									+ "Failed to add new Seller with account " + accountNumber
									+ " to IBuy");
				}
			}
			 
			// ================			Building Command			================
			 else if (command.equals("addBuyer")) {
				//  create and add new Customer to Ibuy
				String accountNumber = input.next();
				String firstName 	  = input.next();
				String lastName 	  = input.next();
				Date birthDate        = df.parse(input.next());
				String password 	  = input.next();
				URL email			  = new URL(input.next());
				
				String country		  = input.next();
				E_Cities city 		  = E_Cities.valueOf(input.next());
				String street		  = input.next();
				int housNumber		  = Integer.parseInt(input.next());
				String[] phoneNumber  = {input.next()};
				
				Address address = new Address(country, city, street, housNumber, phoneNumber);
				
				isUpdated = IBuy.addBuyer(accountNumber, firstName, lastName, birthDate, password, email, address);
				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("addBuyer returns: "
									+ "Successfully added Buyer with account " + accountNumber
									+ " to IBuy");
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("addBuyer returns: "
									+ "Failed to add new Buyer with account " + accountNumber
									+ " to IBuy");
				}
			}
			// ================			Building Command			================
			 else if (command.equals("addFlightAttendant")) {
					//  create and add new FlightAttendant to IFly
					int employeeNumber	  = Integer.parseInt(input.next());
					String firstName 	  = input.next();
					String lastName 	  = input.next();
					Date birthDate        = df.parse(input.next());
					Date startWorkingDate = df.parse(input.next());
					String password 	  = input.next();
					Double rank	  = Double.parseDouble(input.next());
					
					String country		  = input.next();
					E_Cities city 		  = E_Cities.valueOf(input.next());
					String street		  = input.next();
					int housNumber		  = Integer.parseInt(input.next());
					String[] phoneNumber  = {input.next()};
					
					Address address = new Address(country, city, street, housNumber, phoneNumber);
					
					Employee FlightAttendant = new FlightAttendant(employeeNumber, firstName, lastName,
											birthDate, startWorkingDate, password, address, rank);
					
					isUpdated = IBuy.addEmployee(FlightAttendant);
					if (isUpdated) { // if adding successfully, then true returned,
						// the following message is written to the output file
						MyFileLogWriter
								.writeToFileInSeparateLine("addEmployee returns: "
										+ "Successfully added FlightAttendant " + employeeNumber
										+ " to IFly");
					} else {
						MyFileLogWriter
								.writeToFileInSeparateLine("addEmployee returns: "
										+ "Failed to add new FlightAttendant " + employeeNumber
										+ " to IFly");
					}
				}
				// ================			Building Command			================
				else if (command.equals("addPilot")) {
					//  create and add new Pilot to IFly
					int employeeNumber	  = Integer.parseInt(input.next());
					String firstName 	  = input.next();
					String lastName 	  = input.next();
					Date birthDate        = df.parse(input.next());
					Date startWorkingDate = df.parse(input.next());
					String password 	  = input.next();
					
					String country		  = input.next();
					E_Cities city 		  = E_Cities.valueOf(input.next());
					String street		  = input.next();
					int housNumber		  = Integer.parseInt(input.next());
					String[] phoneNumber  = {input.next()};
					
					Address address = new Address(country, city, street, housNumber, phoneNumber);
					
					Employee pilot = new Pilot(employeeNumber, firstName, lastName,
											birthDate, startWorkingDate, password, address);
					
					isUpdated = IBuy.addEmployee(pilot);
					if (isUpdated) { // if adding successfully, then true returned,
						// the following message is written to the output file
						MyFileLogWriter
								.writeToFileInSeparateLine("addEmployee returns: "
										+ "Successfully added Pilot " + employeeNumber
										+ " to IFly");
					} else {
						MyFileLogWriter
								.writeToFileInSeparateLine("addEmployee returns: "
										+ "Failed to add new Pilot " + employeeNumber
										+ " to IFly");
					}
				}
				// ================			Building Command			================
				else if (command.equals("addLicenseToPilot")) {
					int employeeNumber	  = Integer.parseInt(input.next());
					E_Airplanes license   = E_Airplanes.valueOf(input.next());

					
					isUpdated = IBuy.AddLicenseToPilot(employeeNumber,license);
					if (isUpdated) { // if adding successfully, then true returned,
						// the following message is written to the output file
						MyFileLogWriter
								.writeToFileInSeparateLine("addLicenseToPilot returns: "
										+ "Successfully added "+license+" To Pilot " + employeeNumber
										+ " to IBuy");
					} else {
						MyFileLogWriter
								.writeToFileInSeparateLine("addLicenseToPilot returns: "
										+ "Failed to add "+license +" To Pilot " + employeeNumber
										+ " to IBuy");
					}
				}
				// ================			Building Command			================
			else if (command.equals("addFlight")) {
				//  create and add new Flight to IBuy
				int flightNumber	 			  = Integer.parseInt(input.next());
				Date flightDateAndTimeSource 	  = df.parse(input.next());
				Date flightDateAndTimeDestination = df.parse(input.next());
				double flightCost				  = Double.parseDouble(input.next());
				E_Airports source				  = E_Airports.valueOf(input.next());
				E_Airports destination			  = E_Airports.valueOf(input.next());
				int airplaneNumber				  = Integer.parseInt(input.next());
				E_Airplanes licenseType = E_Airplanes.valueOf(input.next());
				
				
				isUpdated = IBuy.addFlight(flightNumber, flightDateAndTimeSource, flightDateAndTimeDestination,
													flightCost, source, destination,airplaneNumber,licenseType);
				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("addFlight returns: "
									+ "Successfully added Flight " + flightNumber
									+ " to IBuy");
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("addFlight returns: "
									+ "Failed to add new Flight " + flightNumber
									+ " to IBuy");
				}
			}
			// ================			Building Command			================
			else if (command.equals("addStepInToFlight")) {
				// Add a new stepping airport to an existing flight
				int flightNumber		= Integer.parseInt(input.next());
				E_Airports airport		= E_Airports.valueOf(input.next());

				isUpdated = IBuy.addStepInToFlight(flightNumber, airport);
				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("addStepInToFlight returns: "
									+ "Successfully added a new stepping airport " + airport
									+ " to flight " + flightNumber);
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("addStepInToFlight returns: "
									+ "Failed to add a new stepping airport " + airport
									+ " to flight " + flightNumber);
				}
			}
			
			// ================			Building Command			================
			else if (command.equals("addPilotOrFlightAttendantToFlight")) {
				// associate between existing flight and existing FlightAttendant OR pilot
				int employeeNumber				  = Integer.parseInt(input.next());
				int flightNumber	 			  = Integer.parseInt(input.next());

				Flight flight = IBuy.getFlights().get(flightNumber);
				Employee employee = IBuy.getEmployees().get(employeeNumber);
				
				String FlightAttendantOrPilot = employee instanceof Pilot ? "Pilot" : "FlightAttendant";

				isUpdated = IBuy.addPilotOrFlightAttendantToFlight(employee, flight);
				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("addPilotOrFlightAttendantToFlight returns: "
									+ "Successfully associated Flight " + flightNumber
									+ " with " + FlightAttendantOrPilot + " " + employeeNumber);
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("addPilotOrFlightAttendantToFlight returns: "
									+ "Failed to associate Flight " + flightNumber
									+ " with " + FlightAttendantOrPilot + " " +employeeNumber);
				}
			}
			// ================			Building Command			================
			else if (command.equals("addParcel")) {
				// Add a parcel to an order
				String buyerAccountNumber           = input.next();
				String sellerAccountNumber           = input.next();
				int orderNumber				      = Integer.parseInt(input.next());
				int productNumber				      = Integer.parseInt(input.next());
				int flightNumber	 			  = Integer.parseInt(input.next());

				isUpdated = IBuy.addParcel(buyerAccountNumber, sellerAccountNumber, orderNumber, productNumber, flightNumber);
				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("addParcel returns: "
									+ "Successfully added Product " + productNumber
									+ " to order " + orderNumber);
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("addParcel returns: "
									+ "Failed to add Product " + productNumber
									+ " to order " + orderNumber);
				}
			}
			
			// ================			Building Command			================
			else if (command.equals("changeSellerAddress")) {
				// Change an existing customer's address
				String sellerId     = input.next();
				String country     = input.next();
				E_Cities city 		  = E_Cities.valueOf(input.next());
				String street		  = input.next();
				int housNumber		  = Integer.parseInt(input.next());
				String[] phoneNumber  = {input.next()};

				isUpdated = IBuy.changeSellerAddress(sellerId, country, city, street, housNumber, phoneNumber);
				if (isUpdated) { // if changing successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("changeSellerAddress returns: "
									+ "Successfully changed address of seller: " + sellerId+ IBuy.sellers().get(IBuy.sellers().get(sellerId))+"\n");
					
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("changeSellerAddress returns: "
									+ "Failed to change address of seller with account number " + sellerId+"\n");
					
				}
			}
			 
			// ================			Building Command			================
			else if (command.equals("changeBuyerAddress")) {
				// Change an existing customer's address
				String buyerId = input.next();
				String country = input.next();
				E_Cities city = E_Cities.valueOf(input.next());
				String street = input.next();
				int housNumber = Integer.parseInt(input.next());
				String[] phoneNumber = { input.next() };

				isUpdated = IBuy.changeSellerAddress(buyerId, country, city, street, housNumber, phoneNumber);
				if (isUpdated) { // if changing successfully, then true
									// returned,
					// the following message is written to the output file
					MyFileLogWriter.writeToFileInSeparateLine(
							"changeBuyerAddress returns: " + "Successfully changed address of buyer: " + buyerId
									+ IBuy.buyers().get(IBuy.buyers().get(buyerId)) + "\n");

				} else {
					MyFileLogWriter.writeToFileInSeparateLine("changeBuyerAddress returns: "
							+ "Failed to change address of buyer with account number " + buyerId + "\n");

				}
			}
			// ================			Building Command			================
			else if (command.equals("cancelOrder")) {
				// Cancel an existing order
				int orderNumber  =  Integer.parseInt(input.next());
				
				isUpdated = IBuy.cancelOrder(orderNumber);
				if (isUpdated) { // if canceling successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
							.writeToFileInSeparateLine("cancelOrder returns: "
									+ "Successfully canceled order " + orderNumber);
				} else {
					MyFileLogWriter
							.writeToFileInSeparateLine("cancelOrder returns: "
									+ "Failed to cancel order " + orderNumber);
				}
			}
			
			// ================			Query Command			================
			else if (command.equals("getAllOrdersOfMostProfitableBuyer")) {
				List<Order> mostOrders = IBuy.getAllOrdersOfMostProfitableBuyer();
				MyFileLogWriter.writeToFileInSeparateLine("getAllOrdersOfMostProfitableBuyer returns:\n");
				if (mostOrders.size() != 0) { 
					MyFileLogWriter.writeToFileInSeparateLine("the following orders:\n"); 
							int i=1;
					for(Order o: mostOrders)
						if(o != null)
							MyFileLogWriter.writeToFileInSeparateLine((i++)+"\t- "+o);

				} else 
					MyFileLogWriter.writeToFileInSeparateLine("No Orders were found");
			}
			
			
			// ================			Query Command			================
			 
				else if (command.equals("flightAttendantOfTheMonth")) {
				
				@SuppressWarnings("deprecation")
				Date theMonth = new Date(2016, 9, 1);
				Employee empOfTheMonth = 
						IBuy.flightAttendantOfTheMonth(theMonth);

				if (empOfTheMonth != null) { 
					MyFileLogWriter.writeToFileInSeparateLine("flightAttendant of the month returns: \n" + 
														"the following flightAttendant returned: " + empOfTheMonth);
				} else 
					MyFileLogWriter.writeToFileInSeparateLine("No flightAttendant of the month was found");
			}
			// ================			Query Command			================
			 
			else if (command.equals("getAllPilotsSortedBySeniority")) {
					List<Employee> pilots = IBuy.getAllPilotsSortedBySeniority();
					
					if (!pilots.isEmpty()) { 
						MyFileLogWriter.writeToFileInSeparateLine("getAllPilotsSortedBySeniority returns: \n");
						int i = 1;
						
						for(Employee employee : pilots)
							MyFileLogWriter.writeToFileInSeparateLine((i++)+"\t- "+ employee);

					} else 
						MyFileLogWriter.writeToFileInSeparateLine("No pilots were found");
				}
			// ================			Query Command			================
			else if (command.equals("getAllSellersSortedByName")) {
				List<Customer> customers = IBuy.getAllSellersSortedByName();
				
				if (!customers.isEmpty()) { 
					MyFileLogWriter.writeToFileInSeparateLine("getAllSellersSortedByName returns: \n");
					int i = 1;
					
					for(Customer c : customers)
						MyFileLogWriter.writeToFileInSeparateLine((i++)+"\t- "+ c);

				} else 
					MyFileLogWriter.writeToFileInSeparateLine("No sellers were found");
			}
		// ================			Query Command			================
			else if (command.equals("getAllSellersSortedByRating")) {
				List<Customer> customers = IBuy.getAllSellersSortedByRating();
				
				if (!customers.isEmpty()) { 
					MyFileLogWriter.writeToFileInSeparateLine("getAllSellersSortedByRating returns: \n");
					int i = 1;
					
					for(Customer c : customers)
						MyFileLogWriter.writeToFileInSeparateLine((i++)+"\t- "+ c);

				} else 
					MyFileLogWriter.writeToFileInSeparateLine("No sellers were found");
			}
			 
		// ================			Query Command			================
			else if (command.equals("getBuyersOrdersSortedByCost")) {
				Map<Customer, ArrayList<Order>> buyersOrders = IBuy.getBuyersOrdersSortedByCost();
				
				if (!buyersOrders.isEmpty()) { 
					MyFileLogWriter.writeToFileInSeparateLine("getBuyersOrdersSortedByCost returns: \n");
					int i = 1;
					
					for(Customer s : buyersOrders.keySet()){
						MyFileLogWriter.writeToFileInSeparateLine((i++)+"\t- "+ s + "\nOrders:");
						MyFileLogWriter.writeToFileInSeparateLine(buyersOrders.get(s) + "\n");
					}
					
				} else 
					MyFileLogWriter.writeToFileInSeparateLine("Not found");
			}
			// ================			Query Command			================
			else if (command.equals("getTheMostProfitableOrder")) {
				Order order = IBuy.getTheMostProfitableOrder();
				MyFileLogWriter.writeToFileInSeparateLine("getTheMostProfitableOrder returns:\n");
				if(order!=null)
				{
					MyFileLogWriter.writeToFileInSeparateLine(order.toString());
				}
				else
					MyFileLogWriter.writeToFileInSeparateLine("No Order were found");
			}
			 
			else if (command.equals("//")) {
				// Separate line command
				MyFileLogWriter.writeToFileInSeparateLine("\n");
				input.nextLine();
				// ignores line starts by '//' the result is empty lines in the
				// output
			}
			// ================				Command			================
			else
				System.out.printf("Command %s does not exist\n", command);
		} //~ end of clause - while input has next
		
		MyFileLogWriter.saveLogFile(); // save the output file
		input.close(); // close connection to input file
		System.out.println("[End Of process]");
		System.out.println("\n NOTICE:\n\t\"End of process\" " +
						"does NOT mean that all your methods are correct.\n" +
						"\n==>\t You NEED to check the \"output.txt\" file");
		
	}//END OF ~ main
	
}// ~ END OF Class MainClass
