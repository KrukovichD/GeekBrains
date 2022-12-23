package by.savushkin.geekbrains.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import by.savushkin.geekbrains.R;

public class Lesson_1
        extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener {

    Switch lswitch;
    LinearLayout lin,
            linear;
    Button button;
    EditText firstEdit;
    ToggleButton toogle;

    List<CheckBox> check = new ArrayList<>();
    int[] colors = {Color.WHITE,
            Color.parseColor("#BB86FC"),
            Color.parseColor("#fffdd0"),
            Color.parseColor("#abcdef")};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        initViews();

        lswitch.setOnCheckedChangeListener(this);
        lin.setBackgroundColor(colors[0]);

        check.get(0).setOnCheckedChangeListener((buttonView, isChecked) ->
                OnCheckedChangeListener(buttonView));

        check.get(1).setOnCheckedChangeListener((buttonView, isChecked) ->
                OnCheckedChangeListener(buttonView));

        check.get(2).setOnCheckedChangeListener((buttonView, isChecked) ->
                OnCheckedChangeListener(buttonView));

        check.get(3).setOnCheckedChangeListener((buttonView, isChecked) ->
                OnCheckedChangeListener(buttonView));

        button.setOnClickListener(v -> {
            firstEdit.setText("");
        });

        finishActivity(0);
    }

    public void OnCheckedChangeListener(View view) {
        // Получаем флаг
        CheckBox checkBox = (CheckBox) view;
        // Получаем, отмечен ли данный флаг
        boolean checked = checkBox.isChecked();

        // Смотрим, какой именно из флажков отмечен
        switch (view.getId()) {
            case R.id.white:
                if (checked) {
                    setCheck(check.get(0));
                    setBackgraund(colors[0]);
                }
                break;
            case R.id.purple:
                if (checked) {
                    setCheck(check.get(1));
                    setBackgraund(colors[1]);
                }
                break;
            case R.id.cream:
                if (checked) {
                    setCheck(check.get(2));
                    setBackgraund(colors[2]);
                }
                break;
            case R.id.blue:
                if (checked) {
                    setCheck(check.get(3));
                    setBackgraund(colors[3]);
                }
                break;
            default:
                check.get(0).setChecked(true);
        }
    }


    private void initViews() {
        lswitch = findViewById(R.id.lswitch);
        lin = findViewById(R.id.lin);
        linear = findViewById(R.id.linear);

        check.add(findViewById(R.id.white));
        check.add(findViewById(R.id.purple));
        check.add(findViewById(R.id.cream));
        check.add(findViewById(R.id.blue));

        button = findViewById(R.id.button);
        firstEdit = findViewById(R.id.firstEdit);
        toogle = findViewById(R.id.toogle);

    }


    private void setCheck(CheckBox checkBox) {
        for (CheckBox box : check)
            if (box != checkBox)
                box.setChecked(false);
    }

    private void setBackgraund(int color) {
        lin.setBackgroundColor(color);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            lin.setVisibility(View.GONE);
            linear.setVisibility(View.VISIBLE);
        } else {
            lin.setVisibility(View.VISIBLE);
            linear.setVisibility(View.GONE);
        }
    }
}