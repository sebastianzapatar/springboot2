package com.juanipissistemas.proyecto.models;

public class Anime implements Comparable<Anime>{
    private String nombre;
    private int capitulos;
    private double califacion;
    public void setNombre (String n){
        this.nombre=n;
    }
    public  String getNombre(){
        return nombre;
    }
    public void setCapitulos (int c ){
        this.capitulos =c ;
    }
    public   int getCapitulos (){
        return capitulos;
    }
    public void setCalificacion (double ca ){
        this.califacion=ca;
    }
    public     Double getCalificacion () {
        return califacion;
    }
    @Override
    public int compareTo(Anime e) {
        // TODO Auto-generated method stub
        if(this.getCalificacion()>e.getCalificacion()){
            return -1;
        }
        else if(this.getCalificacion().equals(e.getCalificacion())){
            return e.capitulos-this.getCapitulos();
        }
        else{
            return 1;
        }
    }

}
