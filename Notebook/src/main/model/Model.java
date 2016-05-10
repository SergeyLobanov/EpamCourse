package main.model;

import main.notebook.*;


/**
 * Created by Сергей on 03.05.2016.
 */
public class Model {
    /**
     * notebook to store data
     */
    private Notebook notebook;

    /**
     * create empty notebook
     */
    public void createNotebook() {
        notebook = new Notebook();
    }

    /**
     * add note to notebook
     * @param note that added
     */
    public void addNote(Note note) {
        notebook.addNote(note);
    }

    /**
     * create and add note to notebook
     */
    public void createNote(String surname, String name, String middleName,
                           String nickname, String comment, SubscriberGroup group,
                           String homeNumber, String mobileNumber, String email,
                           String skype, String addressIndex, String city,
                           String street, String houseNumber, String apartmentNumber,
                           String creationDate, String lastChangeDate) {
        addNote(new Note(surname, name, middleName, nickname, comment, group,
                homeNumber, mobileNumber, email, skype, addressIndex, city, street,
                houseNumber, apartmentNumber, creationDate, lastChangeDate));

    }



}
