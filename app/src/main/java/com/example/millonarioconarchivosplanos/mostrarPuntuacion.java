package com.example.millonarioconarchivosplanos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mostrarPuntuacion extends AppCompatActivity {

    Button btnPuntuacionlMenu;
    ListView lvLaPuntuacion;
    ArrayList<OPuntuacion> Puntos = new ArrayList();
    ArrayAdapter adapter;
    CRUDPuntuacion objAP = new CRUDPuntuacion(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_puntuacion);
        conectar();
        adaptar();

        btnPuntuacionlMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), menuJugador.class);
                startActivity(I);
            }
        });
    }

    public void adaptar(){
        Puntos = objAP.leerPuntuacion();
        Collections.sort(Puntos, new Comparator<OPuntuacion>() {
            @Override
            public int compare(OPuntuacion S1, OPuntuacion S2) {
                return new Integer(S2.getPuntos()).compareTo(new Integer(S1.getPuntos()));
            }
        });
        adapter = new ArrayAdapter<OPuntuacion>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, Puntos);
        lvLaPuntuacion.setAdapter(adapter);
    }

    private void conectar() {
        btnPuntuacionlMenu = findViewById(R.id.btnPuntuacionlMenu);
        lvLaPuntuacion = findViewById(R.id.lvLaPuntuacion);
    }
}