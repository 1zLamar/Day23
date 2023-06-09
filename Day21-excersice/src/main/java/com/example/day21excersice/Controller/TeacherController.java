package com.example.day21excersice.Controller;

import com.example.day21excersice.Model.Teacher;
import com.example.day21excersice.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        List<Teacher> teachers=teacherService.getAllTeachers();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("teacher updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");
    }
    @GetMapping("/get-teacher-address/{id}")
    public ResponseEntity getTeachersAddress(@PathVariable Integer id){
        List<Teacher> teachers=teacherService.getTeachersAddress(id);
        return ResponseEntity.status(200).body(teachers);
    }

}
