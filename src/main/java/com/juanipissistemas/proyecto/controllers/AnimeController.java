package com.juanipissistemas.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.juanipissistemas.proyecto.models.Anime;
import com.juanipissistemas.proyecto.services.IAnimeService;

@RestController
@RequestMapping("/lordenzo")
public class AnimeController {
    @Autowired
    private IAnimeService lordEnzoService;
    // GET /animes
    @GetMapping("/anime")
    public List<Anime> listarAnimes(){
        return lordEnzoService.findAll();
    }
    
    //GET /Anime/:id
    @GetMapping("/anime/{id}")
    public ResponseEntity<?> verAnime(@PathVariable Long id){
        Anime anime=lordEnzoService.findById(id);
        Map<String,String> respone=new HashMap<>();
        if (anime==null){
            respone.put("Mensaje", "El anime con id "+
            id+" no existe");
            return new ResponseEntity<Map<String,String>>
            (respone, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Anime>(anime, 
        HttpStatus.OK);
    }
    @DeleteMapping("/anime/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarRegistro(@PathVariable Long id){
        lordEnzoService.delete(id);
    }
    @PostMapping("/anime")
    @ResponseStatus(HttpStatus.CREATED)
    public Anime create(@RequestBody Anime anime){
        return lordEnzoService.save(anime);
    }
    @PutMapping("/anime/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Anime update (@PathVariable Long id, 
    @RequestBody Anime anime) {
        Anime actual=lordEnzoService.findById(id);
        if (actual!=null){
            actual.setNombre(anime.getNombre());
            actual.setCapitulos(anime.getCapitulos());
            actual.setCalificacion(anime.getCalificacion());
        }
        return lordEnzoService.save(actual);
    }
}
