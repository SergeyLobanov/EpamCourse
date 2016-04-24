package controller;

import model.Model;
import view.View;

import java.util.Scanner;

/**
 * Created by Сергей on 23.04.2016.
 */
public class Controller {
    // The Constants
    public static final int RAND_MAX = 100;
    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void playGame() {
        view.printMessage(View.GAME_TITLE);

        model.rand();

        Scanner sc = new Scanner(System.in);
        model.addAttempt(enterAssumption(sc));

        while (model.getRandomValue() != model.getLastAttempt()) {
            compareWithRandom();
            view.printMessageAndAttempts(View.USER_VARIANTS, model.getUserAttempts());
            model.addAttempt(enterAssumption(sc));
        }

        endOfGame();
    }

    public void compareWithRandom() {
        if (model.getLastAttempt() < model.getRandomValue()) {
            view.printMessage(View.LESS_THAN_RANDOM);
            model.setMinValue(model.getLastAttempt());
        }
        else if (model.getLastAttempt() > model.getRandomValue()){
            view.printMessage(View.MORE_THAN_RANDOM);
            model.setMaxValue(model.getLastAttempt());
        }
    }

    public void endOfGame() {
        view.printMessageAndInt(View.CORRECT_ANSWER, model.getLastAttempt());
        view.printMessageAndAttempts(View.USER_VARIANTS, model.getUserAttempts());
        view.printMessageAndInt(View.ATTEMPTS_NUMBER, model.getNumberOfUserAttempts());
    }

    public int enterAssumption(Scanner sc) {
        int assumption = inputIntValueWithScanner(sc);
        while (assumption < model.getMinValue() || assumption > model.getMaxValue()) {
            view.printMessage(View.WRONG_RANGE);
            assumption = inputIntValueWithScanner(sc);
        }
        return assumption;
    }

    // The Utility methods
    public int inputIntValueWithScanner(Scanner sc) {
        view.printValidRange(View.RANGE_VALUES, model.getMinValue(), model.getMaxValue());
        view.printMessage(View.USER_INPUT);

        while( !sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_DATA);
            sc.next();
        }

        return sc.nextInt();
    }
}
