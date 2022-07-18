package com.example.demo.controller;

import com.example.demo.entity.Anime;
import com.example.demo.form.AnimeForm;
import com.example.demo.service.AnimeService;
import com.example.demo.service.ResponseService;
import com.example.demo.service.response.Responce;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/anime")
public class AnimeController {

    private final AnimeService animeService;
    private final ResponseService responseService;

    public AnimeController(AnimeService animeService, ResponseService responseService) {
        this.animeService = animeService;
        this.responseService = responseService;
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
    public Responce registerAnime(@Validated @RequestBody AnimeForm animeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return responseService.validationError(bindingResult);
        } else {
            animeService.registerAnime(animeForm.getName(), animeForm.getGenre());
            return responseService.postSuccess();
        }
    }

    @PatchMapping(path = "{animeId}")
    public Responce updateAnime(@PathVariable("animeId") Integer id, @Validated @RequestBody AnimeForm animeForm, BindingResult bindingResult) {
        if (animeService.getAnime(id).isEmpty()) {
            return responseService.userNotFound();
        } else if (bindingResult.hasErrors()) {
            return responseService.validationError(bindingResult);
        } else {
            animeService.updateAnime(id, animeForm.getName(), animeForm.getGenre());
            return responseService.updateSuccess();
        }
    }


    @DeleteMapping(path = "{animeId}")
    public Responce deleteAnime(@PathVariable("animeId") Integer id) {
        if (animeService.getAnime(id).isEmpty()) {
            return responseService.userNotFound();
        }
        animeService.deleteAnime(id);
        return responseService.deleteSuccess();
    }
}
