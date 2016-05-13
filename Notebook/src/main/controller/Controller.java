package main.controller;

import main.model.Model;
import main.notebook.SubscriberGroup;
import main.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Сергей on 03.05.2016.
 */
public class Controller {
    // The Regex
    //Name
    public static final String REGEX_NAME = "[A-Z]{1}[a-z]+";
    public static final String REGEX_NICKNAME = "\\w+";
    public static final String REGEX_COMMENT = ".*";
    public static final String REGEX_GROUP = "\\d{1}";
    // «1234567»
    public static final String REGEX_HOME_PHONE = "\\d{5,9}";
    // «+38(044)555-55-55»
    public static final String REGEX_MOBILE_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    // «nick@mail.com»
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    public static final String REGEX_SKYPE = "\\w+";
    public static final String REGEX_INDEX = "\\d{5}+";
    public static final String REGEX_HOUSE_NUMBER = "\\d{1,3}+";
    public static final String REGEX_APARTMENT_NUMBER = "\\d{1,4}+";
    public static final String REGEX_DATE = "\\d{2}\\.\\d{2}\\.\\d{4}";

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void notebookWork(){
        Scanner sc = new Scanner(System.in);

        model.createNotebook();
        view.printMessage(View.APP_TITLE);
        String surname = enterStringByPattern(sc, REGEX_NAME, View.NAME);
        String name = enterStringByPattern(sc, REGEX_NAME, View.SURNAME);
        String middleName = enterStringByPattern(sc, REGEX_NAME, View.MIDDLE_NAME);
        String nickname = enterStringByPattern(sc, REGEX_NICKNAME, View.NICKNAME);
        String comment = enterStringByPattern(sc, REGEX_COMMENT, View.COMMENT);
        SubscriberGroup group =
                SubscriberGroup.getName(Integer.valueOf(enterStringByPattern(sc, REGEX_GROUP, View.GROUP)));
        String homeNumber = enterStringByPattern(sc, REGEX_HOME_PHONE, View.HOME_PHONE);
        String mobileNumber = enterStringByPattern(sc, REGEX_MOBILE_PHONE, View.MOBILE_NUMBER);
        String email = enterStringByPattern(sc, REGEX_MAIL, View.EMAIL);
        String skype = enterStringByPattern(sc, REGEX_SKYPE, View.SKYPE);
        String addressIndex = enterStringByPattern(sc, REGEX_INDEX, View.INDEX);
        String city = enterStringByPattern(sc, REGEX_NAME, View.CITY);
        String street = enterStringByPattern(sc, REGEX_NAME, View.STREET);
        String houseNumber = enterStringByPattern(sc, REGEX_HOUSE_NUMBER, View.HOUSE_NUMBER);
        String apartmentNumber = enterStringByPattern(sc, REGEX_APARTMENT_NUMBER, View.APARTMENT);
        String creationDate = enterStringByPattern(sc, REGEX_DATE, View.DATE);
        String lastChangeDate = enterStringByPattern(sc, REGEX_DATE, View.DATE);
        model.createNote(surname, name, middleName, nickname, comment, group,
                homeNumber, mobileNumber, email, skype, addressIndex, city, street,
                houseNumber, apartmentNumber, creationDate, lastChangeDate);
    }

    public String enterStringByPattern(Scanner sc, String pattern, String dataType) {
        view.printMessage(View.INPUT_DATA, dataType);
        String temp = sc.next();

        while(!isFitsPattern(temp, pattern)) {
            view.printMessage(View.WRONG_INPUT_DATA_PATTERN, pattern);
            temp = sc.next();
        }

        return temp;
    }

    public static boolean isFitsPattern(String input, String pattern) {
        Pattern pat = Pattern.compile(pattern);
        Matcher matcher = pat.matcher(input);
        return matcher.matches();
    }
}
