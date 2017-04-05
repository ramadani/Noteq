package id.ramadani.noteq.presenter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import id.ramadani.noteq.model.Note;
import id.ramadani.noteq.view.NotesView;

/**
 * Created by dani on 4/4/17.
 */

public class NotesPresenter {

    private final NotesView notesView;

    private DatabaseReference mNoteRef;
    private ValueEventListener mNotesListerner;

    public NotesPresenter(NotesView notesView) {
        this.notesView = notesView;
    }

    public void onCreate() {
        mNoteRef = FirebaseDatabase.getInstance().getReference("notes");
    }

    public void onStart() {
        ValueEventListener notesListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Note> notes = new ArrayList<Note>();

                for (DataSnapshot noteSnapshot: dataSnapshot.getChildren()) {
                    Note note = noteSnapshot.getValue(Note.class);
                    notes.add(note);
                }

                notesView.addNotesToList(notes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mNoteRef.addValueEventListener(notesListener);

        mNotesListerner = notesListener;
    }

    public void onStop() {
        if (mNotesListerner != null) {
            mNoteRef.removeEventListener(mNotesListerner);
        }
    }
}
