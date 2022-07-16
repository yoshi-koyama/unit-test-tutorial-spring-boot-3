package com.example.demo.mapper;

import com.example.demo.entity.Anime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AnimeMapper {

    List<Anime> findAll();

    Optional<Anime> findById(Integer id);

    void createAnime(Anime anime);

    void updateAnime(Anime anime);

    void deleteAnime(Integer id);
}
