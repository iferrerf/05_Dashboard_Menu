package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.iesch.a05_dashboard_menu.JavaClass.Quizzes.model.PreguntasRespuestas;
import org.iesch.a05_dashboard_menu.databinding.ActivityQuizzesBinding;

public class QuizzesActivity extends AppCompatActivity {

    private ActivityQuizzesBinding binding;
    TextView totalPreguntas_textView;
    TextView preguntas_textView;
    RadioButton rb1, rb2, rb3;
    RadioGroup rgb;
    Button validar_btn;
    ImageView imageView;

    int aciertos = 0;
    int totalPreguntas = PreguntasRespuestas.preguntas.length - (PreguntasRespuestas.preguntas.length - 1);
    public static int numPreguntas = PreguntasRespuestas.preguntas.length;
    public static int preguntaSeleccionadaIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuizzesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.quizzes_title);

        totalPreguntas_textView = findViewById(R.id.tv_NumPregunta);
        preguntas_textView = findViewById(R.id.tv_Pregunta);
        rb1 = findViewById(R.id.radioOpcion1);
        rb2 = findViewById(R.id.radioOpcion2);
        rb3 = findViewById(R.id.radioOpcion3);
        rgb = findViewById(R.id.radioGroup);
        validar_btn = findViewById(R.id.btn_Validar);
        imageView = findViewById(R.id.imgView);

        cargarNuevaPregunta();

        binding.btnValidar.setOnClickListener(view -> {

            aciertos();

            if (!rb1.isChecked() && !rb2.isChecked() && !rb3.isChecked()) {
                Toast.makeText(this, R.string.toas_info, Toast.LENGTH_SHORT).show();
            } else {
                validarRespuesta();
                preguntaSeleccionadaIndex++;
                cargarNuevaPregunta();
            }

        });

    }

    private void aciertos() {
        if (numPreguntas == preguntaSeleccionadaIndex +1) {
            if (aciertos == 0) {
                String s = ("Vaya desastre!!, no has acertado ninguna opcion");
                abrirResultActivity(s);
            } else if (aciertos == 1) {
                String s = "Enhorabuena, has terminado el formulario!" + "\n\n\n" +
                        "Has acertado" + aciertos + " pregunta";
                abrirResultActivity(s);
            } else if (aciertos > 1) {
                String s = "Enhorabuena, has terminado el formulario!" + "\n\n\n" +
                        "Has acertado " + aciertos + " preguntas";
                abrirResultActivity(s);
            }
        }
    }

    private void validarRespuesta() {
        if (rb1.isChecked()) {
            if (rb1.getText().equals(PreguntasRespuestas.respuestaCorrecta[preguntaSeleccionadaIndex])) {
                aciertos++;
                String acierto = "Has acertado!";
                abrirResultActivity(acierto);
            } else {
                String fallo = "Has fallado!";
                abrirResultActivity(fallo);
            }
        } else if (rb2.isChecked()) {
            if (rb2.getText().equals(PreguntasRespuestas.respuestaCorrecta[preguntaSeleccionadaIndex])) {
                aciertos++;
                String acierto = "Has acertado!";
                abrirResultActivity(acierto);
            } else {
                String fallo = "Has fallado!";
                abrirResultActivity(fallo);
            }
        } else if (rb3.isChecked()) {
            if (rb3.getText().equals(PreguntasRespuestas.respuestaCorrecta[preguntaSeleccionadaIndex])) {
                aciertos++;
                String acierto = "Has acertado!";
                abrirResultActivity(acierto);
            } else {
                String fallo = "Has fallado!";
                abrirResultActivity(fallo);
            }
        }

    }

    private void cargarNuevaPregunta() {
        //imageView.setImageDrawable(Drawable.createFromPath(PreguntasRespuestas.rutaImagenes[preguntaSeleccionadaIndex]));

        switch (PreguntasRespuestas.rutaImagenes[preguntaSeleccionadaIndex]) {
            case "drawable/mirambel":
                imageView.setImageResource(R.drawable.logomirambel);
                break;
            case "drawable/elestudio":
                imageView.setImageResource(R.drawable.elestudio);
                break;
            case "drawable/lasmonjas":
                imageView.setImageResource(R.drawable.lasmonjas);
                break;
        }

        totalPreguntas_textView.setText(totalPreguntas + "/3");
        totalPreguntas++;
        rgb.clearCheck();
        preguntas_textView.setText(PreguntasRespuestas.preguntas[preguntaSeleccionadaIndex]);
        rb1.setText(PreguntasRespuestas.opciones[preguntaSeleccionadaIndex][0]);
        rb2.setText(PreguntasRespuestas.opciones[preguntaSeleccionadaIndex][1]);
        rb3.setText(PreguntasRespuestas.opciones[preguntaSeleccionadaIndex][2]);
        validar_btn.setText("Validar");


    }

    private void abrirResultActivity(String s) {
        Intent resultadoIntent = new Intent(this, QuizzesResultActivity.class);
        resultadoIntent.putExtra("mensaje", s);
        startActivity(resultadoIntent);

    }
}