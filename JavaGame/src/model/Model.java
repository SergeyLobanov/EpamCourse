package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * Created by Сергей on 23.04.2016.
 */
public class Model {
    /** randomValue is generated at the start of game*/
    private int randomValue;
    /** minValue is lower border to guess*/
    private int minValue;
    /** maxValue is higher border to guess*/
    private int maxValue;
    /** userAttempts list storing users previous enters*/
    private List<Integer> userAttempts;

    /** Model default constructor*/
    public Model() {
        randomValue = 0;
        minValue = 0;
        maxValue = 0;
        userAttempts = new LinkedList<>();
    }

    /**
     * default rand method that generates int random value from default range
     * @return the randomly generated value
     */
    public int rand() {
        return rand(GlobalVariables.RAND_MIN, GlobalVariables.RAND_MAX);
    }

    /** rand method that generates int random value from range between min and max values
     *
     * @param min int value of lower border
     * @param max int value of higher border
     * @return the randomly generated value
     */
    public int rand(int min, int max) {
        Random random = new Random();
        setMinValue(min);
        setMaxValue(max);

        randomValue = random.nextInt(max - min + 1) + min;

        return randomValue;
    }

    /**
     * set min value (included)
     * @param minValue int value of lower border (excluded)
     */
    public void setMinValue(int minValue) {
        this.minValue = minValue + 1;
    }

    /**
     * set max value (included)
     * @param maxValue int value of higher border (excluded)
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue - 1;
    }

    /**
     * add correct user attempt to attempts list
     * @param value user assumption
     */
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
