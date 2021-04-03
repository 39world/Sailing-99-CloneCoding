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
    public List<ContentDto> getContent(){
        String resultString = apiSearch.poppular();
        System.out.println(apiSearch.fromJSONtoItems(resultString));
        return apiSearch.fromJSONtoItems(resultString);

    }
}
