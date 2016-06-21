package epam.model.creators;

import epam.model.accessory.Accessory;
import epam.model.accessory.Accompaniment;
import epam.model.accessory.Ribbon;
import epam.model.accessory.Wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Class creates list of accessories for bouquet
 * Created by Сергей on 01.06.2016.
 */
public class AccessoriesCreator {
	/**
	 * list of accessories
	 */
	private List<Accessory> accessories;
	
	public AccessoriesCreator() {
		accessories = new ArrayList<>();
		accessories.add(new Ribbon(Accessory.Color.RED, 2.0, 350));
		accessories.add(new Wrapper(Accessory.Color.GREEN, 4.50, 250, 300));
		accessories.add(new Accompaniment(Accessory.Color.YELLOW, 0.75, Accompaniment.AccompanimentName.STAR));
		accessories.add(new Accompaniment(Accessory.Color.VIOLET, 1.25, Accompaniment.AccompanimentName.SHELL));
		accessories.add(new Ribbon(Accessory.Color.BLUE, 1.0, 200));
	}
	
	public List<Accessory> getAccessories() {
		return accessories;
	}
	
}