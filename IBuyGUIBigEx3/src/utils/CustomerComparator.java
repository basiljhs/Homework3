package utils;

import java.util.Comparator;

import core.Customer;

/**
 * Class CustomerComparator ~ use for sorting Customers by their rating.<br>
 * If there are two Customers with the same rating, the sorting criteria is
 * number of orders they made.
 * @author Java Course 2016
 * @author University Of Haifa-Israel
 */	
public class CustomerComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		Double c1Rating = c1.calcRating();
		Double c2Rating = c2.calcRating();
		int comRes=c1Rating.compareTo(c2Rating);
		if(comRes == 0)
			return c1.getNumOfCustomerOrders() - c2.getNumOfCustomerOrders();
		else
			return comRes;
	}
	
} // ~ END OF CustomerComparator
