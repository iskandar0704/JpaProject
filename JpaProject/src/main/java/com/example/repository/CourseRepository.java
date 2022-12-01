package com.example.repository;

import com.example.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    List<CourseEntity> findByName(String name);

    List<CourseEntity> findByPrice(Double price);

    List<CourseEntity> findByDuration(Integer duration);

    List<CourseEntity> findByPriceBetween(Double priceFrom, Double priceTill);
}
