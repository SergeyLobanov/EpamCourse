package epam.model;

import epam.model.accessory.Accessory;
import epam.model.creators.AccessoriesCreator;
import epam.model.creators.FlowersCreator;
import epam.model.flower.Flower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Сергей on 01.06.2016.
 */
public class Bouquet {
	/**
	 * list of flowers in bouquet
	 */
	private List<Flower> flowers;
	/**
	 * list of accessories in bouquet
	 */
	private List<Accessory> accessories;
	
	public Bouquet() {
		this.flowers = new ArrayList<>();
		this.accessories = new ArrayList<>();
	}
	
	public Bouquet(List<Flower> flowers, List<Accessory> accessories) {
		this.flowers = flowers;
		this.accessories = accessories;
	}
	
	public Bouquet(List<Flower> flowers) {
		this(flowers, new ArrayList<Accessory>());
	}

	/**
	 * stub for bouquet creating
	 */
	public Bouquet createBouquet(){
		return new Bouquet(new FlowersCreator().getFlowers(),
				new AccessoriesCreator().getAccessories());
	}


	/**
	 * print full consist of bouquet
	 */
	public void printBouquetConsist() {
		for(Flower flower : this.getFlowers()) {
			System.out.println(flower);
		}
		for(Accessory accessory : this.getAccessories()) {
			System.out.println(accessory);
		}
	}

	/**
	 * calculate full price of bouquet
	 * @return bouquet price
     */
	public double getBouquetPrice() {
		double bouquetPrice = 0;
		for(Flower flower : flowers) {
			bouquetPrice += flower.getPrice();
		}
		for(Accessory accessory : accessories) {
			bouquetPrice += accessory.getPrice();
		}
		System.out.println(bouquetPrice);
		return bouquetPrice;
	}

	/**
	 * sort flowers in bouquet by freshness and print them
	 */
	public void sortFlowersByFreshness() {
		Collections.sort(flowers, new Comparator<Flower>() {
			@Override
			public int compare(Flower flower1, Flower flower2) {
				return flower1.getFreshness() - flower2.getFreshness();
			}
		});
		// Collections.sort(flowers, (flower1, flower2) -> flower1.getFreshness() - flower2.getFreshness());
		for(Flower flower : flowers) {
			System.out.println(flower);
		}
	}


	/**
	 * print flowers by stem length from range
	 * @param fromLength lower edge
	 * @param toLength higher length
	 * @return list of suitable flowers
	 */
	public List<Flower> findFlowersByStemLength(double fromLength, double toLength) {
		List<Flower> resultFlowers = new ArrayList<>();
		double min = Math.min(fromLength, toLength);
		double max = Math.max(fromLength, toLength);
		
		for(Flower flower : flowers) {
			if(flower.getStemLength() >= min && flower.getStemLength() <= max) {
				resultFlowers.add(flower);
			}
		}

		for(Flower flower : resultFlowers) {
			System.out.println(flower);
		}
		
		return resultFlowers;
	}

	public void addFlower(Flower flower) {
		flowers.add(flower);
	}
	
	public void addAccessory(Accessory accessory) {
		accessories.add(accessory);
	}

	public List<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

	public List<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}

	@Override
	public String toString() {
		return "Bouquet contains " +
				"flowers " + flowers +
				"and accessories " + accessories +
				" full price " + getBouquetPrice();
	}
}