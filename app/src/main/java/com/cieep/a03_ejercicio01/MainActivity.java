package com.cieep.a03_ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Atributos para las vistas
    private EditText txtFrase;
    private Button btnPalabras;
    private Button btnCaracteres;

    // Constantes
    public static final int PALABRAS = 1;
    public static final int CARACTERES = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVistas();
        //  inicializaEventos();

    }

    private void inicializaEventos() {
        btnPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(PALABRAS);
            }
        });

        btnCaracteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(CARACTERES);
            }
        });
    }

    private void onclick(int PALABRAS) {
        String frase = txtFrase.getText().toString();
        if (!frase.isEmpty()){
            Bundle bundle = new Bundle();
            bundle.putString("FRASE", frase);
            bundle.putInt("OPERACION", PALABRAS);
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this, "Frase Vacia", Toast.LENGTH_SHORT).show();
        }
    }

    private void inicializaVistas() {
        txtFrase = findViewById(R.id.txtFraseMain);
        btnCaracteres = findViewById(R.id.btnCaracteresMain);
        btnPalabras = findViewById(R.id.btnPalabrasMain);
    }

    public void onClickBotones(View boton) {
        String frase = txtFrase.getText().toString();
        if (!frase.isEmpty()){
            Bundle bundle = new Bundle();
            bundle.putString("FRASE", frase);

            // Cada botón inserta su ID
            bundle.putInt("OPERACION", boton.getId());
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this, "Frase Vacia", Toast.LENGTH_SHORT).show();
        }
    }
}