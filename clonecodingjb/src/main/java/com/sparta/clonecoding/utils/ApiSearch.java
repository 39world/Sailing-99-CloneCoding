package com.sparta.clonecoding.utils;

import com.sparta.clonecoding.dto.ContentDto;
import com.sparta.clonecoding.dto.TrendDto;
import com.sparta.clonecoding.models.Content;
import com.sparta.clonecoding.models.Trend;
import com.sparta.clonecoding.repository.ContentRepository;
import com.sparta.clonecoding.repository.TrendRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
//TMDB에서 영화,드라마,트랜드영상의 데이터를 가져와 DB에 저장 하는 역할의 첫번쨰 관문이다.
@Component

public class ApiSearch {
    private final ContentRepository contentRepository;
    private final TrendRepository trendRepository;

    public ApiSearch(ContentRepository contentRepository, TrendRepository trendRepository) {
        this.contentRepository = contentRepository;
        this.trendRepository = trendRepository;
    }


    public String moviePoppular(int page){

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("cookie", "JSESSIONID=D639E44D96F4C8B7CCDD48F8F1CB2480");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://api.themoviedb.org/3/movie/popular?api_key=127d1ec8dfd28bfe9f6b8d15f689cdd4&language=ko-KR&page=" + page, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);
        return response;
    }

    public List<ContentDto>fromJSONtoContent(String result){
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("results");

        List<ContentDto> contentDtoList = new ArrayList<>();
        for(int i=0 ; i<items.length();i++){

            JSONObject itemJson = items.getJSONObject(i);
            ContentDto itemDto = new ContentDto(itemJson);
            Content content = new Content(itemDto);
            contentDtoList.add(itemDto);
            contentRepository.save(content);



        }
        return contentDtoList;
    }





    public String trend(int page) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://api.themoviedb.org/3/trending/all/day?api_key=127d1ec8dfd28bfe9f6b8d15f689cdd4&language=ko-KR&page="+page, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);
        return response;
    }


    public List<TrendDto> fromJSONtotrend(String result) {
        JSONObject tjson = new JSONObject(result);
        JSONArray trends = tjson.getJSONArray("results");
        List<TrendDto> trendDtoList = new ArrayList<>();

        for (int i = 0; i < trends.length(); i++) {

            JSONObject trendJson = trends.getJSONObject(i);
            TrendDto trenddto = new TrendDto(trendJson);
            Trend trend = new Trend(trenddto);
            trendDtoList.add(trenddto);
            trendRepository.save(trend);
        }
        return trendDtoList;
    }



}