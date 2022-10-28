package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ingresoJugador extends AppCompatActivity {

    EditText etCorreoIngresoJugador, etContraseñaIngresoJugador;
    Button btnIngresaJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_jugador);
        conectar();

        btnIngresaJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CrearJugador.class);
                startActivity(intent);
            }
        });
    }

    private void conectar() {
        etCorreoIngresoJugador = findViewById(R.id.etCorreoIngresoJugador);
        etContraseñaIngresoJugador = findViewById(R.id.etContraseñaIngresoJugador);
        btnIngresaJugador = findViewById(R.id.btnIngresaJugador);

    }
}