package by.savushkin.geekbrains.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import by.savushkin.geekbrains.Lesson;
import by.savushkin.geekbrains.R;

public class Lessons_RecViewAdapter extends RecyclerView.Adapter<Lessons_RecViewAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Lesson> lessons;

    public Lessons_RecViewAdapter(Context context, List<Lesson> lessons) {
        this.inflater = LayoutInflater.from(context);
        this.lessons = lessons;
    }

    @Override
    public Lessons_RecViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.less_item, parent, false);
        return new Lessons_RecViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rTextView.setText(lessons.get(position).lName);
    }


    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView rTextView;
        final CardView rCardView;

        ViewHolder(View view) {
            super(view);
            rTextView = view.findViewById(R.id.rTextView);
            rCardView = view.findViewById(R.id.rCardView);


        }
    }
}
