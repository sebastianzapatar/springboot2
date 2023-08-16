package com.juanipissistemas.proyecto.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="animes")
public class Anime implements Comparable<Anime>,Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=4, max=150)
    @Column
    private String nombre;
    @Column
    private Integer capitulos;
    @Column(nullable = false)
    private Double califacion;
    public void setNombre (String n){
        this.nombre=n;
    }
    public Long getId(){
        return id;
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
