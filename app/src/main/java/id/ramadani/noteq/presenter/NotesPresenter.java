package id.ramadani.noteq.presenter;

import java.util.ArrayList;

import id.ramadani.noteq.model.Note;
import id.ramadani.noteq.view.NotesView;

/**
 * Created by dani on 4/4/17.
 */

public class NotesPresenter {

    private final NotesView notesView;

    public NotesPresenter(NotesView notesView) {
        this.notesView = notesView;
    }

    public void onCreate() {
        ArrayList<Note> notes = new ArrayList<Note>();
        notes.add(new Note("Lorem Ipsum", "Lorem Ipsum Great Gan"));
        notes.add(new Note("Lorem Ipsum 2", "Lorem Ipsum Great Gan 2"));
        notes.add(new Note("Lorem Ipsum 3", "Lorem Ipsum Great Gan 3"));
        notes.add(new Note("Lorem Ipsum 4", "Lorem Ipsum Great Gan 4"));
        notes.add(new Note("Lorem Ipsum 5", "Lorem Ipsum Great Gan 5"));

        this.notesView.addNotesToList(notes);
    }
}
