package com.juanipissistemas.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

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
    public Anime verAnime(@PathVariable Long id){
        return lordEnzoService.findById(id);
    }
    @DeleteMapping("/anime/{id}")
    public void borrarRegistro(@PathVariable Long id){
        lordEnzoService.delete(id);
    }
    @PostMapping("/anime")
    public Anime create(@RequestBody Anime anime){
        return lordEnzoService.save(anime);
    }
    @PutMapping("/anime/{id}")
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
