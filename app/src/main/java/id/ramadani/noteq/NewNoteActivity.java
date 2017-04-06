package id.ramadani.noteq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.ramadani.noteq.presenter.NotePresenter;

public class NewNoteActivity extends AppCompatActivity {

    private static final String TAG = NewNoteActivity.class.getSimpleName();

    private NotePresenter mNotePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        mNotePresenter = new NotePresenter();

        final EditText etNoteTitle = (EditText) findViewById(R.id.et_note_title);
        final EditText etNoteContent = (EditText) findViewById(R.id.et_note_content);
        Button btnNoteSave = (Button) findViewById(R.id.btn_note_submit);

        btnNoteSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etNoteTitle.getText().toString();
                String content = etNoteContent.getText().toString();

                mNotePresenter.create(title, content);

                onBackPressed();
            }
        });
    }
}
