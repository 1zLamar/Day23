package com.example.day21excersice.Controller;

import com.example.day21excersice.Model.Course;
import com.example.day21excersice.Service.CourseService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
        List<Course> courseList=courseService.getAllCourses();
        return ResponseEntity.status(200).body(courseList);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course,@PathVariable Integer id){
        courseService.updateCourse(course,id);
        return ResponseEntity.status(200).body("Course Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course Deleted");
    }

    @PutMapping("/{courseId}/assign/{teacherId}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer courseId,@PathVariable Integer teacherId){
        courseService.assignCourseToTeacher(courseId,teacherId);
        return ResponseEntity.status(200).body("Course Assigned");
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity findTeacherName(@PathVariable Integer id){
        String course=courseService.findTeacherName(id);
        return ResponseEntity.status(200).body(course);
    }
}
