package com.sparta.clonecoding.utils;

import com.sparta.clonecoding.dto.ContentDto;
import com.sparta.clonecoding.model.Content;
import com.sparta.clonecoding.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ApiSearch {

    private final MovieRepository movieRepository;


    public String moivePoppular(int page){

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

    public List<ContentDto> fromJSONtoItems(String result){
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("results");

        List<ContentDto> contentDtoList = new ArrayList<>();
        System.out.println("hi");
        for(int i=0 ; i<items.length();i++){

                JSONObject itemJson = items.getJSONObject(i);
                ContentDto itemDto = new ContentDto(itemJson);
                Content content = new Content(itemDto);
                System.out.println("hi2");
                contentDtoList.add(itemDto);
                movieRepository.save(content);



        }
        return contentDtoList;
    }


}
