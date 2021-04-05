package com.sparta.clonecoding.dto;

import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ContentDto {

    private Long movieId;

    private String title;

    private String overview;

    private String poster_path;

    private String releaseDate;

    private Double average;

    private String backdrop_path;

    private JSONArray genre;



    public ContentDto(JSONObject contentJson){
        this.movieId = contentJson.getLong("id");
        this.title = contentJson.getString("title");
        this.overview = contentJson.getString("overview");
        this.poster_path = contentJson.getString("poster_path");
        this.releaseDate = contentJson.getString("release_date");
        this.average = contentJson.getDouble("vote_average");
        this.backdrop_path = contentJson.getString("backdrop_path");
        this.genre = contentJson.getJSONArray("genre_ids");
    }


}
