package epam.model.accessory;

/**
 * Created by Сергей on 01.06.2016.
 */
public class Ribbon extends Accessory {
	/**
	 * ribbon length in mm
	 */
	private int ribbonLength;

	/**
	 * ribbon constructor
     */
	public Ribbon(Color color, double price, int ribbonLength) {
		super(color, price);
		this.ribbonLength = ribbonLength;
	}

	public int getRibbonLength() {
		return ribbonLength;
	}

	public void setRibbonLength(int ribbonLength) {
		this.ribbonLength = ribbonLength;
	}

	@Override
	public String toString() {
		return super.toString() +
				" Ribbon length " + ribbonLength;
	}
}
