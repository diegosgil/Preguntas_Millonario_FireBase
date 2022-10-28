package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroJugador extends AppCompatActivity {

    EditText etCorreoJugador, etNombreJugador, etPasswordJugador;
    Button btnInsertar, btnLimpiar, btnVolverMenuRegistroJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_jugador);
        conectar();

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = etNombreJugador.getText().toString();
                Toast.makeText(registroJugador.this, Nombre + "Jugador registrado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), CrearJugador.class);
                //intent.putExtra("idPrivNom", Nombre);
                startActivity(intent);
            }
        });

        btnVolverMenuRegistroJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), loginJugador.class);
                startActivity(intent);
            }
        });
    }

    private void conectar() {
        etCorreoJugador = findViewById(R.id.etCorreoJugador);
        etNombreJugador = findViewById(R.id.etNombreJugador);
        etPasswordJugador = findViewById(R.id.etPasswordJugador);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
    }
}