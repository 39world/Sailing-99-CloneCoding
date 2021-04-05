package com.sparta.clonecoding.repository;

import com.sparta.clonecoding.model.Drama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DramaRepository extends JpaRepository<Drama, Long> {
}
