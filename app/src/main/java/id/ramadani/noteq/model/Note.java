package id.ramadani.noteq.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by dani on 4/4/17.
 */

@IgnoreExtraProperties
public class Note {

    private String key;
    private String title;
    private String content;

    public Note() {
    }

    public Note(String key, String title, String content) {
        this.key = key;
        this.title = title;
        this.content = content;
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
