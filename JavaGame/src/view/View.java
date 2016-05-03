package view;

import java.util.List;

/**
 * Created by Сергей on 23.04.2016.
 */
public class View {
    // Text's constants
    public static final String GAME_TITLE = "Java Game: More or Less";
    public static final String RANGE_VALUES = "Valid range [min; max]: ";
    public static final String USER_INPUT = "Enter your assumption (INT value from range): ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String WRONG_RANGE = "Invalid input! Enter INT value from range! ";
    public static final String LESS_THAN_RANDOM = "Your variant less than given number, try again.";
    public static final String MORE_THAN_RANDOM = "Your variant more than given number, try again.";
    public static final String CORRECT_ANSWER = "Congratulations! You have guessed it! Our number is: ";
    public static final String USER_VARIANTS = "Your variants: ";
    public static final String ATTEMPTS_NUMBER = "You have used attempts: ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndInt(String message, int value){
        System.out.println(message + value);
    }

    public void printMessageAndAttempts(String message, List<Integer> attempts) {
        System.out.println(message + attempts);
    }

    public void printValidRange(String message, int min, int max){
        System.out.println(message + "[" + min + ";" + max + "]");
    }


}
