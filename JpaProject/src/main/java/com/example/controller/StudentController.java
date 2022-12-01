package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto){
        StudentDTO studentDTO =  service.create(dto);

        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping("/getAll")
    public List<StudentDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    public StudentDTO getById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody StudentDTO dto){
        StudentEntity entity =  service.update(dto);

        if(entity == null){
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{name}")
    public List<StudentDTO> getByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }

    @GetMapping("/surname/{surname}")
    public List<StudentDTO> getBySurname(@PathVariable("surname") String surname){
        return service.getAllBySurname(surname);
    }

    @GetMapping("/age/{age}")
    public List<StudentDTO> getByAge(@PathVariable("age") Integer age){
        return service.getAllByAge(age);
    }

    @GetMapping("/level/{level}")
    public List<StudentDTO> getByLevel(@PathVariable("level") Integer level){
        return service.getAllByLevel(level);
    }

    @GetMapping("/gender/{gender}")
    public List<StudentDTO> getByGender(@PathVariable("gender") String gender){
        return service.getAllByGender(gender);
    }

    @GetMapping("/getAll/byCreatedDate/{dateTime}")
    public List<StudentDTO> getByCreatedDate(@PathVariable String dateTime){
        return service.getAllByCreatedDate(dateTime);
    }

    @GetMapping("/getAll/dateBetween")
    public List<StudentDTO> getByCreatedDateBetween(@RequestBody List<LocalDateTime> dateTimeList){
        return service.getAllByCreatedDateBetween(dateTimeList.get(0),dateTimeList.get(1));
    }
}
