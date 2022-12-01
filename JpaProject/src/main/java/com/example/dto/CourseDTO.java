package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {
    private Integer id;

    private String name;
    private Double price;
    private Integer duration;

    private LocalDateTime createdDate;
}
