package com.sparta.clonecoding.repository;

import com.sparta.clonecoding.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}


//package com.sparta.clonecoding.repository;
//
//        import com.sparta.clonecoding.model.Content;
//        import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface MovieRepository extends JpaRepository<Content, Long> {
//}