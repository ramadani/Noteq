package id.ramadani.noteq.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by dani on 4/4/17.
 */

@IgnoreExtraProperties
public class Note {
    private String title;
    private String content;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
