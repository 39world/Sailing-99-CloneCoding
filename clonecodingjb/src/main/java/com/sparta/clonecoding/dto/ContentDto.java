package com.sparta.clonecoding.dto;

import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


//게터의 역할을 해준다(받아오는거)

@Getter
//얘는 dto
public class ContentDto {
//dto의 구성은 즉 우리가 리스트에서 가져와야할값은 밑에 5개이다
    private String title;
    private String overview;
    private String image;
    private String releaseDate;
    private Double average;
    private Long contentId;
    private String backdropPath;
//    private ArrayList<String> genre;
//5개를 찾기위한 키값과 우리가 지정할 이름을 매칭시킨다.
    public ContentDto(JSONObject contentJson){
        this.title = contentJson.getString("title");
        this.overview = contentJson.getString("overview");
        this.image = contentJson.getString("poster_path");
        this.releaseDate = contentJson.getString("release_date");
        this.average = contentJson.getDouble("vote_average");
        this.contentId =contentJson.getLong("id");
        this.backdropPath = contentJson.getString("backdrop_path");
//        this.genre = contentJson.get("genre_ids");
    }

}
//import lombok.Getter;
//        import org.json.JSONObject;
//
//        import javax.persistence.Column;
//        import java.util.ArrayList;
//
//@Getter
//public class ContentDto {
//
//    private String title;
//
//    private String overview;
//
//    private String poster_path;
//
//    private String releaseDate;
//
//    private Double average;
//
//    private String backdrop_path;
//
//    private ArrayList<Double> genre;
//
//
//
//    public ContentDto(JSONObject contentJson){
//        this.title = contentJson.getString("title");
//        this.overview = contentJson.getString("overview");
//        this.poster_path = contentJson.getString("poster_path");
//        this.releaseDate = contentJson.getString("release_date");
//        this.average = contentJson.getDouble("vote_average");
//        this.backdrop_path = contentJson.getString("backdrop_path");
//        this.genre = contentJson.getArrayList("genre_ids");
//    }
//
//
//}