/**
 *
package com.example.millonarioconarchivosplanos;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EditarAPuntuacion {

    String Archivo = "Puntos.txt";
    Context ctx;
    FileOutputStream fos;
    FileInputStream fis;

    public EditarAPuntuacion(Context ctx) {this.ctx = ctx;}

    public void EscribirPuntuacion(String textArchivo) throws IOException {
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

    public ArrayList<OPuntuacion> GuardarPuntuacion (){
        ArrayList<String> auxiliar = new ArrayList();
        ArrayList<OPuntuacion> auxiliarFinal = new ArrayList();

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
                    auxiliarFinal.add( new OPuntuacion(auxiliar.get(0), Integer.parseInt(auxiliar.get(1))));
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

