package com.juanipissistemas.proyecto.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.juanipissistemas.proyecto.models.Anime;
public interface IAnimeDAO extends JpaRepository<Anime,Long>{

}