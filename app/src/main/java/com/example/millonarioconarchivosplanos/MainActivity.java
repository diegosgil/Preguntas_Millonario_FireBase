package com.example.millonarioconarchivosplanos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnDiez;
    Button btnOnce, btnDoce, btnTrece, btnCatorce, btnQuince, btnDieciseis, btnDieciSiete, btnDieciOcho, btnDieciNueve, btnVeinte;
    Button btnR1, btnR2, btnR3, btnVolverMenu;
    TextView tvNN, tvPuntaje, tvPregunta;

    int puntajeCompleto, puntuacionCompleta, preguntasBuenas;
    String correcta;
    Button btnAuxiliar;

    DatabaseReference miDB;
    Random random = new Random();
    ArrayList<OPregunta> NumPreguntas = new ArrayList();
    CRUDPuntuacion objDBPunt = new CRUDPuntuacion(this);
    CRUDPreguntas objDBPregu = new CRUDPreguntas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        crearPreguntas();
        puntuacionCompleta = 0;
        preguntasBuenas = 0;
        tvNN.setText(Nombre());

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnUno);
            }
        });

        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDos);
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnTres);
            }
        });

        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnCuatro);
            }
        });

        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnCinco);
            }
        });

        btnSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnSeis);
            }
        });

        btnSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnSiete);
            }
        });

        btnOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnOcho);
            }
        });

        btnNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnNueve);
            }
        });

        btnDiez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDiez);
            }
        });

        btnOnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnOnce);
            }
        });

        btnDoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDoce);
            }
        });

        btnTrece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnTrece);
            }
        });

        btnCatorce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnCatorce);
            }
        });

        btnQuince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnQuince);
            }
        });

        btnDieciseis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDieciseis);
            }
        });

        btnDieciSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDieciSiete);
            }
        });

        btnDieciOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDieciOcho);
            }
        });

        btnDieciNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnDieciNueve);
            }
        });

        btnVeinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PintarPreguntas(btnVeinte);
            }
        });

        btnR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarPreguntar(btnR1);
                activarOpciones(false);
            }
        });

        btnR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarPreguntar(btnR2);
                activarOpciones(false);
            }
        });

        btnR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarPreguntar(btnR3);
                activarOpciones(false);
            }
        });

        btnVolverMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CrearJugador.class);
                startActivity(intent);
            }
        });
    }

    /**
    public void crearPreguntas(){
        NumPreguntas = objDBPregu.leerPreguntas();
    }
     **/

    public void crearPreguntas(){
        miDB = FirebaseDatabase.getInstance().getReference();
        miDB.child("Question").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot objsnapshot : snapshot.getChildren()) {
                    NumPreguntas.add(new OPregunta(objsnapshot.child("id").getValue().toString(),
                            objsnapshot.child("question").getValue().toString(),
                            objsnapshot.child("respuesta1").getValue().toString(),
                            objsnapshot.child("respuesta2").getValue().toString(),
                            objsnapshot.child("respuesta3").getValue().toString(),
                            objsnapshot.child("respuestaFinal").getValue().toString(),
                            Integer.parseInt(objsnapshot.child("puntaje").getValue().toString())));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void mostrarPreguntas(Button Questions){
        btnAuxiliar = Questions;
        int intRandom = random.nextInt(NumPreguntas.size());

        tvPregunta.setText(NumPreguntas.get(intRandom).getQuestion());
        btnR1.setText(NumPreguntas.get(intRandom).getRespuesta1());
        btnR2.setText(NumPreguntas.get(intRandom).getRespuesta2());
        btnR3.setText(NumPreguntas.get(intRandom).getRespuesta3());
        correcta = NumPreguntas.get(intRandom).getRespuestaFinal();
        puntuacionCompleta = NumPreguntas.get(intRandom).getPuntaje();
        NumPreguntas.remove(intRandom);
    }

    public void comprobarPreguntar(Button verificarOpcion){
        if(Integer.parseInt(verificarOpcion.getText().toString()) == Integer.parseInt(correcta)){
            puntajeCompleto += puntuacionCompleta;
            preguntasBuenas += 1;
            tvPuntaje.setText(puntajeCompleto+"");
            verificarOpcion.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            Toast.makeText(this, "Pregunta Correcta", Toast.LENGTH_LONG).show();
            btnAuxiliar.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            btnAuxiliar.setEnabled(false);
        } else {
            verificarOpcion.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            btnAuxiliar.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            Toast.makeText(this, "Pregunta Incorrecta", Toast.LENGTH_LONG).show();
        }if ((NumPreguntas.size() + preguntasBuenas) < 20){
            CrearPuntaje(Nombre(), puntajeCompleto);
            //Intent intent = new Intent(getApplicationContext(), Fin.class);
            //startActivity(intent);
        }else if (preguntasBuenas == 20){
            CrearPuntaje(Nombre(), puntajeCompleto);
            Intent intent = new Intent(getApplicationContext(), Fin.class);
            startActivity(intent);
        }
    }

    public void PintarPreguntas(Button NQuiz){
        mostrarPreguntas(NQuiz);
        activarOpciones(true);
        btnR1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        btnR2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        btnR3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
    }

    public void activarOpciones(Boolean desactivarOpciones){
        btnR1.setEnabled(desactivarOpciones);
        btnR2.setEnabled(desactivarOpciones);
        btnR3.setEnabled(desactivarOpciones);
    }

    public void CrearPuntaje(String Nombre, int Puntos){
        objDBPunt.crearPuntuacion(Nombre, Puntos);
    }

    public String Nombre(){
        String nombreJugador;
        Bundle info = getIntent().getExtras();
        if (info != null) {
            nombreJugador = info.getString("idPrivNom");
        }else {
            nombreJugador = "nn";
        }
        return nombreJugador;
    }

    private void conectar() {
        btnUno = findViewById(R.id.btnUno);
        btnDos = findViewById(R.id.btnDos);
        btnTres = findViewById(R.id.btnTres);
        btnCuatro = findViewById(R.id.btnCuatro);
        btnCinco = findViewById(R.id.btnCinco);
        btnSeis = findViewById(R.id.btnSeis);
        btnSiete = findViewById(R.id.btnSiete);
        btnOcho = findViewById(R.id.btnOcho);
        btnNueve = findViewById(R.id.btnNueve);
        btnDiez = findViewById(R.id.btnDiez);
        btnOnce = findViewById(R.id.btnOnce);
        btnDoce = findViewById(R.id.btnDoce);
        btnTrece = findViewById(R.id.btnTrece);
        btnCatorce = findViewById(R.id.btnCatorce);
        btnQuince = findViewById(R.id.btnQuince);
        btnDieciseis = findViewById(R.id.btnDieciseis);
        btnDieciSiete = findViewById(R.id.btnDieciSiete);
        btnDieciOcho = findViewById(R.id.btnDieciOcho);
        btnDieciNueve = findViewById(R.id.btnDieciNueve);
        btnVeinte = findViewById(R.id.btnVeinte);

        btnR1 = findViewById(R.id.btnR1);
        btnR2 = findViewById(R.id.btnR2);
        btnR3 = findViewById(R.id.btnR3);

        btnVolverMenu = findViewById(R.id.btnVolverMenu);

        tvPuntaje = findViewById(R.id.tvPuntaje);
        tvPregunta = findViewById(R.id.tvPregunta);
        tvNN = findViewById(R.id.tvNN);

    }
}