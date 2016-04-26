import controller.Controller;
import model.Model;
import view.View;

/**
 * Created by Сергей on 23.04.2016.
 */
public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.playGame();
    }

}
