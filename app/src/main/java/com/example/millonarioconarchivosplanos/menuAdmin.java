package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class menuAdmin extends AppCompatActivity {

    //Button btnJugar, btnPuntuacion;
    Button btnAdministrarPreguntas, btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        conectar();

        /*
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Intent intent = new Intent(getApplicationContext(), CrearJugador.class);
                startActivity(intent);
            }
        });
        */

        btnAdministrarPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), administrarPreguntas.class);
                startActivity(intent2);
            }
        });

        /*
        btnPuntuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), mostrarPuntuacion.class);
                startActivity(intent3);
            }
        });
        */

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("")
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }

    private void conectar() {
        //btnJugar = findViewById(R.id.btnJugar);
        btnAdministrarPreguntas = findViewById(R.id.btnAdministrarPreguntas);
        //btnPuntuacion = findViewById(R.id.btnPuntuacion);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
    }
}