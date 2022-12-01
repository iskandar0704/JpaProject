package com.example.controller;


import com.example.dto.CourseDTO;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping("/create")
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO dto){
        CourseDTO dto1 =  service.create(dto);

        return ResponseEntity.ok(dto1);
    }

    @GetMapping("/id/{id}")
    public CourseDTO getById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @GetMapping("/getAll")
    public List<CourseDTO> getAll(){
        return service.getAll();
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody CourseDTO dto){
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        service.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{name}")
    public List<CourseDTO> getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }

    @GetMapping("/price/{price}")
    public List<CourseDTO> getByPrice(@PathVariable("price") Double price){
        return service.getByPrice(price);
    }

    @GetMapping("/duration/{duration}")
    public List<CourseDTO> getByDuration(@PathVariable("duration") Integer duration){
        return service.getByDuration(duration);
    }

    @GetMapping("/priceBetween/{priceFrom}/{priceTill}")
    public List<CourseDTO> getListByPriceBetween(@PathVariable("priceFrom") Double priceFrom, @PathVariable("priceTill") Double priceTill){
        return service.getListPriceBetween(priceFrom,priceTill);
    }

}
