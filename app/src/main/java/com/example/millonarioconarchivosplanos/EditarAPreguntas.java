/**
 *package com.example.millonarioconarchivosplanos;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EditarAPreguntas {

    String Archivo = "Preguntas.txt";
    Context ctx;
    FileOutputStream fos;
    FileInputStream fis;

    public EditarAPreguntas(Context ctx) {this.ctx = ctx;}

    public void EscribirP(String textArchivo) throws IOException {
        try
        {
            fos = ctx.openFileOutput(Archivo, Context.MODE_APPEND);
            fos.write(textArchivo.getBytes());
            fos.close();
        }
        catch (FileNotFoundException e){
            Log.e("",e.getMessage());
        }
        catch (IOException ex){
            Log.e("",ex.getMessage());
        }
    }

    public ArrayList<OPregunta> GuardarPregunta (){
        ArrayList<String> auxiliar = new ArrayList();
        ArrayList<OPregunta> auxiliarFinal = new ArrayList();

        String Lectura = "";
        try
        {
            fis = ctx.openFileInput(Archivo);
            int i;
            char caracter = 'a';
            do {
                i = fis.read();
                if ( i != '\n')
                {
                    caracter = (char)i;
                    Lectura += caracter;
                }
                if(caracter == ','){
                    auxiliar.add(Lectura.substring(0, Lectura.length()-1));
                    Lectura = "";
                }
                if(caracter =='/'){
                    auxiliar.add(Lectura.substring(0, Lectura.length()-1));
                    auxiliarFinal.add( new OPregunta(id, auxiliar.get(0),
                            auxiliar.get(1),
                            auxiliar.get(2),
                            auxiliar.get(3),
                            auxiliar.get(4),
                            Integer.parseInt(auxiliar.get(5))));
                    auxiliar.clear();
                    Lectura = "";
                }
            } while (i > 0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return auxiliarFinal;
    }
}
**/
