package com.sparta.clonecoding.model;

import com.sparta.clonecoding.dto.ContentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.tool.schema.internal.exec.GenerationTarget;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Content {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private Long movieId;

    private String title;

    private String overview;

    private String poster_path;

    private String releaseDate;

    private Double average;

    private String backdrop_path;

    private Double genre;

    public Content(ContentDto contentDto){
        this.movieId = contentDto.getMovieId();
        this.title = contentDto.getTitle();
        this.overview = contentDto.getOverview();
        this.poster_path = contentDto.getPoster_path();
        this.releaseDate = contentDto.getReleaseDate();
        this.average = contentDto.getAverage();
        this.backdrop_path = contentDto.getBackdrop_path();
//        this.genre = contentDto.getGenre();

    }


}
