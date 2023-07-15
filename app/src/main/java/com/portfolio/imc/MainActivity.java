package com.portfolio.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint({"MissingInflatedId", "SetTextI18n"})
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etPeso = findViewById(R.id.et_peso);
        EditText etAltura = findViewById(R.id.et_altura);
        TextView tvResultado = findViewById(R.id.tv_resultado);
        ImageView imgResultado = findViewById(R.id.img_resultado);
        Button btnCalcular = findViewById(R.id.btn_calcular);
        LinearLayout layoutResultado = findViewById(R.id.layout_resultado);

        btnCalcular.setOnClickListener(v -> {
            double peso = Double.parseDouble(etPeso.getText().toString());
            double altura = Double.parseDouble(etAltura.getText().toString().replace(",", "."));
            double imc = peso / (altura * altura);

            String resultado;
            int img;
            if (imc > 0 && imc <= 16) {
                resultado = "Magreza";
                img = R.drawable.magreza;
            } else if (imc > 16 && imc <= 18.5) {
                resultado = "Abaixo do peso";
                img = R.drawable.abaixo;
            } else if (imc > 18.5 && imc <= 25) {
                resultado = "Peso ideal";
                img = R.drawable.ideal;
            } else if (imc > 25 && imc <= 30) {
                resultado = "Sobrepreso";
                img = R.drawable.sobre;
            } else {
                resultado = "Obesidade";
                img = R.drawable.obesidade;
            }


            tvResultado.setText((int) imc + ": " + resultado);
            imgResultado.setImageResource(img);
            layoutResultado.setVisibility(View.VISIBLE);
        });
    }
}