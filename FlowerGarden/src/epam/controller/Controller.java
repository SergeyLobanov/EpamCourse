package epam.controller;

import epam.model.Bouquet;
import epam.view.View;

import java.util.Scanner;

/**
 * Created by Сергей on 01.06.2016.
 */
public class Controller {
	/**
	 * constant to check positive int
	 */
	public static final int ZERO_VALUE = 0;

	private Bouquet bouquet;
	private View view;
	
	public Controller(Bouquet bouquet, View view) {
		this.bouquet = bouquet;
		this.view = view;
	}

	/**
	 * main method for work
	 */
	public void processUser() {
		Scanner sc = new Scanner(System.in);
		
		view.printMessage(View.MAIN_MENU);
		
		int menuItem = enterIntValue(sc);
		/**
		 * menu for user
		 */
		switch (menuItem) {
			case MenuItem.FIRST_ITEM: //bouquet price
				bouquet.getBouquetPrice();
				processUser();
				break;
			case MenuItem.SECOND_ITEM: //sort by freshness
				bouquet.sortFlowersByFreshness();
				processUser();
				break;
			case MenuItem.THIRD_ITEM: //flowers by stem length from range
				view.printMessage(View.ENTER_RANGE);
				bouquet.findFlowersByStemLength(enterPositiveInt(sc), enterPositiveInt(sc));
				processUser();
				break;
			case MenuItem.FOURTH_ITEM: //print bouquet consist
				bouquet.printBouquetConsist();
				processUser();
				break;
			case MenuItem.FIFTH_ITEM: //end of work
				break;
			default:
				view.printMessage(View.WRONG_MENU_ITEM);
				processUser();
				break;
		}			
	}
	
	private int enterPositiveInt(Scanner sc) {
		int positiveInt = enterIntValue(sc);
		while (positiveInt < ZERO_VALUE) {
			view.printMessage(View.WRONG_INT);
			positiveInt = enterIntValue(sc);
		}
		return positiveInt;
	}
	
	private int enterIntValue(Scanner sc) {
		while( !sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_DATA);
            sc.next();
        }

        return sc.nextInt();		
	}
}