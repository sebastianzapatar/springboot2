package com.juanipissistemas.proyecto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.juanipissistemas.proyecto.models.Anime;
import com.juanipissistemas.proyecto.models.TesisLorenzo;
import com.juanipissistemas.proyecto.services.IAnimeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/anime")
public class PrimerControlador {
    @Autowired
    private IAnimeService animeService;
    static List<Anime> lista=new ArrayList<>();
    
    public static void llenarLista(){
        Anime anime = new Anime();
        anime.setNombre("Evangelion");
        anime.setCapitulos(24);
        anime.setCalificacion(10);
        Anime anime2=new Anime();
        anime2.setNombre("Jujutsu kaisen");
        anime2.setCapitulos(24);
        anime2.setCalificacion(9);
        lista.add(anime);
        lista.add(anime2);
        Anime anime3=new Anime();
        anime3.setNombre("One Piece");
        anime3.setCapitulos(1070);
        anime3.setCalificacion(10);
        lista.add(anime3);
        
    } 
    @GetMapping("/api")
    public String saludo(){
        return "Hola Amigos";
    }
    @GetMapping("/resta")    public int resta(){
        int a=10;
        int b=4;
        return a-b;
    }
    @GetMapping("/noexiste/{nombre}/{intento}/{tema}")
    public TesisLorenzo noExiste(@PathVariable String nombre, 
    @PathVariable int intento, @PathVariable String tema){
        TesisLorenzo tema1=new TesisLorenzo();
        tema1.setIntento(intento);
        tema1.setNombre(nombre);
        tema1.setTema(tema);
        return tema1;
    }
    @GetMapping("/lista")
    public List<Anime> listaAnimes(){
       
        return animeService.findAll();
    }
    @PostMapping("/crearanime")
    public List<Anime> postMethodName(@RequestBody Anime anime) {
        //TODO: process POST request
        lista.add(anime);
        return lista;
    }
    @GetMapping("/lista/{id}")
    public Anime buscar(@PathVariable Long id){
        return animeService.findById(id);
    }
    
}
