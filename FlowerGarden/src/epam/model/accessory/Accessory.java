package epam.model.accessory;

import epam.model.Product;

/**
 * Abstract class for addition element that inserted in bouquet
 * Created by Сергей on 01.06.2016.
 */
public abstract class Accessory implements Product {
	/**
	 * color of accessory
	 */
	private Color color;
	/**
	 * price of accessory in grn
	 */
	private double price;

	/**
	 * accessory constructor
     */
	public Accessory(Color color, double price) {
		this.color = color;
		this.price = price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Accessory " +
				"color " + color +
				", price = " + price;
	}

	/**
	 * possible colors for accessory
	 */
	public enum Color {
		RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET
	}
}


