package id.ramadani.noteq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.ramadani.noteq.R;
import id.ramadani.noteq.model.Note;

/**
 * Created by dani on 4/4/17.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private Context mContext;
    private List<Note> mNotes;

    public NotesAdapter(Context context, List<Note> notes) {
        mContext = context;
        mNotes = notes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View noteView = inflater.inflate(R.layout.item_note, parent, false);

        ViewHolder viewHolder = new ViewHolder(noteView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = mNotes.get(position);

        holder.getTvTitle().setText(note.getTitle());
        holder.getTvContent().setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvContent;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_note_title);
            tvContent = (TextView) itemView.findViewById(R.id.tv_note_content);
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvContent() {
            return tvContent;
        }
    }
}
