package com.example.millonarioconarchivosplanos;

public class OPuntuacion {
    int id;
    String Nombre;
    int Puntos;

    public OPuntuacion(int id, String nombre, int puntos) {
        this.id = id;
        Nombre = nombre;
        Puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int puntos) {
        Puntos = puntos;
    }

    @Override
    public String toString() {
        return "Puntuacion{" +
                "Nombre='" + Nombre + '\'' +
                ", Puntos=" + Puntos +
                '}';
    }
}


