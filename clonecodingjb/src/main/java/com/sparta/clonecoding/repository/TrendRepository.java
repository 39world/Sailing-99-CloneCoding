package com.sparta.clonecoding.repository;


import com.sparta.clonecoding.models.Trend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrendRepository extends JpaRepository<Trend, Long> {
}
