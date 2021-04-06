package com.sparta.clonecoding.repository;

import com.sparta.clonecoding.model.Content;
import com.sparta.clonecoding.model.Drama;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Content, Long> {

    List<Content> findAllByOrderByAverageDesc();

    List<Content> findAllByGenreByAverageDesc(Long Genre);

}
