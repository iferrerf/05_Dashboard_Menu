package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.iesch.a05_dashboard_menu.databinding.ActivityCalculadoraBinding;

public class CalculadoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        setTitle(R.string.calculator_title);

        ActivityCalculadoraBinding binding = ActivityCalculadoraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText n1 = binding.editText1;
        EditText n2 = binding.editText2;
        Button btnSuma = binding.btnAdd;
        Button btnResta = binding.btnSub;
        Button btnMult = binding.btnMul;
        Button btnDiv = binding.btnDiv;

        // Al hacer clic en el boton Sum queremos que sume
        binding.btnAdd.setOnClickListener(v -> {
            int num1 = 0;
            int num2 = 0;

            String number1 = n1.getText().toString();
            String number2 = n2.getText().toString();

            if (!number1.isEmpty()){
                num1 = Integer.parseInt(number1);

                if (!number2.isEmpty()){
                    num2 = Integer.parseInt(number2);

                }else {
                    Log.d("MainActivity", "El campo Numero 2 está vacío");
                    Toast.makeText(this, R.string.inputNumber, Toast.LENGTH_SHORT).show();
                }

            }else {
                Log.d("MainActivity", "El campo Numero 1 está vacío");
                Toast.makeText(this, R.string.inputNumber, Toast.LENGTH_LONG).show();
            }

            int res =  num1 + num2;
            binding.textView5.setText(String.valueOf(res));

        });

        // Al hacer clic en el boton Res queremos que calcule la diferencia
        binding.btnSub.setOnClickListener(v -> {
            int num1 = 0;
            int num2 = 0;

            String number1 = n1.getText().toString();
            String number2 = n2.getText().toString();

            if (!number1.isEmpty()){
                num1 = Integer.parseInt(number1);

                if (!number2.isEmpty()){
                    num2 = Integer.parseInt(number2);

                }else {
                    Log.d("MainActivity", "El campo Numero 2 está vacío");
                    Toast.makeText(this, R.string.inputNumber, Toast.LENGTH_SHORT).show();
                }

            }else {
                Log.d("MainActivity", "El campo Numero 1 está vacío");
                Toast.makeText(this, R.string.inputNumber, Toast.LENGTH_LONG).show();
            }

            int res =  num1 - num2;
            binding.textView5.setText(String.valueOf(res));

        });

        // Al hacer clic en el boton Mult queremos que calcule la multiplicacion
        binding.btnMul.setOnClickListener(v -> {
            int num1 = 0;
            int num2 = 0;

            String number1 = n1.getText().toString();
            String number2 = n2.getText().toString();

            if (!number1.isEmpty()){
                num1 = Integer.parseInt(number1);

                if (!number2.isEmpty()){
                    num2 = Integer.parseInt(number2);

                }else {
                    Log.d("MainActivity", "El campo Numero 2 está vacío");
                    Toast.makeText(this, R.string.inputNumber, Toast.LENGTH_SHORT).show();
                }

            }else {
                Log.d("MainActivity", "El campo Numero 1 está vacío");
                Toast.makeText(this, R.string.inputNumber, Toast.LENGTH_LONG).show();
            }

            int res =  num1 * num2;
            binding.textView5.setText(String.valueOf(res));

        });

        // Al hacer clic en el boton Div queremos que calcule la division
        binding.btnDiv.setOnClickListener(v -> {
            double num1 = 0;
            double num2 = 0;

            String number1 = n1.getText().toString();
            String number2 = n2.getText().toString();

            if (!number1.isEmpty()){
                num1 = Integer.parseInt(number1);

                if (!number2.isEmpty()){
                    num2 = Integer.parseInt(number2);

                }else {
                    Log.d("MainActivity", "El campo Numero 2 está vacío");
                    Toast.makeText(this, R.string.inputNumber, Toast.LENGTH_SHORT).show();
                }

            }else {
                Log.d("MainActivity", "El campo Numero 1 está vacío");
                Toast.makeText(this, R.string.inputNumber, Toast.LENGTH_LONG).show();
            }

            double res =  num1 / num2;
            binding.textView5.setText(String.valueOf(res));

        });

    }
}