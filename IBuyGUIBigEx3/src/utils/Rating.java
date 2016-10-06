package utils;

/**
 * Interface Rating ~  Rating/score of a Customer
 * @author Java Course 2016
 * @author University Of Haifa-Israel
 */
public interface Rating {

	/**
	 * @return the entity's primary key
	 */
	public String getPrimaryKey();
	
	/**
	 * Calculate the rating of this entity
	 */
	public double calcRating();
	
}// ~ END OF Interface Rating
