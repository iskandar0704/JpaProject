package com.example.repository;

import com.example.entity.StudentEntity;
import com.example.enums.GenderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

    List<StudentEntity> findByName(String name);

    List<StudentEntity> findBySurname(String surname);

    List<StudentEntity> findByAge(Integer age);

    List<StudentEntity> findByLevel(Integer level);

    List<StudentEntity> findByGender(GenderStatus gender);

    List<StudentEntity> findByCreatedDate(LocalDateTime localDateTime);

    List<StudentEntity> findByCreatedDateBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
