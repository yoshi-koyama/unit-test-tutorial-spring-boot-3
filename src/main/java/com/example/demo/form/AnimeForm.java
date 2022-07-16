package com.example.demo.form;

import javax.validation.constraints.NotBlank;

public class AnimeForm {

    private Integer id;

    @NotBlank(message = "タイトルが未入力です。")
    private String name;

    @NotBlank(message = "ジャンルが未入力です。")
    private String genre;

    public AnimeForm(Integer id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public AnimeForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
