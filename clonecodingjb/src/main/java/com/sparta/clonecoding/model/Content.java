package com.sparta.clonecoding.model;

import com.sparta.clonecoding.dto.ContentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.tool.schema.internal.exec.GenerationTarget;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Getter
@Entity
@NoArgsConstructor
public class Content {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private Long contentId;
    @Column
    private String title;
    @Column(length = 1000,nullable = false)
    private String overview;
    @Column
    private String poster_path;
    @Column
    private String releaseDate;
    @Column
    private Double average;
    @Column
    private String backdrop_path;
    @Column
    private Long genre;

    public Content(ContentDto contentDto){
        this.contentId = contentDto.getContentId();
        this.title = contentDto.getTitle();
        this.overview = contentDto.getOverview();
        this.poster_path = contentDto.getPoster_path();
        this.releaseDate = contentDto.getReleaseDate();
        this.average = contentDto.getAverage();
        this.backdrop_path = contentDto.getBackdrop_path();
        this.genre = contentDto.getGenre().get(0);

    }


}
