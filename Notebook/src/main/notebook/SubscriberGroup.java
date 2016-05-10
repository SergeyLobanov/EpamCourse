package main.notebook;

/**
 * Created by Сергей on 03.05.2016.
 */
public enum SubscriberGroup {
    FAMILY(1), FRIENDS(2), COLLEAGUES(3), SCHOOL_FRIENDS(4), UNIVERSITY_FRIENDS(5);
    int value;

    SubscriberGroup(int value) {
        this.value = value;
    }
    public static SubscriberGroup getName(int value) {
        switch (value) {
            case 1:
                return FAMILY;
            case 2:
                return FRIENDS;
            case 3:
                return COLLEAGUES;
            case 4:
                return SCHOOL_FRIENDS;
            case 5:
                return UNIVERSITY_FRIENDS;
        }
        return null;
    }
}
