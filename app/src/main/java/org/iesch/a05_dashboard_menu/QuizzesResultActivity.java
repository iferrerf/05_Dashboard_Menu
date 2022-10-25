package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.iesch.a05_dashboard_menu.databinding.ActivityQuizzesResultBinding;

public class QuizzesResultActivity extends AppCompatActivity {

    private ActivityQuizzesResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes_result);
        setTitle(R.string.quizzes_title);

        binding = ActivityQuizzesResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        String mensaje = extras.getString("mensaje");

        binding.tvRespuesta.setText(mensaje);

        binding.btnNext.setOnClickListener(view -> {
            finish();
        });

    }
}