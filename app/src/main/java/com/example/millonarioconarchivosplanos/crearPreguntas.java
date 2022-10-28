package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class crearPreguntas extends AppCompatActivity {

    ArrayAdapter adapter;
    ArrayList<OPregunta> Preguntas = new ArrayList<>();
    Button btnAgregar, btnMenu;
    ListView lvAparecenPreguntas;
    EditText etPregregunta, etOpcion1, etOpcion2, etOpcion3, etOpcionCorrecta, etPuntos;

    String Pregunta, OpcionUno, OpcionDos, OpcionTres, OpcionCorrecta;
    int OpcionPuntos;
    CRUDPreguntas objDB = new CRUDPreguntas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_preguntas);
        conectar();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Pregunta = etPregregunta.getText().toString();
                OpcionUno = etOpcion1.getText().toString();
                OpcionDos = etOpcion2.getText().toString();
                OpcionTres = etOpcion3.getText().toString();
                OpcionCorrecta = etOpcionCorrecta.getText().toString();
                OpcionPuntos = Integer.parseInt(etPuntos.getText().toString());
                etPregregunta.setText("");
                etOpcion1.setText("");
                etOpcion2.setText("");
                etOpcion3.setText("");
                etOpcionCorrecta.setText("");
                etPuntos.setText("");

                objDB.crearPregunta(Pregunta, OpcionCorrecta, OpcionUno, OpcionDos, OpcionTres, OpcionPuntos);
                Toast.makeText(getApplicationContext(), "Pregunta Creada", Toast.LENGTH_SHORT).show();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), administrarPreguntas.class);
                startActivity(intent);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), menuAdmin.class);
                startActivity(intent2);
            }
        });
    }

    private void conectar() {
        etPregregunta = findViewById(R.id.etPregregunta);
        etOpcion1 = findViewById(R.id.etOpcion1);
        etOpcion2 = findViewById(R.id.etOpcion2);
        etOpcion3 = findViewById(R.id.etOpcion3);
        etOpcionCorrecta = findViewById(R.id.etOpcionCorrecta);
        etPuntos = findViewById(R.id.etPuntos);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnMenu = findViewById(R.id.btnMenu);
    }
}