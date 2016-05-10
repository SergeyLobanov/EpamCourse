package main;

import main.controller.Controller;
import main.model.Model;
import main.view.View;

/**
 * Created by Сергей on 03.05.2016.
 */
public class Main {
    // Initialization
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.notebookWork();
    }

}
