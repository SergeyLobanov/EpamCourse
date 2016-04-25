package model;

import controller.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Сергей on 23.04.2016.
 */
public class Model {
    private int randomValue;
    private int minValue = 0;
    private int maxValue = Controller.RAND_MAX;
    private List<Integer> userAttempts;

    // The Program logic
    public int rand() {
        return rand(0, Controller.RAND_MAX);
    }

    public int rand(int min, int max) {
        Random random = new Random();
        userAttempts = new LinkedList<>();
        randomValue = random.nextInt(max - min + 1) + min;
        return randomValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue + 1;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue - 1;
    }

    public void addAttempt(int value) {
        userAttempts.add(value);
    }

    public int getRandomValue() {
        return randomValue;
    }

    public List<Integer> getUserAttempts() {
        return userAttempts;
    }

    public int getLastAttempt() {
        return userAttempts.get(userAttempts.size()-1);
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getNumberOfUserAttempts() {
        return userAttempts.size();
    }

}
