package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;

public class AnimeForm {

  @NotBlank(message = "cannot be empty")
  private String name;

  @NotBlank(message = "cannot be empty")
  private String genre;

  public AnimeForm(String name, String genre) {
    this.name = name;
    this.genre = genre;
  }

  public AnimeForm() {
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
