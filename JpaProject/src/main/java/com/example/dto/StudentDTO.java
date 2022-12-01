package com.example.dto;

import com.example.enums.GenderStatus;
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
public class StudentDTO {
    private Integer id;

    private String name;
    private String surname;
    private Integer level;
    private Integer age;
    private GenderStatus gender;

    private LocalDateTime createdDate;
}
