package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizzesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);
        setTitle(R.string.quizzes_title);
    }
}