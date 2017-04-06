package id.ramadani.noteq;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import id.ramadani.noteq.adapter.NotesAdapter;
import id.ramadani.noteq.model.Note;
import id.ramadani.noteq.presenter.NotesPresenter;
import id.ramadani.noteq.util.MarginItemDecoration;
import id.ramadani.noteq.view.NotesView;

public class MainActivity extends AppCompatActivity implements NotesView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRvNotes;
    private NotesAdapter mNotesAdapter;
    private ArrayList<Note> mNotes;
    private NotesPresenter mNotesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "klik floating action button");

                Intent intent = new Intent(view.getContext(), NewNoteActivity.class);
                startActivity(intent);
            }
        });

        mRvNotes = (RecyclerView) findViewById(R.id.rv_note);
        mNotes = new ArrayList<Note>();
        mNotesAdapter = new NotesAdapter(this, mNotes);
        mNotesPresenter = new NotesPresenter(this);

        int itemMargin = getResources().getDimensionPixelSize(R.dimen.item_margin);
        mRvNotes.addItemDecoration(new MarginItemDecoration(itemMargin));
        mRvNotes.setAdapter(mNotesAdapter);
        mRvNotes.setLayoutManager(new LinearLayoutManager(this));

        mNotesPresenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mNotesPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();

        mNotesPresenter.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void refreshNoteList(List<Note> notes) {
        mNotes.clear();
        mNotes.addAll(notes);
        mNotesAdapter.notifyDataSetChanged();
    }
}
