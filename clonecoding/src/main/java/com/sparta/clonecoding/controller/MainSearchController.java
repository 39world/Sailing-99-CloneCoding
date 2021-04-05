package com.sparta.clonecoding.controller;

import com.sparta.clonecoding.dto.ContentDto;
import com.sparta.clonecoding.utils.ApiSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.spec.PSource;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainSearchController {

    private final ApiSearch apiSearch;

    //메인 페이지 인기영화 데이터 조회
    @GetMapping("/api/main/popular")
    public void getContent(){
        //300페이지까지 불러오기
        for (int i = 1 ; i<=10; i++){
            String resultString = apiSearch.moivePoppular(i);
            System.out.println(apiSearch.fromJSONtoItems(resultString));
            apiSearch.fromJSONtoItems(resultString);
        }
    }
}
