package com.example.demo.service;

import com.example.demo.entity.Anime;
import com.example.demo.mapper.AnimeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    private final AnimeMapper animeMapper;

    public AnimeService(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }

    public List<Anime> getAllAnime() {
        List<Anime> animeList = animeMapper.findAll();
        return animeList;
    }

    public Optional<Anime> getAnime(Integer id) {
        Optional<Anime> animeId = animeMapper.findById(id);
        return animeId;
    }

    public void registerAnime(String name, String genre) {
        Anime anime = new Anime(name, genre);
        animeMapper.createAnime(anime);
    }

    public void updateAnime(Integer id, String name, String genre) {
        Anime anime = new Anime(id, name, genre);
        animeMapper.updateAnime(anime);
    }

    public void deleteAnime(Integer id) {
        animeMapper.deleteAnime(id);
    }
}
