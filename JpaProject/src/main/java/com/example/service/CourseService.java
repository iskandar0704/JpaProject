package com.example.service;


import com.example.dto.CourseDTO;
import com.example.entity.CourseEntity;
import com.example.exception.ItemNotFoundException;
import com.example.repository.CourseRepository;
import com.example.utils.CourseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public CourseDTO create(CourseDTO dto){
        if(dto == null){
            throw new ItemNotFoundException("Empty body!");
        }

        CourseEntity entity = CourseUtil.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());

        repository.save(entity);

        dto.setCreatedDate(entity.getCreatedDate());
        dto.setId(entity.getId());

        return dto;
    }
    public CourseDTO getById(Integer id){
        Optional<CourseEntity> optional = repository.findById(id);

        if(optional.isEmpty()){
            throw new ItemNotFoundException("Course not found!");
        }

        CourseEntity entity = optional.get();

        return CourseUtil.toDtoWithId(entity);
    }
    public List<CourseDTO> getAll(){
        List<CourseEntity> entityList = repository.findAll();

        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity e: entityList){
            dtoList.add(CourseUtil.toDtoWithId(e));
        }

        return dtoList;
    }
    public void update(CourseDTO dto){
        if(dto == null){
            throw new ItemNotFoundException("Body is empty!");
        }

        CourseEntity entity = CourseUtil.toEntityWithId(dto);

        repository.save(entity);
    }
    public void deleteById(Integer id){
        Optional<CourseEntity> optional = repository.findById(id);

        if(optional.isEmpty()){
            throw new ItemNotFoundException("Course not found!");
        }

        repository.deleteById(id);
    }
    public List<CourseDTO> getByName(String name){
        List<CourseEntity> entityList = repository.findByName(name);

        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity e: entityList){
            dtoList.add(CourseUtil.toDtoWithId(e));
        }

        return dtoList;
    }
    public List<CourseDTO> getByPrice(Double price){
        List<CourseEntity> entityList = repository.findByPrice(price);

        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity e: entityList){
            dtoList.add(CourseUtil.toDtoWithId(e));
        }

        return dtoList;
    }
    public List<CourseDTO> getByDuration(Integer duration){
        List<CourseEntity> entityList = repository.findByDuration(duration);

        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity e: entityList){
            dtoList.add(CourseUtil.toDtoWithId(e));
        }

        return dtoList;
    }
    public List<CourseDTO> getListPriceBetween(Double priceFrom, Double priceTill){
        List<CourseEntity> entityList= repository.findByPriceBetween(priceFrom,priceTill);

        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity e: entityList){
            dtoList.add(CourseUtil.toDtoWithId(e));
        }

        return dtoList;
    }

}
