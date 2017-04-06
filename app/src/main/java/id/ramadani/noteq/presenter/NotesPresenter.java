package id.ramadani.noteq.presenter;

import android.util.Log;

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

    private static final String TAG = NotesPresenter.class.getSimpleName();
    
    private final NotesView notesView;

    private DatabaseReference mNoteRef;
    private ValueEventListener mNotesEventListener;

    public NotesPresenter(NotesView notesView) {
        this.notesView = notesView;
    }

    public void onCreate() {
        mNoteRef = FirebaseDatabase.getInstance().getReference("notes");
    }

    public void onStart() {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Note> notes = new ArrayList<Note>();

                for (DataSnapshot noteSnapshot: dataSnapshot.getChildren()) {
                    Note note = noteSnapshot.getValue(Note.class);
                    notes.add(note);
                }

                notesView.refreshNoteList(notes);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };

        mNoteRef.orderByKey().addValueEventListener(valueEventListener);

        mNotesEventListener = valueEventListener;
    }

    public void onStop() {
        if (mNotesEventListener != null) {
            mNoteRef.removeEventListener(mNotesEventListener);
        }
    }
}
