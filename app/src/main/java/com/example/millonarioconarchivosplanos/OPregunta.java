package com.example.millonarioconarchivosplanos;

public class OPregunta {
    private String id;
    private String Question;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private String respuestaFinal;
    private int puntaje;

    public OPregunta(String id, String question, String respuesta1, String respuesta2, String respuesta3, String respuestaFinal, int puntaje) {
        this.id = id;
        Question = question;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuestaFinal = respuestaFinal;
        this.puntaje = puntaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public String getRespuestaFinal() {
        return respuestaFinal;
    }

    public void setRespuestaFinal(String respuestaFinal) {
        this.respuestaFinal = respuestaFinal;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "Question='" + Question + '\'' +
                ", respuesta1='" + respuesta1 + '\'' +
                ", respuesta2='" + respuesta2 + '\'' +
                ", respuesta3='" + respuesta3 + '\'' +
                ", respuestaFinal='" + respuestaFinal + '\'' +
                ", puntaje=" + puntaje +
                '}';
    }
}