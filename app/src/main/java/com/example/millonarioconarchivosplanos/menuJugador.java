package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuJugador extends AppCompatActivity {

    //Button btnAdministrarPreguntas;
    Button btnJugarJugador, btnPuntuacionJugador, btnCerrarSesionJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jugador);
        conectar();

        btnJugarJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CrearJugador.class);
                startActivity(intent);
            }
        });

        /*
        btnAdministrarPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), administrarPreguntas.class);
                startActivity(intent2);
            }
        });
        */

        btnPuntuacionJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), mostrarPuntuacion.class);
                startActivity(intent3);
            }
        });

        btnCerrarSesionJugador.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("")
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }

    private void conectar() {
        btnJugarJugador = findViewById(R.id.btnJugarJugador);
        btnPuntuacionJugador = findViewById(R.id.btnPuntuacionJugador);
        btnCerrarSesionJugador = findViewById(R.id.btnCerrarSesionJugador);
    }
}