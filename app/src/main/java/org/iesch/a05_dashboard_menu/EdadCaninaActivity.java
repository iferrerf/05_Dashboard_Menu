package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.iesch.a05_dashboard_menu.databinding.ActivityEdadCaninaBinding;

public class EdadCaninaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edad_canina);
        setTitle(R.string.edadCanina_title);

        ActivityEdadCaninaBinding binding = ActivityEdadCaninaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText ageEdit = binding.EdadEditText;

        binding.btnCalcular.setOnClickListener(v -> {
            //Al hacer click queremos capturar el texto introducido
            String edad = ageEdit.getText().toString();
            if (!edad.isEmpty()){
                int edadInteger = Integer.parseInt(edad);

                int resultado = edadInteger * 7;
                //String resultadoTexto = "If you were a dog, your age would be " + resultado + " years old";
                String resultadoTexto = getString(R.string.result_format, resultado);

                binding.RespuestaTextView.setText(resultadoTexto);
            } else {
                Log.d("MainActivity","El campo Edad está vacio");
                Toast.makeText(this, getString(R.string.you_have_to_insert_an_age), Toast.LENGTH_LONG).show();
            }

        });
    }
}