package epam.model.flower;

/**
 * Created by Сергей on 01.06.2016.
 */
public class TreesFlower extends Flower {
	/**
	 * name of tree flower
	 */
	private TreeName treeName;

	public TreesFlower(double price, int stemLength, int freshness, TreeName treeName) {
		super(price, stemLength, freshness);
		this.treeName = treeName;
	}

	@Override
	public String toString() {
		return "Type - Tree Flower: " + super.toString() +
				" tree name " + treeName.name();
	}

	/**
	 * different names of tree flowers
	 */
	public enum TreeName {
		CHESTNUT, HIBISCUS, APRICOT, SAKURA
	}
}
