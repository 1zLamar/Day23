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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name shouldn't be empty")
    private String name;
    @NotNull(message = "age shouldn't be empty")
    private Integer age;
    @NotEmpty(message = "email shouldn't be null")
    private String email;
    @NotNull(message = "salary shouldn't be null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher1")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> course;
}
