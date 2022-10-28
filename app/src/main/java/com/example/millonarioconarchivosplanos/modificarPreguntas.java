package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class modificarPreguntas extends AppCompatActivity {

    EditText etModificarPregunta, etModificarOpcion1, etModificarOpcion2, etModificarOpcion3;
    EditText etModificarOpcionCorrecta, etModificarPuntos;
    Button btnModificar, btnEliminar, btnVolver;
    String id, pregunta, respUno, respDos, respTres, respFinal;

    int puntaje;
    ArrayList<OPregunta> Preguntas = new ArrayList<>();
    CRUDPreguntas objDB = new CRUDPreguntas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_preguntas);
        conectar();

        //Posicion = Integer.parseInt(getIntent().getStringExtra("id"));
        //Preguntas = objDB.leerPregunta(Posicion);
        Preguntas = llamarPreguntas();

        etModificarPregunta.setText(Preguntas.get(0).getQuestion());
        etModificarOpcion1.setText(Preguntas.get(0).getRespuesta1());
        etModificarOpcion2.setText(Preguntas.get(0).getRespuesta2());
        etModificarOpcion3.setText(Preguntas.get(0).getRespuesta3());
        etModificarOpcionCorrecta.setText(Preguntas.get(0).getRespuestaFinal());
        etModificarPuntos.setText((Preguntas.get(0).getPuntaje())+"");

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = Preguntas.get(0).toString();
                pregunta = etModificarPregunta.getText().toString();
                respUno = etModificarOpcion1.getText().toString();
                respDos= etModificarOpcion2.getText().toString();
                respTres = etModificarOpcion3.getText().toString();
                respFinal = etModificarOpcionCorrecta.getText().toString();
                puntaje = Integer.parseInt(etModificarPuntos.getText().toString());

                objDB.actulizarPregunta(id, pregunta , respUno, respDos,respTres, respFinal,  puntaje);

                Toast.makeText(getApplicationContext(), "Pregunta Modificada", Toast.LENGTH_SHORT).show();
                Intent I = new Intent(getApplicationContext(), administrarPreguntas.class);
                startActivity(I);
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objDB.eliminarPregunta(String.valueOf(puntaje));
                Toast.makeText(getApplicationContext(), "Pregunta Eliminada", Toast.LENGTH_SHORT).show();
                Intent I = new Intent(getApplicationContext(), administrarPreguntas.class);
                startActivity(I);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), menuAdmin.class);
                startActivity(I);
            }
        });
    }

    private ArrayList<OPregunta> llamarPreguntas() {
        ArrayList<OPregunta> auxAddPregunta = new ArrayList<>();
        Bundle InfPregunta = getIntent().getExtras();
        id = InfPregunta.getString("id");
        pregunta = InfPregunta.getString("Pregunta");
        respUno = InfPregunta.getString("RespuestaUno");
        respDos = InfPregunta.getString("RespuestaDos");
        respTres = InfPregunta.getString("RespuestaTres");
        respFinal = InfPregunta.getString("RespuestaFinal");
        puntaje = InfPregunta.getInt("Puntaje");
        auxAddPregunta.add(new OPregunta(id, pregunta, respUno, respDos, respTres, respFinal, puntaje));
        return auxAddPregunta;
    }

    private void conectar() {
        etModificarPregunta = findViewById(R.id.etModificarPregunta);
        etModificarOpcion1 = findViewById(R.id.etModificarOpcion1);
        etModificarOpcion2 = findViewById(R.id.etModificarOpcion2);
        etModificarOpcion3 = findViewById(R.id.etModificarOpcion3);
        etModificarOpcionCorrecta = findViewById(R.id.etModificarOpcionCorrecta);
        etModificarPuntos = findViewById(R.id.etModificarPuntos);

        btnModificar = findViewById(R.id.btnModificar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnVolver = findViewById(R.id.btnVolver);
    }
}