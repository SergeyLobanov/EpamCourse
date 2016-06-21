package epam.model.flower;

/**
 * Flowers that grows in fields from ground
 * Created by Сергей on 01.06.2016.
 */
public class GroundFlower extends Flower{
	/**
	 * name of ground flower
	 */
	private FlowerName flowerName;

	public GroundFlower(double price, int stemLength, int freshness, FlowerName flowerName) {
		super(price, stemLength, freshness);
		this.flowerName = flowerName;
	}

	public FlowerName getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(FlowerName flowerName) {
		this.flowerName = flowerName;
	}

	@Override
	public String toString() {
		return "Type - Ground Flower: " + super.toString() +
				" flowerName " + flowerName.name();
	}

	/**
	 * different names of ground flowers
	 */
	public enum FlowerName {
		ROSE, LILY, TULIP, CAMOMILE
	}
}
