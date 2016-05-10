package main.notebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Notebook to store notes about subscribers
 * Created by Сергей on 03.05.2016.
 */
public class Notebook {

    /**
     * list of notes in notebook
     */
    private List<Note> notes;

    /**
     * Notebook constructor
     */
    public Notebook() {
        notes = new ArrayList<>();
    }

    /**
     * add note to notebook
     */
    public boolean addNote(Note note) {
        if (note == null) {
            return false;
        }
        notes.add(note);
        return true;
    }



}
