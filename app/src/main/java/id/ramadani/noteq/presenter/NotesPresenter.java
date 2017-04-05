package id.ramadani.noteq.presenter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import id.ramadani.noteq.model.Note;
import id.ramadani.noteq.view.NotesView;

/**
 * Created by dani on 4/4/17.
 */

public class NotesPresenter {

    private final NotesView notesView;

    private DatabaseReference mNoteRef;
    private ChildEventListener mNoteChildListener;

    public NotesPresenter(NotesView notesView) {
        this.notesView = notesView;
    }

    public void onCreate() {
        mNoteRef = FirebaseDatabase.getInstance().getReference("notes");
    }

    public void onStart() {
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Note note = dataSnapshot.getValue(Note.class);
                notesView.addNoteToList(note);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mNoteRef.addChildEventListener(childEventListener);

        mNoteChildListener = childEventListener;
    }

    public void onStop() {
        if (mNoteChildListener != null) {
            mNoteRef.removeEventListener(mNoteChildListener);
        }
    }
}
