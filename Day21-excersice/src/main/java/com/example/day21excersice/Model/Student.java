package com.example.day21excersice.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name shouldn't be null")
    private String name;

    @NotNull(message = "age shouldn't be null")
    private Integer age;
    @NotEmpty(message = "major shouldn't be null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

}
