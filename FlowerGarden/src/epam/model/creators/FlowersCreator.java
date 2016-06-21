package epam.model.creators;

import epam.model.flower.GroundFlower;
import epam.model.flower.Flower;
import epam.model.flower.TreesFlower;

import java.util.ArrayList;
import java.util.List;

/**
 * Class creates list of flowers for bouquet
 * Created by Сергей on 01.06.2016.
 */
public class FlowersCreator {
	/**
	 * list of flowers
	 */
	private List<Flower> flowers;
	
	public FlowersCreator() {
		flowers = new ArrayList<>();
		flowers.add(new GroundFlower(17, 200, 8, GroundFlower.FlowerName.ROSE));
		flowers.add(new GroundFlower(10, 270, 10, GroundFlower.FlowerName.TULIP));
		flowers.add(new GroundFlower(19.5, 230, 4, GroundFlower.FlowerName.ROSE));
		flowers.add(new TreesFlower(45, 50, 9, TreesFlower.TreeName.SAKURA));
		flowers.add(new TreesFlower(15, 75, 7, TreesFlower.TreeName.HIBISCUS));
		flowers.add(new GroundFlower(40, 310, 5, GroundFlower.FlowerName.LILY));
		flowers.add(new GroundFlower(23.25, 185, 5, GroundFlower.FlowerName.CAMOMILE));
	}
	
	public List<Flower> getFlowers() {
		return flowers;
	}
}