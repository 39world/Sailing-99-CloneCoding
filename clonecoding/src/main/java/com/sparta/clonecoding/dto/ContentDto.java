package com.sparta.clonecoding.dto;

import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ContentDto {

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
    private List<Long> genre;



    public ContentDto(JSONObject contentJson){


        if(contentJson.isNull("id")){
            this.contentId = null;
        } else{
            this.contentId = contentJson.getLong("id");
        }
        if(contentJson.isNull("title")){
            this.title = "";
        } else{
            this.title = contentJson.getString("title");
        }
        if(contentJson.isNull("overview")){
            this.overview = "";
        } else{
            this.overview = contentJson.getString("overview");
        }
        if(contentJson.isNull("poster_path")){
            this.poster_path = "";
        } else{
            this.poster_path = contentJson.getString("poster_path");
        }

        if(contentJson.isNull("release_date")){
            this.releaseDate = "";
        } else{
            this.releaseDate = contentJson.getString("release_date");
        }
        if(contentJson.isNull("vote_average")){
            this.average = null;
        } else{
            this.average = contentJson.getDouble("vote_average");
        }

        if(contentJson.isNull("backdrop_path")){
            this.backdrop_path = "";
        } else{
            this.backdrop_path = contentJson.getString("backdrop_path");
        }
        if(contentJson.isNull("genre_ids")){
            this.genre = null;
        } else{
            this.genre = new ArrayList<>();
            JSONArray genre_ids_array = contentJson.getJSONArray("genre_ids");

            if( genre_ids_array.length() >0){
                this.genre.add(genre_ids_array.getLong(0));
            }else {
                this.genre = null;
            }
        }
    }

}



