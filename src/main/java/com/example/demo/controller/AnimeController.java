package com.example.demo.controller;

import com.example.demo.entity.Anime;
import com.example.demo.form.AnimeForm;
import com.example.demo.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/anime")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public List<Anime> getAllAnime() {
        return animeService.getAllAnime();
    }

    @GetMapping(path = "{animeId}")
    public Optional<Anime> getAnime(@PathVariable("animeId") Integer id) {
        return animeService.getAnime(id);
    }

    @PostMapping
    public void registerAnime(@RequestBody AnimeForm animeForm) {
        animeService.registerAnime(animeForm.getName(), animeForm.getGenre());
    }

    @PatchMapping(path = "{animeId}")
    public void updateAnime(@PathVariable("animeId") Integer id, @RequestBody AnimeForm animeForm) {
        animeService.updateAnime(id, animeForm.getName(), animeForm.getGenre());
    }

    @DeleteMapping(path = "{animeId}")
    public void deleteAnime(@PathVariable("animeId") Integer id) {
        animeService.deleteAnime(id);
    }
}
