package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class administrarPreguntas extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvLeerPreguntas;
    Button btnAgregarPregunta, btnLeerMenu;
    ArrayAdapter adapter;
    ArrayList<OPregunta> Preguntas = new ArrayList();
    CRUDPreguntas objDB = new CRUDPreguntas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_preguntas);
        conectar();

        adaptar();

        btnAgregarPregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), crearPreguntas.class);
                startActivity(intent);
            }
        });

        btnLeerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), menuAdmin.class);
                startActivity(intent);
            }
        });
    }


    private void adaptar() {
        Preguntas = objDB.leerPreguntas();
        adapter = new ArrayAdapter<OPregunta>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, Preguntas);
        lvLeerPreguntas.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent I = new Intent(getApplicationContext(), modificarPreguntas.class);
        I.putExtra("id", Preguntas.get(i).getId() + "");
        startActivity(I);
    }

    private void conectar() {
        lvLeerPreguntas = findViewById(R.id.lvLeerPreguntas);
        lvLeerPreguntas.setOnItemClickListener(this);
        btnLeerMenu = findViewById(R.id.btnLeerMenu);
        btnAgregarPregunta = findViewById(R.id.btnAgregarPregunta);
    }
}