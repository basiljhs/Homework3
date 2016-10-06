/**
 * 
 */
package core;

/**
 * @author Basil Hawari 302373188
 *
 */
public class Parcel {
	private Flight flight;
	private Order order;
	private Product product;
	

	/**
	 * 
	 */
	public Parcel() {}
	/**
	 * Full Constructor ~ use for initial all fields
	 * @param flight
	 * @param order
	 * @param product
	 */
	public Parcel(Flight flight, Order order, Product product){
		this.flight=flight;
		this.order=order;
		this.product=product;
	}
	
	/**
	 * This method calculate the total cost of the parcel (product cost and shipment cost).
	 * @return total cost of the parcel
	 */
	public double getPrice(){
		return product.getPrice()+flight.getFlightCost();
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
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		if (!(obj instanceof Parcel))
			return false;
		Parcel other = (Parcel) obj;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parcel [flight=" + flight + "product=" + product + "]";
	}
	

}
