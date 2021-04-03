package com.sparta.clonecoding.utils;

import com.sparta.clonecoding.dto.ContentDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiSearch {


    public String poppular(){

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

    public List<ContentDto> fromJSONtoItems(String result){
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("results");

        List<ContentDto> contentDtoList = new ArrayList<>();

        for(int i=0 ; i<items.length();i++){
            JSONObject itemJson = items.getJSONObject(i);
            ContentDto itemDto = new ContentDto(itemJson);
            contentDtoList.add(itemDto);
        }
        return contentDtoList;
    }


}
