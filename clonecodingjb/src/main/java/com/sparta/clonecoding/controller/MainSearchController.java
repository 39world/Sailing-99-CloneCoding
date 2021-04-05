package com.sparta.clonecoding.controller;

import com.sparta.clonecoding.dto.ContentDto;
import com.sparta.clonecoding.dto.TrendDto;
import com.sparta.clonecoding.repository.ContentRepository;
import com.sparta.clonecoding.utils.ApiSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//이걸안쓰면 리스폰스 바디를 이용하여 정적 컨트롤러임을 밝혀야한다.,
@RestController
//뭐였지??/
@RequiredArgsConstructor
public class MainSearchController {
    //APIsearch를 기반으로한 데이터 조회이기 떄문에 꼭 있어야하는 파이널값을 넣어준다.
    private final ApiSearch apiSearch;
    private final ContentRepository contentRepository;

    //메인 페이지 인기영화 데이터 조회
    @GetMapping("/api/main/popular")
    public void getContent() {
        //10페이지까지 불러오기
        for (int i = 1; i <= 8; i++) {
            String resultString = apiSearch.moviePoppular(i);
            System.out.println(apiSearch.fromJSONtoContent(resultString));
            List<ContentDto> contentDtoList = apiSearch.fromJSONtoContent(resultString);


        }
    }


    //    //메인 페이지 인기드라마 데이터 조회
//    @GetMapping("/api/main/drama")
//    public  List<ContentDto> getDrama(){
//        String dramaString = apiSearch.drama();
//        return apiSearch.fromJSONtodramas(dramaString);
//    }
//    //메인페이지 트랜드영상 데이터 조회
    @GetMapping("/api/main/trend")
    public void gettrend() {
        for (int i = 1; i <= 8; i++) {
            String resultString = apiSearch.trend(i);
            System.out.println(apiSearch.fromJSONtotrend(resultString));
            List<TrendDto> trendDtoList = apiSearch.fromJSONtotrend(resultString);
        }
    }
}







//import com.sparta.clonecoding.dto.ContentDto;
//        import com.sparta.clonecoding.utils.ApiSearch;
//        import lombok.RequiredArgsConstructor;
//        import org.springframework.web.bind.annotation.GetMapping;
//        import org.springframework.web.bind.annotation.RestController;
//
//        import javax.crypto.spec.PSource;
//        import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class MainSearchController {
//
//    private final ApiSearch apiSearch;
//
//    //메인 페이지 인기영화 데이터 조회
//    @GetMapping("/api/main/popular")
//    public void getContent(){
//        //300페이지까지 불러오기
//        for (int i = 1 ; i<=10; i++){
//            String resultString = apiSearch.moivePoppular(i);
//            System.out.println(apiSearch.fromJSONtoItems(resultString));
//            apiSearch.fromJSONtoItems(resultString);
//        }
//    }
//}
