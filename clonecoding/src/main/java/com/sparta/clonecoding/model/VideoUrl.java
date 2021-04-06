package com.sparta.clonecoding.model;

import com.sparta.clonecoding.dto.DramaDetailDto;
import com.sparta.clonecoding.dto.DramaDto;
import com.sparta.clonecoding.dto.VideoUrlDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class VideoUrl {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String key;

    public VideoUrl(VideoUrlDto VideoUrlDto){
        this.key = VideoUrlDto.getKey();
     }


}
