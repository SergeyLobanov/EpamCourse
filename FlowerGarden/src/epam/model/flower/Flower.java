package epam.model.flower;

import epam.model.Product;

/**
 * Abstract class that represents flowers
 * Created by Сергей on 01.06.2016.
 */
public abstract class Flower implements Product {
	/**
	* stem length in mm
	*/
	private int stemLength;
	/**
	* freshness of flower from 0 to 10 (included)
	*/
	private int freshness;
	/**
	 * flower price
	 */
	private double price;

	/**
	 * flower constructor
     */
	Flower(double price, int stemLength, int freshness) {
		this.price = price;
		this.stemLength = stemLength;
		this.freshness = freshness;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public int getStemLength() {
		return stemLength;
	}
	
	public void setStemLength() {
		this.stemLength = stemLength;
	}

	public int getFreshness() {
		return freshness;
	}

	public void setFreshness(int freshness) {
		this.freshness = freshness;
	}

	@Override
	public String toString() {
		return "Flower with stemLength " + stemLength +
				"mm, freshness is " + freshness +
				"/10, price = " + price;
	}
}

