package epam.model.accessory;

/**
 * Created by Сергей on 01.06.2016.
 */
public class Wrapper extends Accessory {
	/**
	 * height of wrapper
	 */
	private int wrapperHeight;
	/**
	 * width of wrapper
	 */
	private int wrapperWidth;

	/**
	 * wrapper constructor
     */
	public Wrapper(Color color, double price, int wrapperHeight, int wrapperWidth) {
		super(color, price);
		this.wrapperHeight = wrapperHeight;
		this.wrapperWidth = wrapperWidth;
	}

	public int getWrapperHeight() {
		return wrapperHeight;
	}

	public void setWrapperHeight(int wrapperHeight) {
		this.wrapperHeight = wrapperHeight;
	}

	public int getWrapperWidth() {
		return wrapperWidth;
	}

	public void setWrapperWidth(int wrapperWidth) {
		this.wrapperWidth = wrapperWidth;
	}

	@Override
	public String toString() {
		return super.toString() +
				" Wrapper height " + wrapperHeight +
				" width " + wrapperHeight;
	}
}
