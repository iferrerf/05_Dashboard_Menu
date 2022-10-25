    package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.iesch.a05_dashboard_menu.databinding.ActivityMenuBinding;

    public class MenuActivity extends AppCompatActivity {

        ActivityMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupMenuButtons();
    }

        private void setupMenuButtons() {
            binding.rellayCalculadora.setOnClickListener(v -> {
                Intent intent = new Intent(this, CalculadoraActivity.class);
                startActivity(intent);
            });
            binding.rellayAmigos.setOnClickListener(v -> {
                Intent intent = new Intent(this, UsersActivity.class);
                startActivity(intent);
            });
            binding.rellayPerrete.setOnClickListener(v -> {
                Intent intent = new Intent(this, EdadCaninaActivity.class);
                startActivity(intent);
            });
            binding.rellayQuizzes.setOnClickListener(v -> {
                Intent intent = new Intent(this, QuizzesActivity.class);
                startActivity(intent);
            });
            binding.rellayGaleria.setOnClickListener(v -> {
                Intent intent = new Intent(this, GaleriaActivity.class);
                startActivity(intent);
            });
            binding.rellayMapas.setOnClickListener(v -> {
                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
            });
            binding.rellayRestaurantes.setOnClickListener(v -> {
                Intent intent = new Intent(this, RestaurantesActivity.class);
                startActivity(intent);
            });
            binding.rellaySettings.setOnClickListener(v -> {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
            });
            binding.rellayUser.setOnClickListener(v -> {
                Intent intent = new Intent(this, ProgrammerActivity.class);
                startActivity(intent);
            });
            binding.rellayMarcadorBaloncesto.setOnClickListener(v -> {
                Intent intent = new Intent(this, MarcadorBaloncestoActivity.class);
                startActivity(intent);
            });

    }
}