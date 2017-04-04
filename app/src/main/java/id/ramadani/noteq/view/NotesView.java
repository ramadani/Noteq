package id.ramadani.noteq.view;

import java.util.List;

import id.ramadani.noteq.model.Note;

/**
 * Created by dani on 4/4/17.
 */

public interface NotesView {
    void addNotesToList(List<Note> notes);

    void addNoteToList(Note note);
}
