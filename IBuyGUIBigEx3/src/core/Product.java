/**
 * 
 */
package core;

/**
 * @author Basil Hawari 302373188
 * Class Product ~ represent the product used by some entities in the system. The key of this class is product id
 */
public class Product {
	private int productId;
	private String productName;
	private double price;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
		/**
	 * Class Product ~ represent the product used by some entities in the system. The key of this class is product id
	 */
	public Product() {}
	/**
	 * Partial constructor
	 * @param productId
	 */
	public Product(int productId){
		this.productId=productId;
	}
	/**
	 * Full constructor
	 * @param productId
	 * @param productName
	 * @param price
	 */
	public Product(int productId, String productName, double price){
		this(productId);
		this.productName=productName;
		this.price=price;				
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}

}
