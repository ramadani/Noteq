package id.ramadani.noteq.presenter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import id.ramadani.noteq.model.Note;

/**
 * Created by dani on 4/6/17.
 */

public class NotePresenter {

    private DatabaseReference mNoteRef;

    public NotePresenter() {
        mNoteRef = FirebaseDatabase.getInstance().getReference("notes");
    }

    public void create(String title, String content) {
        String key = mNoteRef.push().getKey();
        Note note = new Note(key, title, content);

        mNoteRef.child(key).setValue(note);
    }
}
