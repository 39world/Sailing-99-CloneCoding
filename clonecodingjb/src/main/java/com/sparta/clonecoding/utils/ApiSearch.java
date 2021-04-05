package com.sparta.clonecoding.utils;

import com.sparta.clonecoding.dto.ContentDto;
import com.sparta.clonecoding.models.Content;
import com.sparta.clonecoding.repository.ContentRepository;
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

    public ApiSearch(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }


    public String poppular() {

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("cookie", "JSESSIONID=D639E44D96F4C8B7CCDD48F8F1CB2480");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://api.themoviedb.org/3/movie/popular?api_key=127d1ec8dfd28bfe9f6b8d15f689cdd4&language=ko-KR&page=1", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public List<ContentDto> fromJSONtoContent(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("results");

        List<ContentDto> contentDtoList = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            ContentDto itemDto = new ContentDto(itemJson);
            Content content = new Content(itemDto);
            contentDtoList.add(itemDto);
            contentRepository.save(content);

        }
        return contentDtoList;
    }


    public String drama() {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://api.themoviedb.org/3/tv/popular?api_key=127d1ec8dfd28bfe9f6b8d15f689cdd4&language=ko-KR&page=1](https://api.themoviedb.org/3/tv/popular?api_key=127d1ec8dfd28bfe9f6b8d15f689cdd4&language=ko-KR&page=1", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;

    }


    public List<ContentDto> fromJSONtodramas(String result) {
        JSONObject djson = new JSONObject(result);
        JSONArray dramas = djson.getJSONArray("results");
        List<ContentDto> dramaDtoList = new ArrayList<>();

        for (int i = 0; i < dramas.length(); i++) {

            JSONObject dramaJson = dramas.getJSONObject(i);
            ContentDto dramadto = new ContentDto(dramaJson);
            dramaDtoList.add(dramadto);
        }
        return dramaDtoList;
    }


    public String trend() {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://api.themoviedb.org/3/trending/all/day?api_key=127d1ec8dfd28bfe9f6b8d15f689cdd4", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);
        return response;
    }


    public List<ContentDto> fromJSONtotrend(String result) {
        JSONObject tjson = new JSONObject(result);
        JSONArray trends = tjson.getJSONArray("results");
        List<ContentDto> trendDtoList = new ArrayList<>();

        for (int i = 0; i < trends.length(); i++) {

            JSONObject trendJson = trends.getJSONObject(i);
            ContentDto trenddto = new ContentDto(trendJson);
            trendDtoList.add(trenddto);
        }
        return trendDtoList;
    }



}
