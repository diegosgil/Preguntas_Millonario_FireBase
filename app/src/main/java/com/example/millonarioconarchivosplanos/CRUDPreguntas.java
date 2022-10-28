package com.example.millonarioconarchivosplanos;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CRUDPreguntas {
    public Context ctx;
    DatabaseReference miDB;


    public CRUDPreguntas(Context ctx){this.ctx = ctx;}

    //Muestra la fila con el 'id' seleccionado
    /**
    public ArrayList<OPregunta>leerPregunta(int id) {
        ArrayList<OPregunta> Auxpreguntas = new ArrayList<>();
        DbHelperPreguntas helper = new DbHelperPreguntas(ctx, "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "SELECT * FROM Preguntas WHERE id ='" + id + "'";
        Cursor C = db.rawQuery(SQL, null);

        if (C.moveToFirst()) {
            do {
                OPregunta tablaAux =  new OPregunta(C.getInt(0), C.getString(1), C.getString(2), C.getString(3), C.getString(4), C.getString(5), C.getInt(6));
                Auxpreguntas.add(tablaAux);
            } while (C.moveToNext());
        }
        db.close();
        return Auxpreguntas;
    }
     **/

    //Muestra toda la lista que esta en la base de datos
    /**
    public ArrayList<OPregunta>leerPreguntas() {
        ArrayList<OPregunta> Auxpreguntas = new ArrayList<>();
        DbHelperPreguntas helper = new DbHelperPreguntas(ctx, "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "SELECT * FROM Preguntas";
        Cursor C = db.rawQuery(SQL, null);

        if (C.moveToFirst()) {
            do {
                Auxpreguntas.add(new OPregunta(C.getInt(0), C.getString(1), C.getString(2), C.getString(3), C.getString(4), C.getString(5), C.getInt(6)));
            } while (C.moveToNext());
        }
        db.close();
        return Auxpreguntas;
    }
     **/

    /**
    public void crearPregunta(String Question, String respuesta1, String respuesta2, String respuesta3, String respuestaFinal, String puntaje){
        DbHelperPreguntas helper = new DbHelperPreguntas(ctx, "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Question", Question);
        cv.put("respuesta1", respuesta1);
        cv.put("respuesta2", respuesta2);
        cv.put("respuesta3", respuesta3);
        cv.put("respuestaFinal", respuestaFinal);
        cv.put("puntaje", puntaje);
        db.insert("Preguntas", null, cv);
        db.close();
    }
     **/

    public void crearPregunta(String Question, String respuesta1, String respuesta2, String respuesta3, String respuestaFinal, int puntaje){
        miDB = FirebaseDatabase.getInstance().getReference();
        String id = miDB.push().getKey();
        OPregunta P = new OPregunta(id, Question, respuesta1, respuesta2, respuesta3, respuestaFinal, puntaje);
        miDB.child("Preguntas").child(id).setValue(P);
    }

    /**
    public void actulizarPregunta(int id, String Question, String respuesta1, String respuesta2, String respuesta3, String respuestaFinal, String puntaje){
        DbHelperPreguntas helper = new DbHelperPreguntas(ctx , "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "UPDATE Preguntas " +
                "set Question = '" + Question +"'" +
                ", respuesta1 = '" + respuesta1 +"' " +
                ", respuesta2 = '" + respuesta2 +"' " +
                ", respuesta3 = '" + respuesta3 +"' " +
                ", respuestaFinal = '" + respuestaFinal +"' " +
                ", puntaje = '" + puntaje +"' " +
                "WHERE id = '" + id +"'";
        db.execSQL(SQL);
        db.close();
    }
     **/

    public void actulizarPregunta(String id, String Question, String respuesta1, String respuesta2, String respuesta3, String respuestaFinal, int puntaje){
        miDB = FirebaseDatabase.getInstance().getReference();
        OPregunta Q = new OPregunta(id, Question, respuesta1, respuesta2, respuesta3, respuestaFinal, puntaje);
        miDB.child("Question").child(id).setValue(Q);
    }

    /**
    public void eliminarPregunta(int id){
        DbHelperPreguntas helper = new DbHelperPreguntas(ctx, "Preguntas", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "DELETE FROM Preguntas WHERE id = '" + id + "'";
        db.execSQL(SQL);
        db.close();
    }
     **/

    public void eliminarPregunta(String id){
        miDB = FirebaseDatabase.getInstance().getReference();
        miDB.child("Question").child(id).removeValue();
    }
}
