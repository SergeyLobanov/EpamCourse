package main.view;

/**
 * Created by Сергей on 03.05.2016.
 */
public class View {
    public static final String APP_TITLE = "Work with notebook is started";
    public static final String INPUT_DATA = "Input note data:";
    public static final String WRONG_INPUT_DATA_PATTERN = "Wrong input! Repeat please! " +
            "Your enter should fits the pattern: ";
    public static final String NAME = " name";
    public static final String SURNAME = " surname";
    public static final String MIDDLE_NAME = " middle name";
    public static final String NICKNAME = " nickname";
    public static final String COMMENT = " comment";
    public static final String GROUP = " subscriber group(ID):\n1. Family\n2. Friends\n" +
            "3. Colleagues\n4. School friends\n5. University friends";
    public static final String HOME_PHONE = " home phone number";
    public static final String MOBILE_NUMBER = " mobile phone number";
    public static final String EMAIL = " email";
    public static final String SKYPE = " skype";
    public static final String INDEX = " address index";
    public static final String CITY = " city";
    public static final String STREET = " street";
    public static final String HOUSE_NUMBER = " house number";
    public static final String APARTMENT = " apartment number";
    public static final String DATE = " date";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessage(String message, String pattern){
        System.out.println(message + pattern);
    }
}
