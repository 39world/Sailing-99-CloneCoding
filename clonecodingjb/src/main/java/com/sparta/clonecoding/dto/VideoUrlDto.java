package com.sparta.clonecoding.dto;

import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.Column;
import java.util.ArrayList;
@Getter
public class VideoUrlDto {


    @Column
    private String key;


    public VideoUrlDto(JSONObject contentJson){

        if(contentJson.isNull("key")){
            this.key = "";
        } else{
            this.key = contentJson.getString("key");
        }


    }
}
