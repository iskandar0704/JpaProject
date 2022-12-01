package com.example.utils;

import com.example.dto.CourseDTO;
import com.example.entity.CourseEntity;

public class CourseUtil {

    public static CourseDTO toDtoWithId(CourseEntity entity){
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public static CourseDTO toDto(CourseEntity entity){
        CourseDTO dto = new CourseDTO();
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public static CourseEntity toEntityWithId(CourseDTO dto){
        CourseEntity entity = new CourseEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }

    public static CourseEntity toEntity(CourseDTO dto){
        CourseEntity entity = new CourseEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }
}
