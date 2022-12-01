package com.example.service;

import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.enums.GenderStatus;
import com.example.exception.ItemNotFoundException;
import com.example.repository.StudentRepository;
import com.example.utils.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;


    public StudentDTO create(StudentDTO dto){
        StudentEntity entity = StudentUtil.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        repository.save(entity);

        dto.setCreatedDate(entity.getCreatedDate());
        dto.setId(entity.getId());

        return dto;
    }

    public List<StudentDTO> getAll(){
        List<StudentEntity> entityList = repository.findAll();

        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity s: entityList){
            dtoList.add(StudentUtil.toDtoWithId(s));
        }

        return dtoList;
    }

    public StudentDTO getById(Integer id){
        Optional<StudentEntity> optional = repository.findById(id);

        if(optional.isEmpty()){
            throw new ItemNotFoundException("Student not found!");
        }

        StudentEntity entity = optional.get();

        return StudentUtil.toDtoWithId(entity);
    }

    public StudentEntity update(StudentDTO dto){
        if(dto == null){
            throw new ItemNotFoundException("Bad request!");
        }

        Optional<StudentEntity> optional = repository.findById(dto.getId());
        if(optional.isEmpty()){
            throw new ItemNotFoundException("Student not found!");
        }

        StudentEntity entity = StudentUtil.toEntityWithId(dto);
        return repository.save(entity);
    }

    public void deleteById(Integer id){
        Optional<StudentEntity> optional =  repository.findById(id);

        if(optional.isEmpty()){
            throw new ItemNotFoundException("Student not found!");
        }

        repository.deleteById(id);
    }

    public List<StudentDTO> getAllByName(String name){
        List<StudentEntity> entityList = repository.findByName(name);

        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity s: entityList){
            dtoList.add(StudentUtil.toDtoWithId(s));
        }

        return dtoList;
    }

    public List<StudentDTO> getAllBySurname(String surname){
        List<StudentEntity> entityList = repository.findBySurname(surname);

        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity s: entityList){
            dtoList.add(StudentUtil.toDtoWithId(s));
        }

        return dtoList;
    }

    public List<StudentDTO> getAllByAge(Integer age){
        List<StudentEntity> entityList = repository.findByAge(age);

        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity s: entityList){
            dtoList.add(StudentUtil.toDtoWithId(s));
        }

        return dtoList;
    }

    public List<StudentDTO> getAllByLevel(Integer level){
        List<StudentEntity> entityList = repository.findByLevel(level);

        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity s: entityList){
            dtoList.add(StudentUtil.toDtoWithId(s));
        }

        return dtoList;
    }

    public List<StudentDTO> getAllByGender(String gender){
        List<StudentEntity> entityList = repository.findByGender(GenderStatus.valueOf(gender));

        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity s: entityList){
            dtoList.add(StudentUtil.toDtoWithId(s));
        }

        return dtoList;
    }

    public List<StudentDTO> getAllByCreatedDate(String dateTimeString){
        LocalDateTime dateTime =  LocalDateTime.parse(dateTimeString);
        List<StudentEntity> entityList = repository.findByCreatedDate(dateTime);

        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity s: entityList){
            dtoList.add(StudentUtil.toDtoWithId(s));
        }

        return dtoList;
    }

    public List<StudentDTO> getAllByCreatedDateBetween(LocalDateTime dateFrom,LocalDateTime dateTo){
        List<StudentEntity> entityList = repository.findByCreatedDateBetween(dateFrom,dateTo);

        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity s: entityList){
            dtoList.add(StudentUtil.toDtoWithId(s));
        }

        return dtoList;
    }

}
