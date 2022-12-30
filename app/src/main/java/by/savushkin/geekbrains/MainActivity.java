package by.savushkin.geekbrains;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

import by.savushkin.geekbrains.lesson1.Lesson_1;
import by.savushkin.geekbrains.lesson2.Lesson_2;
import by.savushkin.geekbrains.recycler.Lessons_RecViewAdapter;
import by.savushkin.geekbrains.recycler.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {
    List<Lesson> lessons = new ArrayList<>();
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        Lessons_RecViewAdapter adapter = new Lessons_RecViewAdapter(this, lessons);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        startActivity(lessons.get(position).lIntent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }

    private void initViews() {
        exit = findViewById(R.id.exit);

        lessons.add(new Lesson("1 урок",
                new Intent(this, Lesson_1.class)));

        lessons.add(new Lesson("2 - 4 уроки",
                new Intent(this, Lesson_2.class)));

    }
}

