package com.sparta.clonecoding.dto;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class ContentDto {

    private String title;
    private String overview;
    private String image;
    private String releaseDate;
    private Double average;

    public ContentDto(JSONObject contentJson){
        this.title = contentJson.getString("title");
        this.overview = contentJson.getString("overview");
        this.image = contentJson.getString("poster_path");
        this.releaseDate = contentJson.getString("release_date");
        this.average = contentJson.getDouble("vote_average");
    }

}
