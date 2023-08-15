package com.juanipissistemas.proyecto.services;

import java.util.List;
import com.juanipissistemas.proyecto.models.Anime;
public interface IAnimeService {
    public List<Anime> findAll();
    public Anime findById(Long id);
    public void delete(Long id);
    public Anime save (Anime anime);

}
