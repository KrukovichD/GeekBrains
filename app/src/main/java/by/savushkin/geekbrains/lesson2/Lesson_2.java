package by.savushkin.geekbrains.lesson2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import by.savushkin.geekbrains.R;

public class Lesson_2
        extends AppCompatActivity {
    static final String KEY = "KEY";


    TextView calc_view;
    private Calc calc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            getSupportActionBar().hide();
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            // In portrait
            getSupportActionBar().show();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        View.OnClickListener listener = v -> {
            Button button = (Button) v;
            String numInter = button.getText().toString();
            String visible = calc.numHandler(numInter);
            calc_view.setText(String.valueOf(visible));
        };

        View.OnClickListener operListener = view -> {
            Button operButton = (Button) view;
            String operInter = operButton.getText().toString();
            String visible = calc.operHandler(operInter);
            calc_view.setText(String.valueOf(visible));

        };

        init(listener, operListener);

        if (savedInstanceState != null) {
            calc = savedInstanceState.getParcelable(KEY);
        } else
            calc = new Calc();
        calc_view.setText(String.valueOf(calc.getVisible()));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outstate) {
        outstate.putParcelable(KEY, calc);
        super.onSaveInstanceState(outstate);
    }


    private void init(View.OnClickListener listener, View.OnClickListener operListener) {
        //TextView
        calc_view = findViewById(R.id.calc_view);

        //Button
        findViewById(R.id.butt_delete).setOnClickListener(operListener);
        findViewById(R.id.butt_percent).setOnClickListener(operListener);
        findViewById(R.id.butt_division).setOnClickListener(operListener);
        findViewById(R.id.butt_minus).setOnClickListener(operListener);
        findViewById(R.id.butt_equals).setOnClickListener(operListener);
        findViewById(R.id.butt_plus).setOnClickListener(operListener);
        findViewById(R.id.butt_X).setOnClickListener(operListener);
        findViewById(R.id.butt_С).setOnClickListener(operListener);

        findViewById(R.id.butt_0).setOnClickListener(listener);
        findViewById(R.id.butt_1).setOnClickListener(listener);
        findViewById(R.id.butt_2).setOnClickListener(listener);
        findViewById(R.id.butt_3).setOnClickListener(listener);
        findViewById(R.id.butt_4).setOnClickListener(listener);
        findViewById(R.id.butt_5).setOnClickListener(listener);
        findViewById(R.id.butt_6).setOnClickListener(listener);
        findViewById(R.id.butt_7).setOnClickListener(listener);
        findViewById(R.id.butt_8).setOnClickListener(listener);
        findViewById(R.id.butt_9).setOnClickListener(listener);
        findViewById(R.id.butt_dot).setOnClickListener(listener);

    }
}