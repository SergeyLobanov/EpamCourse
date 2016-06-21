package epam.model.accessory;

/**
 * Created by Сергей on 01.06.2016.
 */
public class Accompaniment extends Accessory {
	/**
	 * name of accompaniment
	 */
	private AccompanimentName accName;

	/**
	 * accompaniment constructor
     */
	public Accompaniment(Color color, double price, AccompanimentName accName) {
		super(color, price);
		this.accName = accName;
	}

	public AccompanimentName getAccName() {
		return accName;
	}

	public void setAccName(AccompanimentName accName) {
		this.accName = accName;
	}

	@Override
	public String toString() {
		return super.toString() +
				" Accompaniment name " + accName.name();
	}

	/**
	 * possible accompaniment names
	 */
	public enum AccompanimentName {
		STAR, SHELL, BALL
	}
}
