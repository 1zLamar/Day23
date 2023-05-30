package com.example.day21excersice.Model;

import com.example.day21excersice.Controller.StudentController;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name shouldn't be null")
    private String name;


    @ManyToOne
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;


    @ManyToMany
    @JsonIgnore
    private Set<Student> students;

}
