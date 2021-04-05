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
    private String poster_path;
    private String releaseDate;
    private Double average;
    private Long contentId;
    private String backdrop_path;
    private List<Long> genre;

    //    private ArrayList<String> genre;
//5개를 찾기위한 키값과 우리가 지정할 이름을 매칭시킨다.

    /*
        {
            "title":"토a과 제리",
            "gerne_ids":
        }

     */

    public ContentDto(JSONObject contentJson) {
        if (contentJson.has("id")) {
            this.contentId = contentJson.getLong("id");
        }

        if (contentJson.isNull("title")) {
            this.title = "";
        } else {
            this.title = contentJson.getString("title");
        }

        if (contentJson.isNull("overview")) {
            this.overview = "";
        } else {
            this.overview = contentJson.getString("overview");
        }

        if (contentJson.isNull("poster_path")) {
            this.poster_path = "";
        } else {
            this.poster_path = contentJson.getString("poster_path");
        }


        if (contentJson.isNull("release_date")) {
            this.releaseDate = "";
        } else {
            this.releaseDate = contentJson.getString("release_date");
        }

        if (contentJson.has("vote_average")) {
            this.average = contentJson.getDouble("vote_average");
        }

        if (contentJson.isNull("backdrop_path")) {
            this.backdrop_path = "";
        } else {
            this.backdrop_path = contentJson.getString("backdrop_path");
        }
        if (contentJson.isNull("genre_ids")) {
            this.genre = null;
        } else {
            this.genre = new ArrayList<>();

            JSONArray genre_ids_array = contentJson.getJSONArray("genre_ids");
            for (int i = 0; i < genre_ids_array.length(); i++) {
                this.genre.add(genre_ids_array.getLong(i));
            }

        }
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