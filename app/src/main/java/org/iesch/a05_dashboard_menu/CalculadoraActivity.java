package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CalculadoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        setTitle(R.string.calculator_title);
    }
}