package by.savushkin.geekbrains;

import android.content.Intent;

public class Lesson {
    public String lName;
    public Intent lIntent;

    Lesson(String lName, Intent lIntent) {
        this.lName = lName;
        this.lIntent = lIntent;
    }
}
