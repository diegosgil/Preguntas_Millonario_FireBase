package com.example.millonarioconarchivosplanos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CRUDPuntuacion {
    public Context ctx;

    public CRUDPuntuacion(Context ctx){this.ctx = ctx;}

    //Muestra toda la lista que esta en la base de datos
    public ArrayList<OPuntuacion>leerPuntuacion() {
        ArrayList<OPuntuacion> Auxpreguntas = new ArrayList<>();
        DbHelperPuntuacion helper = new DbHelperPuntuacion(ctx, "Puntuacion", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "SELECT * FROM Puntuacion";
        Cursor C = db.rawQuery(SQL, null);

        if (C.moveToFirst()) {
            do {
                OPuntuacion tablaAux =  new OPuntuacion(C.getInt(0), C.getString(1), C.getInt(2));
                Auxpreguntas.add(tablaAux);
            } while (C.moveToNext());
        }
        db.close();
        return Auxpreguntas;
    }

    public void crearPuntuacion(String nombre, int puntos){
        DbHelperPuntuacion helper = new DbHelperPuntuacion(ctx, "Puntuacion", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Nombre", nombre);
        cv.put("Puntos", puntos);

        db.insert("Puntuacion", null, cv);
        db.close();
    }
}
