package com.example.utils;

import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import org.springframework.stereotype.Component;

public class StudentUtil {
    public static StudentDTO toDto(StudentEntity studentEntity){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(studentEntity.getName());
        studentDTO.setSurname(studentEntity.getSurname());
        studentDTO.setAge(studentEntity.getAge());
        studentDTO.setLevel(studentEntity.getLevel());
        studentDTO.setGender(studentEntity.getGender());
        studentDTO.setCreatedDate(studentEntity.getCreatedDate());
        return studentDTO;
    }

    public static StudentDTO toDtoWithId(StudentEntity studentEntity){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setName(studentEntity.getName());
        studentDTO.setSurname(studentEntity.getSurname());
        studentDTO.setAge(studentEntity.getAge());
        studentDTO.setLevel(studentEntity.getLevel());
        studentDTO.setGender(studentEntity.getGender());
        studentDTO.setCreatedDate(studentEntity.getCreatedDate());
        return studentDTO;
    }

    public static StudentEntity toEntity(StudentDTO dto){
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setLevel(dto.getLevel());
        return entity;
    }

    public static StudentEntity toEntityWithId(StudentDTO dto){
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setLevel(dto.getLevel());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }
}
