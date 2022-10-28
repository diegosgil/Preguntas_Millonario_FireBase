package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearJugador extends AppCompatActivity {

    EditText etNombreJugador;
    Button btnPlay, btnMenuJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_jugador);
        conectart();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = etNombreJugador.getText().toString();
                Toast.makeText(CrearJugador.this, Nombre + "Jugador guardado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CrearJugador.this, MainActivity.class);
                intent.putExtra("idPrivNom", Nombre);
                startActivity(intent);
            }
        });

        btnMenuJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), menuJugador.class);
                startActivity(intent);
            }
        });
    }

    private void conectart() {
        etNombreJugador = findViewById(R.id.etNombreJugador);
        btnPlay = findViewById(R.id.btnPlay);
        btnMenuJugador = findViewById(R.id.btnMenuJugador);
    }
}