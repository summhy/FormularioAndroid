package com.summhy.formulario.Models;

import java.util.ArrayList;

public class Calificacion {
    private String curso;
    private ArrayList<Float> notas=new ArrayList<Float>(1);

    public Calificacion(String curso){
        this.curso=curso;
    }
    public ArrayList<Float> getNotas(){
        return this.notas;
    }
    public void agregarNota(float nota){
        notas.add(nota);
    }
    public float promedio(){
        float suma =0;
        for (float nota:notas) {
            suma+=nota;
        }
        return suma/notas.size();
    }
}
