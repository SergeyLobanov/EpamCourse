package epam;

import epam.controller.Controller;
import epam.model.Bouquet;
import epam.model.creators.AccessoriesCreator;
import epam.model.creators.FlowersCreator;
import epam.view.View;

/**
 * Created by Сергей on 01.06.2016.
 */
public class FlowerGardenMain {
    public static void main(String[] args) {
        Controller controller = new Controller(new Bouquet().createBouquet(), new View());
        controller.processUser();
    }
}
