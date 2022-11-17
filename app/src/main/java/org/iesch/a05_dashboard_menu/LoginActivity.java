package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextEmail, editTexPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_Entrar);
        editTextEmail = findViewById(R.id.editText_email);
        editTexPassword = findViewById(R.id.editText_password);

        // 1 - Al iniciar la Aplicacion debe mostrar lo que tiene GUARDADO en el archivo SharedPrefrences
        //Obtengo los valores que se han creado previamente
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);

        if (preferencias.getString("email","") != ""){
            Intent i = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(i);
        }

        // 2 - Escribimos las referencias que hemos obtenido en el valor que buscamos
        // El par de comillas vacío es el valor inicial EN CASO DE QUE NO HAYA NINGÚN VALOR
        editTextEmail.setText(preferencias.getString("email", ""));
        editTexPassword.setText(preferencias.getString("pass", ""));

        btnLogin.setOnClickListener(view -> {
            // Guardamos en variables el contenido de los editTexto
            String email = editTextEmail.getText().toString();
            String password = editTexPassword.getText().toString();

            // Mensajes de error si los campos estan vacios
            // Sino llamamos al metodo que guarda las preferencias y abre el MenuActivity
            if (email.isEmpty()){
                Toast.makeText(this, "Debes insertar una dirección email", Toast.LENGTH_SHORT).show();
            }else if (password.isEmpty()){
                Toast.makeText(this, "Debes insertar una contraseña", Toast.LENGTH_SHORT).show();
            }else guardar(email, password);
        });

    }

    private void guardar(String email, String password) {
        // En este método he de crear el objeto nuevamente
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        // Editor es la clase que me sirve para modificar este archivo
        SharedPreferences.Editor Obj_editor = preferences.edit();
        // Indicamos que se guarde el texto recogido de los editText
        Obj_editor.putString("email", email);
        Obj_editor.putString("pass", password);

        //Commit confirma que lo que acabamoos de recuperar arriba lo queremos GUARDAR.
        // Sin commit no guarda nada en SharedPreferences
        Obj_editor.commit();

        // Mensaje para el usuario
        Toast.makeText(this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();

        // Abrimos MenuActivity
        Intent i = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(i);

    }
}