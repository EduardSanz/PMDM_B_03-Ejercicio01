package com.cieep.a03_ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.StringTokenizer;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        lblResultado = findViewById(R.id.lblResultadoCalculadora);

        // Obtener la Info enviada
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String frase = bundle.getString("FRASE");
            int operacion = bundle.getInt("OPERACION");

            if (operacion == R.id.btnPalabrasMain) {
                int resultado = contarPalabras(frase);
                lblResultado.setText("Palabras: "+resultado);
            }
            else if (operacion == R.id.btnCaracteresMain){
                int resultado = contarCaracteres(frase);
                lblResultado.setText("Caracteres: "+resultado);
            }
            else{
                lblResultado.setText("ERROR OPERACIÓN");
            }
        }

    }

    private int contarCaracteres(String frase) {
        return frase.length();
    }

    private int contarPalabras(String frase) {
        StringTokenizer stringTokenizer = new StringTokenizer(frase);
        String[] palabras = frase.split("\\s+");
        return stringTokenizer.countTokens();
    }
}