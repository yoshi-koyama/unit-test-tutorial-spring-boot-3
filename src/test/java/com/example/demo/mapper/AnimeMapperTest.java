package com.example.demo.mapper;

import com.example.demo.entity.Anime;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AnimeMapperTest {
  @Autowired
  AnimeMapper animeMapper;

  @Test
  @DataSet(value = "anime.yml")
  void すべてのアニメが取得できること() {
    List<Anime> animeList = animeMapper.findAll();
    assertThat(animeList)
      .hasSize(2)
      .contains(
        new Anime(1, "Kill la Kill", "Action"),
        new Anime(2, "Fairy Tail", "Adventure")
      );
  }

}
