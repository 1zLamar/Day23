package com.example.day21excersice.Controller;

import com.example.day21excersice.Model.Student;
import com.example.day21excersice.Service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student,@PathVariable Integer id){
        studentService.updateStudent(student,id);
        return ResponseEntity.status(200).body("student updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted");
    }

    @PutMapping("/{studentId}/assign/{courseId}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer studentId,@PathVariable Integer courseId){
        studentService.assignStudentToCourse(studentId,courseId);
        return ResponseEntity.status(200).body("Student assigned");
    }

    @PutMapping("/change/{studentId}/{major}")
    public ResponseEntity changeCourse(@PathVariable Integer studentId,@PathVariable String major){
        studentService.changeMajor(studentId,major);
        return ResponseEntity.status(200).body("Student change major");
    }


}
