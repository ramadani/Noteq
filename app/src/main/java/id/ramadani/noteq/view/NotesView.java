package id.ramadani.noteq.view;

import java.util.List;

import id.ramadani.noteq.model.Note;

/**
 * Created by dani on 4/4/17.
 */

public interface NotesView {
    void refreshNoteList(List<Note> notes);
}
