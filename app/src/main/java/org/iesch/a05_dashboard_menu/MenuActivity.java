package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import org.iesch.a05_dashboard_menu.databinding.ActivityMenuBinding;
import org.iesch.a05_dashboard_menu.fragments.DetailMusicFragment;

public class MenuActivity extends AppCompatActivity {

    ActivityMenuBinding binding;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupMenuButtons();
    }



    private void setupMenuButtons() {
        binding.rellaySalir.setOnClickListener(view -> {
            SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor Obj_editor = preferencias.edit();

            Obj_editor.putString("email","");
            Obj_editor.putString("pass","");
            Obj_editor.commit();

            DetailMusicFragment.mediaPlayer.stop();

            Intent i = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(i);
        });
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
            Intent intent = new Intent(this, MusicListActivity.class);
            startActivity(intent);
        });
        binding.rellayMarcadorBaloncesto.setOnClickListener(v -> {
            Intent intent = new Intent(this, MarcadorBaloncestoActivity.class);
            startActivity(intent);
        });

    }
}