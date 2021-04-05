package com.sparta.clonecoding.models;

import com.sparta.clonecoding.dto.ContentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity
public class Content {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

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
    @Column(nullable = true)
    private String backdrop_path;
    @Column
    private Long contentId;
    @Column
    private Long genre;



    public Content(ContentDto contentDto){
        this.title = contentDto.getTitle();
        this.overview = contentDto.getOverview();
        this.poster_path = contentDto.getPoster_path();
        this.releaseDate = contentDto.getReleaseDate();
        this.average = contentDto.getAverage();
        this.backdrop_path = contentDto.getBackdrop_path();
        this.contentId =contentDto.getContentId();
        this.genre = contentDto.getGenre().get(0);


    }


//    // ID가 자동으로 생성 및 증가합니다.
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    private Long id;
//
//    // 반드시 값을 가지도록 합니다.
//    //영화제목가져오기
//    @Column(nullable = false)
//    private String title;
////영화 포스터 가져오기
//    @Column(nullable = false)
//    private String poster_path;
////영오버뷰가뭐야
//    @Column(nullable = false)
//    private String overview;
//    //개봉일
//    @Column(nullable = false)
//    private String releaseDate;
//    //평점
//    @Column(nullable = false)
//    private String average;
//
//    @Column(nullable = false)
//    private Long genre;


}

//import com.sparta.clonecoding.dto.ContentDto;
//        import lombok.Getter;
//        import lombok.NoArgsConstructor;
//        import lombok.Setter;
//        import org.hibernate.tool.schema.internal.exec.GenerationTarget;
//        import org.springframework.stereotype.Service;
//
//        import javax.persistence.Entity;
//        import javax.persistence.GeneratedValue;
//        import javax.persistence.GenerationType;
//        import javax.persistence.Id;
//        import java.util.ArrayList;

//@Getter
//@Entity
//@NoArgsConstructor
//public class Content {
//
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    private Long id;
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
//    public Content(ContentDto contentDto){
//        this.title = contentDto.getTitle();
//        this.overview = contentDto.getOverview();
//        this.poster_path = contentDto.getPoster_path();
//        this.releaseDate = contentDto.getReleaseDate();
//        this.average = contentDto.getAverage();
//        this.backdrop_path = contentDto.getBackdrop_path();
//        this.genre = contentDto.getGenre();
//
//    }
//

//}