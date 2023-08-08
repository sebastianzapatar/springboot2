package com.juanipissistemas.proyecto.models;

public class TesisLorenzo {
    private String nombre;
    private int intento;
    private String tema;
    public void setNombre(String n){
        this.nombre =n ;
    }
    public  String getNombre(){return   this.nombre;}
    public void setIntento (int i) {this.intento=i;}
    public int getIntento() { return this.intento;}
    public void setTema(String te){tema=te;}
    public String getTema (){return     this.tema;}
    
}
